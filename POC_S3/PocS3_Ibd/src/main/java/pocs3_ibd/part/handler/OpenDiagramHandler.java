
package pocs3_ibd.part.handler;

import java.util.Arrays;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import pocs3_ibd_service_definitions.IBlockDiagram;

/**
 * The class <b>OpenDiagramHandler</b> allows to open diagram
 */
public class OpenDiagramHandler {

  @Inject
  ESelectionService selectionService;

  @Execute
  public void execute() {
    System.out.println("OPEN DIAGRAM");
  }

  @CanExecute
  public boolean canExecute(MPart part, Adapter adapter) {
    final Object object = part.getObject();
//    System.out.println("OpenDiagramHandler canExecute on view "+object);

    final IBlockDiagramPart blockDiagramPart = adapter.adapt(object, IBlockDiagramPart.class);
    if (blockDiagramPart != null) {
//      blockDiagramPart.doOpenDiagram();

      final Object selection = this.selectionService.getSelection();
      System.out.println("canExecute for " + selection);

      if (selection == null) {
        return false;
      }

      //
      if (selection instanceof IBlockDiagram) {
        return true;
      }

      //
      if (selection instanceof Object[]) {
        final Object[] array = (Object[]) selection;
        if (array.length != 0 && Arrays.stream(array).allMatch(IBlockDiagram.class::isInstance)) {
          System.out.println("canExecute " + Arrays.toString(array));
          return true;
        }
      }
    }

    return false;
  }

}