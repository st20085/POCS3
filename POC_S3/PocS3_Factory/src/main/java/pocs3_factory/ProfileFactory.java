// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_factory;

import java.util.List;

import pocs3_factory.impl.CompleteProfile;
import pocs3_factory.impl.ProfileImpl;
import pocs3_service_definitions.IApplication;
import pocs3_service_definitions.IProfile;

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
