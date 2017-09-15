package pocs3_service_providers;

import pocs3_factory.ElementFactory;
import pocs3_service_definitions.IElement;
import pocs3_service_definitions.IElementService;

/**
 *
 */
public class ElementService implements IElementService {
    @Override
    public IElement createNewElement(String name) {
        return ElementFactory.createNewElement(name);
    }
}
