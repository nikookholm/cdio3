package cdio3_v1.views;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.client.controller.MainController;
import cdio3_v1.server.AdminControllerImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class MainView extends Composite {
	
	VerticalPanel  logoPanel    = new VerticalPanel();
	VerticalPanel  topMenuPanel = new VerticalPanel();
	VerticalPanel  mainPanel	= new VerticalPanel();
	MainController mc;
	
	public MainView(final MainController mc)
	{
		VerticalPanel panel = new VerticalPanel();
		this.mc = mc;
		initWidget(panel);
		panel.add(logoPanel);
		panel.add(topMenuPanel);
		panel.add(mainPanel);
		
		LoginView lv = new LoginView(mc);
		show(lv);
	}
	
	private void loadTopMenu()
	{
		Anchor link = new Anchor("Home");
		link.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				show(new AdminMenu(mc));
			}
		});
		topMenuPanel.clear();
		topMenuPanel.add(link);
	}
	
	private void loadLogo()
	{
		Label logoText = new Label("LOGO");
		logoText.setSize("200", "20");
		logoPanel.clear();
		logoPanel.add(logoText);
	}
	
	public void show(Widget w)
	{
		loadLogo();
		loadTopMenu();
		
		mainPanel.clear();
		mainPanel.add(w);
	}
		
	

}
