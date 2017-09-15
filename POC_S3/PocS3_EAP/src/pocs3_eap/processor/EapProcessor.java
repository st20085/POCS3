package pocs3_eap.processor;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;

/**
 *
 */
public class EapProcessor {
    /**
     * Update on event change
     *
     * @param event
     */
    @Inject
    @Optional
    public void updateOnEventChange(@UIEventTopic(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) org.osgi.service.event.Event event) {
        // final Object oldValue = event.getProperty(EventTags.OLD_VALUE);
        final Object newValue = event.getProperty(EventTags.NEW_VALUE);

        if (newValue instanceof MPerspective) {
            final MPerspective perspective = (MPerspective) newValue;

            //
            this.updateWhenPerspectiveHasChanged(perspective);
        }
    }

    /**
     * Update update when perspective has changed
     *
     * @param perspective
     */
    @Inject
    @Optional
    private void updateWhenPerspectiveHasChanged(MPerspective perspective) {
        // update toolbar
        this.updateToolbarWhenPerspectiveIsChanged(perspective);
    }

    /**
     * Update toolbar when perspective has changed
     *
     * @param perspective
     */
    @Inject
    @Optional
    private void updateToolbarWhenPerspectiveIsChanged(MPerspective perspective) {
        // change l3d toolbar renderer
//        final boolean l3d_perspective_activated = L3d_Constants.L3D_PERSPECTIVE_ID.equals(perspective.getElementId());
//        this.changeL3dToolbarRenderer(l3d_perspective_activated);
    }

}
