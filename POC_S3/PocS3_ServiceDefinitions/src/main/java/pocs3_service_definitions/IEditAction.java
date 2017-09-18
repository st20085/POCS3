
package pocs3_service_definitions;

import pocs3_service_definitions.exceptions.NotEditImplementedException;

/**
 * The interface <b>IEditAction</b> defines some generic actions.<br>
 */
public interface IEditAction {
    public static final String DEFAULT_UNDO_TOOLTIP = "Undo";
    public static final String DEFAULT_REDO_TOOLTIP = "Redo";

    public static final String DEFAULT_COPY_TOOLTIP = "Copy";
    public static final String DEFAULT_CUT_TOOLTIP = "Cut";
    public static final String DEFAULT_PASTE_TOOLTIP = "Paste";

    ///////////////////////////////////////////////////////////////////////////

    /**
     * @return
     */
    public default boolean canCopy() {
        return false;
    }

    /**
     * Return the Copy tooltip
     */
    public default String getCopyTooltip() {
        return DEFAULT_COPY_TOOLTIP;
    }

    /**
     */
    public default void copy() {
        throw new NotEditImplementedException("Copy not implemented");
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * @return
     */
    public default boolean canPaste() {
        return false;
    }

    /**
     * Return the Paste tooltip
     */
    public default String getPasteTooltip() {
        return DEFAULT_PASTE_TOOLTIP;
    }

    /**
     */
    public default void paste() {
        throw new NotEditImplementedException("Paste not implemented");
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * @return
     */
    public default boolean canCut() {
        return false;
    }

    /**
     * Return the Cut tooltip
     */
    public default String getCutTooltip() {
        return DEFAULT_CUT_TOOLTIP;
    }

    /**
     */
    public default void cut() {
        throw new NotEditImplementedException("Cut not implemented");
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * @return
     */
    public default boolean canUndo() {
        return false;
    }

    /**
     * Return the Undo tooltip
     */
    public default String getUndoTooltip() {
        return DEFAULT_UNDO_TOOLTIP;
    }

    /**
     */
    public default void undo() {
        throw new NotEditImplementedException("Undo not implemented");
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * @return
     */
    public default boolean canRedo() {
        return false;
    }

    /**
     * Return the Redo tooltip
     */
    public default String getRedoTooltip() {
        return DEFAULT_REDO_TOOLTIP;
    }

    /**
     */
    public default void redo() {
        throw new NotEditImplementedException("Redo not implemented");
    }


    // /**
    // * React to delete event
    // */
    // public void doDelete();
}
