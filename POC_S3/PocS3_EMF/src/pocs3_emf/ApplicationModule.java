/**
 */
package pocs3_emf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pocs3_emf.ApplicationModule#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see pocs3_emf.Pocs3_emfPackage#getApplicationModule()
 * @model
 * @generated
 */
public interface ApplicationModule extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see pocs3_emf.Pocs3_emfPackage#getApplicationModule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link pocs3_emf.ApplicationModule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // ApplicationModule
