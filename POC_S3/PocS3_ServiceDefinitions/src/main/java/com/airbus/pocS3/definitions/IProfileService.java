// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocS3.definitions;

import java.util.Set;

/**
 *
 */
public interface IProfileService {
    public static final String PROFILE_ADDED = "com/airbus/pocS3/definitions/IProfileService/PROFILE_ADDED";
    //
    void addProfile(IProfile profile);

    //
    Set<IProfile> getProfiles();
}