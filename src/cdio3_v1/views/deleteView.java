package cdio3_v1.views;

import java.util.List;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

//import dtu.client.service.KartotekServiceClientImpl;
//import dtu.client.ui.DeleteView.DeleteHandler;
//import dtu.shared.PersonDTO;

public class deleteView extends Composite {
	VerticalPanel deletePanel;
	FlexTable t;

	// V.1 reference to data layer
	// IPersonDAO iPersonDAO;

	// V.2
	ClientSideImpl clientImpl;

	// previous cancel anchor
	Anchor previousCancel = null;

	public deleteView(ClientSideImpl clientImpl) {
		// V.1 this.iPersonDAO = iPersonDAO;
		// v.2
		this.clientImpl = clientImpl;
		deletePanel = new VerticalPanel();
		initWidget(this.deletePanel);

		t = new FlexTable();
		t.getFlexCellFormatter().setWidth(0, 0, "50px");
		t.getFlexCellFormatter().setWidth(0, 1, "200px");
		t.getFlexCellFormatter().setWidth(0, 2, "50px");
		t.getFlexCellFormatter().setWidth(0, 3, "200px");
		t.getFlexCellFormatter().setWidth(0, 4, "200px");

		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");


		// set headers in flextable
		t.setText(0, 0, "Id");
		t.setText(0, 1, "Navn");
		t.setText(0, 2, "ini");
		t.setText(0, 3, "pass");
		t.setText(0, 4, "cpr");
		
	
		// V 1. fetch persons from data layer
		// List<PersonDTO> personer = iPersonDAO.getPersons();

		// V.1 populate table and add delete anchor to each row
//		for (int rowIndex=0; rowIndex < personer.size(); rowIndex++) {
//			t.setText(rowIndex+1, 0, personer.get(rowIndex).getNavn());
//			t.setText(rowIndex+1, 1, "" + personer.get(rowIndex).getAlder());
//			Anchor delete = new Anchor("delete");
//			t.setWidget(rowIndex+1, 2, delete);
//
//			delete.addClickHandler(new DeleteHandler());
//		}

		

		// V.2
		clientImpl.service.getPersons(new AsyncCallback<List<OperatorDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Server fejl");
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
					
					Anchor delete = new Anchor("delete");
					t.setWidget(i+1, 4, delete);	
					
					delete.addClickHandler(new DeleteHandler());
				}

			}

		});

		deletePanel.add(t);
	}

	private class DeleteHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			// if previous cancel open - force cancel operation�
			if (previousCancel != null)
				previousCancel.fireEvent(new ClickEvent(){});


			// get rowindex where event happened
			final int eventRowIndex = t.getCellForEvent(event).getRowIndex();

			// get delete anchor ref for cancel operation
			final Anchor delete =  (Anchor) event.getSource();

			Anchor ok = new Anchor("ok");
			ok.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					

					// here you will normally fetch the primary key of the row 
					// and use it for location the object to be deleted

					// V. 1
					// iPersonDAO.deletePerson(eventRowIndex-1);

					// V.2
					// delete object with id in back end	
					
					
					clientImpl.service.deleteOperatoR(Integer.parseInt(t.getText(eventRowIndex, 0)), new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {

						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}

					});
				
					// remove row in flextable
					t.removeRow(eventRowIndex);
				}
			});

			Anchor cancel = new Anchor("cancel");
			previousCancel = cancel;
			cancel.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					t.setWidget(eventRowIndex, 4, delete);
					t.clearCell(eventRowIndex, 5);
				}

			});

			// showing ok and cancel widgets
			t.setWidget(eventRowIndex, 4 , ok);
			t.setWidget(eventRowIndex, 5 , cancel);
		}
	}
}
