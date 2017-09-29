package pocs3_common_model;

import java.util.List;

import pocs3_service_definitions.IElement;

/**
 *
 */
public interface ICommonElementModel {
    public static enum COMMON_ELEMENT_MODEL_EVENT_TYPE {COMMON_MODEL_ELEMENT_ADDED, COMMON_MODEL_ELEMENT_REMOVED};
    public static String COMMON_MODEL_CHANGED_TOPIC = "POCS3/COMMON_MODEL/*";
    public static String COMMON_MODEL_ELEMENTS_ADDED_TOPIC = "POCS3/COMMON_MODEL/ELEMENTS_ADDED";
    public static String COMMON_MODEL_ELEMENTS_REMOVED_TOPIC = "POCS3/COMMON_MODEL/ELEMENTS_REMOVED";

    List<IElement> getElements();

    /**
     * @param elements
     */
    void removeElements(List<IElement> elements);

    /**
     * @param elements
     */
    void addElements(List<IElement> elements);

//    /**
//     * @param commonElementModelListener
//     */
//    void addCommonElementModelListener(CommonElementModelListener commonElementModelListener);
//
//    /**
//     * @param commonElementModelListener
//     */
//    void removeCommonElementModelListener(CommonElementModelListener commonElementModelListener);
}
