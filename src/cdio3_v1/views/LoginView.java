package cdio3_v1.views;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.client.Main;
import cdio3_v1.client.controller.MainController;
import cdio3_v1.shared.FieldVerifier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginView extends Composite {

	VerticalPanel vPanel;
	Label userLabel;
	Label passwordLabel;
	TextBox userBox;
	TextBox passwordBox;
	Button okBtn;
	ClientSideImpl clientImpl;
	// Flag der skal afgøre om ok knappen skal gøres tilgændlig
	boolean pwBox = false; 
	boolean uBox = false;
	
	//midlertidig variabel
	MainController mc = new MainController();
	
	public LoginView(ClientSideImpl clientImpl){
		this.clientImpl = clientImpl;
		this.vPanel = new VerticalPanel();
		initWidget(vPanel);
		
		userLabel = new Label("Operatør ID");
		passwordLabel = new Label("Password");
		
		userBox = new TextBox();
		passwordBox = new PasswordTextBox();
		
		okBtn = new Button("Ok");
		okBtn.setEnabled(false);
		
		vPanel.add(userLabel);
		vPanel.add(userBox);
		vPanel.add(passwordLabel);
		vPanel.add(passwordBox);
		vPanel.add(okBtn);
		
		/*
		 *  Der skal implementeres 
		 *  	En clickhandler til ok knappen, skal sende ID og password ned af.
		 *  	En KeyupHandler til textbox'ne
		 *  	En fieldverifier, der gør at man kun kan klikke ok, hvis Operatør id er et tal, og hvis password min. har 6 char
		 */
		
		// Skal registrerer om der er indtastet et integer i feltet, og rejse et flag, ok knappen kan aktiveres
		userBox.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if(FieldVerifier.isValidID(userBox.getText())){
					uBox = true;
				}
				else{
					uBox = false;
				}
				okButtonEnabler();
			}
		});
		// Skal registrerer om der er indtastet minimum 6 tegn i feltet, og rejse et flag, så ok knappen kan aktiveres
		passwordBox.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if(FieldVerifier.isPasswordValid(passwordBox.getText())){
					pwBox = true;
				}
				else{
					pwBox = false;
				}
				okButtonEnabler();
				
			}
		});
		//Skal sende login dataen videre så den kan behandles, og operatøren eller admin kan registreres
		okBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//Skal have fat i den respektive callback, så brugeren kan valideres.
				//Herefter skal der komme en menu, altefter om det er en admin eller en operatør der er logget ind
				//Admin skal kunne bruge vægten samt have adgang til CRUD funktionerne.
				String loginData = userBox.getText() + "," + passwordBox.getText();
				
				mc.loadOperatorMenu();
				
				
				
				
			}
		});
	}
	
	private void okButtonEnabler(){
		if(pwBox && uBox){
			okBtn.setEnabled(true);
		}
		else{
			okBtn.setEnabled(false);
		}
	}
}
