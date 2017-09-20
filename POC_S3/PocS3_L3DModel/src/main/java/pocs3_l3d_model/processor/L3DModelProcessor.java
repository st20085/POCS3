
package pocs3_l3d_model.processor;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_l3d_model.IL3dModel;
import pocs3_l3d_model.impl.L3dModelImpl;

/**
 *
 */
public class L3DModelProcessor {
    public static final String L3D_PERSPECTIVE_ID = "pocs3_l3d.perspective"; // temporaire

    @Execute
    public void execute(IEclipseContext context) {
        // Inject l3dModel to context
        final IL3dModel l3dModel = ContextInjectionFactory.make(L3dModelImpl.class, context);
        context.set(IL3dModel.class, l3dModel);
    }


//    @Execute
//    public void execute(IEclipseContext context, EModelService modelService, MApplication application) {
//
//        // find L3D perspective
//        final MPerspective l3dPerspective = (MPerspective) modelService.find(L3D_PERSPECTIVE_ID, application);
//        if (l3dPerspective != null) {
//            final EObject l3dPerspectiveEObject = (EObject) l3dPerspective;
//            l3dPerspectiveEObject.eAdapters().add(new AdapterImpl() {
//                @Override
//                public void notifyChanged(Notification notification) {
//                    // when perspective change context
//                    if (notification.getEventType() == Notification.SET && notification.getFeatureID(MPerspective.class) == AdvancedPackageImpl.PERSPECTIVE__CONTEXT) {
//                        L3DModelProcessor.this.updateWhenL3DPerspectiveContextChanges(l3dPerspective);
//                    }
//                }
//            });
//        }
//    }
//
//    /**
//     *
//     * @param l3dPerspective
//     */
//    private void updateWhenL3DPerspectiveContextChanges(MPerspective l3dPerspective) {
//        this.injectL3DModel(l3dPerspective);
//    }
//
//    /**
//     * @param l3dPerspective
//     */
//    private void injectL3DModel(MPerspective l3dPerspective) {
//        final IEclipseContext ibdPerspectiveContext = l3dPerspective.getContext();
//        if (ibdPerspectiveContext != null) {
//            // Inject l3dModel to l3dPerspective context
//            final IL3dModel l3dModel = ContextInjectionFactory.make(L3dModelImpl.class, ibdPerspectiveContext);
//            ibdPerspectiveContext.set(IL3dModel.class, l3dModel);
//        }
//    }
}
