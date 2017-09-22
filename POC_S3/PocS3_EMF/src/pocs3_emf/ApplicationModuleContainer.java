/**
 */
package pocs3_emf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Module Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pocs3_emf.ApplicationModuleContainer#getApplicationModules <em>Application Modules</em>}</li>
 * </ul>
 *
 * @see pocs3_emf.Pocs3_emfPackage#getApplicationModuleContainer()
 * @model
 * @generated
 */
public interface ApplicationModuleContainer extends EObject {
  /**
   * Returns the value of the '<em><b>Application Modules</b></em>' containment reference list.
   * The list contents are of type {@link pocs3_emf.ApplicationModule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Modules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Modules</em>' containment reference list.
   * @see pocs3_emf.Pocs3_emfPackage#getApplicationModuleContainer_ApplicationModules()
   * @model containment="true"
   * @generated
   */
  EList<ApplicationModule> getApplicationModules();

} // ApplicationModuleContainer
