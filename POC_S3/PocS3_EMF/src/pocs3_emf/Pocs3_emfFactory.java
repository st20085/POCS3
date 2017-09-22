/**
 */
package pocs3_emf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pocs3_emf.Pocs3_emfPackage
 * @generated
 */
public interface Pocs3_emfFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Pocs3_emfFactory eINSTANCE = pocs3_emf.impl.Pocs3_emfFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Application Module Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application Module Container</em>'.
   * @generated
   */
  ApplicationModuleContainer createApplicationModuleContainer();

  /**
   * Returns a new object of class '<em>Application Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application Module</em>'.
   * @generated
   */
  ApplicationModule createApplicationModule();

  /**
   * Returns a new object of class '<em>Thermal Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Thermal Unit</em>'.
   * @generated
   */
  ThermalUnit createThermalUnit();

  /**
   * Returns a new object of class '<em>Block Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block Unit</em>'.
   * @generated
   */
  BlockUnit createBlockUnit();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Pocs3_emfPackage getPocs3_emfPackage();

} //Pocs3_emfFactory
