package pocs3_factory.impl;

import pocs3_service_definitions.IElement;

/**
 * The class Element define default implementation of IElement
 */
public class Element implements IElement {
    private final String name;

    public Element(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
