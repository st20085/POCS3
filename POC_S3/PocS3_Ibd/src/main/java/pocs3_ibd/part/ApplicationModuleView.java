// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.part;

import java.util.EventObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pocs3_emf.ApplicationModule;
import pocs3_emf.ApplicationModuleContainer;
import pocs3_emf.Pocs3_emfFactory;
import pocs3_emf.Pocs3_emfPackage;
import pocs3_emf.util.Pocs3_emfAdapterFactory;
import pocs3_service_definitions.IEditAction;

/**
 * The class <b>ApplicationModuleView</b> allows to
 */
public class ApplicationModuleView implements IEditingDomainProvider, IEditAction {
  @Inject
  MDirtyable dirtyable;

  TableViewer applicationModuleTableViewer;

  AdapterFactoryEditingDomain editingDomain;

  ApplicationModuleContainer applicationModuleContainer;

  final static Pocs3_emfFactory POCS3_EMF_FACTORY = Pocs3_emfFactory.eINSTANCE;

  @Inject
  IEventBroker eventBroker;

  @Inject
  public ApplicationModuleView() {}

  @PostConstruct
  public void postConstruct(Composite parent) {
    final GridLayout layout = new GridLayout(1, false);
    layout.marginWidth = layout.marginHeight = 0;
    parent.setLayout(layout);

    // temporary
    applicationModuleTableViewer = new TableViewer(parent, SWT.NONE);
//    checkTableViewer.setContentProvider(ArrayContentProvider.getInstance());
    applicationModuleTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));

    // init
    applicationModuleContainer = POCS3_EMF_FACTORY.createApplicationModuleContainer();

    // create default
    ApplicationModule applicationModule = POCS3_EMF_FACTORY.createApplicationModule();
    applicationModule.setName("'application module 1'");
    applicationModuleContainer.getApplicationModules().add(applicationModule);

    //
    ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(); // new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    adapterFactory.addAdapterFactory(new Pocs3_emfAdapterFactory());
    adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
    adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

    //
    BasicCommandStack commandStack = new BasicCommandStack();
    commandStack.addCommandStackListener(new CommandStackListener() {
      @Override
      public void commandStackChanged(EventObject event) {
        dirtyable.setDirty(true);
        // Display.getDefault().asyncExec(new Runnable() {
        // @Override
        // public void run() {
        // firePropertyChange(PROP_DIRTY);
        // }
        // });
      }
    });

    editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);

    applicationModuleTableViewer.setContentProvider(new AdapterFactoryContentProvider(editingDomain.getAdapterFactory()));
    applicationModuleTableViewer.setLabelProvider(new AdapterFactoryLabelProvider(editingDomain.getAdapterFactory()));
    applicationModuleTableViewer.setInput(applicationModuleContainer);

    applicationModuleTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        // refresh all elements UI
        eventBroker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
      }
    });

//    checkTableViewer.setInput(applicationModuleContainer.getApplicationModules());
  }

//  @Inject
//  BlockDiagramController blockDiagramController;
//
//  @Inject
//  BlockDiagramEditController blockDiagramEditController;
//
//  @Override
//  public <T> T getAdapter(Class<T> adapter) {
//    // if (IEditAction.class.equals(adapter)) {
//    // return adapter.cast(this.blockDiagramEditController);
//    // }
//    if (IBlockDiagramAction.class.equals(adapter)) {
//      return adapter.cast(this.blockDiagramController);
//    }
//    if (IEditAction.class.equals(adapter)) {
//      return adapter.cast(this.blockDiagramEditController);
//    }
//    return null;
//  }

  @Persist
  public void save() {
    dirtyable.setDirty(false);
  }

  /*
   * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
   */
  @Override
  public EditingDomain getEditingDomain() {
    return editingDomain;
  }

  /**
   * @param applicationModuleName
   */
  public void createNewApplicationModule(String applicationModuleName) {
    ApplicationModule applicationModule = POCS3_EMF_FACTORY.createApplicationModule();
    applicationModule.setName(applicationModuleName);
//    applicationModuleContainer.getApplicationModules().add(applicationModule);

    Command addCommand = AddCommand.create(editingDomain, applicationModuleContainer, Pocs3_emfPackage.Literals.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES, applicationModule);
    getEditingDomain().getCommandStack().execute(addCommand);
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /*
   * @see pocs3_service_definitions.IEditAction#canCut()
   */
  @Override
  public boolean canCut() {
    return ! applicationModuleTableViewer.getSelection().isEmpty();
  }

  /*
   * @see pocs3_service_definitions.IEditAction#cut()
   */
  @Override
  public void cut() {
    ApplicationModule applicationModule = (ApplicationModule) ((IStructuredSelection) applicationModuleTableViewer.getSelection()).getFirstElement();
    Command removeCommand = RemoveCommand.create(editingDomain, applicationModuleContainer, Pocs3_emfPackage.Literals.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES, applicationModule);
    getEditingDomain().getCommandStack().execute(removeCommand);
  }


}