package com.dendrytdev.org.client.designer.problemOverview;

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
	@SuppressWarnings("deprecation") // TODO: toLocaleString - refactor into
	private static String getText(Problem p) {
		StringBuilder sb = new StringBuilder();
		
		if(p.getProduct() != null){
			sb.append(p.getProduct());
		}
		if(p.getClient() != null){
			sb.append(" zglaszajacy:");
			sb.append(p.getClient());			
			sb.append(" ");
		}
		if(p.getProblemDate() != null){
			sb.append(" data zgloszenia:");
			sb.append(p.getProblemDate().toLocaleString());			
		}
		if(p.getDescription() != null){
			sb.append(" tresc:");
			sb.append(p.getDescription());			
		}
		String text = sb.toString();
		return text;
	}
	public Problem getProblem(){
		return _problem;
	}

}
