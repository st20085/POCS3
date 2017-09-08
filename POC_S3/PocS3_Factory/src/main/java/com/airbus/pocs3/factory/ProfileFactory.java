// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocs3.factory;

import java.util.List;

import com.airbus.pocS3.definitions.IApplication;
import com.airbus.pocS3.definitions.IProfile;
import com.airbus.pocs3.factory.impl.CompleteProfile;
import com.airbus.pocs3.factory.impl.ProfileImpl;

/**
 *
 */
public class ProfileFactory {
    private static final IProfile COMPLETE_PROFILE = new CompleteProfile();

    /**
     * Create profile
     * @param name
     * @param perspectiveIdList
     */
    public static IProfile createProfile(String name, List<IApplication> perspectiveIdList) {
        return new ProfileImpl(name, perspectiveIdList);
    }

    public static IProfile getCompleteProfile() {
        return COMPLETE_PROFILE;
    }
}
