package poc_s3_ibd_factory.internal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import pocs3_common_model.ICommonModel;
import pocs3_ibdmodel.IBlockDiagram;
import pocs3_ibdmodel.IbdModel;
import pocs3_ibdmodel.event.IbdModelEvent;
import pocs3_ibdmodel.event.IbdModelListener;

/**
 * The class IbdModelImpl define default implementation of IbdModel
 */
public class IbdModelImpl implements IbdModel {

    @Inject
    ICommonModel commonModel;

    List<IBlockDiagram> blockDiagramList = new ArrayList<>();

    Set<IbdModelListener> listeners = new LinkedHashSet<>();

    @Override
    public List<IBlockDiagram> getBlockDiagrams() {
        return new ArrayList<>(this.blockDiagramList);
    }

    @Override
    public void removeBlockDiagrams(List<IBlockDiagram> blockDiagramToRemove) {
        // POC dont check if all blockDiagram has been removed
        this.blockDiagramList.removeAll(blockDiagramToRemove);

        // send event
//        this.eventBroker.post(IbdModel.IBDMODEL_BLOCK_DIAGRAM_REMOVED, data);
        final IbdModelEvent ibdModelEvent = new IbdModelEvent(this, IbdModel.IBD_MODEL_EVENT_TYPE.IBDMODEL_BLOCK_DIAGRAM_REMOVED, blockDiagramToRemove);
        this.listeners.forEach(listener -> listener.modelChanged(ibdModelEvent));
    }

    @Override
    public void addBlockDiagrams(List<IBlockDiagram> blockDiagramToAdd) {
        // POC dont check if all blockDiagram has been added
        this.blockDiagramList.addAll(blockDiagramToAdd);

     // send event
//        this.eventBroker.post(IbdModel.IBDMODEL_BLOCK_DIAGRAM_ADDED, data);
        final IbdModelEvent ibdModelEvent = new IbdModelEvent(this, IbdModel.IBD_MODEL_EVENT_TYPE.IBDMODEL_BLOCK_DIAGRAM_ADDED, blockDiagramToAdd);
        this.listeners.forEach(listener -> listener.modelChanged(ibdModelEvent));
    }

    @Override
    public void addIbdModelListener(IbdModelListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeIbdModelListener(IbdModelListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public ICommonModel getCommonModel() {
        return this.commonModel;
    }
}
