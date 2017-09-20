package pocs3_common_model.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import pocs3_common_model.IBlockDiagramModel;
import pocs3_common_model.event.BlockDiagramModelEvent;
import pocs3_common_model.event.BlockDiagramModelListener;
import pocs3_service_definitions.IBlockDiagram;

/**
 *
 */
public class BlockDiagramModelImpl implements IBlockDiagramModel {

    List<IBlockDiagram> blockDiagramList = new ArrayList<>();

    Set<BlockDiagramModelListener> listeners = new LinkedHashSet<>();

    @Override
    public List<IBlockDiagram> getBlockDiagrams() {
        return new ArrayList<>(this.blockDiagramList);
    }

    @Override
    public void removeBlockDiagrams(List<IBlockDiagram> blockDiagramToRemove) {
        // POC dont check if all blockDiagram has been removed
        this.blockDiagramList.removeAll(blockDiagramToRemove);

        // send event
        final BlockDiagramModelEvent commonModelEvent = new BlockDiagramModelEvent(this, IBlockDiagramModel.BLOCK_DIAGRAM_MODEL_EVENT_TYPE.BLOCK_DIAGRAM_REMOVED, blockDiagramToRemove);
        this.listeners.forEach(listener -> listener.modelChanged(commonModelEvent));
    }

    @Override
    public void addBlockDiagrams(List<IBlockDiagram> blockDiagramToAdd) {
        // POC dont check if all blockDiagram has been added
        this.blockDiagramList.addAll(blockDiagramToAdd);

     // send event
        final BlockDiagramModelEvent commonModelEvent = new BlockDiagramModelEvent(this, IBlockDiagramModel.BLOCK_DIAGRAM_MODEL_EVENT_TYPE.BLOCK_DIAGRAM_ADDED, blockDiagramToAdd);
        this.listeners.forEach(listener -> listener.modelChanged(commonModelEvent));
    }

    @Override
    public void addBlockDiagramModelListener(BlockDiagramModelListener blockDiagramModelListener) {
        this.listeners.add(blockDiagramModelListener);
    }

    @Override
    public void removeBlockDiagramModelListener(BlockDiagramModelListener blockDiagramModelListener) {
        this.listeners.remove(blockDiagramModelListener);
    }
}
