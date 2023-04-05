package Database.quotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DelQuote implements RequestHandler<String, String> {

	private static final String endPoint = System.getenv("endPoint");
	private static final String port = System.getenv("port");

	private static final String CRM_DB_URL = "jdbc:mariadb://" + endPoint + ":" + port + "/"
			+ System.getenv("dbSystem");
	private static final String CRM_DB_USERNAME = System.getenv("user");
	private static final String CRM_DB_PASSWORD = System.getenv("pass");

	private static final String ACCOUNT_DB_URL_PREFIX = "jdbc:mariadb://" + endPoint + ":" + port + "/";
	private static final String ACCOUNT_DB_USERNAME = System.getenv("user");
	private static final String ACCOUNT_DB_PASSWORD = System.getenv("pass");

	public static Connection systemConnection;

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

	@Override
	public String handleRequest(String input, Context context) {
		Connection connection = null;
		System.out.println(input);
		try {
			connection = setConnection(CRM_DB_URL, CRM_DB_USERNAME, CRM_DB_PASSWORD);
			String sql = "SELECT DATABASE_ID FROM sys_accounts WHERE account_id = '" + input + "'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int dbId = rs.getInt("DATABASE_ID");
				System.out.println(dbId);
				String sqlString = "SELECT d.DATABASE FROM sys_databases d where d.database_id =" + dbId;
				Statement statement = connection.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while (rSet.next()) {
					String dbAccount = rSet.getString("DATABASE");
					System.out.println(dbAccount);
					connection = setConnection(ACCOUNT_DB_URL_PREFIX + dbAccount, ACCOUNT_DB_USERNAME,ACCOUNT_DB_PASSWORD);
					Statement statement2 = connection.createStatement();
					ResultSet resultSet = statement2.executeQuery("DELETE FROM crm_quote where account_id = '" + input + "'");
					System.out.println("DELETE SUCCESSFULLY!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

//	public String update(String input1, String a)  {
//		String SQLUPDATE = "UPDATE crm_email_list set EMAIL_LIST_NAME = '" + input1.getBytes("EMAIL_LIST_NAME").toString()
//				+ "'," + "EMAILS ='" + input1.getBytes("EMAILS") + "'," + "NOTE='"
//				+ input1.getBytes("NOTE").toString() + "'" + "where ACCOUNT_ID='" + a + "'";
//		return SQLADD;
//	}
	
//	public String saveUser(String jsonString, Connection conn) {
//		JSONObject input=new JSONObject(jsonString);
//		System.out.println(input.toString());
//		String sql_String = "";
//		String mess="";
//		try {
//			if (input.get("userId") == null) {
//				sql_String = "INSERT INTO sys_users (USER_ID , USER_NAME, USER_EMAIL,PHONE,UPD_DTTM,CONFIRM) VALUES ("
//						+ input.get("userName") + "," + input.get("userName") + "," + input.get("email") + ","
//						+ input.get("phone") + "," + LocalDateTime.now() + ",0);";
//				mess="Create Success";
//			} else {
//				sql_String = "update sys_users set  USER_NAME='" + input.get("userName") + "', USER_EMAIL='"
//						+ input.get("email") + "', PHONE='" + input.get("phone") + "', UPD_DTTM='" + LocalDateTime.now()
//						+ "' where USER_ID='" + input.get("userId") + "';";
//				mess="Update Success";
//			}
//			System.out.println("Query_SQL= "+sql_String);
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql_String);
//			System.out.println("Result: "+rs);
//			System.out.println("Message: "+mess);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return mess;
//	}
//
//	public String deleteUser(String input, Connection conn) {
//		String sql_delete = "";
//		return null;
//	}
//
//	public String getUser(String input, Connection conn) {
//		String sql_get = "";
//
//		return null;
//	}

}
