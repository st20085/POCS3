package pocs3_ibd.internal;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

import pocs3_eap.transfer.BlockDiagramTransfer;
import pocs3_ibdmodel.IbdModel;
import pocs3_service_definitions.IBlockDiagram;
import pocs3_service_definitions.IEditAction;

/**
 *
 */
public class BlockDiagramEditController implements IEditAction {
    @Inject
    IbdModel ibdModel;

    private IBlockDiagram[] selectedBlockDiagrams;

    /**
     * @param selectedBlockDiagrams
     */
    public void setBlockDiagrams(IBlockDiagram[] selectedBlockDiagrams) {
        this.selectedBlockDiagrams = selectedBlockDiagrams;
    }

    /*
     * @see pocs3_service_definitions.IEditAction#canCopy()
     */
    @Override
    public boolean canCopy() {
        return this.selectedBlockDiagrams != null && this.selectedBlockDiagrams.length != 0;
    }

    /*
     * @see pocs3_service_definitions.IEditAction#copy()
     */
    @Override
    public void copy() {
        this.copySelectedBlocDiagramsToClipboard(this.selectedBlockDiagrams);
    }

    /**
     *
     */
    @Override
    public String getCopyTooltip() {
        final String blockDiagramNames = Arrays.stream(this.selectedBlockDiagrams)
            .map(IBlockDiagram::getName)
            .collect(Collectors.joining(", "));

        return IEditAction.super.getCopyTooltip() + " bloc diagram(s) '" + blockDiagramNames + "'";
    }

    /*
     * @see pocs3_service_definitions.IEditAction#canCut()
     */
    @Override
    public boolean canCut() {
        return this.canCopy();
    }

    /*
     * @see pocs3_service_definitions.IEditAction#cut()
     */
    @Override
    public void cut() {
        this.copy();

        // TODO faire un undoRedo operation
        this.ibdModel.getBlocDiagramModel().removeBlockDiagrams(Arrays.asList(this.selectedBlockDiagrams));
    }

    /**
     * @see pocs3_service_definitions.IEditAction#getCutTooltip()
     */
    @Override
    public String getCutTooltip() {
        final String blockDiagramNames = Arrays.stream(this.selectedBlockDiagrams)
            .map(IBlockDiagram::getName)
            .collect(Collectors.joining(", "));

        return IEditAction.super.getCutTooltip() + " bloc diagram(s) '" + blockDiagramNames + "'";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * @see pocs3_service_definitions.IEditAction#canPaste()
     */
    @Override
    public boolean canPaste() {

        final Clipboard clipboard = new Clipboard(null);

        final BlockDiagramTransfer blockDiagramTransfer = BlockDiagramTransfer.getInstance();

        // check if
        try {
            for (final TransferData transferData : clipboard.getAvailableTypes()) {
                // supported block diagram type
                if (blockDiagramTransfer.isSupportedType(transferData)) {
                    return true;
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            clipboard.dispose();
        }

        return false;
    }

    /**
    *
    */
    @Override
    public String getPasteTooltip() {
        final IBlockDiagram[] blockDiagrams = this.getBlockDiagramFromClipboard();

        final String blockDiagramNames = Arrays.stream(blockDiagrams)
            .map(IBlockDiagram::getName)
            .collect(Collectors.joining(", "));

        return IEditAction.super.getPasteTooltip() + " bloc diagram(s) '" + blockDiagramNames + "'";
    }

    /*
     * @see pocs3_service_definitions.IEditAction#paste()
     */
    @Override
    public void paste() {

        final IBlockDiagram[] blockDiagrams = this.getBlockDiagramFromClipboard();

        // TODO faire un undoRedo operation
        this.ibdModel.getBlocDiagramModel().addBlockDiagrams(Arrays.asList(blockDiagrams));
    }

    /**
     * Get Block diagrams from clipboard
     *
     * @param clipboard
     */
    public IBlockDiagram[] getBlockDiagramFromClipboard() {
        final Clipboard clipboard = new Clipboard(null);

        try {
            // get blockDiagrams from clipboard
            final BlockDiagramTransfer blockDiagramTransfer = BlockDiagramTransfer.getInstance();
            final IBlockDiagram[] blockDiagrams = (IBlockDiagram[]) clipboard.getContents(blockDiagramTransfer);

            // remove clipboard contents
            // clipboard.clearContents();
            // clipboard.setContents(new String[] {"e"}, new Transfer[] {TextTransfer.getInstance()});

            // System.out.println("clear "+clipboard.getContents(blockDiagramTransfer));
            return blockDiagrams;
        } finally {
            clipboard.dispose();
        }
    }

    /**
     * Copy selected bloc diagrams to clipboard
     *
     * @param blockDiagrams
     */
    public void copySelectedBlocDiagramsToClipboard(IBlockDiagram[] blockDiagrams) {
        final Clipboard clipboard = new Clipboard(null);
        try {
            final String text = Arrays.stream(blockDiagrams)
                .map(IBlockDiagram::getName)
                .collect(Collectors.joining(", "));

            final TextTransfer textTransfer = TextTransfer.getInstance();
            final BlockDiagramTransfer blockDiagramTransfer = BlockDiagramTransfer.getInstance();
            final Transfer[] transfers = new Transfer[] {textTransfer, blockDiagramTransfer};

            // set contents
            final Object[] data = new Object[] {text, blockDiagrams};
            clipboard.setContents(data, transfers);

        } finally {
            clipboard.dispose();
        }
    }
}
