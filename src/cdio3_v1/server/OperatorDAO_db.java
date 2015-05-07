package cdio3_v1.server;
import cdio3_v1.shared.*;
import cdio3_v1.client.*;
import cdio3_v1.views.*;
import cdio3_v1.server.IOperatorDAO.DALException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class OperatorDAO_db //extends RemoteServiceServlet implements Main 
{
	private static final String URL = "jdbc:mysql://localhost/cdio3_v1";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private Connection connection = null; //Laver forbindelse, som bruges i SQL-sætninger. 
	
	private PreparedStatement createOperatorStmt = null;
	private PreparedStatement updateOperatorStmt = null;
	private PreparedStatement getOperatorListStmt = null;
	private PreparedStatement deleteOperatorStmt = null;
	private PreparedStatement getSizeStmt = null;

	public OperatorDAO_db() throws Exception
	{
		try
		{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
			createOperatorStmt = connection.prepareStatement( 
					"INSERT INTO operator " + 
					"(id, name, ini, cpr, password  ) " + "VALUES ( ?, ?, ?, ?, ? )" );
		
			updateOperatorStmt = connection.prepareStatement( 
							"UPDATE operator SET name = ?, "
							+ "ini = ?, cpr = ?, password = ?  WHERE id = ?" );
			
			getOperatorListStmt = connection.prepareStatement( 
					"SELECT * FROM operator "); 
			
			deleteOperatorStmt = connection.prepareStatement( 
					"DELETE FROM operator WHERE id =  ? ");
			
			
		}
		catch( SQLException sqlException )
		{
			throw new DALException("Kan ikke oprette forbindelse til database");
		}
	}
	
	public void createOperator(OperatorDTO operator) throws Exception 
	{
		//SQL-forespørgsel til at lave Operator med 5 parametre. Tjek om parametrene er rigtige i forhold til indeks	
		try {
			createOperatorStmt.setString(1, operator.getName());
			createOperatorStmt.setString(2, operator.getIni());
			createOperatorStmt.setString(3, operator.getCpr());
			createOperatorStmt.setString(4, operator.getPassword());
			createOperatorStmt.setInt(5, operator.getID());
			
			createOperatorStmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DALException(" \"createOperator\" fejlede");
		} 
	}
	
	public void updateOperator(OperatorDTO operator) throws DALException
	{
		try {
			updateOperatorStmt.setInt(1, operator.getID());
			updateOperatorStmt.setString(2, operator.getName());
			updateOperatorStmt.setString(3, operator.getIni());
			updateOperatorStmt.setString(4, operator.getCpr());
			updateOperatorStmt.setString(5, operator.getPassword());
			updateOperatorStmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DALException(" \"updateOperator\" fejlede");
		} 
	}
	
	public ArrayList<OperatorDTO> getOperatorList() throws Exception {
		ArrayList<OperatorDTO > results = null;
		ResultSet resultSet = null;

		try 
		{
			resultSet = getOperatorListStmt.executeQuery(); 
			results = new ArrayList<OperatorDTO>();

			while ( resultSet.next() )
			{
				results.add(new OperatorDTO(
						resultSet.getInt( "id" ),
						resultSet.getString( "navn" ),
						resultSet.getString( "ini" ),
						resultSet.getString( "cpr"),
						resultSet.getString( "password" )
						));
			} 
		} 
		catch ( SQLException e )
		{
			throw new DALException(" \"getOperators\" fejlede");
		} 
		finally
		{
			try 
			{
				resultSet.close();
			} 
			catch ( SQLException sqlException )
			{
				sqlException.printStackTrace();         
				
			} 
		} 
		return results;
	} 

	public void deleteOperator(int oprId) throws Exception 
	{
		try {
			deleteOperatorStmt.setInt(1, oprId);

			deleteOperatorStmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DALException(" \"deleteOperator\" fejlede");
		} 
	}
	
	public int getSize() throws Exception
	{
		try {
			ResultSet rs = null;
			rs = getSizeStmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new DALException(" \"getSize\" fejlede");
		} 
	}
}
