// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocs3.factory;

import com.airbus.pocS3.definitions.IApplication;
import com.airbus.pocs3.factory.impl.ApplicationImpl;

/**
 *
 */
public class ApplicationFactory {

    /**
     * Create Application
     * @param name
     * @param perspectiveId
     * @return
     */
    public static IApplication createApplication(String name) {
        return new ApplicationImpl(name);
    }
}
