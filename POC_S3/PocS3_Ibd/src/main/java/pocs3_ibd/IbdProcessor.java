// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.advanced.impl.AdvancedPackageImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

import pocs3_ibd.internal.IbdController;

/**
 *
 */
public class IbdProcessor {

    @Inject
    IbdController ibdController;

    @Inject
    EModelService modelService;

    @Inject
    MApplication application;

    public static final String IBD_PERSPECTIVE_ID = "pocs3_ibd.perspective"; // temporaire

    @Execute
    public void execute(IEclipseContext context) {

//        final BlockDiagramController blockDiagramController = ContextInjectionFactory.make(BlockDiagramController.class, context);
//        context.set(BlockDiagramController.class, blockDiagramController);
//
//        final BlockDiagramEditController blockDiagramEditController = ContextInjectionFactory.make(BlockDiagramEditController.class, context);
//        context.set(BlockDiagramEditController.class, blockDiagramEditController);



        // find perspective
        final MPerspective perspective = (MPerspective) this.modelService.find(IBD_PERSPECTIVE_ID, this.application);
        if (perspective != null) {
            final EObject parentEObject = (EObject) perspective.getParent();
            parentEObject.eAdapters().add(new AdapterImpl() {
                Object oldValue = null;

                @Override
                public void notifyChanged(Notification notification) {
                    // when perspective change context
                    if (notification.getEventType() == Notification.SET && notification.getFeatureID(MPerspectiveStack.class) == AdvancedPackageImpl.PERSPECTIVE_STACK__SELECTED_ELEMENT) {
                        if (notification.getNewValue() instanceof MPerspective) {
                            if (notification.getNewValue() != this.oldValue) {
                                this.oldValue = notification.getNewValue();
                                final MPerspective selectedPerspective = (MPerspective) this.oldValue;
                                IbdProcessor.this.updateWhenPerspectiveHasChanged(selectedPerspective);
                            }
                        }
                    }
                }
            });
        }
    }

//    /**
//     * Update on event change
//     * @param event
//     */
//    @Inject
//    @Optional
//    public void updateOnEventChange(@UIEventTopic(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) org.osgi.service.event.Event event) {
////        final Object oldValue = event.getProperty(EventTags.OLD_VALUE);
//        final Object newValue = event.getProperty(EventTags.NEW_VALUE);
//
//        if (newValue instanceof MPerspective) {
//            final MPerspective perspective = (MPerspective) newValue;
//
//            //
//            this.updateWhenPerspectiveHasChanged(perspective);
//        }
//    }

    /**
     * Update update when perspective has changed
     * @param perspective
     */
    @Inject
    @Optional
    private void updateWhenPerspectiveHasChanged(MPerspective perspective) {
        // update toolbar
        this.updateToolbarWhenPerspectiveHasChanged(perspective);
    }

    /**
     * Update toolbar when perspective has changed
     * @param perspective
     */
    @Inject
    @Optional
    private void updateToolbarWhenPerspectiveHasChanged(MPerspective perspective) {
        // change Ibd toolbar renderer
        final boolean ibd_perspective_activated = Ibd_Constants.IBD_PERSPECTIVE_ID.equals(perspective.getElementId());
        this.ibdController.changeIbdToolbarRenderer(ibd_perspective_activated);
    }

}
