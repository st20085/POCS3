package pocs3_common_model;

import java.util.List;

import pocs3_common_model.event.BlockDiagramModelListener;
import pocs3_service_definitions.IBlockDiagram;

/**
 *
 */
public interface IBlockDiagramModel extends IROBlockDiagramModel {
    public static enum BLOCK_DIAGRAM_MODEL_EVENT_TYPE {BLOCK_DIAGRAM_ADDED, BLOCK_DIAGRAM_REMOVED};

    /**
     * @param blockDiagrams
     */
    void removeBlockDiagrams(List<IBlockDiagram> blockDiagrams);

    /**
     * @param blockDiagrams
     */
    void addBlockDiagrams(List<IBlockDiagram> blockDiagrams);

    /**
     * @param blockDiagramModelListener
     */
    void addBlockDiagramModelListener(BlockDiagramModelListener blockDiagramModelListener);

    /**
     * @param commonModelListener
     */
    void removeBlockDiagramModelListener(BlockDiagramModelListener blockDiagramModelListener);
}
