package com.robotoworks.mechanoid.sqlite.serializer;

import com.google.inject.Inject;
import com.robotoworks.mechanoid.sqlite.services.SqliteModelGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SqliteModelSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SqliteModelGrammarAccess grammarAccess;
	protected AbstractElementAlias match_InsertStatement_InsertKeyword_0_0_0_or_ReplaceKeyword_0_1;
	protected AbstractElementAlias match_NullExpression_NotNullKeyword_1_1_0_or_NotnullKeyword_1_1_1;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_2_0_a;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_2_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SqliteModelGrammarAccess) access;
		match_InsertStatement_InsertKeyword_0_0_0_or_ReplaceKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getInsertStatementAccess().getInsertKeyword_0_0_0()), new TokenAlias(false, false, grammarAccess.getInsertStatementAccess().getReplaceKeyword_0_1()));
		match_NullExpression_NotNullKeyword_1_1_0_or_NotnullKeyword_1_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getNullExpressionAccess().getNotNullKeyword_1_1_0()), new TokenAlias(false, false, grammarAccess.getNullExpressionAccess().getNotnullKeyword_1_1_1()));
		match_PrimaryExpression_LeftParenthesisKeyword_2_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());
		match_PrimaryExpression_LeftParenthesisKeyword_2_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_InsertStatement_InsertKeyword_0_0_0_or_ReplaceKeyword_0_1.equals(syntax))
				emit_InsertStatement_InsertKeyword_0_0_0_or_ReplaceKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_NullExpression_NotNullKeyword_1_1_0_or_NotnullKeyword_1_1_1.equals(syntax))
				emit_NullExpression_NotNullKeyword_1_1_0_or_NotnullKeyword_1_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_2_0_a.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_2_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_2_0_p.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_2_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'insert' | 'replace'
	 */
	protected void emit_InsertStatement_InsertKeyword_0_0_0_or_ReplaceKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'notnull' | 'not null'
	 */
	protected void emit_NullExpression_NotNullKeyword_1_1_0_or_NotnullKeyword_1_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_2_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_2_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
