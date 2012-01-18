/**
 * <copyright>
 * </copyright>
 *

 */
package de.bmw.carit.jnario.jnario.impl;

import de.bmw.carit.jnario.jnario.And;
import de.bmw.carit.jnario.jnario.AndRef;
import de.bmw.carit.jnario.jnario.AndStep;
import de.bmw.carit.jnario.jnario.Background;
import de.bmw.carit.jnario.jnario.Code;
import de.bmw.carit.jnario.jnario.ExampleCell;
import de.bmw.carit.jnario.jnario.ExampleHeading;
import de.bmw.carit.jnario.jnario.ExampleRow;
import de.bmw.carit.jnario.jnario.ExampleTable;
import de.bmw.carit.jnario.jnario.Feature;
import de.bmw.carit.jnario.jnario.Given;
import de.bmw.carit.jnario.jnario.GivenRef;
import de.bmw.carit.jnario.jnario.GivenSteps;
import de.bmw.carit.jnario.jnario.Jnario;
import de.bmw.carit.jnario.jnario.JnarioFactory;
import de.bmw.carit.jnario.jnario.JnarioPackage;
import de.bmw.carit.jnario.jnario.Scenario;
import de.bmw.carit.jnario.jnario.Step;
import de.bmw.carit.jnario.jnario.Then;
import de.bmw.carit.jnario.jnario.ThenRef;
import de.bmw.carit.jnario.jnario.When;
import de.bmw.carit.jnario.jnario.WhenRef;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JnarioPackageImpl extends EPackageImpl implements JnarioPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass backgroundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass givenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleHeadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleRowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleCellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jnarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass givenRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whenRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thenRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass givenStepsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andStepEClass = null;

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
	 * @see de.bmw.carit.jnario.jnario.JnarioPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JnarioPackageImpl()
	{
		super(eNS_URI, JnarioFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JnarioPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JnarioPackage init()
	{
		if (isInited) return (JnarioPackage)EPackage.Registry.INSTANCE.getEPackage(JnarioPackage.eNS_URI);

		// Obtain or create and register package
		JnarioPackageImpl theJnarioPackage = (JnarioPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JnarioPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JnarioPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Xtend2Package.eINSTANCE.eClass();

		// Create package meta-data objects
		theJnarioPackage.createPackageContents();

		// Initialize created meta-data
		theJnarioPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJnarioPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JnarioPackage.eNS_URI, theJnarioPackage);
		return theJnarioPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature()
	{
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Description()
	{
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Background()
	{
		return (EReference)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBackground()
	{
		return backgroundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBackground_Steps()
	{
		return (EReference)backgroundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBackground_Members()
	{
		return (EReference)backgroundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenario()
	{
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Examples()
	{
		return (EReference)scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScenario_Name()
	{
		return (EAttribute)scenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Steps()
	{
		return (EReference)scenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScenario_Members()
	{
		return (EReference)scenarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStep()
	{
		return stepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStep_Name()
	{
		return (EAttribute)stepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStep_Code()
	{
		return (EReference)stepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStep_And()
	{
		return (EReference)stepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGiven()
	{
		return givenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhen()
	{
		return whenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThen()
	{
		return thenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd()
	{
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCode()
	{
		return codeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCode_Annotations()
	{
		return (EReference)codeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCode_BlockExpression()
	{
		return (EReference)codeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExampleTable()
	{
		return exampleTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExampleTable_Name()
	{
		return (EAttribute)exampleTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExampleTable_Heading()
	{
		return (EReference)exampleTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExampleTable_Rows()
	{
		return (EReference)exampleTableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExampleHeading()
	{
		return exampleHeadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExampleHeading_Parts()
	{
		return (EReference)exampleHeadingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExampleRow()
	{
		return exampleRowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExampleRow_Parts()
	{
		return (EReference)exampleRowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExampleCell()
	{
		return exampleCellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExampleCell_Name()
	{
		return (EReference)exampleCellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJnario()
	{
		return jnarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGivenRef()
	{
		return givenRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGivenRef_Reference()
	{
		return (EReference)givenRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhenRef()
	{
		return whenRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhenRef_Reference()
	{
		return (EReference)whenRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThenRef()
	{
		return thenRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThenRef_Reference()
	{
		return (EReference)thenRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGivenSteps()
	{
		return givenStepsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndRef()
	{
		return andRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAndRef_Reference()
	{
		return (EReference)andRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndStep()
	{
		return andStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JnarioFactory getJnarioFactory()
	{
		return (JnarioFactory)getEFactoryInstance();
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
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__DESCRIPTION);
		createEReference(featureEClass, FEATURE__BACKGROUND);

		backgroundEClass = createEClass(BACKGROUND);
		createEReference(backgroundEClass, BACKGROUND__STEPS);
		createEReference(backgroundEClass, BACKGROUND__MEMBERS);

		scenarioEClass = createEClass(SCENARIO);
		createEReference(scenarioEClass, SCENARIO__EXAMPLES);
		createEAttribute(scenarioEClass, SCENARIO__NAME);
		createEReference(scenarioEClass, SCENARIO__STEPS);
		createEReference(scenarioEClass, SCENARIO__MEMBERS);

		stepEClass = createEClass(STEP);
		createEAttribute(stepEClass, STEP__NAME);
		createEReference(stepEClass, STEP__CODE);
		createEReference(stepEClass, STEP__AND);

		givenEClass = createEClass(GIVEN);

		whenEClass = createEClass(WHEN);

		thenEClass = createEClass(THEN);

		andEClass = createEClass(AND);

		codeEClass = createEClass(CODE);
		createEReference(codeEClass, CODE__ANNOTATIONS);
		createEReference(codeEClass, CODE__BLOCK_EXPRESSION);

		exampleTableEClass = createEClass(EXAMPLE_TABLE);
		createEAttribute(exampleTableEClass, EXAMPLE_TABLE__NAME);
		createEReference(exampleTableEClass, EXAMPLE_TABLE__HEADING);
		createEReference(exampleTableEClass, EXAMPLE_TABLE__ROWS);

		exampleHeadingEClass = createEClass(EXAMPLE_HEADING);
		createEReference(exampleHeadingEClass, EXAMPLE_HEADING__PARTS);

		exampleRowEClass = createEClass(EXAMPLE_ROW);
		createEReference(exampleRowEClass, EXAMPLE_ROW__PARTS);

		exampleCellEClass = createEClass(EXAMPLE_CELL);
		createEReference(exampleCellEClass, EXAMPLE_CELL__NAME);

		jnarioEClass = createEClass(JNARIO);

		givenRefEClass = createEClass(GIVEN_REF);
		createEReference(givenRefEClass, GIVEN_REF__REFERENCE);

		whenRefEClass = createEClass(WHEN_REF);
		createEReference(whenRefEClass, WHEN_REF__REFERENCE);

		thenRefEClass = createEClass(THEN_REF);
		createEReference(thenRefEClass, THEN_REF__REFERENCE);

		givenStepsEClass = createEClass(GIVEN_STEPS);

		andRefEClass = createEClass(AND_REF);
		createEReference(andRefEClass, AND_REF__REFERENCE);

		andStepEClass = createEClass(AND_STEP);
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
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Xtend2Package theXtend2Package = (Xtend2Package)EPackage.Registry.INSTANCE.getEPackage(Xtend2Package.eNS_URI);
		XAnnotationsPackage theXAnnotationsPackage = (XAnnotationsPackage)EPackage.Registry.INSTANCE.getEPackage(XAnnotationsPackage.eNS_URI);
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureEClass.getESuperTypes().add(theXtend2Package.getXtendClass());
		scenarioEClass.getESuperTypes().add(theXtend2Package.getXtendMember());
		stepEClass.getESuperTypes().add(theXtend2Package.getXtendMember());
		givenEClass.getESuperTypes().add(this.getStep());
		whenEClass.getESuperTypes().add(this.getStep());
		thenEClass.getESuperTypes().add(this.getStep());
		andEClass.getESuperTypes().add(this.getStep());
		jnarioEClass.getESuperTypes().add(theXtend2Package.getXtendFile());
		givenRefEClass.getESuperTypes().add(this.getStep());
		whenRefEClass.getESuperTypes().add(this.getStep());
		thenRefEClass.getESuperTypes().add(this.getStep());
		givenStepsEClass.getESuperTypes().add(this.getStep());
		andRefEClass.getESuperTypes().add(this.getStep());
		andStepEClass.getESuperTypes().add(this.getStep());

		// Initialize classes and features; add operations and parameters
		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Description(), ecorePackage.getEString(), "description", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Background(), this.getBackground(), null, "background", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(backgroundEClass, Background.class, "Background", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBackground_Steps(), this.getStep(), null, "steps", null, 0, -1, Background.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBackground_Members(), theXtend2Package.getXtendMember(), null, "members", null, 0, -1, Background.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_Examples(), this.getExampleTable(), null, "examples", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScenario_Name(), ecorePackage.getEString(), "name", null, 0, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScenario_Steps(), this.getStep(), null, "steps", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScenario_Members(), theXtend2Package.getXtendMember(), null, "members", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stepEClass, Step.class, "Step", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStep_Name(), ecorePackage.getEString(), "name", null, 0, 1, Step.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStep_Code(), this.getCode(), null, "code", null, 0, 1, Step.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStep_And(), this.getStep(), null, "and", null, 0, -1, Step.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(givenEClass, Given.class, "Given", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(whenEClass, When.class, "When", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(thenEClass, Then.class, "Then", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(codeEClass, Code.class, "Code", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCode_Annotations(), theXAnnotationsPackage.getXAnnotation(), null, "annotations", null, 0, -1, Code.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCode_BlockExpression(), theXbasePackage.getXBlockExpression(), null, "blockExpression", null, 0, 1, Code.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleTableEClass, ExampleTable.class, "ExampleTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExampleTable_Name(), ecorePackage.getEString(), "name", null, 0, 1, ExampleTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleTable_Heading(), this.getExampleHeading(), null, "heading", null, 0, 1, ExampleTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleTable_Rows(), this.getExampleRow(), null, "rows", null, 0, -1, ExampleTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleHeadingEClass, ExampleHeading.class, "ExampleHeading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleHeading_Parts(), theXtend2Package.getXtendField(), null, "parts", null, 0, -1, ExampleHeading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleRowEClass, ExampleRow.class, "ExampleRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleRow_Parts(), this.getExampleCell(), null, "parts", null, 0, -1, ExampleRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleCellEClass, ExampleCell.class, "ExampleCell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleCell_Name(), theXbasePackage.getXExpression(), null, "name", null, 0, 1, ExampleCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jnarioEClass, Jnario.class, "Jnario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(givenRefEClass, GivenRef.class, "GivenRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGivenRef_Reference(), this.getGiven(), null, "reference", null, 0, 1, GivenRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whenRefEClass, WhenRef.class, "WhenRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhenRef_Reference(), this.getWhen(), null, "reference", null, 0, 1, WhenRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thenRefEClass, ThenRef.class, "ThenRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThenRef_Reference(), this.getThen(), null, "reference", null, 0, 1, ThenRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(givenStepsEClass, GivenSteps.class, "GivenSteps", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andRefEClass, AndRef.class, "AndRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAndRef_Reference(), this.getAnd(), null, "reference", null, 0, 1, AndRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andStepEClass, AndStep.class, "AndStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //JnarioPackageImpl
