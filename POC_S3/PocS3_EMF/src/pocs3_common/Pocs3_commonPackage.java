/**
 */
package pocs3_common;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see pocs3_common.Pocs3_commonFactory
 * @model kind="package"
 * @generated
 */
public interface Pocs3_commonPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "pocs3_common";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.example.org/pocs3_common";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "pocs3_common";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Pocs3_commonPackage eINSTANCE = pocs3_common.impl.Pocs3_commonPackageImpl.init();

  /**
   * The meta object id for the '{@link pocs3_common.impl.CommonImpl <em>Common</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see pocs3_common.impl.CommonImpl
   * @see pocs3_common.impl.Pocs3_commonPackageImpl#getCommon()
   * @generated
   */
  int COMMON = 0;

  /**
   * The number of structural features of the '<em>Common</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMON_FEATURE_COUNT = 0;

  /**
   * The number of operations of the '<em>Common</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMON_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link pocs3_common.Common <em>Common</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Common</em>'.
   * @see pocs3_common.Common
   * @generated
   */
  EClass getCommon();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Pocs3_commonFactory getPocs3_commonFactory();

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
     * The meta object literal for the '{@link pocs3_common.impl.CommonImpl <em>Common</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pocs3_common.impl.CommonImpl
     * @see pocs3_common.impl.Pocs3_commonPackageImpl#getCommon()
     * @generated
     */
    EClass COMMON = eINSTANCE.getCommon();

  }

} //Pocs3_commonPackage
