// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;

import pocs3_ibd.internal.BlockDiagramEditController;
import pocs3_ibd.internal.IbdController;
import pocs3_ibdcontroller.BlockDiagramController;

/**
 *
 */
public class IbdProcessor {

    @Inject
    IbdController ibdController;

    @Execute
    public void execute(IEclipseContext context) {

        final BlockDiagramController blockDiagramController = ContextInjectionFactory.make(BlockDiagramController.class, context);
        context.set(BlockDiagramController.class, blockDiagramController);

        final BlockDiagramEditController blockDiagramEditController = ContextInjectionFactory.make(BlockDiagramEditController.class, context);
        context.set(BlockDiagramEditController.class, blockDiagramEditController);
    }

    /**
     * Update on event change
     * @param event
     */
    @Inject
    @Optional
    public void updateOnEventChange(@UIEventTopic(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) org.osgi.service.event.Event event) {
//        final Object oldValue = event.getProperty(EventTags.OLD_VALUE);
        final Object newValue = event.getProperty(EventTags.NEW_VALUE);

        if (newValue instanceof MPerspective) {
            final MPerspective perspective = (MPerspective) newValue;

            //
            this.updateWhenPerspectiveHasChanged(perspective);
        }
    }

    /**
     * Update update when perspective has changed
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
     * @param perspective
     */
    @Inject
    @Optional
    private void updateToolbarWhenPerspectiveIsChanged(MPerspective perspective) {
        // change Ibd toolbar renderer
        final boolean ibd_perspective_activated = Ibd_Constants.IBD_PERSPECTIVE_ID.equals(perspective.getElementId());
        this.ibdController.changeIbdToolbarRenderer(ibd_perspective_activated);
    }



//    @Inject
//    @Optional
//    public void event(@UIEventTopic(UIEvents.UILifeCycle.BRINGTOTOP) Object o, EModelService modelService,
//        MApplication application) {
//        System.out.println("event "+o);
////        event.forEach((key, value) -> System.out.println("key="+key+"   " +value));
////        final Object newValue = (Object) event.getProperty(EventTags.NEW_VALUE);
//    }



    // @Inject
    // public void setPerspective(@Optional MPerspective perspective) {
    // System.err.println("TODO "+perspective);
    // }

//    @Inject
//    void setPerspective(@Optional @Named(PocS3_Constants.POCS3_ACTIVE_PERSPECTIVE_VARIABLE) String perspectiveId, MApplication application,
//        EModelService modelService, EMenuService menuService, EPartService partService) {
//        final boolean activate = Ibd_Constants.IBD_PERSPECTIVE_ID.equals(perspectiveId);
//
//
//
//        final MMenuElement ibd_menu = (MMenuElement) modelService.find(Ibd_Constants.IBD_MENU_ID, application);
//        System.out.println("ibd_menu " + ibd_menu);
//        if (activate) {
//            if (ibd_menu == null) {
////                ibd_menu = modelService.createModelElement(MMenuElement.class);
////                ibd_menu.s
//            }
//            ibd_menu.setVisible(activate);
//        } else {
//            if (ibd_menu != null) {
//                ibd_menu.setVisible(activate);
//            }
//        }
//
//        // System.err.println("TODO "+perspectiveId);
//        // if () {
//        // System.err.println("Must activate");
//        // } else {
//        // System.err.println("Must deactivate");
//        // }
//    }

}
