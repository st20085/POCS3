// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_factory.impl;

import java.util.List;

import pocs3_service_definitions.IApplication;
import pocs3_service_definitions.IProfile;

/**
 *
 */
public class ProfileImpl implements IProfile {

    String name;
    List<IApplication> applicationList;

    /**
     * @param name
     * @param applicationList
     */
    public ProfileImpl(String name, List<IApplication> applicationList) {
        this.name = name;
        this.applicationList = applicationList; // TODO copy defensive
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<IApplication> getApplications() {
        return this.applicationList; // TODO copy defensive
    }

    @Override
    public String toString() {
        return "Profile[name="+this.name+", applicationList="+this.applicationList+"]";
    }
}
