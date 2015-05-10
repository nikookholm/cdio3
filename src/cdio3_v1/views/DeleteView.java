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

public class DeleteView extends Composite {
	VerticalPanel deletePanel;
	FlexTable t;
	OperatorDTO opr;
	ClientSideImpl clientImpl;

	Anchor previousCancel = null;

	public DeleteView(ClientSideImpl clientImpl, OperatorDTO opr) {
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
				e.printStackTrace();
			}
		}
	}
}
	
