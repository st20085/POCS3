package pocs3_common_model.processor;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_common_model.ICommonModel;
import pocs3_common_model.impl.CommonModelImpl;

/**
 *
 */
public class CommonModelProcessor {
    @Execute
    public void execute(IEclipseContext context) {
        final ICommonModel commonModel = ContextInjectionFactory.make(CommonModelImpl.class, context);

        context.set(ICommonModel.class, commonModel);
    }
}
