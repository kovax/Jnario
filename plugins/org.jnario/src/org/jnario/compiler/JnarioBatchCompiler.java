/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.compiler;

import static com.google.common.collect.Iterables.addAll;
import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.toArray;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static java.util.Arrays.asList;
import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;
import static org.eclipse.xtext.util.Strings.concat;
import static org.eclipse.xtext.util.Strings.emptyIfNull;
import static org.eclipse.xtext.util.Strings.isEmpty;
import static org.eclipse.xtext.util.Strings.split;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian - Initial contribution and API
 */
public abstract class JnarioBatchCompiler extends XtendBatchCompiler {

	private static final Logger log = Logger.getLogger(JnarioBatchCompiler.class);

	@Inject
	private JvmModelGenerator generator;

	@Inject
	private IGeneratorConfigProvider generatorConfigprovider;

	@Inject
	private IXtendJvmAssociations xtendJvmAssociations;

	@Inject
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	@Inject
	private RuntimeWorkspaceConfigProvider workspaceConfigProvider;

	@Override
	protected File createStubs(ResourceSet resourceSet) {
		File outputDirectory = createTempDir("stubs");
		JavaIoFileSystemAccess fileSystemAccess = javaIoFileSystemAccessProvider
				.get();
		fileSystemAccess.setOutputPath(outputDirectory.toString());
		List<EObject> objectsWithClasses = getObjectsWithClasses(jnarioResources(resourceSet));
		for (EObject eObject : objectsWithClasses) {
			StringBuilder classSignatureBuilder = new StringBuilder();
			String packageName = getPackageName(eObject);
			if (!Strings.isEmpty(packageName)) {
				classSignatureBuilder.append("package " + packageName + ";");
				classSignatureBuilder.append("\n");
			}
			classSignatureBuilder.append("public class "
					+ getClassName(eObject) + "{}");
			String javaFileName = getJavaFileName(eObject);
			if (log.isDebugEnabled()) {
				log.debug("create java stub '" + javaFileName + "'");
			}
			fileSystemAccess.generateFile(javaFileName,
					classSignatureBuilder.toString());
		}
		return outputDirectory;
	}

	@Override
	protected void generateJavaFiles(ResourceSet resourceSet) {
		JavaIoFileSystemAccess javaIoFileSystemAccess = javaIoFileSystemAccessProvider
				.get();
		javaIoFileSystemAccess.setOutputPath(outputPath);
		javaIoFileSystemAccess.setWriteTrace(writeTraceFiles);

		for (Resource resource : jnarioResources(resourceSet)) {
			XtendFile file = filter(resource.getContents(), XtendFile.class)
					.iterator().next();
			for (XtendTypeDeclaration xtendClass : file.getXtendTypes()) {
				String packageName = toPath(getPackageName(xtendClass));
				for (JvmGenericType type : filter(resource.getContents(),
						JvmGenericType.class)) {
					CharSequence generatedType = generator.generateType(type,
							generatorConfigprovider.get(xtendClass));
					String fileName = packageName + type.getSimpleName()
							+ ".java";
					javaIoFileSystemAccess
							.generateFile(fileName, generatedType);
				}
			}
		}

		List<EObject> objectsWithClasses = getObjectsWithClasses(jnarioResources(resourceSet));
		if (log.isInfoEnabled()) {
			int size = Iterables.size(objectsWithClasses);
			if (size == 0) {
				log.info("No sources to compile in '" + sourcePath + "'");
			} else {
				log.info("Compiling " + size + " source "
						+ (size == 1 ? "file" : "files") + " to " + outputPath);
			}
		}
		for (EObject eObject : objectsWithClasses) {
			Iterable<JvmDeclaredType> jvmGenericTypes = Iterables.filter(
					xtendJvmAssociations.getJvmElements(eObject),
					JvmDeclaredType.class);
			for (JvmDeclaredType jvmType : jvmGenericTypes) {
				CharSequence generatedType = generator.generateType(jvmType,
						generatorConfigprovider.get(eObject));
				String javaFileName = getJavaFileName(eObject);
				if (log.isDebugEnabled()) {
					log.debug("write '" + outputPath + File.separator
							+ javaFileName + "'");
				}
				javaIoFileSystemAccess
						.generateFile(javaFileName, generatedType);
			}
		}
	}

	@Override
	protected List<Issue> validate(ResourceSet resourceSet) {
		List<Issue> issues = Lists.newArrayList();
		List<Resource> resources = newArrayList(resourceSet.getResources());
		for (Resource resource : resources) {
			if (fileExtensionProvider
					.isValid(resource.getURI().fileExtension())) {
				IResourceServiceProvider resourceServiceProvider = ((XtextResource) resource)
						.getResourceServiceProvider();
				IResourceValidator resourceValidator = resourceServiceProvider
						.getResourceValidator();
				List<Issue> result = resourceValidator.validate(resource,
						CheckMode.ALL, null);
				addAll(issues, result);
			}
		}
		return issues;
	}

	/**
	 * Installs the JvmTypeProvider optionally including index access into the
	 * {@link ResourceSet}. The lookup classpath is enhanced with the given tmp
	 * directory.
	 */
	protected void installJvmTypeProvider(ResourceSet resourceSet,
			File tmpClassDirectory, boolean skipIndexLookup) {
		if (skipIndexLookup) {
			internalInstallJvmTypeProvider(resourceSet, tmpClassDirectory,
					skipIndexLookup);
		} else {
			// delegate to the deprecated signature in case it was overridden by
			// clients
			installJvmTypeProvider(resourceSet, tmpClassDirectory);
		}
	}

	private void internalInstallJvmTypeProvider(ResourceSet resourceSet,
			File tmpClassDirectory, boolean skipIndexLookup) {
		Iterable<String> classPathEntries = concat(getClassPathEntries(),
				getSourcePathDirectories(),
				asList(tmpClassDirectory.toString()));
		classPathEntries = filter(classPathEntries, new Predicate<String>() {
			public boolean apply(String input) {
				return !Strings.isEmpty(input.trim());
			}
		});
		Iterable<URL> classPathUrls = Iterables.transform(classPathEntries,
				new Function<String, URL>() {
					public URL apply(String from) {
						try {
							return new File(from).toURI().toURL();
						} catch (MalformedURLException e) {
							throw new RuntimeException(e);
						}
					}
				});
		if (log.isDebugEnabled()) {
			log.debug("classpath used for Xtend compilation : " + classPathUrls);
		}

		ClassLoader parentClassLoader = useCurrentClassLoaderAsParent ? getClass()
				.getClassLoader() : null;
		if (((XtextResourceSet) resourceSet).getClasspathURIContext() instanceof URLClassLoader) {
			parentClassLoader = (ClassLoader) ((XtextResourceSet) resourceSet)
					.getClasspathURIContext();
		}
		URLClassLoader urlClassLoader = new URLClassLoader(toArray(
				classPathUrls, URL.class), parentClassLoader);
		new ClasspathTypeProvider(urlClassLoader, resourceSet,
				skipIndexLookup ? null : indexedJvmTypeAccess);
		((XtextResourceSet) resourceSet).setClasspathURIContext(urlClassLoader);
	}

	protected Iterable<Resource> jnarioResources(ResourceSet resourceSet) {
		return newArrayList(filter(resourceSet.getResources(),
				new Predicate<Resource>() {
					public boolean apply(Resource resource) {
						return fileExtensionProvider.isValid(resource.getURI()
								.fileExtension());
					}
				}));
	}

	protected String getJavaFileName(EObject obj) {
		String packageName = getPackageName(obj);
		String javaClassName = getClassName(obj) + ".java";
		return toPath(packageName) + javaClassName;
	}

	private String toPath(String packageName) {
		if (packageName == null) {
			return "";
		}
		return packageName.replaceAll("\\.", "/") + "/";
	}

	protected String getPackageName(EObject obj) {
		return getContainerOfType(obj, XtendFile.class).getPackage();
	}

	protected abstract String getClassName(EObject eObject);

	protected List<EObject> getObjectsWithClasses(Iterable<Resource> resources) {
		List<EObject> result = newArrayList();
		for (Resource resource : resources) {
			addObjectsWithClasses(resource, result);
		}
		return result;
	}

	protected abstract void addObjectsWithClasses(Resource resource,
			List<EObject> result);

	/*** copied from super class to fix maven problem **/

	public boolean configureWorkspace2() {
		List<File> sourceFileList = getSourcePathFileList();
		File outputFile = getOutputPathFile();
		if (sourceFileList == null || outputFile == null) {
			return false;
		}

		File commonRoot = determineCommonRoot(outputFile, sourceFileList);

		// We don't want to use root ("/") as a workspace folder, didn't we?
		if (commonRoot == null || commonRoot.getParent() == null
				|| commonRoot.getParentFile().getParent() == null) {
			log.error("All source folders and the output folder should have "
					+ "a common parent non-top level folder (like project folder)");
			for (File sourceFile : sourceFileList) {
				log.error("(Source folder: '" + sourceFile + "')");
			}
			log.error("(Output folder: '" + outputFile + "')");
			return false;
		}

		WorkspaceConfig workspaceConfig = new WorkspaceConfig(commonRoot.getParent().toString());
		ProjectConfig projectConfig = new ProjectConfig(commonRoot.getName());

		java.net.URI commonURI = commonRoot.toURI();
		java.net.URI relativizedTarget = commonURI.relativize(outputFile.toURI());
		if (relativizedTarget.isAbsolute()) {
			log.error("Target folder '" + outputFile
					+ "' must be a child of the project folder '" + commonRoot + "'");
			return false;
		}

		for (File source : sourceFileList) {
			java.net.URI relativizedSrc = commonURI.relativize(source.toURI());
			if (relativizedSrc.isAbsolute()) {
				log.error("Source folder '" + source
						+ "' must be a child of the project folder '" + commonRoot + "'");
				return false;
			}
			projectConfig.addSourceFolderMapping(relativizedSrc.getPath(), relativizedTarget.getPath());
		}
		workspaceConfig.addProjectConfig(projectConfig);
		workspaceConfigProvider.setWorkspaceConfig(workspaceConfig);
		return true;
	}

	private File getOutputPathFile() {
		try {
			return new File(outputPath).getCanonicalFile();
		} catch (IOException e) {
			log.error("Invalid target folder '" + outputPath + "' (" + e.getMessage() + ")");
			return null;
		}
	}

	private List<File> getSourcePathFileList() {
		List<File> sourceFileList = new ArrayList<File>();
		for (String path : getSourcePathDirectories()) {
			try {
				sourceFileList.add(new File(path).getCanonicalFile());
			} catch (IOException e) {
				log.error("Invalid source folder '" + path + "' (" + e.getMessage() + ")");
				return null;
			}
		}
		return sourceFileList;
	}

	private File determineCommonRoot(File outputFile, List<File> sourceFileList) {
		List<File> pathList = new ArrayList<File>(sourceFileList);
		pathList.add(outputFile);

		List<List<File>> pathParts = new ArrayList<List<File>>();

		for (File path : pathList) {
			List<File> partsList = new ArrayList<File>();
			File subdir = path;
			while (subdir != null) {
				partsList.add(subdir);
				subdir = subdir.getParentFile();
			}
			pathParts.add(partsList);
		}
		int i = 1;
		File result = null;
		while (true) {
			File compareWith = null;
			for (List<File> parts : pathParts) {
				if (parts.size() < i) {
					return result;
				}
				File part = parts.get(parts.size() - i);
				if (compareWith == null) {
					compareWith = part;
				} else {
					if (!compareWith.equals(part)) {
						return result;
					}
				}
			}
			result = compareWith;
			i++;
		}
	}

	public boolean compile() {
		try {
			if (workspaceConfigProvider.getWorkspaceConfig() == null) {
				if (!configureWorkspace2()) {
					return false;
				}
			}
			ResourceSet resourceSet = resourceSetProvider.get();
			File classDirectory = createTempDir("classes");
				// install a type provider without index lookup for the first phase
				installJvmTypeProvider(resourceSet, classDirectory, true);
				loadXtendFiles(resourceSet);
				File sourceDirectory = createStubs(resourceSet);
				if (!preCompileStubs(sourceDirectory, classDirectory)) {
					log.debug("Compilation of stubs and existing Java code had errors. This is expected and usually is not a probblem.");
				}
			// install a fresh type provider for the second phase, so we clear all previously cached classes and misses.
			installJvmTypeProvider(resourceSet, classDirectory, false);
			EcoreUtil.resolveAll(resourceSet);
			List<Issue> issues = validate(resourceSet);
			Iterable<Issue> errors = Iterables.filter(issues, SeverityFilter.ERROR);
			Iterable<Issue> warnings = Iterables.filter(issues, SeverityFilter.WARNING);
			reportIssues(Iterables.concat(errors, warnings));
			if (!Iterables.isEmpty(errors)) {
				return false;
			}
			generateJavaFiles(resourceSet);
		} finally {
			if (isDeleteTempDirectory()) {
				deleteTmpFolders();
			}
		}
		return true;
	}

	@Deprecated
	protected ResourceSet loadXtendFiles() {
		final ResourceSet resourceSet = resourceSetProvider.get();
		return loadXtendFiles(resourceSet);
	}


	protected boolean preCompileStubs(File tmpSourceDirectory, File classDirectory) {
		List<String> commandLine = Lists.newArrayList();
		// todo args
		if (isVerbose()) {
			commandLine.add("-verbose");
		}
		if (!isEmpty(classPath)) {
			commandLine.add("-cp \"" + concat(File.pathSeparator, getClassPathEntries())+"\"");
		}
		commandLine.add("-d \"" + classDirectory.toString() + "\"");
		commandLine.add("-" + getComplianceLevel());
		commandLine.add("-proceedOnError");
		List<String> sourceDirectories = newArrayList(getSourcePathDirectories());
		sourceDirectories.add(tmpSourceDirectory.toString());
		commandLine.add(concat(" ", transform(sourceDirectories, new Function<String, String>() {

			public String apply(String path) {
				return "\"" + path + "\"";
			}
		})));
		if (log.isDebugEnabled()) {
			log.debug("invoke batch compiler with '" + concat(" ", commandLine) + "'");
		}
		return BatchCompiler.compile(concat(" ", commandLine), new PrintWriter(getOutputWriter()), new PrintWriter(
				getErrorWriter()), null);
	}

	
	/**
	 * Installs the complete JvmTypeProvider including index access into the {@link ResourceSet}.
	 * The lookup classpath is enhanced with the given tmp directory.
	 * @deprecated use the explicit variant {@link #installJvmTypeProvider(ResourceSet, File, boolean)} instead.
	 */
	@Deprecated
	protected void installJvmTypeProvider(ResourceSet resourceSet, File tmpClassDirectory) {
		internalInstallJvmTypeProvider(resourceSet, tmpClassDirectory, false);
	}
	

	protected void reportIssues(Iterable<Issue> issues) {
		for (Issue issue : issues) {
			StringBuilder issueBuilder = createIssueMessage(issue);
			if (Severity.ERROR == issue.getSeverity()) {
				log.error(issueBuilder.toString());
			} else if (Severity.WARNING == issue.getSeverity()) {
				log.warn(issueBuilder.toString());
			}
		}
	}

	private StringBuilder createIssueMessage(Issue issue) {
		StringBuilder issueBuilder = new StringBuilder("\n");
		issueBuilder.append(issue.getSeverity()).append(": \t");
		URI uriToProblem = issue.getUriToProblem();
		if (uriToProblem != null) {
			URI resourceUri = uriToProblem.trimFragment();
			issueBuilder.append(resourceUri.lastSegment()).append(" - ");
			if (resourceUri.isFile()) {
				issueBuilder.append(resourceUri.toFileString());
			}
		}
		issueBuilder.append("\n").append(issue.getLineNumber()).append(": ").append(issue.getMessage());
		return issueBuilder;
	}


	protected ResourceSetBasedResourceDescriptions getResourceDescriptions(ResourceSet resourceSet) {
		ResourceSetBasedResourceDescriptions resourceDescriptions = resourceSetDescriptionsProvider.get();
		resourceDescriptions.setContext(resourceSet);
		resourceDescriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		return resourceDescriptions;
	}

	private String getJavaFileName(QualifiedName typeName) {
		return Strings.concat("/", typeName.getSegments()) + ".java";
	}

	@Nullable protected XtendFile getXtendFile(Resource resource) {
		XtextResource xtextResource = (XtextResource) resource;
		IParseResult parseResult = xtextResource.getParseResult();
		if (parseResult != null) {
			EObject model = parseResult.getRootASTElement();
			if (model instanceof XtendFile) {
				XtendFile xtendFile = (XtendFile) model;
				return xtendFile;
			}
		}
		return null;
	}

	protected List<String> getClassPathEntries() {
		return getDirectories(classPath);
	}

	protected List<String> getSourcePathDirectories() {
		return getDirectories(sourcePath);
	}

	protected List<String> getDirectories(String path) {
		if (Strings.isEmpty(path)) {
			return Lists.newArrayList();
		}
		final List<String> split = split(emptyIfNull(path), File.pathSeparator);
		return transform(split, new Function<String, String>() {
			public String apply(String from) {
				try {
					return new File(from).getCanonicalPath();
				} catch (IOException e) {
					throw new WrappedException(e);
				}
			}
		});
	}

	protected File createTempDir(String prefix) {
		File tempDir = new File(getTempDirectory(), prefix + System.nanoTime());
		cleanFolder(tempDir, ACCEPT_ALL_FILTER, true, true);
		if (!tempDir.mkdirs()) {
			throw new RuntimeException("Error creating temp directory '" + tempDir.getAbsolutePath() + "'");
		}
		tempFolders.add(tempDir);
		return tempDir;
	}

	protected void deleteTmpFolders() {
		for (File file : tempFolders) {
			cleanFolder(file, ACCEPT_ALL_FILTER, true, true);
		}
	}

	// FIXME: use Files#cleanFolder after the maven distro availability of version 2.2.x
	protected static boolean cleanFolder(File parentFolder, FileFilter filter, boolean continueOnError,
			boolean deleteParentFolder) {
		if (!parentFolder.exists()) {
			return true;
		}
		if (filter == null)
			filter = ACCEPT_ALL_FILTER;
		log.debug("Cleaning folder " + parentFolder.toString());
		final File[] contents = parentFolder.listFiles(filter);
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
				if (!cleanFolder(file, filter, continueOnError, true) && !continueOnError)
					return false;
			} else {
				if (!file.delete()) {
					log.error("Couldn't delete " + file.getAbsolutePath());
					if (!continueOnError)
						return false;
				}
			}
		}
		if (deleteParentFolder) {
			if (parentFolder.list().length == 0 && !parentFolder.delete()) {
				log.error("Couldn't delete " + parentFolder.getAbsolutePath());
				return false;
			}
		}
		return true;
	}	

}