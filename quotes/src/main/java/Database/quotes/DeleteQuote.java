package Database.quotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeleteQuote implements RequestHandler<String, String> {

	
	private static final String endPoint = System.getenv("endPoint"); 
	private static final String port = System.getenv("port");
	
    private static final String CRM_DB_URL = "jdbc:mariadb://" + endPoint +":"+ port + "/" + System.getenv("dbSystem");
    private static final String CRM_DB_USERNAME = System.getenv("user");
    private static final String CRM_DB_PASSWORD = System.getenv("pass");
    
    private static final String ACCOUNT_DB_URL_PREFIX = "jdbc:mariadb://" + endPoint + ":" + port + "/";
    private static final String ACCOUNT_DB_USERNAME = System.getenv("user");
    private static final String ACCOUNT_DB_PASSWORD = System.getenv("pass");
    
    public static Connection systemConnection;
    
	private static Connection setConnection (String url, String user, String pass) throws Exception {
    	Class.forName("org.mariadb.jdbc.Driver");
    	try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			return connection; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
	

	@Override
	public String handleRequest(String input, Context context) {
		Connection connection = null;
		System.out.println(input);
		try {
			connection = setConnection(CRM_DB_URL, CRM_DB_USERNAME, CRM_DB_PASSWORD);
			String sql = "SELECT DATABASE_ID FROM sys_accounts WHERE account_id = '" + input + "'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int dbId = rs.getInt("DATABASE_ID");
				System.out.println(dbId);
				String sqlString = "SELECT d.DATABASE FROM sys_databases d where d.database_id ="+ dbId;
				Statement statement = connection.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					String dbAccount = rSet.getString("DATABASE");
					System.out.println(dbAccount);
					connection = setConnection(ACCOUNT_DB_URL_PREFIX + dbAccount, ACCOUNT_DB_USERNAME, ACCOUNT_DB_PASSWORD);
					String SQLDELETE = "DELETE FROM crm_quote where account_id= '" + input + "'";
					Statement statement2 = connection.createStatement();
					ResultSet resultSet = statement2.executeQuery(SQLDELETE);
					System.out.println("DELETE SUCCESSFULLY!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
