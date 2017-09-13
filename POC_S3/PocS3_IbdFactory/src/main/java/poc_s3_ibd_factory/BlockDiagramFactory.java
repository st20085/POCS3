package poc_s3_ibd_factory;

import poc_s3_ibd_factory.internal.BlockDiagram;
import pocs3_ibdmodel.IBlockDiagram;

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
