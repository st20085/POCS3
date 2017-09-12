
package pocs3_eap.handlers;

import javax.inject.Named;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;

/**
 * The class <b>RedoHandler</b> allows to save .<br>
 */
public class RedoHandler {
    @Execute
    private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter) {

      try {
          OperationHistoryFactory.getOperationHistory().redo(null, null, null);
      } catch (final ExecutionException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
    }

    @CanExecute
    private static boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part) {
        System.out.println("@@@RedoHandler "+OperationHistoryFactory.getOperationHistory().canRedo(null));
        return OperationHistoryFactory.getOperationHistory().canRedo(null);
    }
}