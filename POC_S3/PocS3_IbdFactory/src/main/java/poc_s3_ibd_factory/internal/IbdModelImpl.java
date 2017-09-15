package poc_s3_ibd_factory.internal;

import javax.inject.Inject;

import pocs3_common_model.ICommonElementModel;
import pocs3_common_model.IBlockDiagramModel;
import pocs3_ibdmodel.IbdModel;

/**
 * The class IbdModelImpl define default implementation of IbdModel
 */
public class IbdModelImpl implements IbdModel {

    @Inject
    IBlockDiagramModel commonModel;

    @Inject
    ICommonElementModel commonElementModel;

    @Override
    public IBlockDiagramModel getBlocDiagramModel() {
        return this.commonModel;
    }

    @Override
    public ICommonElementModel getCommonElementModel() {
        return this.commonElementModel;
    }


}
