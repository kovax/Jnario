/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
 * generated by Xtext
 */
package org.jnario.suite;

import org.eclipse.xtend.core.featurecalls.XtendIdentifiableSimpleNameProvider;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.linking.XtendLinkingDiagnosticMessageProvider;
import org.eclipse.xtend.core.resource.XtendResource;
import org.eclipse.xtend.core.resource.XtendResourceDescriptionStrategy;
import org.eclipse.xtend.core.scoping.XtendImportedNamespaceScopeProvider;
import org.eclipse.xtend.core.validation.XtendEarlyExitValidator;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.TraceAwarePostProcessor;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.resource.JvmDeclaredTypeSignatureHashProvider.SignatureHashBuilder;
import org.eclipse.xtext.xbase.validation.EarlyExitValidator;
import org.jnario.doc.AbstractDocGenerator;
import org.jnario.doc.DocOutputConfigurationProvider;
import org.jnario.generator.JnarioJavaIoFileSystemAccess;
import org.jnario.jvmmodel.ExtendedJvmModelGenerator;
import org.jnario.jvmmodel.ExtendedJvmTypesBuilder;
import org.jnario.jvmmodel.JnarioNameProvider;
import org.jnario.jvmmodel.JnarioSignatureHashBuilder;
import org.jnario.suite.compiler.SuiteBatchCompiler;
import org.jnario.suite.conversion.SuiteValueConverterService;
import org.jnario.suite.doc.SuiteDocGenerator;
import org.jnario.suite.generator.SuiteGenerator;
import org.jnario.suite.jvmmodel.SuiteClassNameProvider;
import org.jnario.suite.jvmmodel.SuiteJvmModelInferrer;
import org.jnario.suite.naming.SuiteQualifiedNameProvider;
import org.jnario.suite.resource.SuiteResourceDescriptionManager;
import org.jnario.suite.scoping.SuiteScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("restriction")
public class SuiteRuntimeModule extends org.jnario.suite.AbstractSuiteRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractDocGenerator.class).to(SuiteDocGenerator.class);
		binder.bind(SignatureHashBuilder.class).to(JnarioSignatureHashBuilder.class);
		binder.bind(JnarioNameProvider.class).to(SuiteClassNameProvider.class);
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return SuiteValueConverterService.class;
	}
	
	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return SuiteGenerator.class;
	}

	public Class<? extends OutputConfigurationProvider> bindOutputConfigurationProvider() {
		return DocOutputConfigurationProvider.class;
	}
	
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return XtendLinkingDiagnosticMessageProvider.class;
	}
	
	public Class<? extends JvmTypesBuilder> bindJvmTypesBuilder(){
		return ExtendedJvmTypesBuilder.class;
	}
	
	public Class<? extends JvmModelGenerator> bindJvmModelGenerator(){
		return ExtendedJvmModelGenerator.class;
	}
	
	@Override
	public java.lang.Class<? extends IScopeProvider> bindIScopeProvider() {
		return SuiteScopeProvider.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return XtendResource.class;
	}
	
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
		.to(XtendImportedNamespaceScopeProvider.class);
	}

	@Override
	public Class<? extends IdentifiableSimpleNameProvider> bindIdentifiableSimpleNameProvider() {
		return XtendIdentifiableSimpleNameProvider.class;
	}

	public Class <? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return XtendResourceDescriptionStrategy.class;
	}

	public Class<? extends JvmModelAssociator> bindJvmModelAssociator() {
		return IXtendJvmAssociations.Impl.class;
	}

	public Class<? extends EarlyExitValidator> bindEarlyExitValidator() {
		return XtendEarlyExitValidator.class;
	}
	
	public Class<? extends IFilePostProcessor> bindPostProcessor() {
		return TraceAwarePostProcessor.class;
	}
	
	public Class<? extends JavaIoFileSystemAccess> bindJavaIoFileSystemAccess() {
		return JnarioJavaIoFileSystemAccess.class;
	}
	
	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return SuiteJvmModelInferrer.class;
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SuiteQualifiedNameProvider.class;
	}

	@Override
	public Class<? extends IResourceDescription.Manager> bindIResourceDescription$Manager() {
		return SuiteResourceDescriptionManager.class;
	}
	
	public Class<? extends org.jnario.compiler.JnarioBatchCompiler> bindJnarioBatchCompiler(){
		return SuiteBatchCompiler.class;
	}
}
