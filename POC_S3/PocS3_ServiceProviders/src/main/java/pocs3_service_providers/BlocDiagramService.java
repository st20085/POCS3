package pocs3_service_providers;

import pocs3_factory.BlockDiagramFactory;
import pocs3_service_definitions.IBlocDiagramService;
import pocs3_service_definitions.IBlockDiagram;

/**
 *
 */
public class BlocDiagramService implements IBlocDiagramService {

    @Override
    public IBlockDiagram createNewBlockDiagram(String name) {
        return BlockDiagramFactory.createNewBlockDiagram(name);
    }

}