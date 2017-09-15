package pocs3_common_model.processor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_common_model.IBlockDiagramModel;
import pocs3_common_model.ICommonElementModel;
import pocs3_common_model.impl.BlockDiagramModelImpl;
import pocs3_common_model.impl.CommonElementModelImpl;
import pocs3_service_definitions.IBlocDiagramService;
import pocs3_service_definitions.IBlockDiagram;
import pocs3_service_definitions.IElement;
import pocs3_service_definitions.IElementService;

/**
 *
 */
public class CommonModelProcessor {
    @Execute
    public void execute(IEclipseContext context, IBlocDiagramService blocDiagramService, IElementService elementService) {
        this.createCommonModel(context, blocDiagramService);

        this.createCommonElementModel(context, elementService);
    }

    /**
     * @param context
     * @param blocDiagramService
     */
    private void createCommonModel(IEclipseContext context, IBlocDiagramService blocDiagramService) {
        final IBlockDiagramModel commonModel = ContextInjectionFactory.make(BlockDiagramModelImpl.class, context);

        // add default block diagrams
        final IBlockDiagram KA_return_BlockDiagram = blocDiagramService.createNewBlockDiagram("KA return");
        final IBlockDiagram bd1 = blocDiagramService.createNewBlockDiagram("Ibd1");
        final IBlockDiagram bd2 = blocDiagramService.createNewBlockDiagram("Ibd2");

        final List<IBlockDiagram> defaultBlockDiagrams = Arrays.asList(KA_return_BlockDiagram, bd1, bd2);
        commonModel.addBlockDiagrams(defaultBlockDiagrams);

        context.set(IBlockDiagramModel.class, commonModel);
    }

    /**
     * @param context
     * @param blocDiagramService
     */
    private void createCommonElementModel(IEclipseContext context, IElementService elementService) {
        final ICommonElementModel commonElementModel = ContextInjectionFactory.make(CommonElementModelImpl.class, context);

        // add default elements
        final IElement element1 = elementService.createNewElement("element1");
        final IElement element2 = elementService.createNewElement("element2");
        final IElement element3 = elementService.createNewElement("element3");

        final List<IElement> defaultElements = Arrays.asList(element1, element2, element3);
        commonElementModel.addElements(defaultElements);

        context.set(ICommonElementModel.class, commonElementModel);
    }
}
