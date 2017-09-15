package pocs3_factory;

import pocs3_factory.impl.Element;
import pocs3_service_definitions.IElement;

/**
 *
 */
public class ElementFactory {

    /**
     * Create new element
     */
    public static IElement createNewElement(String name) {
        final Element element = new Element(name);
        return element;
    }
}
