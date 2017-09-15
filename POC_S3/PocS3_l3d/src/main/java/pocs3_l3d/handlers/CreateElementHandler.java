
package pocs3_l3d.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;

import pocs3_service_definitions.IElementAction;


public class CreateElementHandler {

    @CanExecute
    public boolean canExecute(MPart part, Adapter adapter) {
      final Object object = part.getObject();
//      System.out.println("CreateDiagramHandler canExecute on view "+object);

      final IElementAction elementAction = adapter.adapt(object, IElementAction.class);
      if (elementAction != null && elementAction.canCreateElement()) {
        return true;
      }

      return false;
    }

    @Execute
    public void execute(MPart part, Adapter adapter, Shell shell) {
        final Object object = part.getObject();
//      System.out.println("CREATE DIAGRAM");
      final IElementAction elementAction = adapter.adapt(object, IElementAction.class);
      if (elementAction != null) {
          final InputDialog inputDialog = new InputDialog(shell, "Example", "Enter element name", "Element n°"+System.currentTimeMillis()%100, null);
          if (inputDialog.open() == InputDialog.OK) {
              final String elementName = inputDialog.getValue();
              elementAction.createElement(elementName);
          }
      }
    }
}