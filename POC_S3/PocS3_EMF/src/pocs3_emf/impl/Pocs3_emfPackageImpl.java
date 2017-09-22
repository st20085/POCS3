/**
 */
package pocs3_emf.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pocs3_common.Pocs3_commonPackage;

import pocs3_common.impl.Pocs3_commonPackageImpl;

import pocs3_emf.ApplicationModule;
import pocs3_emf.ApplicationModuleContainer;
import pocs3_emf.BlockUnit;
import pocs3_emf.IUnit;
import pocs3_emf.Pocs3_emfFactory;
import pocs3_emf.Pocs3_emfPackage;
import pocs3_emf.ThermalUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pocs3_emfPackageImpl extends EPackageImpl implements Pocs3_emfPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass applicationModuleContainerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass applicationModuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thermalUnitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockUnitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iUnitEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see pocs3_emf.Pocs3_emfPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Pocs3_emfPackageImpl() {
    super(eNS_URI, Pocs3_emfFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link Pocs3_emfPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Pocs3_emfPackage init() {
    if (isInited) return (Pocs3_emfPackage)EPackage.Registry.INSTANCE.getEPackage(Pocs3_emfPackage.eNS_URI);

    // Obtain or create and register package
    Pocs3_emfPackageImpl thePocs3_emfPackage = (Pocs3_emfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Pocs3_emfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Pocs3_emfPackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    Pocs3_commonPackageImpl thePocs3_commonPackage = (Pocs3_commonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Pocs3_commonPackage.eNS_URI) instanceof Pocs3_commonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Pocs3_commonPackage.eNS_URI) : Pocs3_commonPackage.eINSTANCE);

    // Create package meta-data objects
    thePocs3_emfPackage.createPackageContents();
    thePocs3_commonPackage.createPackageContents();

    // Initialize created meta-data
    thePocs3_emfPackage.initializePackageContents();
    thePocs3_commonPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePocs3_emfPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Pocs3_emfPackage.eNS_URI, thePocs3_emfPackage);
    return thePocs3_emfPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getApplicationModuleContainer() {
    return applicationModuleContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getApplicationModuleContainer_ApplicationModules() {
    return (EReference)applicationModuleContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getApplicationModule() {
    return applicationModuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getApplicationModule_Name() {
    return (EAttribute)applicationModuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThermalUnit() {
    return thermalUnitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThermalUnit_Name() {
    return (EAttribute)thermalUnitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThermalUnit_BlockUnit() {
    return (EReference)thermalUnitEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThermalUnit_Common() {
    return (EReference)thermalUnitEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlockUnit() {
    return blockUnitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBlockUnit_Name() {
    return (EAttribute)blockUnitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getBlockUnit__Generate() {
    return blockUnitEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIUnit() {
    return iUnitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIUnit_Id() {
    return (EAttribute)iUnitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_emfFactory getPocs3_emfFactory() {
    return (Pocs3_emfFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    applicationModuleContainerEClass = createEClass(APPLICATION_MODULE_CONTAINER);
    createEReference(applicationModuleContainerEClass, APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES);

    applicationModuleEClass = createEClass(APPLICATION_MODULE);
    createEAttribute(applicationModuleEClass, APPLICATION_MODULE__NAME);

    thermalUnitEClass = createEClass(THERMAL_UNIT);
    createEAttribute(thermalUnitEClass, THERMAL_UNIT__NAME);
    createEReference(thermalUnitEClass, THERMAL_UNIT__BLOCK_UNIT);
    createEReference(thermalUnitEClass, THERMAL_UNIT__COMMON);

    blockUnitEClass = createEClass(BLOCK_UNIT);
    createEAttribute(blockUnitEClass, BLOCK_UNIT__NAME);
    createEOperation(blockUnitEClass, BLOCK_UNIT___GENERATE);

    iUnitEClass = createEClass(IUNIT);
    createEAttribute(iUnitEClass, IUNIT__ID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    Pocs3_commonPackage thePocs3_commonPackage = (Pocs3_commonPackage)EPackage.Registry.INSTANCE.getEPackage(Pocs3_commonPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(applicationModuleContainerEClass, ApplicationModuleContainer.class, "ApplicationModuleContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getApplicationModuleContainer_ApplicationModules(), this.getApplicationModule(), null, "applicationModules", null, 0, -1, ApplicationModuleContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(applicationModuleEClass, ApplicationModule.class, "ApplicationModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getApplicationModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, ApplicationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thermalUnitEClass, ThermalUnit.class, "ThermalUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getThermalUnit_Name(), ecorePackage.getEString(), "name", null, 0, 1, ThermalUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThermalUnit_BlockUnit(), this.getBlockUnit(), null, "blockUnit", null, 0, -1, ThermalUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThermalUnit_Common(), thePocs3_commonPackage.getCommon(), null, "common", null, 0, 1, ThermalUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blockUnitEClass, BlockUnit.class, "BlockUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBlockUnit_Name(), ecorePackage.getEString(), "name", null, 0, 1, BlockUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getBlockUnit__Generate(), null, "generate", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(iUnitEClass, IUnit.class, "IUnit", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIUnit_Id(), ecorePackage.getEString(), "id", null, 0, 1, IUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Pocs3_emfPackageImpl
