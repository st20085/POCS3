package pocs3_common_model.event;

import java.util.List;

import pocs3_common_model.IBlockDiagramModel;
import pocs3_common_model.IBlockDiagramModel.BLOCK_DIAGRAM_MODEL_EVENT_TYPE;
import pocs3_service_definitions.IBlockDiagram;

/**
 *
 */
public class BlockDiagramModelEvent {

    // public for the POC
    public final IBlockDiagramModel commonModel;
    public final BLOCK_DIAGRAM_MODEL_EVENT_TYPE common_model_event_type;
    public final List<IBlockDiagram> blockDiagrams;

    public BlockDiagramModelEvent(IBlockDiagramModel commonModel, BLOCK_DIAGRAM_MODEL_EVENT_TYPE common_model_event_type, List<IBlockDiagram> blockDiagrams) {
        this.commonModel = commonModel;
        this.common_model_event_type = common_model_event_type;
        this.blockDiagrams = blockDiagrams;
    }
}
