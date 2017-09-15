package pocs3_ibdcontroller;


import java.util.Collections;

import javax.inject.Inject;

import pocs3_common_model.event.BlockDiagramModelListener;
import pocs3_ibdmodel.IbdModel;
import pocs3_ibdmodel.action.IBlockDiagramAction;
import pocs3_service_definitions.IBlocDiagramService;
import pocs3_service_definitions.IBlockDiagram;

/**
 * The class BlockDiagramController control the creation of block diagram in IbdModel
 */
public class BlockDiagramController implements IBlockDiagramAction {
    @Inject
    IBlocDiagramService blocDiagramService;

    @Inject
    IbdModel ibdModel;

    @Override
    public boolean canCreateBlockDiagrams() {
        return true;
    }

    @Override
    public void createBlockDiagram(String blockDiagramName) {
        final IBlockDiagram blockDiagram = this.blocDiagramService.createNewBlockDiagram(blockDiagramName);

        this.ibdModel.getBlocDiagramModel().addBlockDiagrams(Collections.singletonList(blockDiagram));
    }

    /**
     * @return
     */
    public Object getBlockDiagrams() {
        return this.ibdModel.getBlocDiagramModel().getBlockDiagrams();
    }

    /**
     * @param commonModelListener
     */
    public void addIbdModelListener(BlockDiagramModelListener commonModelListener) {
        this.ibdModel.getBlocDiagramModel().addCommonModelListener(commonModelListener);
    }

    /**
     * @param ibdModelListener
     */
    public void removeIbdModelListener(BlockDiagramModelListener ibdModelListener) {
        this.ibdModel.getBlocDiagramModel().removeCommonModelListener(ibdModelListener);
    }

}
