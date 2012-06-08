/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.doc

import org.eclipse.xtext.xbase.lib.Procedures$Procedure1
import java.util.List

class HtmlFile {

	def static newHtmlFile(Procedures$Procedure1<HtmlFile> initializer){
		val htmlFile = new HtmlFile()
		initializer.apply(htmlFile)
		return htmlFile
	}

	List<String> cssFiles = newArrayList("bootstrap.min.css", "bootstrap-responsive.min.css", "custom.css", "prettify.css")
	List<String> jsFiles = newArrayList("prettify.js", "lang-jnario.js")
	
	
	public static HtmlFile EMPTY_FILE = new HtmlFile
	
	public CharSequence fileName = ""
	public CharSequence title = ""
	public CharSequence content = ""
	public String rootFolder = ""
	
	
	def toText()'''
		<!DOCTYPE html>
		<html lang="en">
		<head>
		<meta charset="utf-8">
		<title>�title�</title>
		<meta name="description" content="">
		<meta name="author" content="Jnario">

		<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
		<!--[if lt IE 9]>
		      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		    <![endif]-->

		<!-- Le styles -->
		�FOR cssFile : cssFiles�
		<link rel="stylesheet" href="�rootFolder�/css/�cssFile�">
		�ENDFOR�
		�FOR jsFile : jsFiles�
		<script type="text/javascript" src="�rootFolder�/js/�jsFile�"></script>
		�ENDFOR�
		</head>
		
		<body onload="prettyPrint()">
			<div class="container">
				<div class="content">
					<div class="page-header">
						<h1>�title�</h1>
					</div>
					<div class="row">
						<div class="span12">
		�content�
						</div>
					</div>
				</div> <!-- /content -->
				<footer>
					<p><small>Generated by <a href="http://www.jnario.org">Jnario</a>.</small></p>
				</footer>
		
			</div>
			<!-- /container -->
		
		</body>
		</html>
	'''
	
	def setTitle(String title){
		this.title = title
	}
	
	def setContent(String content){
		this.content = content
	}
	
	def setFileName(String fileName){
		this.fileName = fileName
	}
	
	def getTitle(){
		return title
	}
	
	def getContent(){
		return content
	}
	
	def getFileName(){
		return content
	}
	
	def getCssFiles(){
		return cssFiles
	}
	
	def getJsFiles(){
		return jsFiles
	}

} 