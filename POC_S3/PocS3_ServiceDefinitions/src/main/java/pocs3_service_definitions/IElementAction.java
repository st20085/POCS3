package pocs3_service_definitions;

/**
 *
 */
public interface IElementAction {
    /**
     * @return
     */
    default boolean canCreateElement() {
        return false;
    }


    /**
     * @param elementName
     */
    default void createElement(String elementName){
        // POC use RuntimeException
        throw new RuntimeException("Create element not implemented");
    }
}
