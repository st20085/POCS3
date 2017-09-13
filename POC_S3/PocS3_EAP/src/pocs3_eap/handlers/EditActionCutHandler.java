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
 * The class <b>CutHandler</b> allows to save .<br>
 */
public class EditActionCutHandler {
  @Execute
  private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter) {
    final Object object = part.getObject();
//    System.out.println("CutHandler execute on view "+object);

    final IEditAction editAction = adapter.adapt(object, IEditAction.class);
    if (editAction != null) {
        editAction.cut();
    }
  }

  @CanExecute
  private static boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, PocS3EapController pocS3EapController) {
    final Object object = part.getObject();
//    System.out.println("++CutHandler canExecute on view ");

    final IEditAction editAction = adapter.adapt(object, IEditAction.class);
    if (editAction != null && editAction.canCut()) {
        pocS3EapController.setCutTooltip(editAction.getCutTooltip());
        return true;
    }

    // default tooltip
    pocS3EapController.setCutTooltip(IEditAction.DEFAULT_CUT_TOOLTIP);

    return false;
  }
}
