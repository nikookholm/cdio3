package cdio3_v1.views;

import java.util.List;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;



public class readView extends Composite {

	VerticalPanel readPanel;

	// reference to data layer
	// IPersonDAO iPersonDAO;

	public readView(ClientSideImpl clientImpl) {
		//	this.iPersonDAO = iPersonDAO;

		readPanel = new VerticalPanel();
		initWidget(this.readPanel);

		final FlexTable t = new FlexTable();
		t.getFlexCellFormatter().setWidth(0, 0, "200px");
		t.getFlexCellFormatter().setWidth(0, 1, "50px");
		t.getFlexCellFormatter().setWidth(0, 2, "200px");
		t.getFlexCellFormatter().setWidth(0, 3, "200px");


		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");
		
		// set headers in flextable
		t.setText(0, 0, "Navn");
		t.setText(0, 1, "Ini");
		t.setText(0, 2, "Password");
		t.setText(0, 3, "cpr");

		// V.1
		//List<PersonDTO> personer = iPersonDAO.getPersons();

		// V.2
		try {
			clientImpl.service.read(new AsyncCallback<List<OperatorDTO>>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Server fejl!" + caught.getMessage());
				}

				@Override
				public void onSuccess(List<OperatorDTO> result) {
					for (int i=0; i < result.size(); i++) {
						t.setText(i+1, 0, "" + result.get(i).getName());
						t.setText(i+1, 1, result.get(i).getIni());
						t.setText(i+1, 2, "" + result.get(i).getCpr());
					}

				}

			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		readPanel.add(t);
	}
}