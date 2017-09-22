/**
 */
package pocs3_emf.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pocs3_emf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see pocs3_emf.Pocs3_emfPackage
 * @generated
 */
public class Pocs3_emfSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Pocs3_emfPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_emfSwitch() {
    if (modelPackage == null) {
      modelPackage = Pocs3_emfPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER: {
        ApplicationModuleContainer applicationModuleContainer = (ApplicationModuleContainer)theEObject;
        T result = caseApplicationModuleContainer(applicationModuleContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Pocs3_emfPackage.APPLICATION_MODULE: {
        ApplicationModule applicationModule = (ApplicationModule)theEObject;
        T result = caseApplicationModule(applicationModule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Pocs3_emfPackage.THERMAL_UNIT: {
        ThermalUnit thermalUnit = (ThermalUnit)theEObject;
        T result = caseThermalUnit(thermalUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Pocs3_emfPackage.BLOCK_UNIT: {
        BlockUnit blockUnit = (BlockUnit)theEObject;
        T result = caseBlockUnit(blockUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Pocs3_emfPackage.IUNIT: {
        IUnit iUnit = (IUnit)theEObject;
        T result = caseIUnit(iUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Application Module Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Application Module Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplicationModuleContainer(ApplicationModuleContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Application Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Application Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplicationModule(ApplicationModule object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Thermal Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Thermal Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThermalUnit(ThermalUnit object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockUnit(BlockUnit object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IUnit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IUnit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIUnit(IUnit object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //Pocs3_emfSwitch
