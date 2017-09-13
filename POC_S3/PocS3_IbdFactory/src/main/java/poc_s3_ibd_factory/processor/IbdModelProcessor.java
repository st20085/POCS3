package poc_s3_ibd_factory.processor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;

import poc_s3_ibd_factory.internal.IbdModelImpl;
import pocs3_ibd_service_definitions.IBlocDiagramService;
import pocs3_ibdmodel.IBlockDiagram;
import pocs3_ibdmodel.IbdModel;

/**
 *
 */
public class IbdModelProcessor {
    @Execute
    public void execute(IEclipseContext context) {
        final IbdModel ibdModel = ContextInjectionFactory.make(IbdModelImpl.class, context);

        // add default block diagrams
        final IBlocDiagramService blocDiagramService = E4Workbench.getServiceContext().get(IBlocDiagramService.class);
        final IBlockDiagram KA_return_BlockDiagram = blocDiagramService.createNewBlockDiagram("KA return");
        final IBlockDiagram ibd1 = blocDiagramService.createNewBlockDiagram("Ibd1");
        final IBlockDiagram ibd2 = blocDiagramService.createNewBlockDiagram("Ibd2");

        final List<IBlockDiagram> defaultBlockDiagrams = Arrays.asList(KA_return_BlockDiagram, ibd1, ibd2);
        ibdModel.addBlockDiagrams(defaultBlockDiagrams);

        context.set(IbdModel.class, ibdModel);
    }
}
