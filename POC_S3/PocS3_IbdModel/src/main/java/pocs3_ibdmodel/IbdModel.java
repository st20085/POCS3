package pocs3_ibdmodel;

import java.util.List;

import pocs3_common_model.ICommonModel;
import pocs3_ibdmodel.event.IbdModelListener;

/**
 *
 */
public interface IbdModel {
    public static enum IBD_MODEL_EVENT_TYPE {IBDMODEL_BLOCK_DIAGRAM_ADDED, IBDMODEL_BLOCK_DIAGRAM_REMOVED};

    /**
     * Return the common model
     */
    ICommonModel getCommonModel();

    /**
     * @return
     */
    List<IBlockDiagram> getBlockDiagrams();

    /**
     * @param asList
     */
    void removeBlockDiagrams(List<IBlockDiagram> asList);

    /**
     * @param asList
     */
    void addBlockDiagrams(List<IBlockDiagram> asList);

    /**
     *
     * @param listener
     */
    void addIbdModelListener(IbdModelListener listener);

    /**
     *
     * @param listener
     */
    void removeIbdModelListener(IbdModelListener listener);
}
