package pocs3_ibdmodel.action;

/**
 * The class <b>IBlockDiagramAction</b> allows to.<br>
 */
public interface IBlockDiagramAction {

    /**
     * @return
     */
    default boolean canCreateBlockDiagrams() {
        return false;
    }


    /**
     * @param blockDiagramName
     */
    default void createBlockDiagram(String blockDiagramName){
        // POC use RuntimeException
        throw new RuntimeException("Create block diagrams not implemented");
    }

    /**
     * @return
     */
    default boolean canOpenBlockDiagrams() {
        return false;
    }

    /**
     *
     */
    default void openBlockDiagrams() {
        // POC use RuntimeException
        throw new RuntimeException("Open block diagrams not implemented");
    }

}
