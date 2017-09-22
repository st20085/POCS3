/**
 */
package pocs3_emf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pocs3_emf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pocs3_emfFactoryImpl extends EFactoryImpl implements Pocs3_emfFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Pocs3_emfFactory init() {
    try {
      Pocs3_emfFactory thePocs3_emfFactory = (Pocs3_emfFactory)EPackage.Registry.INSTANCE.getEFactory(Pocs3_emfPackage.eNS_URI);
      if (thePocs3_emfFactory != null) {
        return thePocs3_emfFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Pocs3_emfFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_emfFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER: return createApplicationModuleContainer();
      case Pocs3_emfPackage.APPLICATION_MODULE: return createApplicationModule();
      case Pocs3_emfPackage.THERMAL_UNIT: return createThermalUnit();
      case Pocs3_emfPackage.BLOCK_UNIT: return createBlockUnit();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationModuleContainer createApplicationModuleContainer() {
    ApplicationModuleContainerImpl applicationModuleContainer = new ApplicationModuleContainerImpl();
    return applicationModuleContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ApplicationModule createApplicationModule() {
    ApplicationModuleImpl applicationModule = new ApplicationModuleImpl();
    return applicationModule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThermalUnit createThermalUnit() {
    ThermalUnitImpl thermalUnit = new ThermalUnitImpl();
    return thermalUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockUnit createBlockUnit() {
    BlockUnitImpl blockUnit = new BlockUnitImpl();
    return blockUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_emfPackage getPocs3_emfPackage() {
    return (Pocs3_emfPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Pocs3_emfPackage getPackage() {
    return Pocs3_emfPackage.eINSTANCE;
  }

} //Pocs3_emfFactoryImpl
