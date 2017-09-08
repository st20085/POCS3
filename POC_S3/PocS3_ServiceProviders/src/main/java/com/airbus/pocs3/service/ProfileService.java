// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocs3.service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.airbus.pocS3.definitions.IProfile;
import com.airbus.pocS3.definitions.IProfileService;
import com.airbus.pocs3.factory.ProfileFactory;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;

/**
 *
 */
public class ProfileService implements IProfileService {
        Set<IProfile> profileSet;

    public ProfileService() {
        // 'Complete' in first
        Comparator<IProfile> profileComparator = (profile1, profile2) -> profile1 == ProfileFactory.getCompleteProfile()? -1 : profile2 == ProfileFactory.getCompleteProfile()? 1 : 0;
        // then compare by name
        profileComparator = profileComparator.thenComparing(Comparator.comparing(IProfile::getName));

        this.profileSet = new TreeSet<>(profileComparator);
    }

    @Override
    public void addProfile(IProfile profile) {
        this.profileSet.add(profile);

        final IEventBroker eventBroker = E4Workbench.getServiceContext().get(IEventBroker.class);
        eventBroker.post(PROFILE_ADDED, profile);
    }

    @Override
    public Set<IProfile> getProfiles() {
        return this.profileSet;
    }

}
