
package pocs3_eap.handlers;

import javax.inject.Named;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

/**
 * The class <b>UndoHandler</b> allows to save .<br>
 */
public class UndoHandler {

    @Execute
    private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, MApplication application, IEclipseContext context) {

        try {
            final ObjectUndoContext objectUndoContext = new ObjectUndoContext(application);
            final IUndoableOperation undoableOperation = OperationHistoryFactory.getOperationHistory().getUndoOperation(objectUndoContext);
            if (undoableOperation != null) {
//                undoableOperation.canExecute();
                OperationHistoryFactory.getOperationHistory().undo(objectUndoContext, null, null);
            } else {
                System.err.println("TODO");
            }
        } catch (final ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @CanExecute
    private static boolean canExecute(@Optional EPartService partService, @Named(IServiceConstants.ACTIVE_PART) MPart part, MApplication application) {
        final ObjectUndoContext objectUndoContext = new ObjectUndoContext(application);

        System.out.println("@@@UndoHandler " + OperationHistoryFactory.getOperationHistory().canUndo(objectUndoContext));
        return OperationHistoryFactory.getOperationHistory().canUndo(objectUndoContext);
    }
}
