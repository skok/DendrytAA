package com.dendrytdev.org.client.problemSubmiting;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public class ProblemSubmiting extends Composite{
		public ProblemSubmiting() {
			{
				Composite c = new ProblemSubmitingMain();
				initWidget(c);
			}
		}

	}