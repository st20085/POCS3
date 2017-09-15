package pocs3_l3d_model.impl;

import javax.inject.Inject;

import pocs3_common_model.IBlockDiagramModel;
import pocs3_common_model.ICommonElementModel;
import pocs3_l3d_model.IL3dModel;

/**
 *
 */
public class L3dModelImpl implements IL3dModel {
    @Inject
    IBlockDiagramModel commonModel;

    @Inject
    ICommonElementModel commonElementModel;

    @Override
    public IBlockDiagramModel getCommonModel() {
        return this.commonModel;
    }

    @Override
    public ICommonElementModel getCommonElementModel() {
        return this.commonElementModel;
    }

}
