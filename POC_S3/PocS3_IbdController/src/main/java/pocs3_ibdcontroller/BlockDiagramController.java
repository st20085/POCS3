package pocs3_ibdcontroller;


import java.util.Collections;

import javax.inject.Inject;

import pocs3_ibd_service_definitions.IBlocDiagramService;
import pocs3_ibdmodel.IBlockDiagram;
import pocs3_ibdmodel.IbdModel;
import pocs3_ibdmodel.action.IBlockDiagramAction;
import pocs3_ibdmodel.event.IbdModelListener;

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

        this.ibdModel.addBlockDiagrams(Collections.singletonList(blockDiagram));
    }

    /**
     * @return
     */
    public Object getBlockDiagrams() {
        return this.ibdModel.getBlockDiagrams();
    }

    /**
     * @param ibdModelListener
     */
    public void addIbdModelListener(IbdModelListener ibdModelListener) {
        this.ibdModel.addIbdModelListener(ibdModelListener);
    }

    /**
     * @param ibdModelListener
     */
    public void removeIbdModelListener(IbdModelListener ibdModelListener) {
        this.ibdModel.removeIbdModelListener(ibdModelListener);
    }

}
