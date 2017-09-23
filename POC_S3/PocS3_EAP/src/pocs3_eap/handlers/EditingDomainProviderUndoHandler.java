package pocs3_eap.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

import pocs3_eap.parts.internal.PocS3EapController;
import pocs3_service_definitions.IEditAction;

/**
 * The class <b>EditingDomainProviderUndoHandler</b> allows to.<br>
 */
public class EditingDomainProviderUndoHandler {
  @CanExecute
  public boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, PocS3EapController pocS3EapController) {
    final Object object = part.getObject();

    final IEditingDomainProvider editingDomainProvider = adapter.adapt(object, IEditingDomainProvider.class);
    if (editingDomainProvider != null) {
      EditingDomain editingDomain = editingDomainProvider.getEditingDomain();
      if (editingDomain != null && editingDomain.getCommandStack().canUndo()) {
        if (pocS3EapController != null) {
          String undoTooltip = editingDomain.getCommandStack().getUndoCommand().getLabel();
          pocS3EapController.setUndoTooltip(IEditAction.DEFAULT_UNDO_TOOLTIP + " : " + undoTooltip);
        }

        return true;
      }
    }

    // default tooltip
    if (pocS3EapController != null) {
      pocS3EapController.setUndoTooltip(IEditAction.DEFAULT_UNDO_TOOLTIP);
    }

    return false;
  }

  @Execute
  private static void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, Adapter adapter, IEventBroker eventBroker) {
    final Object object = part.getObject();

    final IEditingDomainProvider editingDomainProvider = adapter.adapt(object, IEditingDomainProvider.class);
    if (editingDomainProvider != null) {
      EditingDomain editingDomain = editingDomainProvider.getEditingDomain();
      if (editingDomain != null) {
        editingDomain.getCommandStack().undo();

        // refresh all elements UI
        eventBroker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
      }
    }
  }

}
