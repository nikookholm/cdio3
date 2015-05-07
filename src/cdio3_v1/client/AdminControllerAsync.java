package cdio3_v1.client;

//import java.util.List;

import java.util.List;

import cdio3_v1.server.WeightFunctions;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface AdminControllerAsync {
	
	void tara(AsyncCallback<Void> callback);
	void RM20(String msg,AsyncCallback<String> callback);
	void display(String displayMsg, AsyncCallback<Void> callback);
	void getWeight(AsyncCallback<Double> callback);
	
	
	
}
