package pocs3_eap.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import pocs3_service_definitions.IClipboardListener;

/**
 * The class <b>CutHandler</b> allows to save .<br>
 */
public class CutHandler {
  @Execute
  private void execute(MPart part, Adapter adapter) {
    Object object = part.getObject();
    System.out.println("CutHandler execute on view "+object);

    IClipboardListener clipboardListener = adapter.adapt(object, IClipboardListener.class);
    if (clipboardListener != null)
      clipboardListener.doCut();
  }

  @CanExecute
  private boolean canExecute(MPart part, Adapter adapter) {
    Object object = part.getObject();
    System.out.println("CutHandler canExecute on view "+object);

    IClipboardListener clipboardListener = adapter.adapt(object, IClipboardListener.class);
    if (clipboardListener != null && clipboardListener.canDoCut())
      return true;

    return false;
  }
}
