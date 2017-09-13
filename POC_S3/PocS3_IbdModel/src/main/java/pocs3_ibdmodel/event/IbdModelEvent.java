package pocs3_ibdmodel.event;

import java.util.List;

import pocs3_ibdmodel.IBlockDiagram;
import pocs3_ibdmodel.IbdModel;
import pocs3_ibdmodel.IbdModel.IBD_MODEL_EVENT_TYPE;

/**
 *
 */
public class IbdModelEvent {

    // public for the POC
    public final IbdModel ibdModel;
    public final IBD_MODEL_EVENT_TYPE ibd_model_event_type;
    public final List<IBlockDiagram> blockDiagrams;

    public IbdModelEvent(IbdModel ibdModel, IBD_MODEL_EVENT_TYPE ibd_model_event_type, List<IBlockDiagram> blockDiagrams) {
        this.ibdModel = ibdModel;
        this.ibd_model_event_type = ibd_model_event_type;
        this.blockDiagrams = blockDiagrams;
    }
}
