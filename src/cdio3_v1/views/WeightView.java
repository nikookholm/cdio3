package cdio3_v1.views;


import cdio3_v1.client.ClientSideImpl;
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
	private VerticalPanel contentPanel;
	Label textLabel = new Label();
	

	public WeightView(){

		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);		
		
		WeightsButtons weightsButtons = new WeightsButtons(this);
		
		this.vPanel.add(weightsButtons);
		
		Anchor showWeigthFunction= new Anchor ("Vægt funktioner: vælg og tryk ");
		vPanel.add(showWeigthFunction);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
		
		this.contentPanel.add(textLabel);

		this.vPanel.add(textLabel);
		


	}
	
}





















