package pocs3_ibdmodel;

import pocs3_common_model.IBlockDiagramModel;
import pocs3_common_model.ICommonElementModel;

/**
 *
 */
public interface IbdModel {

    /**
     * Return the block diagram model
     */
    IBlockDiagramModel getBlocDiagramModel();

    /**
     * Return the common element model
     */
    ICommonElementModel getCommonElementModel();

}
