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
 * The class <b>PasteHandler</b> allows to save .<br>
 */
public class EditActionPasteHandler {
  @Execute
  private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter) {
    final Object object = part.getObject();
//    System.out.println("PasteHandler execute on view "+object);

    final IEditAction editAction = adapter.adapt(object, IEditAction.class);
    if (editAction != null) {
        editAction.paste();
    }
  }

  @CanExecute
  private static boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, PocS3EapController pocS3EapController) {
    final Object object = part.getObject();
//    System.out.println("PasteHandler canExecute on view "+object);

    final IEditAction editAction = adapter.adapt(object, IEditAction.class);
    if (editAction != null && editAction.canPaste()) {
        pocS3EapController.setPasteTooltip(editAction.getPasteTooltip());
        return true;
    }

    // default tooltip
    pocS3EapController.setPasteTooltip(IEditAction.DEFAULT_PASTE_TOOLTIP);

    return false;
  }
}
