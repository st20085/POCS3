/**
 */
package pocs3_common.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pocs3_common.Common;
import pocs3_common.Pocs3_commonFactory;
import pocs3_common.Pocs3_commonPackage;

import pocs3_emf.Pocs3_emfPackage;

import pocs3_emf.impl.Pocs3_emfPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Pocs3_commonPackageImpl extends EPackageImpl implements Pocs3_commonPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commonEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see pocs3_common.Pocs3_commonPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Pocs3_commonPackageImpl() {
    super(eNS_URI, Pocs3_commonFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link Pocs3_commonPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Pocs3_commonPackage init() {
    if (isInited) return (Pocs3_commonPackage)EPackage.Registry.INSTANCE.getEPackage(Pocs3_commonPackage.eNS_URI);

    // Obtain or create and register package
    Pocs3_commonPackageImpl thePocs3_commonPackage = (Pocs3_commonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Pocs3_commonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Pocs3_commonPackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    Pocs3_emfPackageImpl thePocs3_emfPackage = (Pocs3_emfPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Pocs3_emfPackage.eNS_URI) instanceof Pocs3_emfPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Pocs3_emfPackage.eNS_URI) : Pocs3_emfPackage.eINSTANCE);

    // Create package meta-data objects
    thePocs3_commonPackage.createPackageContents();
    thePocs3_emfPackage.createPackageContents();

    // Initialize created meta-data
    thePocs3_commonPackage.initializePackageContents();
    thePocs3_emfPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePocs3_commonPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Pocs3_commonPackage.eNS_URI, thePocs3_commonPackage);
    return thePocs3_commonPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommon() {
    return commonEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pocs3_commonFactory getPocs3_commonFactory() {
    return (Pocs3_commonFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    commonEClass = createEClass(COMMON);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(commonEClass, Common.class, "Common", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //Pocs3_commonPackageImpl
