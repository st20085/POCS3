package pocs3_l3d_model.impl;

import javax.inject.Inject;

import pocs3_common_model.ICommonModel;
import pocs3_l3dmodel.IL3dModel;

/**
 *
 */
public class L3dModelImpl implements IL3dModel {
    @Inject
    ICommonModel commonModel;

    @Override
    public ICommonModel getCommonModel() {
        return this.commonModel;
    }

}
