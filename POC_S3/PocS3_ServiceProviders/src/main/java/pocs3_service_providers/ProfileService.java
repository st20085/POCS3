// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_service_providers;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import pocs3_factory.ProfileFactory;
import pocs3_service_definitions.IProfile;
import pocs3_service_definitions.IProfileService;

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
