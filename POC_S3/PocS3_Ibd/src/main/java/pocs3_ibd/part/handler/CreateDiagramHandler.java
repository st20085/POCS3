
package pocs3_ibd.part.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;

import pocs3_ibdmodel.action.IBlockDiagramAction;

/**
 * The class <b>CreateDiagramHandler</b> allows to create new diagram
 */
public class CreateDiagramHandler {

  @CanExecute
  public boolean canExecute(MPart part, Adapter adapter) {
    final Object object = part.getObject();
//    System.out.println("CreateDiagramHandler canExecute on view "+object);

    final IBlockDiagramAction blockDiagramAction = adapter.adapt(object, IBlockDiagramAction.class);
    if (blockDiagramAction != null && blockDiagramAction.canCreateBlockDiagrams()) {
      return true;
    }

    return false;
  }

  @Execute
  public void execute(MPart part, Adapter adapter, Shell shell) {
      final Object object = part.getObject();
//    System.out.println("CREATE DIAGRAM");
    final IBlockDiagramAction blockDiagramAction = adapter.adapt(object, IBlockDiagramAction.class);
    if (blockDiagramAction != null) {
        final InputDialog inputDialog = new InputDialog(shell, "Example", "Enter a block diagram name", "Bloc diagram n°"+System.currentTimeMillis()%100, null);
        if (inputDialog.open() == InputDialog.OK) {
            final String blockDiagramName = inputDialog.getValue();
            blockDiagramAction.createBlockDiagram(blockDiagramName);
        }
    }
  }
}