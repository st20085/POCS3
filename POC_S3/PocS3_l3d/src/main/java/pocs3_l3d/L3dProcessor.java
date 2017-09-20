// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_l3d;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.advanced.impl.AdvancedPackageImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

/**
 *
 */
public class L3dProcessor {
    @Inject
    private MApplication application;

    @Inject
    private EModelService modelService;

    public static final String L3D_PERSPECTIVE_ID = "pocs3_l3d.perspective"; // temporaire

    @Execute
    public void execute(IEclipseContext context) {

//        final BlockDiagramController blockDiagramController = ContextInjectionFactory.make(BlockDiagramController.class, context);
//        context.set(BlockDiagramController.class, blockDiagramController);
//
//        final BlockDiagramEditController blockDiagramEditController = ContextInjectionFactory.make(BlockDiagramEditController.class, context);
//        context.set(BlockDiagramEditController.class, blockDiagramEditController);



        // find perspective
        final MPerspective perspective = (MPerspective) this.modelService.find(L3D_PERSPECTIVE_ID, this.application);
        if (perspective != null) {
            final EObject parentEObject = (EObject) perspective.getParent();
            parentEObject.eAdapters().add(new AdapterImpl() {
                Object oldValue = null;

                @Override
                public void notifyChanged(Notification notification) {
                    // when perspective stack change selected element
                    if (notification.getEventType() == Notification.SET && notification.getFeatureID(MPerspectiveStack.class) == AdvancedPackageImpl.PERSPECTIVE_STACK__SELECTED_ELEMENT) {
                        if (notification.getNewValue() instanceof MPerspective) {
                            if (notification.getNewValue() != this.oldValue) {
                                this.oldValue = notification.getNewValue();
                                final MPerspective selectedPerspective = (MPerspective) this.oldValue;
                                L3dProcessor.this.updateWhenPerspectiveHasChanged(selectedPerspective);
                            }
                        }
                    }
                }
            });
        }
    }


//    /**
//     * Update on event change
//     *
//     * @param event
//     */
//    @Inject
//    @Optional
//    public void updateOnEventChange(@UIEventTopic(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) org.osgi.service.event.Event event) {
//        // final Object oldValue = event.getProperty(EventTags.OLD_VALUE);
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
        final boolean l3d_perspective_activated = L3d_Constants.L3D_PERSPECTIVE_ID.equals(perspective.getElementId());
        this.changeL3dToolbarRenderer(l3d_perspective_activated);
    }

    /**
     * Change L3d toolbar renderer
     *
     * @param renderer
     */
    public void changeL3dToolbarRenderer(boolean renderer) {
        //
        final MUIElement l3d_toolbar = this.modelService.find(L3d_Constants.L3D_TOOLBAR_ID, this.application);
        if (l3d_toolbar != null) {
            l3d_toolbar.setToBeRendered(renderer);
        } else {
            System.err.println("Cannot found l3d_toolbar");
        }
    }
}
