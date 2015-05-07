package cdio3_v1.client;

import java.util.List;

import cdio3_v1.server.WeightFunctions;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface AdminController extends RemoteService {
	

		public void tara() throws Exception;
		public String RM20(String msg);
		public void display(String displayMsg);
		public double getWeight();
		

		
	

}
