// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_service_definitions;

import java.util.Set;

/**
 *
 */
public interface IProfileService {
    public static final String PROFILE_ADDED = "pocs3_service_definitions/IProfileService/PROFILE_ADDED";
    //
    void addProfile(IProfile profile);

    //
    Set<IProfile> getProfiles();
}
