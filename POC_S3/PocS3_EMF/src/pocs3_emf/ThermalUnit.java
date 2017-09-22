/**
 */
package pocs3_emf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import pocs3_common.Common;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thermal Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pocs3_emf.ThermalUnit#getName <em>Name</em>}</li>
 *   <li>{@link pocs3_emf.ThermalUnit#getBlockUnit <em>Block Unit</em>}</li>
 *   <li>{@link pocs3_emf.ThermalUnit#getCommon <em>Common</em>}</li>
 * </ul>
 *
 * @see pocs3_emf.Pocs3_emfPackage#getThermalUnit()
 * @model
 * @generated
 */
public interface ThermalUnit extends EObject {
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
   * @see pocs3_emf.Pocs3_emfPackage#getThermalUnit_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link pocs3_emf.ThermalUnit#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Block Unit</b></em>' reference list.
   * The list contents are of type {@link pocs3_emf.BlockUnit}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block Unit</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block Unit</em>' reference list.
   * @see pocs3_emf.Pocs3_emfPackage#getThermalUnit_BlockUnit()
   * @model
   * @generated
   */
  EList<BlockUnit> getBlockUnit();

  /**
   * Returns the value of the '<em><b>Common</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Common</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Common</em>' reference.
   * @see #setCommon(Common)
   * @see pocs3_emf.Pocs3_emfPackage#getThermalUnit_Common()
   * @model
   * @generated
   */
  Common getCommon();

  /**
   * Sets the value of the '{@link pocs3_emf.ThermalUnit#getCommon <em>Common</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Common</em>' reference.
   * @see #getCommon()
   * @generated
   */
  void setCommon(Common value);

} // ThermalUnit
