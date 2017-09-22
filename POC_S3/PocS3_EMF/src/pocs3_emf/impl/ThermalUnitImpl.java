/**
 */
package pocs3_emf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pocs3_common.Common;

import pocs3_emf.BlockUnit;
import pocs3_emf.Pocs3_emfPackage;
import pocs3_emf.ThermalUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thermal Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pocs3_emf.impl.ThermalUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link pocs3_emf.impl.ThermalUnitImpl#getBlockUnit <em>Block Unit</em>}</li>
 *   <li>{@link pocs3_emf.impl.ThermalUnitImpl#getCommon <em>Common</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThermalUnitImpl extends MinimalEObjectImpl.Container implements ThermalUnit {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getBlockUnit() <em>Block Unit</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockUnit()
   * @generated
   * @ordered
   */
  protected EList<BlockUnit> blockUnit;

  /**
   * The cached value of the '{@link #getCommon() <em>Common</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommon()
   * @generated
   * @ordered
   */
  protected Common common;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ThermalUnitImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return Pocs3_emfPackage.Literals.THERMAL_UNIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Pocs3_emfPackage.THERMAL_UNIT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BlockUnit> getBlockUnit() {
    if (blockUnit == null) {
      blockUnit = new EObjectResolvingEList<BlockUnit>(BlockUnit.class, this, Pocs3_emfPackage.THERMAL_UNIT__BLOCK_UNIT);
    }
    return blockUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Common getCommon() {
    if (common != null && common.eIsProxy()) {
      InternalEObject oldCommon = (InternalEObject)common;
      common = (Common)eResolveProxy(oldCommon);
      if (common != oldCommon) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Pocs3_emfPackage.THERMAL_UNIT__COMMON, oldCommon, common));
      }
    }
    return common;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Common basicGetCommon() {
    return common;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCommon(Common newCommon) {
    Common oldCommon = common;
    common = newCommon;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Pocs3_emfPackage.THERMAL_UNIT__COMMON, oldCommon, common));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case Pocs3_emfPackage.THERMAL_UNIT__NAME:
        return getName();
      case Pocs3_emfPackage.THERMAL_UNIT__BLOCK_UNIT:
        return getBlockUnit();
      case Pocs3_emfPackage.THERMAL_UNIT__COMMON:
        if (resolve) return getCommon();
        return basicGetCommon();
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
      case Pocs3_emfPackage.THERMAL_UNIT__NAME:
        setName((String)newValue);
        return;
      case Pocs3_emfPackage.THERMAL_UNIT__BLOCK_UNIT:
        getBlockUnit().clear();
        getBlockUnit().addAll((Collection<? extends BlockUnit>)newValue);
        return;
      case Pocs3_emfPackage.THERMAL_UNIT__COMMON:
        setCommon((Common)newValue);
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
      case Pocs3_emfPackage.THERMAL_UNIT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Pocs3_emfPackage.THERMAL_UNIT__BLOCK_UNIT:
        getBlockUnit().clear();
        return;
      case Pocs3_emfPackage.THERMAL_UNIT__COMMON:
        setCommon((Common)null);
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
      case Pocs3_emfPackage.THERMAL_UNIT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Pocs3_emfPackage.THERMAL_UNIT__BLOCK_UNIT:
        return blockUnit != null && !blockUnit.isEmpty();
      case Pocs3_emfPackage.THERMAL_UNIT__COMMON:
        return common != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ThermalUnitImpl
