package poc_s3_ibd_factory.processor;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.impl.AdvancedPackageImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

import poc_s3_ibd_factory.internal.IbdModelImpl;
import pocs3_ibdcontroller.BlockDiagramController;
import pocs3_ibdcontroller.BlockDiagramEditController;
import pocs3_ibdmodel.IbdModel;

/**
 *
 */
public class IbdModelProcessor {
//    @Execute
//    public void execute(IEclipseContext context) {
//        final IbdModel ibdModel = ContextInjectionFactory.make(IbdModelImpl.class, context);
//
//        context.set(IbdModel.class, ibdModel);
//    }

    public static final String IBD_PERSPECTIVE_ID = "pocs3_ibd.perspective"; // temporaire

    @Execute
    public void execute(IEclipseContext context, EModelService modelService, MApplication application) {

        // find perspective
        final MPerspective perspective = (MPerspective) modelService.find(IBD_PERSPECTIVE_ID, application);
        if (perspective != null) {
            final EObject perspectiveEObject = (EObject) perspective;
            perspectiveEObject.eAdapters().add(new AdapterImpl() {
                @Override
                public void notifyChanged(Notification notification) {
                    // when perspective change context
                    if (notification.getEventType() == Notification.SET && notification.getFeatureID(MPerspective.class) == AdvancedPackageImpl.PERSPECTIVE__CONTEXT) {
                        IbdModelProcessor.this.updateWhenPerspectiveContextChanges(perspective);
                    }
                }
            });
        }
    }

    /**
     *
     * @param perspective
     */
    private void updateWhenPerspectiveContextChanges(MPerspective perspective) {
        final IEclipseContext perspectiveContext = perspective.getContext();
        if (perspectiveContext != null) {
            final IbdModel ibdModel = ContextInjectionFactory.make(IbdModelImpl.class, perspectiveContext);
            perspectiveContext.set(IbdModel.class, ibdModel);

              final BlockDiagramController blockDiagramController = ContextInjectionFactory.make(BlockDiagramController.class, perspectiveContext);
              perspectiveContext.set(BlockDiagramController.class, blockDiagramController);

              final BlockDiagramEditController blockDiagramEditController = ContextInjectionFactory.make(BlockDiagramEditController.class, perspectiveContext);
              perspectiveContext.set(BlockDiagramEditController.class, blockDiagramEditController);

        }
    }
}
