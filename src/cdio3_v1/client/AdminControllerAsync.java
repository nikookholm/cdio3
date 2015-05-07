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
	void showCreate(List<OperatorDTO> oDTO, AsyncCallback<Void> callback) throws Exception;
	


}
