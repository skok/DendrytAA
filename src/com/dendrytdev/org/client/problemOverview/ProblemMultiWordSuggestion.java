package com.dendrytdev.org.client.problemOverview;

import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class ProblemMultiWordSuggestion extends MultiWordSuggestion{
	private Problem _problem;
	public ProblemMultiWordSuggestion(Problem p){
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
		StringBuilder sb = new StringBuilder(p.getProduct());
		sb.append(" zglaszajacy:");
		sb.append(p.getClient());
		sb.append(" ");
		sb.append(" data zgloszenia:");
		sb.append(p.getProblemDate().toLocaleString());
		sb.append(" tresc:");
		sb.append(p.getDescription());
		String text = sb.toString();
		return text;
	}
	public Problem getProblem(){
		return _problem;
	}

}
