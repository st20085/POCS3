
package pocs3_ibdcontroller;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
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
    IEclipseContext eclipseContext;

    @Inject
    IbdModel ibdModel;

    @Inject
    IOperationHistory operationHistory;

    @Inject
    IProgressMonitor monitor;

    private IBlockDiagram[] selectedBlockDiagrams;

    ObjectUndoContext undoContext = new ObjectUndoContext(this);

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
        // Copy in clipboard
        this.copy();

        // TODO faire un undoRedo operation
        // this.ibdModel.getBlocDiagramModel().removeBlockDiagrams(Arrays.asList(this.selectedBlockDiagrams));

        this.operationHistory.setLimit(this.undoContext, 2); // temporaire

        //
        final IEclipseContext cutContext = this.eclipseContext.createChild("BlockDiagramEditController cut context");
        cutContext.set(CutBlocDiagramUndoableOperation.BLOCK_DIAGRAM_LIST_NAMED_CONTEXT, Arrays.asList(this.selectedBlockDiagrams));

        // create Cut undoRedo operation
        final CutBlocDiagramUndoableOperation cutOperation = ContextInjectionFactory.make(CutBlocDiagramUndoableOperation.class, cutContext);
        cutOperation.setLabel(this.getCutTooltip());

        //
        cutOperation.addContext(this.undoContext);

        // execute and add to operationHistory
        if (cutOperation.execute(this.monitor, null).isOK()) {
            this.operationHistory.add(cutOperation);
        }

        // final TriggeredOperations triggeredOperations = new TriggeredOperations(cutOperation, this.operationHistory);

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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * @see pocs3_service_definitions.IEditAction#canUndo()
     */
    @Override
    public boolean canUndo() {
        final IOperationHistory operationHistory = this.eclipseContext.get(IOperationHistory.class);
        if (operationHistory == null) {
            return false;
        }

        return operationHistory.canUndo(this.undoContext);
    }

    @Override
    public String getUndoTooltip() {
        final String defaultUndoTooltip = IEditAction.super.getUndoTooltip();

        final IOperationHistory operationHistory = this.eclipseContext.get(IOperationHistory.class);
        if (operationHistory == null) {
            return defaultUndoTooltip;
        }

        final IUndoableOperation undoOperation = operationHistory.getUndoOperation(this.undoContext);
        if (undoOperation == null) {
            return defaultUndoTooltip;
        }

        return defaultUndoTooltip + " : " + undoOperation.getLabel();
    }

    @Override
    public void undo() {
        final IOperationHistory operationHistory = this.eclipseContext.get(IOperationHistory.class);
        if (operationHistory == null) {
            return;
        }

        final IProgressMonitor monitor = this.eclipseContext.get(IProgressMonitor.class);

        try {
            operationHistory.undo(this.undoContext, monitor, null);
        } catch (final ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * @see pocs3_service_definitions.IEditAction#canRedo()
     */
    @Override
    public boolean canRedo() {
        final IOperationHistory operationHistory = this.eclipseContext.get(IOperationHistory.class);
        if (operationHistory == null) {
            return false;
        }

        return operationHistory.canRedo(this.undoContext);
    }

    @Override
    public String getRedoTooltip() {
        final String defaultRedoTooltip = IEditAction.super.getRedoTooltip();

        final IOperationHistory operationHistory = this.eclipseContext.get(IOperationHistory.class);
        if (operationHistory == null) {
            return defaultRedoTooltip;
        }

        final IUndoableOperation redoOperation = operationHistory.getRedoOperation(this.undoContext);
        if (redoOperation == null) {
            return defaultRedoTooltip;
        }

        return defaultRedoTooltip + " : " + redoOperation.getLabel();
    }

    @Override
    public void redo() {
        final IOperationHistory operationHistory = this.eclipseContext.get(IOperationHistory.class);
        if (operationHistory == null) {
            return;
        }

        final IProgressMonitor monitor = this.eclipseContext.get(IProgressMonitor.class);

        try {
            operationHistory.redo(this.undoContext, monitor, null);
        } catch (final ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
