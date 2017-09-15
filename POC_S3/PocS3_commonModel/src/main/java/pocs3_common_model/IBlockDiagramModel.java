package pocs3_common_model;

import java.util.List;

import pocs3_common_model.event.BlockDiagramModelListener;
import pocs3_service_definitions.IBlockDiagram;

/**
 *
 */
public interface IBlockDiagramModel {
    public static enum BLOCK_DIAGRAM_MODEL_EVENT_TYPE {BLOCK_DIAGRAM_ADDED, BLOCK_DIAGRAM_REMOVED};

    List<IBlockDiagram> getBlockDiagrams();

    /**
     * @param asList
     */
    void removeBlockDiagrams(List<IBlockDiagram> asList);

    /**
     * @param asList
     */
    void addBlockDiagrams(List<IBlockDiagram> asList);

    /**
     * @param commonModelListener
     */
    void addCommonModelListener(BlockDiagramModelListener commonModelListener);

    /**
     * @param commonModelListener
     */
    void removeCommonModelListener(BlockDiagramModelListener commonModelListener);
}
