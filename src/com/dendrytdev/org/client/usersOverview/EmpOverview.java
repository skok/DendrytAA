package com.dendrytdev.org.client.usersOverview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.DecoratorPanel;

public class EmpOverview extends Composite{
	public EmpOverview() {
		{
			HorizontalPanel horizontalPanel = new HorizontalPanel();
			initWidget(horizontalPanel);
			
			DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
			horizontalPanel.add(decoratorPanel_1);
			decoratorPanel_1.setSize("400", "340");
			{
				CaptionPanel captionPanel = new CaptionPanel("Lista pracownikow");
				decoratorPanel_1.setWidget(captionPanel);
				captionPanel.setSize("390", "330");
				{
					VerticalPanel verticalPanel = new VerticalPanel();
					captionPanel.setContentWidget(verticalPanel);
					verticalPanel.setSize("5cm", "3cm");
					{
						HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
						verticalPanel.add(horizontalPanel_1);
						{
							Label label = new Label("Sortowanie/wyszukiwanie: ");
							horizontalPanel_1.add(label);
						}
						{
							ListBox listBox = new ListBox();
							horizontalPanel_1.add(listBox);
							listBox.setSize("200", "40");
							listBox.setVisibleItemCount(5);
							listBox.addItem("Login");
							listBox.addItem("Nazwisko i imie");
						}
					}
					{
						RichTextArea richTextArea = new RichTextArea();
						verticalPanel.add(richTextArea);
					}
					{
						Label label = new Label("Wyszukaj");
						verticalPanel.add(label);
					}
					{
						TextBox textBox = new TextBox();
						verticalPanel.add(textBox);
					}
				}
			}
			
			DecoratorPanel decoratorPanel = new DecoratorPanel();
			horizontalPanel.add(decoratorPanel);
			{
				VerticalPanel verticalPanel = new VerticalPanel();
				decoratorPanel.setWidget(verticalPanel);
				{
					CaptionPanel captionPanel = new CaptionPanel("Dane");
					verticalPanel.add(captionPanel);
					{
						Grid grid = new Grid(5, 2);
						captionPanel.setContentWidget(grid);
						grid.setSize("5cm", "3cm");
						{
							Label lLogin = new Label("Login:");
							grid.setWidget(0, 0, lLogin);
							
							Label lName = new Label("Imie:");
							grid.setWidget(1, 0, lName);
							
							Label lSurname = new Label("Nazwisko:");
							grid.setWidget(2, 0, lSurname);
							
							Label lTelephone = new Label("Telefon:");
							grid.setWidget(3, 0, lTelephone);
							
							Label lEmail = new Label("E-mail:");
							grid.setWidget(4, 0, lEmail);
							
							TextBox tbLogin=new TextBox();
							grid.setWidget(0, 1, tbLogin);
							
							TextBox tbName=new TextBox();
							grid.setWidget(1, 1, tbName);
							
							TextBox tbSurname=new TextBox();
							grid.setWidget(2, 1, tbSurname);
							
							TextBox tbTelephone=new TextBox();
							grid.setWidget(3, 1, tbTelephone);
							
							TextBox tbEmail=new TextBox();
							grid.setWidget(4, 1, tbEmail);
							
						}
					}
				}
				{
					CaptionPanel captionPanel = new CaptionPanel("Funkcja");
					verticalPanel.add(captionPanel);
					{
						VerticalPanel verticalPanel_1 = new VerticalPanel();
						captionPanel.setContentWidget(verticalPanel_1);
						verticalPanel_1.setSize("5cm", "3cm");
						{
							RadioButton rbService = new RadioButton("function", "Serwisant");
							verticalPanel_1.add(rbService);
						}
						{
							RadioButton rbDesigner = new RadioButton("function", "Projektant");
							verticalPanel_1.add(rbDesigner);
						}
						{
							RadioButton rbProgrammer = new RadioButton("function", "Programista");
							verticalPanel_1.add(rbProgrammer);
						}
						{
							RadioButton rbTest = new RadioButton("function", "Tester");
							verticalPanel_1.add(rbTest);
						}
					}
				}
				{
					Button button = new Button("Usun pracownika");
					verticalPanel.add(button);
					button.setSize("150", "30");
				}
			}
		}
		{
			
		}
	}

}
