package com.dendrytdev.org.client.designer.problemOverview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.user.client.ui.SuggestOracle;

public class ProblemSuggestOracle extends SuggestOracle {

	private List<ProblemMultiWordSuggestion> _problemSuggestions = null;

	@Override
	public void requestSuggestions(Request request, Callback callback) {
		Response resp = new Response(matchingPeople(request.getQuery(), request
				.getLimit()));
		callback.onSuggestionsReady(request, resp);
	}

	public Collection<ProblemMultiWordSuggestion> matchingPeople(String query, int limit) {
		List<ProblemMultiWordSuggestion> matchingProblems = new ArrayList<ProblemMultiWordSuggestion>(limit);

		// start only for minimum 2 characters
		if (query.length() >= 2) {
			String prefixToMatch = query.toLowerCase();

			for(ProblemMultiWordSuggestion p : _problemSuggestions){
				if(p.getDisplayString().toLowerCase().contains(prefixToMatch)){
					matchingProblems.add(p);
				}
			}
		}

		return matchingProblems;
	}
	

	public boolean add(ProblemMultiWordSuggestion o) {
		if (_problemSuggestions == null) {
			_problemSuggestions = new ArrayList<ProblemMultiWordSuggestion>();
		}

		return _problemSuggestions.add(o);
	}

	public boolean remove(Object o) {
		if (_problemSuggestions != null) {
			return _problemSuggestions.remove(o);
		}

		return false;
	}

	public void clear() {
		if(_problemSuggestions != null){
			_problemSuggestions.clear();
		}
	}

}
