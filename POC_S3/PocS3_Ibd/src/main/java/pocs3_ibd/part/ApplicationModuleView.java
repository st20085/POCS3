// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.part;

import java.io.File;
import java.io.IOException;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
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
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

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
    // init
    loadApplicationModuleContainer();

    //
    createEdtingDomain();

    //
    createContents(parent);
  }

  /**
   * @param parent
   */
  private void createContents(Composite parent) {
    final GridLayout layout = new GridLayout(1, false);
    layout.marginWidth = layout.marginHeight = 0;
    parent.setLayout(layout);

    //
    createApplicationModuleTableViewer(parent);
  }

  /**
   * @param parent
   */
  private void createApplicationModuleTableViewer(Composite parent) {
    //
    applicationModuleTableViewer = new TableViewer(parent, SWT.NONE);
    applicationModuleTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
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
  }

  /**
   *
   */
  private void createEdtingDomain() {
    ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(); // new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    adapterFactory.addAdapterFactory(new Pocs3_emfAdapterFactory());
    adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
    adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

    //
    BasicCommandStack commandStack = new BasicCommandStack();
    commandStack.addCommandStackListener(new CommandStackListener() {
      @Override
      public void commandStackChanged(EventObject event) {
        boolean saveNeeded = ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
        dirtyable.setDirty(saveNeeded);
      }
    });

    //
    editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
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

  /**
   * Save ApplicationModuleContainer
   */
  @Persist
  void saveApplicationModuleContainer() {
    ResourceSet resourceSet = new ResourceSetImpl();

    Map<String, Object> extnMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    extnMap.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl()); // default extension to save
//    extnMap.put("application_modules", new YourXMIResourceFactoryImpl()); // yourImplementation, see AESCipherXMIFactoryImpl

    Bundle ibdBundle = FrameworkUtil.getBundle(getClass());
    IPath sharedLocation = Platform.getStateLocation(ibdBundle);
    File pocs3File = sharedLocation.append("pocs3.xmi").toFile();

    Resource resource = resourceSet.createResource(URI.createFileURI(pocs3File.getPath()));
    resource.getContents().add(applicationModuleContainer);

    Map<Object, Object> options = new HashMap<>();
    options.put(XMLResource.OPTION_ENCODING, "UTF-8");

    try {
      resource.save(options);

      editingDomain.getCommandStack().flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Load ApplicationModuleContainer
   */
  void loadApplicationModuleContainer() {
    ResourceSet resourceSet = new ResourceSetImpl();

    Map<String, Object> extnMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    extnMap.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl()); // default extension to save
//    extnMap.put("application_modules", new YourXMIResourceFactoryImpl()); // yourImplementation, see AESCipherXMIFactoryImpl

    try {
      Bundle ibdBundle = FrameworkUtil.getBundle(getClass());
      IPath sharedLocation = Platform.getStateLocation(ibdBundle);
      File pocs3File = sharedLocation.append("pocs3.xmi").toFile();

      Resource resource = resourceSet.getResource(URI.createFileURI(pocs3File.getPath()), true);
      applicationModuleContainer = (ApplicationModuleContainer) resource.getContents().get(0);
    } catch(Exception e) {

      // create new ApplicationModuleContainer
      applicationModuleContainer = POCS3_EMF_FACTORY.createApplicationModuleContainer();

//      // create default
//      ApplicationModule applicationModule = POCS3_EMF_FACTORY.createApplicationModule();
//      applicationModule.setName("'application module 1'");
//      applicationModuleContainer.getApplicationModules().add(applicationModule);

    }
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

    AddCommand addCommand = (AddCommand) AddCommand.create(editingDomain, applicationModuleContainer, Pocs3_emfPackage.Literals.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES, applicationModule);
    addCommand.setLabel(addCommand.getLabel() + " application module "+applicationModule.getName());
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
   * @see pocs3_service_definitions.IEditAction#getCutTooltip()
   */
  @Override
  public String getCutTooltip() {
    ApplicationModule applicationModule = (ApplicationModule) ((IStructuredSelection) applicationModuleTableViewer.getSelection()).getFirstElement();
    return IEditAction.super.getCutTooltip() + " application module "+applicationModule.getName();
  }

  /*
   * @see pocs3_service_definitions.IEditAction#cut()
   */
  @Override
  public void cut() {
    ApplicationModule applicationModule = (ApplicationModule) ((IStructuredSelection) applicationModuleTableViewer.getSelection()).getFirstElement();
    RemoveCommand removeCommand = (RemoveCommand) RemoveCommand.create(editingDomain, applicationModuleContainer, Pocs3_emfPackage.Literals.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES, applicationModule);
    removeCommand.setLabel(getCutTooltip());
    getEditingDomain().getCommandStack().execute(removeCommand);
  }


}