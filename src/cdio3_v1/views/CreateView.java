
package cdio3_v1.views;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.server.IOperatorDAO;
import cdio3_v1.server.OperatorDAO;
import cdio3_v1.shared.DALException;
import cdio3_v1.shared.FieldVerifier;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

public class CreateView extends Composite {


	VerticalPanel createPanel;

	Label nameLabel;
	Label iniLabel;
	Label passwordLabel;
	Label cprLabel;

	TextBox nameBox;
	TextBox iniBox;
	TextBox passwordBox;
	TextBox cprBox;
	Button save = new Button("tilf\u00F8j");

	boolean nameValid = false;



	public CreateView(final ClientSideImpl clientImpl){


		createPanel = new VerticalPanel();
		createPanel.setHeight("150px");





		initWidget(this.createPanel);

		HorizontalPanel namePanel = new HorizontalPanel();
		HorizontalPanel idPanel  = new HorizontalPanel();
		HorizontalPanel iniPanel  = new HorizontalPanel();
		HorizontalPanel passPanel  = new HorizontalPanel();
		HorizontalPanel cprPanel  = new HorizontalPanel();

		nameLabel= new Label("navn");
		nameLabel.setWidth("60px");
		nameBox = new TextBox();
		nameBox.setHeight("1em");
		namePanel.add(nameLabel);
		namePanel.add(nameBox);

		iniLabel = new Label("ini");
		iniLabel.setWidth("60px");
		iniBox = new TextBox();
		iniBox.setHeight("1em");
		iniPanel.add(iniLabel);
		iniPanel.add(iniBox);


		passwordLabel = new Label("password");
		passwordLabel.setWidth("100px");
		passwordBox = new TextBox();
		passwordBox.setHeight("1em");
		passPanel.add(passwordLabel);
		passPanel.add(passwordBox);

		cprLabel = new Label("cpr");
		cprLabel.setWidth("100px");
		cprBox = new TextBox();
		cprBox.setHeight("1em");
		cprPanel.add(cprLabel);
		cprPanel.add(cprBox);

		createPanel.add(nameLabel);
		createPanel.add(nameBox);
		createPanel.add(iniLabel);
		createPanel.add(iniBox);
		createPanel.add(passwordLabel);
		createPanel.add(passwordBox);
		createPanel.add(cprLabel);
		createPanel.add(cprBox);

		boolean userBox = false;
		boolean passBox = false;

		// use unicode escape sequence \u00F8 for '�'
		save = new Button("Tilf\u00F8j");
		save.setEnabled(false);

		save.addClickHandler(new ClickHandler() {

		

			@Override
			public void onClick(ClickEvent event) {
				OperatorDTO createPerson = new OperatorDTO(8, nameBox.getText(), iniBox.getText(), cprBox.getText(), passwordBox.getText());
				
				
				// skal tilgåes igennem admin, er ikke færdiglavet
//				clientImpl.service.savePerson(newPerson, new AsyncCallback<Void>() {

//				@Override
//				public void onSuccess(Void result) {
//					Window.alert("Operator gemt i databasen");
//			}

//				@Override
//				public void onFailure(Throwable caught) {
//				Window.alert("Server fejl" + caught.getMessage());
//				}
//			});
//		}
//	});


		KeyUpHandler keyuh = new KeyUpHandler() {

			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if (!FieldVerifier.isNameValid(nameBox.getText())){
						nameBox.setStyleName("gwt-TextBox-invalid");
						nameValid = false;
					}

					else{
						nameBox.removeStyleDependentName("gwt-TextBox-invalidEntry");
						nameValid = true;

					}
				} catch (DALException e) {
					e.printStackTrace();
				}
			}};

		
			nameBox.addKeyUpHandler(keyuh);
			iniBox.addKeyUpHandler(keyuh);
			cprBox.addKeyUpHandler(keyuh);
			passwordBox.addKeyUpHandler(keyuh);
			
			}});}}

		
	
	
	