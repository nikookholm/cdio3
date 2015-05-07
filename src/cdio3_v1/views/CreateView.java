
	package cdio3_v1.views;

	import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.server.IOperatorDAO;
import cdio3_v1.server.OperatorDAO;
import cdio3_v1.shared.FieldVerifier;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
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



		public CreateView(final ClientSideImpl clientImpl){


			createPanel = new VerticalPanel();
			
//			createPanel.setHeight("100px");
//			HorizontalPanel namePanel = new HorizontalPanel();
//			HorizontalPanel idPanel  = new HorizontalPanel();
//			HorizontalPanel iniPanel  = new HorizontalPanel();
//			HorizontalPanel passPanel  = new HorizontalPanel();
//			HorizontalPanel cprPanel  = new HorizontalPanel();
			
			
			initWidget(createPanel);

			nameLabel= new Label("navn");
			nameBox = new TextBox();

			iniLabel = new Label("ini");
			iniBox = new TextBox();

			passwordLabel = new Label("password");
			passwordBox = new TextBox();

			cprLabel = new Label("cpr");
			cprBox = new TextBox();

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

			nameBox.addKeyUpHandler(new KeyUpHandler(){

				@Override
				public void onKeyUp(KeyUpEvent event) {
					
					IOperatorDAO createPerson = new OperatorDAO(nameBox.getText(), iniBox.getText(), cprBox.getText());
					
					
					// skal tilgåes igennem admin, er ikke færdiglavet
					 clientImpl.service.
				}
				
				@Override
				public void onSuccess(void result) {
					Window.alert("Operator gemt i databasen");
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Server fejl" + caught.getMessage());
				}
			}
					);
			
			nameBox.addKeyUpHandler(new KeyUpHandler() {
				
				@Override
				public void onKeyUp(KeyUpEvent event) {
					if (!FieldVerifier.isValidID(nameBox.getText())){
						nameBox.setStyleName("gwt-TextBox-invalid");
						userBox = false;
					}
					
				else{
					nameBox.removeStyleDependentName("gwt-TextBox-invalidEntry");
					userBox= true;
				}
					
			
			private void checkFormValid() {
				if (nameBox)
					save.setEnabled(true);
				else
					save.setEnabled(false);
			}
			}
	}