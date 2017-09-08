// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocs3.factory.impl;

import java.util.List;

import com.airbus.pocS3.definitions.IProfile;

/**
 *
 */
public class Profile implements IProfile {

    String name;
    List<String> perspectiveIdList;

    /**
     * @param name
     * @param perspectiveIdList
     */
    public Profile(String name, List<String> perspectiveIdList) {
        this.name = name;
        this.perspectiveIdList = perspectiveIdList; // TODO copy defensive
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> getPerspectiveIds() {
        return this.perspectiveIdList; // TODO copy defensive
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Profile[name="+this.name+", perspectiveIdList="+this.perspectiveIdList+"]";
    }
}
