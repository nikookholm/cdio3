package cdio3_v1.server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cdio3_v1.shared.*;

public class OperatorDAO_db //extends RemoteServiceServlet implements Main 
{
	private static final String URL = "jdbc:mysql://localhost/cdio3";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private Connection connection = null; // manages connection

	private PreparedStatement createOperatorStmt = null;
	private PreparedStatement updateOperatorStmt = null;
	private PreparedStatement getOperatorStmt = null;
	private PreparedStatement getSizeStmt = null;
	private PreparedStatement deleteOperatorStmt = null;

	public OperatorDAO_db() throws Exception
	{
		//		try
		//		{
		//			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		//		
		//			createOperatorStmt = connection.prepareStatement( "INSERT INTO operator " + 
		//					"(id, name, ini, cpr, password  ) " + 
		//					"VALUES ( ?, ?, ?, ?, ? )" );
		//		
		//			updateOperatorStmt = connection.prepareStatement( 
		//							"UPDATE operator SET name = ?, "
		//							+ "ini = ?, cpr = ?, password = ?  WHERE id = ?" );
		//			
		//			getOperatorStmt = connection.prepareStatement( 
		//					"SELECT * FROM operator "); 
		//			
		//			getSizeStmt = connection.prepareStatement( 
		//					"SELECT COUNT(*) FROM operator ");
		//			
		//			deleteOperatorStmt = connection.prepareStatement( 
		//					"DELETE FROM operator WHERE id =  ? ");
		//			
		//			
		//		}
		//		catch( SQLException sqlException )
		//		{
		//			throw new DALException("Kan ikke oprette forbindelse til database");
		//		}
		//	}
		//	
		//	@Override
		//	public void createOperator(OperatorDTO operator) throws Exception {
		//		// simulate server error
		//		// throw new RuntimeException(" \"savePerson\" fejlede");
		//
		//		try {
		//			savePersonStmt.setString(1, p.getNavn());
		//			savePersonStmt.setInt(2, p.getAlder());
		//
		//			savePersonStmt.executeUpdate();
		//		} catch (SQLException e) {
		//			throw new DALException(" \"savePerson\" fejlede");
		//		} 
		//	}

	}

}