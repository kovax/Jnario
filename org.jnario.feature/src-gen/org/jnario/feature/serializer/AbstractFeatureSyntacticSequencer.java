/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.feature.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.jnario.feature.services.FeatureGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractFeatureSyntacticSequencer extends AbstractSyntacticSequencer {

	protected FeatureGrammarAccess grammarAccess;
	protected AbstractElementAlias match_BlockExpression_SemicolonKeyword_1_q;
	protected AbstractElementAlias match_Class_PublicKeyword_1_q;
	protected AbstractElementAlias match_ExampleColumn_PIPETerminalRuleCall_0_0_or_PIPE_SPACESTerminalRuleCall_0_1;
	protected AbstractElementAlias match_ExampleRow_PIPETerminalRuleCall_0_0_0_or_PIPE_SPACESTerminalRuleCall_0_0_1;
	protected AbstractElementAlias match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a;
	protected AbstractElementAlias match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p;
	protected AbstractElementAlias match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (FeatureGrammarAccess) access;
		match_BlockExpression_SemicolonKeyword_1_q = new TokenAlias(false, true, grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_1());
		match_Class_PublicKeyword_1_q = new TokenAlias(false, true, grammarAccess.getClassAccess().getPublicKeyword_1());
		match_ExampleColumn_PIPETerminalRuleCall_0_0_or_PIPE_SPACESTerminalRuleCall_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExampleColumnAccess().getPIPETerminalRuleCall_0_0()), new TokenAlias(false, false, grammarAccess.getExampleColumnAccess().getPIPE_SPACESTerminalRuleCall_0_1()));
		match_ExampleRow_PIPETerminalRuleCall_0_0_0_or_PIPE_SPACESTerminalRuleCall_0_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExampleRowAccess().getPIPETerminalRuleCall_0_0_0()), new TokenAlias(false, false, grammarAccess.getExampleRowAccess().getPIPE_SPACESTerminalRuleCall_0_0_1()));
		match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a = new TokenAlias(true, true, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0());
		match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p = new TokenAlias(true, false, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0());
		match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2()));
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getBACKGROUND_TEXTRule())
			return getBACKGROUND_TEXTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getEXAMPLE_ROW_ENDRule())
			return getEXAMPLE_ROW_ENDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPIPERule())
			return getPIPEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPIPE_SPACESRule())
			return getPIPE_SPACESToken(semanticObject, ruleCall, node);
		return "";
	}
	
	protected String getBACKGROUND_TEXTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "Background:";
	}
	protected String getEXAMPLE_ROW_ENDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|\n";
	}
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	protected String getPIPEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "|";
	}
	protected String getPIPE_SPACESToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "| ";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_BlockExpression_SemicolonKeyword_1_q.equals(syntax))
				emit_BlockExpression_SemicolonKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Class_PublicKeyword_1_q.equals(syntax))
				emit_Class_PublicKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExampleColumn_PIPETerminalRuleCall_0_0_or_PIPE_SPACESTerminalRuleCall_0_1.equals(syntax))
				emit_ExampleColumn_PIPETerminalRuleCall_0_0_or_PIPE_SPACESTerminalRuleCall_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExampleRow_PIPETerminalRuleCall_0_0_0_or_PIPE_SPACESTerminalRuleCall_0_0_1.equals(syntax))
				emit_ExampleRow_PIPETerminalRuleCall_0_0_0_or_PIPE_SPACESTerminalRuleCall_0_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a.equals(syntax))
				emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p.equals(syntax))
				emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q.equals(syntax))
				emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_BlockExpression_SemicolonKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'public'?
	 */
	protected void emit_Class_PublicKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     PIPE | PIPE_SPACES
	 */
	protected void emit_ExampleColumn_PIPETerminalRuleCall_0_0_or_PIPE_SPACESTerminalRuleCall_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     PIPE | PIPE_SPACES
	 */
	protected void emit_ExampleRow_PIPETerminalRuleCall_0_0_0_or_PIPE_SPACESTerminalRuleCall_0_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}