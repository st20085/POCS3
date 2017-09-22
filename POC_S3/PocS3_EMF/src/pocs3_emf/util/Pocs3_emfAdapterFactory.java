/**
 */
package pocs3_emf.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import pocs3_emf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see pocs3_emf.Pocs3_emfPackage
 * @generated
 */
public class Pocs3_emfAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Pocs3_emfPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_emfAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = Pocs3_emfPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Pocs3_emfSwitch<Adapter> modelSwitch =
    new Pocs3_emfSwitch<Adapter>() {
      @Override
      public Adapter caseApplicationModuleContainer(ApplicationModuleContainer object) {
        return createApplicationModuleContainerAdapter();
      }
      @Override
      public Adapter caseApplicationModule(ApplicationModule object) {
        return createApplicationModuleAdapter();
      }
      @Override
      public Adapter caseThermalUnit(ThermalUnit object) {
        return createThermalUnitAdapter();
      }
      @Override
      public Adapter caseBlockUnit(BlockUnit object) {
        return createBlockUnitAdapter();
      }
      @Override
      public Adapter caseIUnit(IUnit object) {
        return createIUnitAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link pocs3_emf.ApplicationModuleContainer <em>Application Module Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see pocs3_emf.ApplicationModuleContainer
   * @generated
   */
  public Adapter createApplicationModuleContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link pocs3_emf.ApplicationModule <em>Application Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see pocs3_emf.ApplicationModule
   * @generated
   */
  public Adapter createApplicationModuleAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link pocs3_emf.ThermalUnit <em>Thermal Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see pocs3_emf.ThermalUnit
   * @generated
   */
  public Adapter createThermalUnitAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link pocs3_emf.BlockUnit <em>Block Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see pocs3_emf.BlockUnit
   * @generated
   */
  public Adapter createBlockUnitAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link pocs3_emf.IUnit <em>IUnit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see pocs3_emf.IUnit
   * @generated
   */
  public Adapter createIUnitAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //Pocs3_emfAdapterFactory
