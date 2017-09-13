package pocs3_ibd_service_providers;

import poc_s3_ibd_factory.BlockDiagramFactory;
import pocs3_ibd_service_definitions.IBlocDiagramService;
import pocs3_ibdmodel.IBlockDiagram;

/**
 *
 */
public class BlocDiagramService implements IBlocDiagramService {

    public BlocDiagramService() {
    }

    @Override
    public IBlockDiagram createNewBlockDiagram(String name) {
        return BlockDiagramFactory.createNewBlockDiagram(name);
    }

}
