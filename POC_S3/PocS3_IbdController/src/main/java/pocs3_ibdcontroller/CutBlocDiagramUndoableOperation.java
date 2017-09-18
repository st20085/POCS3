package pocs3_ibdcontroller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import pocs3_ibdmodel.IbdModel;
import pocs3_service_definitions.IBlockDiagram;

/**
 *
 */
public class CutBlocDiagramUndoableOperation extends AbstractOperation {
    public static final String BLOCK_DIAGRAM_LIST_NAMED_CONTEXT = "blockDiagramList";

    @Inject
    IbdModel ibdModel;

    @Inject @Named(BLOCK_DIAGRAM_LIST_NAMED_CONTEXT)
    List<IBlockDiagram> blockDiagramList;

    /**
     *
     */
    public CutBlocDiagramUndoableOperation() {
        super("Cut bloc diagrams");
    }

    @Override
    public IStatus execute(IProgressMonitor monitor, IAdaptable info) {
        System.err.println("CutBlocDiagramUndoableOperation execute");
        monitor.beginTask("Execute : remove Block Diagrams", 1);

        this.ibdModel.getBlocDiagramModel().removeBlockDiagrams(this.blockDiagramList);

        monitor.worked(1);
        return Status.OK_STATUS;
    }

    @Override
    public IStatus undo(IProgressMonitor monitor, IAdaptable info) {
        System.err.println("CutBlocDiagramUndoableOperation undo");
        monitor.beginTask("Undo: add Block Diagrams", 1);

        this.ibdModel.getBlocDiagramModel().addBlockDiagrams(this.blockDiagramList);

        monitor.worked(1);
        return Status.OK_STATUS;
    }

    @Override
    public IStatus redo(IProgressMonitor monitor, IAdaptable info) {
        System.err.println("CutBlocDiagramUndoableOperation redo");
        monitor.beginTask("Redo : remove Block Diagrams", 1);

        this.ibdModel.getBlocDiagramModel().removeBlockDiagrams(this.blockDiagramList);

        monitor.worked(1);
        return Status.OK_STATUS;
    }
}
