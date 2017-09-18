
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
 * The class <b>EditActionRedoHandler</b> allows to define default "Redo" handler for part which can adapt IEditAction interface.<br>
 */
public class EditActionRedoHandler {

    @CanExecute
    private static boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, PocS3EapController pocS3EapController) {
      final Object object = part.getObject();

      final IEditAction editAction = adapter.adapt(object, IEditAction.class);
      if (editAction != null && editAction.canRedo()) {
          if (pocS3EapController != null) {
            pocS3EapController.setRedoTooltip(editAction.getRedoTooltip());
        }
          return true;
      }

      // default tooltip
      if (pocS3EapController != null) {
        pocS3EapController.setRedoTooltip(IEditAction.DEFAULT_REDO_TOOLTIP);
    }

      return false;
    }

    @Execute
    private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter) {
      final Object object = part.getObject();

      final IEditAction editAction = adapter.adapt(object, IEditAction.class);
      if (editAction != null) {
          editAction.redo();
      }
    }

//    @Execute
//    private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter) {
//
//      try {
//          OperationHistoryFactory.getOperationHistory().redo(null, null, null);
//      } catch (final ExecutionException e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//      }
//    }
//
//    @CanExecute
//    private static boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part) {
//        System.out.println("@@@RedoHandler "+OperationHistoryFactory.getOperationHistory().canRedo(null));
//        return OperationHistoryFactory.getOperationHistory().canRedo(null);
//    }
}