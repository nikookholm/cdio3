package cdio3_v1.views;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class weightView  extends Composite{
	private VerticalPanel  vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();


	public weightView(){

		initWidget(this.vPanel);

		Anchor showWeigthFunction= new Anchor ("Vægt funktioner");
//		Anchor showTaraWeigth= new Anchor ("Tara");
//		Anchor readWeigth= new Anchor ("læs vægten");
//		Anchor sendMessage= new Anchor ("send besked");
//		Anchor sendRM20 = new Anchor ("send besked for at svar");

		vPanel.add(showWeigthFunction);
//		vPanel.add(tara);
//		vPanel.add(readWeigth);
//		vPanel.add(sendMessage);
//		vPanel.add(sendRM20);


	}
	
	public void buttonsView(){
		initWidget(this.hPanel);
		
		Button tara        = new Button("Tara");
		this.hPanel.add(tara);
		tara.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				
			}
		});
		
		
		Button readWeigth  = new Button("læs vægten");
		this.hPanel.add(readWeigth);
		readWeigth.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			}
			
		});
		
		Button sendMessage = new Button("Send Besked");
		this.hPanel.add(sendMessage);
		sendMessage.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		Button sendRM20    = new Button("send besked for at får svar");
		this.hPanel.add(sendRM20);
		sendRM20.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
}





















