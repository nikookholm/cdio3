package cdio3_v1.views;

import java.util.ArrayList;
import java.util.List;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.server.AdminControllerImpl;
import cdio3_v1.server.OperatorDAO;
import cdio3_v1.shared.DALException;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.thirdparty.javascript.jscomp.Result;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sun.java.swing.plaf.windows.resources.windows;



public class ReadView extends Composite {

	VerticalPanel readPanel;
	AdminControllerImpl impl;

	public ReadView(ClientSideImpl clientImpl) throws DALException {

		readPanel = new VerticalPanel();
		initWidget(this.readPanel);

		final FlexTable t = new FlexTable();
		t.getFlexCellFormatter().setWidth(0, 0, "200px");
		t.getFlexCellFormatter().setWidth(0, 1, "50px");
		t.getFlexCellFormatter().setWidth(0, 2, "200px");


		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");
		
		t.setText(0, 0, "Navn");
		t.setText(0, 1, "Ini");
		t.setText(0, 2, "cpr");
		
		try {
			clientImpl.service.read(new AsyncCallback<List<OperatorDTO>>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("fejl kunne ikke finde liste");
				}

				@Override
				public void onSuccess(List<OperatorDTO> result) {
					for (int i=0; i<result.size() ; i++){
						t.setText(i+1, 0, "" + result.get(i).getName());
						t.setText(i+1, 1, "" + result.get(i).getIni());
						t.setText(i+1, 2, "" + result.get(i).getCpr());
			}
					
				}

			

				});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		readPanel.add(t);
	}
			
	}