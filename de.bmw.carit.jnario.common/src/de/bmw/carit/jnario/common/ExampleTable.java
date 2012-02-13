/**
 * <copyright>
 * </copyright>
 *

 */
package de.bmw.carit.jnario.common;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Example Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.bmw.carit.jnario.common.ExampleTable#getName <em>Name</em>}</li>
 *   <li>{@link de.bmw.carit.jnario.common.ExampleTable#getRows <em>Rows</em>}</li>
 *   <li>{@link de.bmw.carit.jnario.common.ExampleTable#getColumns <em>Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.bmw.carit.jnario.common.CommonPackage#getExampleTable()
 * @model
 * @generated
 */
public interface ExampleTable extends XtendMember
{
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
	 * @see de.bmw.carit.jnario.common.CommonPackage#getExampleTable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.bmw.carit.jnario.common.ExampleTable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
	 * The list contents are of type {@link de.bmw.carit.jnario.common.ExampleRow}.
	 * It is bidirectional and its opposite is '{@link de.bmw.carit.jnario.common.ExampleRow#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' containment reference list.
	 * @see de.bmw.carit.jnario.common.CommonPackage#getExampleTable_Rows()
	 * @see de.bmw.carit.jnario.common.ExampleRow#getTable
	 * @model opposite="table" containment="true"
	 * @generated
	 */
	EList<ExampleRow> getRows();

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link de.bmw.carit.jnario.common.ExampleColumn}.
	 * It is bidirectional and its opposite is '{@link de.bmw.carit.jnario.common.ExampleColumn#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see de.bmw.carit.jnario.common.CommonPackage#getExampleTable_Columns()
	 * @see de.bmw.carit.jnario.common.ExampleColumn#getTable
	 * @model opposite="table" containment="true"
	 * @generated
	 */
	EList<ExampleColumn> getColumns();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isValid();

} // ExampleTable