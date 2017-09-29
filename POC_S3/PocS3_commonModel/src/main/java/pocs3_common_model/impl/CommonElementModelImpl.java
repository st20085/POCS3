package pocs3_common_model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;

import pocs3_common_model.ICommonElementModel;
import pocs3_service_definitions.IElement;

/**
 *
 */
public class CommonElementModelImpl implements ICommonElementModel {

    List<IElement> elementList = new ArrayList<>();

//    Set<CommonElementModelListener> listeners = new LinkedHashSet<>();

    @Inject
    IEventBroker eventBoker;

    @Override
    public List<IElement> getElements() {
        return new ArrayList<>(this.elementList);
    }

    @Override
    public void removeElements(List<IElement> elements) {
        // POC dont check if all elements have been removed
        this.elementList.removeAll(elements);

        // send event
//        final CommonElementModelEvent commonElementModelEvent = new CommonElementModelEvent(this, ICommonElementModel.COMMON_ELEMENT_MODEL_EVENT_TYPE.COMMON_MODEL_ELEMENT_REMOVED, elements);
//        this.listeners.forEach(listener -> listener.modelChanged(commonElementModelEvent));

        // use event bus
        eventBoker.post(COMMON_MODEL_ELEMENTS_REMOVED_TOPIC, elements);
    }

    @Override
    public void addElements(List<IElement> elements) {
        // POC dont check if all elements have been added
        this.elementList.addAll(elements);

        // send event
//        final CommonElementModelEvent commonModelEvent = new CommonElementModelEvent(this, ICommonElementModel.COMMON_ELEMENT_MODEL_EVENT_TYPE.COMMON_MODEL_ELEMENT_ADDED, elements);
//        this.listeners.forEach(listener -> listener.modelChanged(commonModelEvent));

        // use event bus
        eventBoker.post(COMMON_MODEL_ELEMENTS_ADDED_TOPIC, elements);
    }

//    @Override
//    public void addCommonElementModelListener(CommonElementModelListener commonElementModelListener) {
//        this.listeners.add(commonElementModelListener);
//    }
//
//    @Override
//    public void removeCommonElementModelListener(CommonElementModelListener commonElementModelListener) {
//        this.listeners.remove(commonElementModelListener);
//    }
}
