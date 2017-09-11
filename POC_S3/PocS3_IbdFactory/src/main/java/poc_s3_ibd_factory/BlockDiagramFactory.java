// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package poc_s3_ibd_factory;

import poc_s3_ibd_factory.internal.BlockDiagram;
import pocs3_ibd_service_definitions.IBlockDiagram;

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
