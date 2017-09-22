/**
 */
package pocs3_common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pocs3_common.Pocs3_commonPackage
 * @generated
 */
public interface Pocs3_commonFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Pocs3_commonFactory eINSTANCE = pocs3_common.impl.Pocs3_commonFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Common</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Common</em>'.
   * @generated
   */
  Common createCommon();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Pocs3_commonPackage getPocs3_commonPackage();

} //Pocs3_commonFactory
