
package pocs3_eap.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;

import pocs3_eap.parts.internal.PocS3EapController;
import pocs3_service_definitions.IEditAction;

/**
 * The class <b>EditActionUndoHandler</b> to define default "Undo" handler for part which can adapt IEditAction interface.<br>
 */
public class EditActionUndoHandler {

    @CanExecute
    private static boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, PocS3EapController pocS3EapController) {
      final Object object = part.getObject();

      final IEditAction editAction = adapter.adapt(object, IEditAction.class);
      if (editAction != null && editAction.canUndo()) {
          if (pocS3EapController != null) {
            pocS3EapController.setUndoTooltip(editAction.getUndoTooltip());
        }
          return true;
      }

      // default tooltip
      if (pocS3EapController != null) {
        pocS3EapController.setUndoTooltip(IEditAction.DEFAULT_UNDO_TOOLTIP);
    }

      return false;
    }

    @Execute
    private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter) {
      final Object object = part.getObject();

      final IEditAction editAction = adapter.adapt(object, IEditAction.class);
      if (editAction != null) {
          editAction.undo();
      }
    }


//    @Execute
//    private static void execute(/*IWorkbenchOperationSupport workbenchOperationSupport, */@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, MApplication application, IEclipseContext context) {
//
//        try {
//            final ObjectUndoContext objectUndoContext = new ObjectUndoContext(application);
//            final IUndoableOperation undoableOperation = OperationHistoryFactory.getOperationHistory().getUndoOperation(objectUndoContext);
//            if (undoableOperation != null) {
////                undoableOperation.canExecute();
//                OperationHistoryFactory.getOperationHistory().undo(objectUndoContext, null, null);
//            } else {
////                System.err.println("TODO");
//            }
//        } catch (final ExecutionException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @CanExecute
//    private static boolean canExecute(@Optional EPartService partService, @Named(IServiceConstants.ACTIVE_PART) MPart part, MApplication application) {
//        final ObjectUndoContext objectUndoContext = new ObjectUndoContext(application);
//
////        System.out.println("@@@UndoHandler " + OperationHistoryFactory.getOperationHistory().canUndo(objectUndoContext));
//        return OperationHistoryFactory.getOperationHistory().canUndo(objectUndoContext);
//    }
}
