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
	
	void tara(AsyncCallback<Void> callback) throws Exception; 
	void RM20(String msg,AsyncCallback<String> callback) throws Exception;
	void display(String displayMsg, AsyncCallback<Void> callback) throws Exception;
	void getWeight(AsyncCallback<Double> callback) throws Exception;
	void create(OperatorDTO oDTO, AsyncCallback<Void> callback) throws Exception;
	void update(OperatorDTO oDTO, AsyncCallback<Void> callback) throws Exception;
	void delete(int id, AsyncCallback<Void> callback) throws Exception;
	void read(AsyncCallback<List<OperatorDTO>> callback)throws Exception;
	void login(String login, AsyncCallback<Boolean> callback) throws Exception;
	
	
	
}
