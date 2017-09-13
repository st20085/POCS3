package pocs3_eap.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;

import pocs3_eap.parts.internal.PocS3EapController;
import pocs3_service_definitions.IEditAction;

/**
 * The class <b>EditActionCopyHandler</b> allows to define default "Copy" handler for part which can adapt IEditAction interface.<br>
 */
public class EditActionCopyHandler {

  @CanExecute
  private static boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, PocS3EapController pocS3EapController) {
    final Object object = part.getObject();

    final IEditAction editAction = adapter.adapt(object, IEditAction.class);
    if (editAction != null && editAction.canCopy()) {
        pocS3EapController.setCopyTooltip(editAction.getCopyTooltip());
        return true;
    }

    // default tooltip
    pocS3EapController.setCopyTooltip(IEditAction.DEFAULT_COPY_TOOLTIP);

    return false;
  }

  @Execute
  private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, MApplication application) {
    final Object object = part.getObject();

    final IEditAction editAction = adapter.adapt(object, IEditAction.class);
    if (editAction != null) {
        editAction.copy();
    }
  }
}
