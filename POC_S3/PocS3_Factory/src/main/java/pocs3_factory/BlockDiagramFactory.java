package pocs3_factory;

import pocs3_factory.impl.BlockDiagram;
import pocs3_service_definitions.IBlockDiagram;

/**
 *
 */
public class BlockDiagramFactory {

    /**
     * Create new blockDiagram
     */
    public static IBlockDiagram createNewBlockDiagram(String name) {
        final BlockDiagram blockDiagram = new BlockDiagram();
        blockDiagram.setName(name);
        return blockDiagram;
    }
}
