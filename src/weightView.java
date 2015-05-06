
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class weightView  extends Composite{
	private VerticalPanel  vPanel = new VerticalPanel();

	public weightView(){

		initWidget(this.vPanel);

		Anchor showWeigthMenu= new Anchor ("Vægt Menu");
		Anchor showTaraWeigth= new Anchor ("Tara");
		Anchor readWeigth= new Anchor ("læs vægten");
		Anchor sendMessage= new Anchor ("send besked");
		Anchor sendRM20 = new Anchor ("svar");

		vPanel.add(showWeigthMenu);
		vPanel.add(showTaraWeigth);
		vPanel.add(readWeigth);
		vPanel.add(sendMessage);
		vPanel.add(sendRM20);


	}
}

