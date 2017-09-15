package pocs3_factory.impl;

import pocs3_service_definitions.IBlockDiagram;

/**
 * The class BlockDiagram define default implementation of IBlockDiagram
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
