package cdio3_v1.views;

import cdio3_v1.client.ClientSideImpl;

public class ErrorView {

	FlexTable t;
	
	public showError(ClientSideImpl clientImpl){
		
		t = new FlexTable();
		t.getFlexCellFormatter().setWidth(0, 0, "50px");
		t.getFlexCellFormatter().setWidth(0, 1, "200px");
	}
}
