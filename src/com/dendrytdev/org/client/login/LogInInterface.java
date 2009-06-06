package com.dendrytdev.org.client.login;

import com.dendrytdev.org.client.IUserInterface;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LogInInterface implements IUserInterface{
	private RootPanel rootPanel;
	private LogInController logInController;

	public LogInInterface() {
		logInController = new LogInController();
		rootPanel = RootPanel.get();
	}

	public void mainInterface() {
		Window.setTitle("Dendryt - interfejs logowania");
		
		final TextBox TBname = new TextBox();
		final PasswordTextBox TBpassword = new PasswordTextBox();
		
		rootPanel.clear();
		
		VerticalPanel vp = new VerticalPanel();
		vp.add(new Label("Login"));
		vp.add(TBname);
		vp.add(new Label("Haslo"));
		vp.add(TBpassword);
		vp.setStyleName("login");
		
		
		

		
		
		Button Blogin=new Button("Zaloguj", new ClickHandler(){

		public void onClick(ClickEvent event) {
			rootPanel.clear();
			rootPanel.add(new Label("Prosze czekac..."));			
			logInController.authenticate(TBname.getText(), TBpassword.getText());
			TBname.setText("");
			TBpassword.setText("");
		}
			 
		});
		 
		vp.add(Blogin);
		rootPanel.add(vp);
	}

}