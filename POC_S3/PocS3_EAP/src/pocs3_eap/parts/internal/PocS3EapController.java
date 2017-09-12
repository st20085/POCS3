// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_eap.parts.internal;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.MUILabel;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import pocs3_eap.parts.PocS3_Constants;
import pocs3_service_definitions.IProfile;

/**
 *
 */
@Creatable
@Singleton
public class PocS3EapController {
    @Inject
    private MApplication application;

    @Inject
    private EModelService modelService;

    @Inject
    private EPartService partService;

    @Inject
    @Optional
    private void injectSelectedPerspectiveId(@EventTopic(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) org.osgi.service.event.Event event) {
        final Object newValue = event.getProperty(EventTags.NEW_VALUE);

        if (newValue instanceof MPerspective) {
            final MPerspective perspective = (MPerspective) newValue;
            this.application.getContext().set(PocS3_Constants.POCS3_ACTIVE_PERSPECTIVE_VARIABLE, perspective.getElementId());
        }
    }

    /**
     * Switch to application perspective
     *
     * @param applicationPerspective
     */
    public void switchToApplicationPerspective(MPerspective applicationPerspective) {
        this.partService.switchPerspective(applicationPerspective);

        //
        final MUIElement pocS3_TrimbarTop = this.modelService.find(PocS3_Constants.POCS3_TRIMBAR_TOP, this.application);
        pocS3_TrimbarTop.setVisible(true);
    }

    /*
     * Switch to profile perspective
     */
    public void switchToProfilePerspective() {
        // unset selectedProfile to Application context
        this.application.getContext().remove(IProfile.class);

        //
        final MUIElement pocS3_TrimbarTop = this.modelService.find(PocS3_Constants.POCS3_TRIMBAR_TOP, this.application);
        pocS3_TrimbarTop.setVisible(false);

        // switch to profile perspective
        this.partService.switchPerspective(PocS3_Constants.PROFILE_PERSPECTIVE_ID);
    }

    /**
     * Switch to application board perspective
     */
    public void switchToApplicationBoardPerspective(IProfile profile) {
        ContextInjectionFactory.inject(profile, this.application.getContext().getActiveLeaf());

        // set selectedProfile to Application context
        this.application.getContext().set(IProfile.class, profile);

        // go to application board perspective
        this.partService.switchPerspective(PocS3_Constants.APPLICATION_BOARD_PERSPECTIVE_ID);

        //
        final MUIElement pocS3_TrimbarTop = this.modelService.find(PocS3_Constants.POCS3_TRIMBAR_TOP, this.application);
        pocS3_TrimbarTop.setVisible(true);
    }

    /**
     * Set copy tooltip on all ui elements
     * @param tooltip
     */
    public void setCopyTooltip(String tooltip) {
        this.setTooltip(tooltip, PocS3_Constants.COPY_START_ELEMENT_ID);
    }

    /**
     * Set cut tooltip on all ui elements
     * @param tooltip
     */
    public void setCutTooltip(String tooltip) {
        this.setTooltip(tooltip, PocS3_Constants.CUT_START_ELEMENT_ID);
    }

    /**
     * Set paste tooltip on all ui elements
     * @param tooltip
     */
    public void setPasteTooltip(String tooltip) {
        this.setTooltip(tooltip, PocS3_Constants.PASTE_START_ELEMENT_ID);
    }
    /**
     * Set paste tooltip on all ui elements
     * @param tooltip
     */
    private void setTooltip(String tooltip, String startElementId) {
        // change all "startElementId*" tooltip
        final StartElementMatcher startElementMatcher = new StartElementMatcher(startElementId, MUILabel.class, null);
        final List<MUILabel> findElements = this.modelService.findElements(this.application, MUILabel.class,
            EModelService.ANYWHERE | EModelService.IN_MAIN_MENU, startElementMatcher);
        for (final MUILabel uiLabel : findElements) {
            uiLabel.setTooltip(tooltip);
        }
    }
}
