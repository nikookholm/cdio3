
	package cdio3_v1.views;

	import com.google.gwt.event.dom.client.KeyUpEvent;
	import com.google.gwt.user.client.ui.Button;
	import com.google.gwt.user.client.ui.Composite;
	import com.google.gwt.user.client.ui.Label;
	import com.google.gwt.user.client.ui.TextBox;
	import com.google.gwt.user.client.ui.VerticalPanel;
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

		Button okButton;
		Button cancelButton;
		Button editButton;




		public CreateView(){


			createPanel = new VerticalPanel();

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

			nameBox.addKeyUpHandler(new KeyUpHandler(){

				@Override
				public void onKeyUp(KeyUpEvent event) {
					//
					

				}
			}
					);








		}

	}