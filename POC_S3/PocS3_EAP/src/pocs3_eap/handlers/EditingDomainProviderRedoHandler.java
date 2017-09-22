package pocs3_eap.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

/**
 * The class <b>EditingDomainProviderUndoHandler</b> allows to.<br>
 */
public class EditingDomainProviderRedoHandler {
  @CanExecute
  public boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart mPart) {
    if (mPart.getObject() instanceof IEditingDomainProvider) {
      EditingDomain editingDomain = ((IEditingDomainProvider) mPart.getObject()).getEditingDomain();
      return editingDomain.getCommandStack().canRedo();
    }
    return false;
  }

  @Execute
  public void execute(@Named(IServiceConstants.ACTIVE_PART) MPart mPart, IEventBroker eventBroker) {
    if (mPart.getObject() instanceof IEditingDomainProvider) {
      EditingDomain editingDomain = ((IEditingDomainProvider) mPart.getObject()).getEditingDomain();
      editingDomain.getCommandStack().redo();

      // refresh all elements UI
      eventBroker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
    }
  }
}
