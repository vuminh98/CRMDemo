package Database.GetValue;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetValue implements RequestHandler<String, String> {
	

	private static String DB_URL = "jdbc:mariadb://crmviet.c09wjkmeasrs.ap-southeast-1.rds.amazonaws.com:3306/crmviet_system";
	private static String USER_NAME = "crmviet";
	private static String PASSWORD = "altalab123";
	
	private static final String endPoint = System.getenv("endPoint"); 
	private static final String port = System.getenv("port");
	
    private static final String CRM_DB_URL = "jdbc:mariadb://" + endPoint +":"+ port + "/" + System.getenv("dbSystem");
    private static final String CRM_DB_USERNAME = System.getenv("user");
    private static final String CRM_DB_PASSWORD = System.getenv("pass");
    
    private static final String ACCOUNT_DB_URL_PREFIX = "jdbc:mariadb://" + endPoint + ":" + port + "/";
    private static final String ACCOUNT_DB_USERNAME = System.getenv("user");
    private static final String ACCOUNT_DB_PASSWORD = System.getenv("pass");

	public String handleRequest(String input, Context context) {
		Connection conn=null;
		try {
			 conn = setConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectDb(conn);
	}

	private static Connection setConnection(String url, String user, String pass) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String selectDb(Connection conn) {
		String content = "";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM sys_accounts where DATABASE_ID = 3;");
//			preparedStatement.setInt(1, input);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("ACCOUNT_NAME"));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return content;
	}

	
	   
}