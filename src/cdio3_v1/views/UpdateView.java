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

public class UpdateView extends Composite {

	VerticalPanel updatePanel;
	FlexTable t;


	TextBox nameBox;
	TextBox iniBox;
	TextBox passwordBox;
	TextBox cprBox;


	boolean nameValid = true;
	boolean iniValid = true;
	boolean passValid = true;
	boolean cprValid = true;

	int eventRowIndex;

	ClientSideImpl clientImpl;


	List<OperatorDTO> personer;

	Anchor previousCancel = null;

	public UpdateView(ClientSideImpl clientImpl) {
		this.clientImpl = clientImpl;

		updatePanel = new VerticalPanel();
		initWidget(this.updatePanel);

		t = new FlexTable();

		t.getFlexCellFormatter().setWidth(0, 0, "200px");
		t.getFlexCellFormatter().setWidth(0, 1, "50px");
		t.getFlexCellFormatter().setWidth(0, 2, "200px");
		t.getFlexCellFormatter().setWidth(0, 3, "200px");

		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");


		t.setText(0, 0, "Navn");
		t.setText(0, 1, "ini");
		t.setText(0, 2, "pass");
		t.setText(0, 3, "cpr");
	}}
//		operator = op
//		
//		
//		try {
//			clientImpl.service.read(new AsyncCallback<List<OperatorDTO>>() {
//				
//				@Override
//				public void onSuccess(List<OperatorDTO> liste) {
//					for (int rowIndex=0; rowIndex < liste.size(); rowIndex++) {
//						t.setText(rowIndex+1, 0, "" + liste.get(rowIndex).getName());
//						t.setText(rowIndex+1, 1, liste.get(rowIndex).getIni());
//						t.setText(rowIndex+1, 2, "" + liste.get(rowIndex).getPassword());
//						t.setText(rowIndex+1, 3, "" + liste.get(rowIndex).getCpr());
//						
//						
//						Anchor update = new Anchor("edit");
//						t.setWidget(rowIndex+1, 4, update);
//
//						update.addClickHandler(new UpdateHandler());
//					}
//					
//				}
//		});
//
//		updatePanel.add(t);
//
//		// text boxes
//		nameBox = new TextBox();
//		iniBox = new TextBox();
//		passwordBox = new TextBox();
//		cprBox = new TextBox();
//	}
//
//	private class UpdateHandler implements ClickHandler {
//		public void onClick(ClickEvent event) {
//
//			if (previousCancel != null)
//				previousCancel.fireEvent(new ClickEvent(){});
//
//			eventRowIndex = t.getCellForEvent(event).getRowIndex();
//
//			nameBox.setText(t.getText(eventRowIndex, 0));
//			iniBox.setText(t.getText(eventRowIndex, 1));
//			passwordBox.setText(t.getText(eventRowIndex, 2));
//			cprBox.setText(t.getText(eventRowIndex, 3));
//
//
//			// show text boxes for editing
//			t.setWidget(eventRowIndex, 0, nameBox);
//			t.setWidget(eventRowIndex, 1, iniBox);
//			t.setWidget(eventRowIndex, 2, passwordBox);
//			t.setWidget(eventRowIndex, 3, cprBox);
//
//			// start editing here
//			nameBox.setFocus(true);
//
//			// get edit anchor ref for cancel operation
//			final Anchor edit =  (Anchor) event.getSource();
//
//			// get textbox contents for cancel operation
//			final String name = nameBox.getText();
//			final String ini = iniBox.getText();
//			final String password = passwordBox.getText();
//			final String cpr = cprBox.getText();
//
//			final Anchor ok = new Anchor("ok");
//			ok.addClickHandler(new ClickHandler() {
//
//				@Override
//				public void onClick(ClickEvent event) {
//
//					// remove inputboxes
//					t.setText(eventRowIndex, 1, nameBox.getText());
//					t.setText(eventRowIndex, 2, iniBox.getText());
//					t.setText(eventRowIndex, 3, passwordBox.getText());
//					t.setText(eventRowIndex, 4, cprBox.getText());
//
//
//					// here you will normally fetch the primary key of the row 
//					// and use it for location the object to be edited
//
//					// fill DTO with id and new values 
//					OperatorDTO OperatorDTO = new OperatorDTO(
//							Integer.parseInt(t.getText(eventRowIndex, 0)), nameBox.getText(), iniBox.getText(), passwordBox.getText(), cprBox.getText()
//							);
//
//					// V.1 update object in backend
//					// iPersonDAO.updatePerson(personDTO, eventRowIndex-1);
//
//
//					// V.2
//					clientImpl.service.updateOperator(OperatorDTO, new AsyncCallback<Void>() {
//
//						@Override
//						public void onSuccess(Void result) {
//
//						}
//
//						@Override
//						public void onFailure(Throwable caught) {
//							Window.alert("Server fejl!" + caught.getMessage());
//						}
//
//					});
//
//					// restore edit link
//					t.setWidget(eventRowIndex, 3, edit);
//					t.clearCell(eventRowIndex, 4);
//
//					previousCancel = null;
//
//				}
//
//			});
//
//			Anchor cancel = new Anchor("cancel");
//			previousCancel = cancel;
//			cancel.addClickHandler(new ClickHandler() {
//
//				@Override
//				public void onClick(ClickEvent event) {
//
//					// restore original content of textboxes and rerun input validation
//					nameBox.setText(name);
//					nameBox.fireEvent(new KeyUpEvent() {}); // validation
//
//					iniBox.setText(ini);
//					iniBox.fireEvent(new KeyUpEvent() {});  // validation
//
//					passwordBox.setText(password);
//					passwordBox.fireEvent(new KeyUpEvent(){});
//
//					cprBox.setText(password);
//					cprBox.fireEvent(new KeyUpEvent(){});	
//				}
//			});
//
//
//			t.setText(eventRowIndex, 1, name);
//			t.setText(eventRowIndex, 2, ini);
//			t.setText(eventRowIndex, 3, password);
//			t.setText(eventRowIndex, 4, cpr);
//
//			// restore edit link
//			t.setWidget(eventRowIndex, 3, edit);
//			t.clearCell(eventRowIndex, 4);
//
//			previousCancel = null;
//		}
//	}
//
//
//
//	nameBox.addKeyUpHandler(new KeyUpHandler()){
//
//		@Override
//		public void onKeyUp(KeyUpEvent event) {
//			if (!FieldVerifier.isNameValid(nameBox.getText())) {
//				nameBox.setStyleName("gwt-TextBox-invalidEntry");
//				nameValid = false;
//			}
//			else {
//				nameBox.removeStyleName("gwt-TextBox-invalidEntry");
//				nameValid = true;
//
//			}if (!FieldVerifier.isIniValid(iniBox.getText())){
//				iniBox.setStyleName("gwt-TextBox-invalidEntry");
//				iniValid = false;
//
//			}else{
//				iniBox.removeStyleName("gwt-TextBox-invalidEntry");
//				iniValid = true;
//
//			}if (!FieldVerifier.isPassValid(passwordBox.getText())){
//				passwordBox.setStyleName("gwt-TextBox-invalidEntry");
//				passValid = false;
//
//			}else{
//				passwordBox.removeStyleName("gwt-TextBox-invalidEntry");
//				passValid = true;
//
//			}if (!FieldVerifier.isCprValid(cprBox.getText())){
//				cprBox.setStyleName("gwt-TextBox-invalidEntry");
//				cprValid = false;
//
//
//			}else{
//				cprBox.removeStyleName("gwt-TextBox-invalidEntry");
//				cprValid = true;
//
//
//
//			});
//			ageTxt.addKeyUpHandler(new KeyUpHandler(){
//
//				@Override
//				public void onKeyUp(KeyUpEvent event) {
//					if (!FieldVerifier.isValidAge(ageTxt.getText())) {
//						ageTxt.setStyleName("gwt-TextBox-invalidEntry");
//						ageValid = false;
//					}
//					else {
//						ageTxt.removeStyleName("gwt-TextBox-invalidEntry");
//						ageValid = true;
//					}
//
//					// enable/disable ok depending on form status 
//					if (nameValid&&ageValid)
//						t.setWidget(eventRowIndex, 3, ok);
//					else
//						t.setText(eventRowIndex, 3, "ok");
//				}
//
//			});
//
//			// showing ok and cancel widgets
//			t.setWidget(eventRowIndex, 3 , ok);
//			t.setWidget(eventRowIndex, 4 , cancel);		
//		}
//	}
//}

