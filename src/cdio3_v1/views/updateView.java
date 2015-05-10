package cdio3_v1.views;

import java.util.List;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.shared.FieldVerifier;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class updateView extends Composite {

	VerticalPanel editPanel;
	FlexTable t;


	// editing text boxes
	TextBox nameBox;
	TextBox iniBox;
	TextBox passwordBox;
	TextBox cprBox;
	

	// valid fields - initially a field is valid
	boolean nameValid = true;
	boolean iniValid = true;
	boolean passValid = true;
	boolean cprValid = true;
	

	int eventRowIndex;

	// V.1 reference to data layer
	// IPersonDAO iPersonDAO;

	// V.2
	ClientSideImpl clientImpl;


	// person list
	List<OperatorDTO> personer;

	// previous cancel anchor
	Anchor previousCancel = null;

	public updateView(ClientSideImpl clientImpl) {
		// V.1 this.iPersonDAO = iPersonDAO;
		// v.2
		this.clientImpl = clientImpl;

		editPanel = new VerticalPanel();
		initWidget(this.editPanel);

		t = new FlexTable();

		// adjust column widths
		t.getFlexCellFormatter().setWidth(0, 0, "50px");
		t.getFlexCellFormatter().setWidth(0, 1, "200px");
		t.getFlexCellFormatter().setWidth(0, 2, "50px");
		t.getFlexCellFormatter().setWidth(0, 3, "200px");
		t.getFlexCellFormatter().setWidth(0, 4, "200px");


		

		// style table
		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");

		// set headers in flextable

		t.setText(0, 0, "Id");
		t.setText(0, 1, "Navn");
		t.setText(0, 2, "ini");
		t.setText(0, 3, "pass");
		t.setText(0, 4, "cpr");

		// V.1 fetch persons from data layer
		// personer = iPersonDAO.getPersons();

		// V.1 populate table and add edit anchor to each row
		//		for (int rowIndex=0; rowIndex < personer.size(); rowIndex++) {
		//			t.setText(rowIndex+1, 0, personer.get(rowIndex).getNavn());
		//			t.setText(rowIndex+1, 1, "" + personer.get(rowIndex).getAlder());
		//			Anchor edit = new Anchor("edit");
		//			t.setWidget(rowIndex+1, 2, edit);
		//
		//			edit.addClickHandler(new EditHandler());
		//		}


		// V.2
		clientImpl.service.getPersons(new AsyncCallback<List<OperatorDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Server fejl!" + caught.getMessage());
			}

			@Override
			public void onSuccess(List<OperatorDTO> result) {
				// populate table and add delete anchor to each row
				for (int i=0; i < result.size(); i++) {
					t.setText(i+1, 0, "" + result.get(i).getID());
					t.setText(i+1, 1, result.get(i).getName());
					t.setText(i+1, 2, "" + result.get(i).getIni());
					t.setText(i+1, 3, "" + result.get(i).getPassword());
					t.setText(i+1, 4, "" + result.get(i).getCpr());
					Anchor edit = new Anchor("edit");
					t.setWidget(i+1, 3, edit);

					edit.addClickHandler(new EditHandler());
				}

			}

		});



		editPanel.add(t);

		// text boxes
		nameBox = new TextBox();
		iniBox = new TextBox();
		passwordBox = new TextBox();
		cprBox = new TextBox();
	}

	private class EditHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			// if previous edit open - force cancel operation�
			if (previousCancel != null)
				previousCancel.fireEvent(new ClickEvent(){});

			// get rowindex where event happened
			eventRowIndex = t.getCellForEvent(event).getRowIndex();

			// populate textboxes
			nameBox.setText(t.getText(eventRowIndex, 1));
			iniBox.setText(t.getText(eventRowIndex, 2));
			passwordBox.setText(t.getText(eventRowIndex, 3));
			cprBox.setText(t.getText(eventRowIndex, 4));
			

			// show text boxes for editing
			t.setWidget(eventRowIndex, 1, nameBox);
			t.setWidget(eventRowIndex, 2, iniBox);
			t.setWidget(eventRowIndex, 3, passwordBox);
			t.setWidget(eventRowIndex, 4, cprBox);

			// start editing here
			nameBox.setFocus(true);

			// get edit anchor ref for cancel operation
			final Anchor edit =  (Anchor) event.getSource();

			// get textbox contents for cancel operation
			final String name = nameBox.getText();
			final String ini = iniBox.getText();
			final String password = passwordBox.getText();
			final String cpr = cprBox.getText();

			final Anchor ok = new Anchor("ok");
			ok.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					// remove inputboxes
					t.setText(eventRowIndex, 1, nameBox.getText());
					t.setText(eventRowIndex, 2, iniBox.getText());
					t.setText(eventRowIndex, 3, passwordBox.getText());
					t.setText(eventRowIndex, 4, cprBox.getText());


					// here you will normally fetch the primary key of the row 
					// and use it for location the object to be edited

					// fill DTO with id and new values 
					OperatorDTO OperatorDTO = new OperatorDTO(
							Integer.parseInt(t.getText(eventRowIndex, 0)), nameBox.getText(), iniBox.getText(), passwordBox.getText(), cprBox.getText()
						);

					// V.1 update object in backend
					// iPersonDAO.updatePerson(personDTO, eventRowIndex-1);


					// V.2
					clientImpl.service.updateOperator(OperatorDTO, new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {

						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}

					});

					// restore edit link
					t.setWidget(eventRowIndex, 3, edit);
					t.clearCell(eventRowIndex, 4);

					previousCancel = null;

				}

			});

			Anchor cancel = new Anchor("cancel");
			previousCancel = cancel;
			cancel.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					// restore original content of textboxes and rerun input validation
					nameBox.setText(name);
					nameBox.fireEvent(new KeyUpEvent() {}); // validation
					
					iniBox.setText(ini);
					iniBox.fireEvent(new KeyUpEvent() {});  // validation
					
					passwordBox.setText(password);
					passwordBox.fireEvent(new KeyUpEvent(){});
					
					cprBox.setText(password);
					cprBox.fireEvent(new KeyUpEvent(){});	
						}
					});


					t.setText(eventRowIndex, 1, name);
					t.setText(eventRowIndex, 2, ini);
					t.setText(eventRowIndex, 3, password);
					t.setText(eventRowIndex, 4, cpr);

					// restore edit link
					t.setWidget(eventRowIndex, 3, edit);
					t.clearCell(eventRowIndex, 4);

					previousCancel = null;
	}
			});


			nameBox.addKeyUpHandler(new KeyUpHandler()){

				@Override
				public void onKeyUp(KeyUpEvent event) {
					if (!FieldVerifier.isNameValid(nameBox.getText())) {
						nameBox.setStyleName("gwt-TextBox-invalidEntry");
						nameValid = false;
					}
					else {
						nameBox.removeStyleName("gwt-TextBox-invalidEntry");
						nameValid = true;
						
					}if (!FieldVerifier.isIniValid(iniBox.getText())){
						iniBox.setStyleName("gwt-TextBox-invalidEntry");
						iniValid = false;
						
					}else{
						iniBox.removeStyleName("gwt-TextBox-invalidEntry");
						iniValid = true;
					
					}if (!FieldVerifier.isPassValid(passwordBox.getText())){
						passwordBox.setStyleName("gwt-TextBox-invalidEntry");
						passValid = false;
						
					}else{
						passwordBox.removeStyleName("gwt-TextBox-invalidEntry");
						passValid = true;
						
					}if (!FieldVerifier.isCprValid(cprBox.getText())){
						cprBox.setStyleName("gwt-TextBox-invalidEntry");
						cprValid = false;
						
						
					}else{
						cprBox.removeStyleName("gwt-TextBox-invalidEntry");
						cprValid = true;
					

//					if (nameValid&&ageValid)
//						t.setWidget(eventRowIndex, 3, ok);
//					else
//						t.setText(eventRowIndex, 3, "ok");				
//				}

			});
			
			
				JEG 
			ageTxt.addKeyUpHandler(new KeyUpHandler(){

				@Override
				public void onKeyUp(KeyUpEvent event) {
					if (!FieldVerifier.isValidAge(ageTxt.getText())) {
						ageTxt.setStyleName("gwt-TextBox-invalidEntry");
						ageValid = false;
					}
					else {
						ageTxt.removeStyleName("gwt-TextBox-invalidEntry");
						ageValid = true;
					}

					// enable/disable ok depending on form status 
					if (nameValid&&ageValid)
						t.setWidget(eventRowIndex, 3, ok);
					else
						t.setText(eventRowIndex, 3, "ok");
				}

			});

			// showing ok and cancel widgets
			t.setWidget(eventRowIndex, 3 , ok);
			t.setWidget(eventRowIndex, 4 , cancel);		
		}
	}
}

