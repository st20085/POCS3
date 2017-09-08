// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocS3;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.eclipse.e4.core.di.annotations.Execute;

import com.airbus.pocS3.definitions.IApplication;
import com.airbus.pocS3.definitions.IProfile;
import com.airbus.pocS3.definitions.IProfileService;
import com.airbus.pocS3.internal.ApplicationDesc;
import com.airbus.pocS3.internal.Profile;
import com.airbus.pocS3.internal.Profiles;
import com.airbus.pocs3.factory.ApplicationFactory;
import com.airbus.pocs3.factory.ProfileFactory;

/**
 *
 */
public class ProfileLoaderProcessor {
    public static final String PROFILE_CONFIGURATION_FILE = "profiles.xml";

    @Execute
    public void execute(IProfileService profileService) {

        // add default 'Complete' profile
        profileService.addProfile(ProfileFactory.getCompleteProfile());

        try {
            // load profiles from configuration profile file
            final Profiles profiles = loadProfiles();

            // for each add to profile service
            getProfiles(profiles)
                  .forEach(profileService::addProfile);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param profiles
     * @return
     */
    private static Stream<IProfile> getProfiles(Profiles profiles) {
//        final List<IApplication> applicationList = profile.applicationList.stream().map(p -> p.perspective_id).collect(Collectors.toList());

      Map<String, ApplicationDesc> nameToApplicationDescMap = profiles.application_descList
              .stream()
              .collect(Collectors.toMap(application_desc -> application_desc.name, Function.identity()));

        return profiles.profileList
                .stream()
                .map(profile -> ProfileLoaderProcessor.createProfile(profile, getApplicationList(profile, nameToApplicationDescMap)))
                ;
    }

    /**
     * @param profile
     * @param nameToApplicationDescMap
     * @return
     */
    private static List<IApplication> getApplicationList(Profile profile, Map<String, ApplicationDesc> nameToApplicationDescMap) {
      return profile.applicationList.stream()
             .map(application -> nameToApplicationDescMap.get(application.name))
             .map(ProfileLoaderProcessor::createApplication)
             .collect(Collectors.toList());
    }

    /**
    *
    * @param application_desc
    * @return
    */
   private static IApplication createApplication(ApplicationDesc application_desc) {
       return ApplicationFactory.createApplication(application_desc.name, application_desc.perspective_id);
   }

    /**
     *
     * @param profile
     * @return
     */
    private static IProfile createProfile(Profile profile, List<IApplication> applicationList) {
        return ProfileFactory.createProfile(profile.name, applicationList);
    }

    /**
     * Load profiles from configuration file
     * @return
     * @throws Exception
     */
    private static Profiles loadProfiles() throws Exception {

        final URL resource = ProfileLoaderProcessor.class.getClassLoader().getResource(PROFILE_CONFIGURATION_FILE);
        final JAXBContext jaxbContext = JAXBContext.newInstance(Profiles.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        final Profiles profiles = Profiles.class.cast(jaxbUnmarshaller.unmarshal(resource));

        return profiles;
    }

}
