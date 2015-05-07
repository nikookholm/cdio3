package cdio3_v1.views;


import cdio3_v1.server.WeightFunctions;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class WeightView  extends Composite{
	private VerticalPanel vPanel       = new VerticalPanel();
//	private VerticalPanel contentPanel;
	Label textLabel = new Label();
	


	public WeightView(){

		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);
//		this.vPanel.add(contentPanel);

		Anchor showWeigthFunction= new Anchor ("Vægt funktioner: vælg og tryk ");

		vPanel.add(showWeigthFunction);

		vPanel.add(new buttonsView());
		
		
		this.vPanel.add(textLabel);
		


	}
	public void runFunktion() throws Exception{
		this.vPanel.clear();
		WeightFunctions taraFunktion = new WeightFunctions();
		Double tara = taraFunktion.tara();
		
		
		textLabel = new Label(tara+"");
		
		this.vPanel.add(textLabel);
				
	}



}
class buttonsView extends Composite{
	private HorizontalPanel hPanel = new HorizontalPanel();

	public buttonsView(){
		initWidget(this.hPanel);
//		this.hPanel.setBorderWidth(1);


		Button tara = new Button("Tara");
		this.hPanel.add(tara);
		tara.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
//				try {
//					WeightFunctions weightFunktion = new WeightFunctions();
//					weightFunktion.tara();
//				} catch (Exception e) {	
//				e.printStackTrace();
//				}
			


			}
		});


		Button readWeigth = new Button("læs vægten");
		this.hPanel.add(readWeigth);
		readWeigth.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			}

		});

		Button sendMessage = new Button("Send Besked");
		this.hPanel.add(sendMessage);
		sendMessage.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			}
		});

		Button sendRM20 = new Button("send besked for at får svar");
		this.hPanel.add(sendRM20);
		sendRM20.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {

			}

		});

	}
}




















