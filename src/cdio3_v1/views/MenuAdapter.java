package cdio3_v1.views;

import cdio3_v1.client.controller.MainController;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuAdapter extends Composite {
	VerticalPanel adapterPanel;
	MainController mc;

	public MenuAdapter(final MainController mc){
		adapterPanel = new VerticalPanel();
		initWidget(this.adapterPanel);	
	}
	
	
	public void loadMenuView(){
		adapterPanel.clear();
		MenuView mv = new MenuView(this.mc);
		adapterPanel.add(mv);
	}
}
