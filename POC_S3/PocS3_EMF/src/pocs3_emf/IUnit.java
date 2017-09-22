/**
 */
package pocs3_emf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IUnit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pocs3_emf.IUnit#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see pocs3_emf.Pocs3_emfPackage#getIUnit()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IUnit extends EObject {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see pocs3_emf.Pocs3_emfPackage#getIUnit_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link pocs3_emf.IUnit#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

} // IUnit
