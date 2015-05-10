
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
	Button okBtn;

	boolean nameValid = false;
	boolean iniValid = false;
	boolean passwordValid = false;
	boolean cprValid = false;



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
		
		
		okBtn = new Button("Tilf\u00F8j");
		createPanel.add(okBtn);


		// use unicode escape sequence \u00F8 for '�'
		
		
     	okBtn.setEnabled(true);

		okBtn.addClickHandler(new ClickHandler() {



			@Override
			public void onClick(ClickEvent event) {
				OperatorDTO createPerson = new OperatorDTO(8, nameBox.getText(), iniBox.getText(), cprBox.getText(), passwordBox.getText());


				// 				skal tilgåes igennem admin, er ikke færdiglavet
				try {
					clientImpl.service.create(createPerson, new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {
							Window.alert("Person gemt i kartotek");
						}


						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}

					}
							);
				} catch (Exception e) {
					e.printStackTrace();
				}
				okBtn.setEnabled(true);
			}}
				);



		nameBox.addKeyUpHandler(new KeyUpHandler() {

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
				okBtn.setEnabled(true);
			}});


		iniBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if(FieldVerifier.isIdValid(iniBox.getText())){
						iniBox.setStyleName(iniBox.getText());
						iniValid = false;
					}
					else{
						iniBox.removeStyleName("gwt-TextBox-invalidEntry");
						iniValid = true;
					}	
				} catch (DALException e) {
					e.printStackTrace();
				}
				okBtn.setEnabled(true);
			}
		});


		cprBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if(FieldVerifier.isIdValid(cprBox.getText())){
						cprBox.setStyleName(cprBox.getText());
						cprValid= false;
					}
					else{
						cprBox.removeStyleName("gwt-TextBox-invalidEntry");
						cprValid = true;
					}	
				} catch (DALException e) {
					e.printStackTrace();
				}
				okBtn.setEnabled(true);
			}
		});

		passwordBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if(FieldVerifier.isIdValid(passwordBox.getText())){
						passwordBox.setStyleName(passwordBox.getText());
						passwordValid= false;
					}
					else{
						passwordBox.removeStyleName("gwt-TextBox-invalidEntry");
						passwordValid = true;
					}	
				} catch (DALException e) {
					e.printStackTrace();
				}
				okBtn.setEnabled(true);
			}
		});
	};}	