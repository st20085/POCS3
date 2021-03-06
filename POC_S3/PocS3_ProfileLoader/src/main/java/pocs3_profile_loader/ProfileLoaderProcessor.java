// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_profile_loader;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_factory.ApplicationFactory;
import pocs3_factory.ProfileFactory;
import pocs3_profile_loader.internal.Application;
import pocs3_profile_loader.internal.Profile;
import pocs3_profile_loader.internal.Profiles;
import pocs3_service_definitions.IApplication;
import pocs3_service_definitions.IProfile;
import pocs3_service_definitions.IProfileService;

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
        return profiles.profileList
                .stream()
                .map(ProfileLoaderProcessor::createProfile)
                ;
    }

    /**
    *
    * @param application_desc
    * @return
    */
   private static IApplication createApplication(Application application) {
       return ApplicationFactory.createApplication(application.name);
   }

    /**
     *
     * @param profile
     * @return
     */
    private static IProfile createProfile(Profile profile) {
      List<IApplication> applicationList = profile.applicationList
                               .stream()
                               .map(ProfileLoaderProcessor::createApplication)
                               .collect(Collectors.toList());
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
