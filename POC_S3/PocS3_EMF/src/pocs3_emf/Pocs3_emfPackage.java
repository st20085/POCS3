/**
 */
package pocs3_emf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see pocs3_emf.Pocs3_emfFactory
 * @model kind="package"
 * @generated
 */
public interface Pocs3_emfPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "pocs3_emf";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.example.org/pocs3_emf";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "pocs3_emf";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Pocs3_emfPackage eINSTANCE = pocs3_emf.impl.Pocs3_emfPackageImpl.init();

  /**
   * The meta object id for the '{@link pocs3_emf.impl.ApplicationModuleContainerImpl <em>Application Module Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see pocs3_emf.impl.ApplicationModuleContainerImpl
   * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getApplicationModuleContainer()
   * @generated
   */
  int APPLICATION_MODULE_CONTAINER = 0;

  /**
   * The feature id for the '<em><b>Application Modules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES = 0;

  /**
   * The number of structural features of the '<em>Application Module Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_MODULE_CONTAINER_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Application Module Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_MODULE_CONTAINER_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link pocs3_emf.impl.ApplicationModuleImpl <em>Application Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see pocs3_emf.impl.ApplicationModuleImpl
   * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getApplicationModule()
   * @generated
   */
  int APPLICATION_MODULE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_MODULE__NAME = 0;

  /**
   * The number of structural features of the '<em>Application Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_MODULE_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Application Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_MODULE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link pocs3_emf.impl.ThermalUnitImpl <em>Thermal Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see pocs3_emf.impl.ThermalUnitImpl
   * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getThermalUnit()
   * @generated
   */
  int THERMAL_UNIT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THERMAL_UNIT__NAME = 0;

  /**
   * The feature id for the '<em><b>Block Unit</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THERMAL_UNIT__BLOCK_UNIT = 1;

  /**
   * The feature id for the '<em><b>Common</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THERMAL_UNIT__COMMON = 2;

  /**
   * The number of structural features of the '<em>Thermal Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THERMAL_UNIT_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Thermal Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THERMAL_UNIT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link pocs3_emf.impl.BlockUnitImpl <em>Block Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see pocs3_emf.impl.BlockUnitImpl
   * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getBlockUnit()
   * @generated
   */
  int BLOCK_UNIT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_UNIT__NAME = 0;

  /**
   * The number of structural features of the '<em>Block Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_UNIT_FEATURE_COUNT = 1;

  /**
   * The operation id for the '<em>Generate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_UNIT___GENERATE = 0;

  /**
   * The number of operations of the '<em>Block Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_UNIT_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link pocs3_emf.IUnit <em>IUnit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see pocs3_emf.IUnit
   * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getIUnit()
   * @generated
   */
  int IUNIT = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IUNIT__ID = 0;

  /**
   * The number of structural features of the '<em>IUnit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IUNIT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>IUnit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IUNIT_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link pocs3_emf.ApplicationModuleContainer <em>Application Module Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Application Module Container</em>'.
   * @see pocs3_emf.ApplicationModuleContainer
   * @generated
   */
  EClass getApplicationModuleContainer();

  /**
   * Returns the meta object for the containment reference list '{@link pocs3_emf.ApplicationModuleContainer#getApplicationModules <em>Application Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Application Modules</em>'.
   * @see pocs3_emf.ApplicationModuleContainer#getApplicationModules()
   * @see #getApplicationModuleContainer()
   * @generated
   */
  EReference getApplicationModuleContainer_ApplicationModules();

  /**
   * Returns the meta object for class '{@link pocs3_emf.ApplicationModule <em>Application Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Application Module</em>'.
   * @see pocs3_emf.ApplicationModule
   * @generated
   */
  EClass getApplicationModule();

  /**
   * Returns the meta object for the attribute '{@link pocs3_emf.ApplicationModule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see pocs3_emf.ApplicationModule#getName()
   * @see #getApplicationModule()
   * @generated
   */
  EAttribute getApplicationModule_Name();

  /**
   * Returns the meta object for class '{@link pocs3_emf.ThermalUnit <em>Thermal Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Thermal Unit</em>'.
   * @see pocs3_emf.ThermalUnit
   * @generated
   */
  EClass getThermalUnit();

  /**
   * Returns the meta object for the attribute '{@link pocs3_emf.ThermalUnit#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see pocs3_emf.ThermalUnit#getName()
   * @see #getThermalUnit()
   * @generated
   */
  EAttribute getThermalUnit_Name();

  /**
   * Returns the meta object for the reference list '{@link pocs3_emf.ThermalUnit#getBlockUnit <em>Block Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Block Unit</em>'.
   * @see pocs3_emf.ThermalUnit#getBlockUnit()
   * @see #getThermalUnit()
   * @generated
   */
  EReference getThermalUnit_BlockUnit();

  /**
   * Returns the meta object for the reference '{@link pocs3_emf.ThermalUnit#getCommon <em>Common</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Common</em>'.
   * @see pocs3_emf.ThermalUnit#getCommon()
   * @see #getThermalUnit()
   * @generated
   */
  EReference getThermalUnit_Common();

  /**
   * Returns the meta object for class '{@link pocs3_emf.BlockUnit <em>Block Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block Unit</em>'.
   * @see pocs3_emf.BlockUnit
   * @generated
   */
  EClass getBlockUnit();

  /**
   * Returns the meta object for the attribute '{@link pocs3_emf.BlockUnit#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see pocs3_emf.BlockUnit#getName()
   * @see #getBlockUnit()
   * @generated
   */
  EAttribute getBlockUnit_Name();

  /**
   * Returns the meta object for the '{@link pocs3_emf.BlockUnit#generate() <em>Generate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Generate</em>' operation.
   * @see pocs3_emf.BlockUnit#generate()
   * @generated
   */
  EOperation getBlockUnit__Generate();

  /**
   * Returns the meta object for class '{@link pocs3_emf.IUnit <em>IUnit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IUnit</em>'.
   * @see pocs3_emf.IUnit
   * @generated
   */
  EClass getIUnit();

  /**
   * Returns the meta object for the attribute '{@link pocs3_emf.IUnit#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see pocs3_emf.IUnit#getId()
   * @see #getIUnit()
   * @generated
   */
  EAttribute getIUnit_Id();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Pocs3_emfFactory getPocs3_emfFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link pocs3_emf.impl.ApplicationModuleContainerImpl <em>Application Module Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pocs3_emf.impl.ApplicationModuleContainerImpl
     * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getApplicationModuleContainer()
     * @generated
     */
    EClass APPLICATION_MODULE_CONTAINER = eINSTANCE.getApplicationModuleContainer();

    /**
     * The meta object literal for the '<em><b>Application Modules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES = eINSTANCE.getApplicationModuleContainer_ApplicationModules();

    /**
     * The meta object literal for the '{@link pocs3_emf.impl.ApplicationModuleImpl <em>Application Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pocs3_emf.impl.ApplicationModuleImpl
     * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getApplicationModule()
     * @generated
     */
    EClass APPLICATION_MODULE = eINSTANCE.getApplicationModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute APPLICATION_MODULE__NAME = eINSTANCE.getApplicationModule_Name();

    /**
     * The meta object literal for the '{@link pocs3_emf.impl.ThermalUnitImpl <em>Thermal Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pocs3_emf.impl.ThermalUnitImpl
     * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getThermalUnit()
     * @generated
     */
    EClass THERMAL_UNIT = eINSTANCE.getThermalUnit();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THERMAL_UNIT__NAME = eINSTANCE.getThermalUnit_Name();

    /**
     * The meta object literal for the '<em><b>Block Unit</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THERMAL_UNIT__BLOCK_UNIT = eINSTANCE.getThermalUnit_BlockUnit();

    /**
     * The meta object literal for the '<em><b>Common</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THERMAL_UNIT__COMMON = eINSTANCE.getThermalUnit_Common();

    /**
     * The meta object literal for the '{@link pocs3_emf.impl.BlockUnitImpl <em>Block Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pocs3_emf.impl.BlockUnitImpl
     * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getBlockUnit()
     * @generated
     */
    EClass BLOCK_UNIT = eINSTANCE.getBlockUnit();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BLOCK_UNIT__NAME = eINSTANCE.getBlockUnit_Name();

    /**
     * The meta object literal for the '<em><b>Generate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation BLOCK_UNIT___GENERATE = eINSTANCE.getBlockUnit__Generate();

    /**
     * The meta object literal for the '{@link pocs3_emf.IUnit <em>IUnit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pocs3_emf.IUnit
     * @see pocs3_emf.impl.Pocs3_emfPackageImpl#getIUnit()
     * @generated
     */
    EClass IUNIT = eINSTANCE.getIUnit();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IUNIT__ID = eINSTANCE.getIUnit_Id();

  }

} //Pocs3_emfPackage
