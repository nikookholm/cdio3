package cdio3_v1.views;

import cdio3_v1.client.Main;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;



/*
 * View der viser en menu - Benyt vægt, Update view, log ud. 
 *                          Ved admin skal der være en admin menu.
 */
public class MainMenu extends Composite{
	
	VerticalPanel vPanel;
	Button benytVægt;
	Button UpdatePassword;
	Button logOut;
	Button adminButton;
	Label valg;
	
	// Bruger operatørDTOen til at fastslå om det er en admin eller ej
	public MainMenu(){
		
		vPanel = new VerticalPanel();
		initWidget(vPanel);
		
		valg = new Label("Du har følgende valgmuligheder");
		benytVægt = new Button("Benyt vægten");
		UpdatePassword = new Button("Ændr password");
		
		
		vPanel.add(valg);
		vPanel.add(benytVægt);
		vPanel.add(UpdatePassword);
		vPanel.add(logOut);
		//if(dto.getID() < 10){
			adminButton= new Button("Systemadministrator menu");
			vPanel.add(adminButton);
		//}
		
	}

}
