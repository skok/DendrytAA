package com.dendrytdev.org.client.client.problemSubmiting;

import java.util.Date;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.designer.problemOverview.ProblemSuggestOracle;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.dendrytdev.org.client.tools.IDialogBoxFactory;
import com.dendrytdev.org.client.tools.IType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class ProblemSubmiting extends Composite implements IProblemSubmiting {

	public void clearProblemDescription() {
		_descriptionTextArea.setText(IType.EMPTY_STRING);
	}

	public void blankAllFields() {
		_productListbox.clear();
		_importanceTextBox.clear();
		clearProblemDescription();
	}

	ListBox _productListbox = new ListBox();
	ListBox _importanceTextBox = new ListBox();
	TextArea _descriptionTextArea = new TextArea();
	ProblemSuggestOracle _oracle = new ProblemSuggestOracle();
	SuggestBox _suggestBox = new SuggestBox(_oracle);
	Button _submitButton;

	IDialogBoxFactory _factory = GuiFactory.getInstance();
	ProblemSubmitingController controller = new ProblemSubmitingController(this);

	/**
	 * TODO: refactor ......
	 */
	public ProblemSubmiting() {
		// initialize textboxes
		_productListbox.setWidth("150");
		_importanceTextBox.addItem("1");
		_importanceTextBox.addItem("2");
		_importanceTextBox.addItem("3");
		_importanceTextBox.addItem("4");
		
		_submitButton = new Button("Zglos problem", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				controller.submitProblem(getFilledProblem()); 
			}

		});


		HorizontalPanel mainPanel = new HorizontalPanel();
		initWidget(mainPanel);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		// create RIGHT Panel
		VerticalPanel rightVerticalPanel = new VerticalPanel();
		mainPanel.add(rightVerticalPanel);
		// add labels with textboxes on up of RIGHT Panel
		rightVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		rightVerticalPanel.add(generateMiddlePanel());
		rightVerticalPanel.setHeight("400");

		controller.updateProductList();
	}

	static class StaticHelperClass {
		static String width;

		static void setWidth(String s) {
			width = s;
		}

		/**
		 * Just pass the label name and textBox reference and the method create
		 * horizontal panel with it
		 * 
		 * @param labelName
		 * @param textBox
		 *            - should be already initialized (member of the class)
		 * @return
		 */
		static HorizontalPanel generateLabeledTextBoxPanel(String labelName,
				Widget textBox) {
			HorizontalPanel horizontalPane = new HorizontalPanel();
			Label l = new Label(labelName);
			l.setWidth(width);
			horizontalPane.add(l);
			horizontalPane.add(textBox);
			return horizontalPane;
		}
	}

	/**
	 * Generates a set of horizontal panels with labels and textboxes. All it is
	 * connected with content of Problem-bean *
	 * 
	 * @param panel
	 *            - panel to which it adds this hPanels
	 */
	VerticalPanel generateMiddlePanel() {

		VerticalPanel panel = new VerticalPanel();
		StaticHelperClass.setWidth("200");
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Produkt:", _productListbox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel(
				"Waga zglaszajacego:", _importanceTextBox));

		CaptionPanel cp = new CaptionPanel("Informacje o produkcie");
		cp.add(panel);
		VerticalPanel vp = new VerticalPanel();
		vp.setHeight("400");
		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		vp.add(cp);

		VerticalPanel descriptionPanel = new VerticalPanel();
		_descriptionTextArea.setCharacterWidth(40);
		_descriptionTextArea.setVisibleLines(20);
		descriptionPanel.add(_descriptionTextArea);
		descriptionPanel.add(_submitButton);
		CaptionPanel cpRight = new CaptionPanel("Opis problemu");
		cpRight.setHeight("400");
		cpRight.add(descriptionPanel);
		vp.add(cpRight);
		return vp; // sorry ... refactor this shit later !!! TODO!
	}


	@Override
	public void updateProductList(Product[] arr) {
		_productListbox.clear();
		for (Product p : arr) {
			_productListbox.addItem(p.getName());
		}
	}
	
	public Problem getFilledProblem() {
		Problem p = new Problem();
		p.setProduct(_productListbox.getItemText(_productListbox.getSelectedIndex()));
		p.setClientImportance(_importanceTextBox.getItemText(_importanceTextBox.getSelectedIndex()));
		p.setDescription(_descriptionTextArea.getText());
		p.setProblemDate(new Date());
		return p;
	}
}
