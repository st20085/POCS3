package poc_s3_ibd_factory.processor;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

import poc_s3_ibd_factory.internal.IbdModelImpl;
import pocs3_ibdmodel.IbdModel;

/**
 *
 */
public class IbdModelProcessor {
    @Execute
    public void execute(IEclipseContext context) {
        final IbdModel ibdModel = ContextInjectionFactory.make(IbdModelImpl.class, context);

        context.set(IbdModel.class, ibdModel);
    }
}
