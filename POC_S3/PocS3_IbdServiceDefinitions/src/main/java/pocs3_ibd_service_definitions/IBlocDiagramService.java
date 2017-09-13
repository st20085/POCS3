package pocs3_ibd_service_definitions;

import pocs3_ibdmodel.IBlockDiagram;

/**
 * The interface <b>IBlocDiagramService</b> allows to.<br>
 */
public interface IBlocDiagramService {

    /**
     * Create new Block diagram
     * @param name
     */
    public IBlockDiagram createNewBlockDiagram(String name);
}
