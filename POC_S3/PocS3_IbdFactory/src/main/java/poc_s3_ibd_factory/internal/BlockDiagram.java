package poc_s3_ibd_factory.internal;

import pocs3_ibd_service_definitions.IBlockDiagram;

/**
 *
 */
public class BlockDiagram implements IBlockDiagram {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
