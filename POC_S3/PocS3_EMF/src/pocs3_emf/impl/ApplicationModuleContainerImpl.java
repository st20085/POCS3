/**
 */
package pocs3_emf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pocs3_emf.ApplicationModule;
import pocs3_emf.ApplicationModuleContainer;
import pocs3_emf.Pocs3_emfPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Module Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pocs3_emf.impl.ApplicationModuleContainerImpl#getApplicationModules <em>Application Modules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationModuleContainerImpl extends MinimalEObjectImpl.Container implements ApplicationModuleContainer {
  /**
   * The cached value of the '{@link #getApplicationModules() <em>Application Modules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplicationModules()
   * @generated
   * @ordered
   */
  protected EList<ApplicationModule> applicationModules;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ApplicationModuleContainerImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return Pocs3_emfPackage.Literals.APPLICATION_MODULE_CONTAINER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ApplicationModule> getApplicationModules() {
    if (applicationModules == null) {
      applicationModules = new EObjectContainmentEList<ApplicationModule>(ApplicationModule.class, this, Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES);
    }
    return applicationModules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES:
        return ((InternalEList<?>)getApplicationModules()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES:
        return getApplicationModules();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES:
        getApplicationModules().clear();
        getApplicationModules().addAll((Collection<? extends ApplicationModule>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES:
        getApplicationModules().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case Pocs3_emfPackage.APPLICATION_MODULE_CONTAINER__APPLICATION_MODULES:
        return applicationModules != null && !applicationModules.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ApplicationModuleContainerImpl
