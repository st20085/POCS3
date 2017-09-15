package pocs3_l3d_model;

import pocs3_common_model.IBlockDiagramModel;
import pocs3_common_model.ICommonElementModel;

/**
 *
 */
public interface IL3dModel {
    /**
     * Return the common model
     */
    IBlockDiagramModel getCommonModel();

    /**
     * Return the common element model
     */
    ICommonElementModel getCommonElementModel();
}
