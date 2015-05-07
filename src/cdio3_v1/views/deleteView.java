package cdio3_v1.views;

import java.util.List;

import cdio3_v1.client.AdminController;
import cdio3_v1.client.AdminControllerAsync;
import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.server.AdminControllerImpl;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sun.java.swing.plaf.windows.resources.windows;

//import dtu.client.service.KartotekServiceClientImpl;
//import dtu.client.ui.DeleteView.DeleteHandler;
//import dtu.shared.PersonDTO;

public class deleteView extends Composite {
	VerticalPanel deletePanel;
	FlexTable t;
	OperatorDTO opr;
	ClientSideImpl clientImpl;

	Anchor previousCancel = null;

	public deleteView(ClientSideImpl clientImpl, OperatorDTO opr) {
		this.opr=opr;
		
		this.clientImpl = clientImpl;
		deletePanel = new VerticalPanel();
		initWidget(this.deletePanel);
		Label oprName = new Label("You want to delete: " + opr.getName() + "?");
		
		Button ok = new Button("ok");
		Button cancel = new Button("cancel");
		
		deletePanel.add(oprName);
		deletePanel.add(ok);
		deletePanel.add(cancel);
	
//		t = new FlexTable();
//		t.getFlexCellFormatter().setWidth(0, 0, "50px");
//		t.getFlexCellFormatter().setWidth(0, 1, "200px");
//		t.getFlexCellFormatter().setWidth(0, 2, "50px");
//		t.getFlexCellFormatter().setWidth(0, 3, "200px");
//		t.getFlexCellFormatter().setWidth(0, 4, "200px");
//
//		t.addStyleName("FlexTable");
//		t.getRowFormatter().addStyleName(0,"FlexTable-Header");
//
//
//		// set headers in flextable
//		t.setText(0, 0, "Id");
//		t.setText(0, 1, "Navn");
//		t.setText(0, 2, "ini");
//		t.setText(0, 3, "pass");
//		t.setText(0, 4, "cpr");
//		
//	
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

	}

	private class OkHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			
			try {
				clientImpl.service.delete(opr.getID(), new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						 Window.alert("succeded");
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Not Succeded");
						
					}
				});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	
