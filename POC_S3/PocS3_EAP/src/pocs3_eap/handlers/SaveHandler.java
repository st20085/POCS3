package pocs3_eap.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

/**
 * The class <b>SaveHandler</b> allows to save .<br>
 */
public class SaveHandler {
  @Execute
  public void execute(EPartService partService) {
    partService.saveAll(false);
  }

  @CanExecute
  boolean canExecute(@Optional EPartService partService) {
    if (partService != null) {
      return !partService.getDirtyParts().isEmpty();
    }
    return false;
  }

}
