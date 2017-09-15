package pocs3_common_model.event;

import java.util.List;

import pocs3_common_model.ICommonElementModel;
import pocs3_common_model.ICommonElementModel.COMMON_ELEMENT_MODEL_EVENT_TYPE;
import pocs3_service_definitions.IElement;

/**
 *
 */
public class CommonElementModelEvent {

    // public for the POC
    public final ICommonElementModel commonElementModel;
    public final COMMON_ELEMENT_MODEL_EVENT_TYPE common_model_event_type;
    public final List<IElement> elements;

    public CommonElementModelEvent(ICommonElementModel commonModel, COMMON_ELEMENT_MODEL_EVENT_TYPE common_model_event_type, List<IElement> elements) {
        this.commonElementModel = commonModel;
        this.common_model_event_type = common_model_event_type;
        this.elements = elements;
    }
}
