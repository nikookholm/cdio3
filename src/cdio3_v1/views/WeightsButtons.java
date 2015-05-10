package cdio3_v1.views;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.server.AdminControllerImpl;
import cdio3_v1.server.WeightFunctions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class WeightsButtons extends Composite{
	private HorizontalPanel hPanel = new HorizontalPanel();
	private WeightView wView;
	ClientSideImpl clientImpl;

	public WeightsButtons(WeightView wView ){
		initWidget(this.hPanel);
		this.hPanel.setBorderWidth(1);
		this.wView = wView;

		Button tara = new Button("Tara");
		this.hPanel.add(tara);

		tara.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				try {
					clientImpl.service.tara(new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {
							Window.alert("Person gemt i kartotek");
						}
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}				

					});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

}




















