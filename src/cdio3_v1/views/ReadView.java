package cdio3_v1.views;

import java.util.List;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;



public class ReadView extends Composite {

	VerticalPanel readPanel;

	// reference to data layer
	// IPersonDAO iPersonDAO;

	public ReadView(ClientSideImpl clientImpl) {
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

		
		
		List<OperatorDTO> personer = OperatorDTO.

	

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

			e.printStackTrace();
		}

		readPanel.add(t);
	}
}