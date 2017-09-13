package pocs3_l3d_model.processor;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_l3d_model.impl.L3dModelImpl;
import pocs3_l3dmodel.IL3dModel;

/**
 *
 */
public class L3DModelProcessor {

    @Execute
    public void execute(IEclipseContext context) {
        final IL3dModel l3dModel = ContextInjectionFactory.make(L3dModelImpl.class, context);

        context.set(IL3dModel.class, l3dModel);
    }
}
