package com.dendrytdev.org.client.problemOverview;

import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class ProblemMultiWordSuggestion extends MultiWordSuggestion{
	private Problem _problem;
	ProblemMultiWordSuggestion(Problem p){
		super(getText(p), getText(p));
		_problem = p;
	}
	
	
	/**
	 * 
	 * TODO: REFACTOR THIS crap!!!
	 * @param p
	 * @return
	 */
	private static String getText(Problem p) {
		StringBuilder sb = new StringBuilder(p.getProdukt());
		sb.append(" zglaszajacy:");
		sb.append(p.getImieZglaszajacego());
		sb.append(" ");
		sb.append(p.getNazwiskoZglaszajacego());
		sb.append(" telefon:");
		sb.append(p.getTelefonZglaszajacego());
		sb.append(" ");
		sb.append(" data zgloszenia:");
		sb.append(p.getDataZgloszenia().toLocaleString());
		String text = sb.toString();
		return text;
	}
	Problem getProblem(){
		return _problem;
	}

}
