/**
 */
package pocs3_common.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pocs3_common.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pocs3_commonFactoryImpl extends EFactoryImpl implements Pocs3_commonFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Pocs3_commonFactory init() {
    try {
      Pocs3_commonFactory thePocs3_commonFactory = (Pocs3_commonFactory)EPackage.Registry.INSTANCE.getEFactory(Pocs3_commonPackage.eNS_URI);
      if (thePocs3_commonFactory != null) {
        return thePocs3_commonFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Pocs3_commonFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_commonFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case Pocs3_commonPackage.COMMON: return createCommon();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Common createCommon() {
    CommonImpl common = new CommonImpl();
    return common;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_commonPackage getPocs3_commonPackage() {
    return (Pocs3_commonPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Pocs3_commonPackage getPackage() {
    return Pocs3_commonPackage.eINSTANCE;
  }

} //Pocs3_commonFactoryImpl
