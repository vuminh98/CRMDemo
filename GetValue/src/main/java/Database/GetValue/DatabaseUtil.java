package Database.GetValue;

import java.sql.Connection;

public class DatabaseUtil {
	
	private static final String endPoint = System.getenv("endPoint");
	private static final String port = System.getenv("port");
	
	private static final String CRM_DB_URL = "jdbc:mariadb://" + endPoint + ":" + port + System.getenv("dbSystem");
	private static final String CRM_DB_USERNAME = System.getenv("user");
	private static final String CRM_DB_PASSWORD = System.getenv("pass");
	
	private static final String ACCOUNT_DB_URL_PREFIX = "jdbc:mariadb://" + endPoint + ":" + port + "/";
	private static final String ACCOUNT_DB_USERNAME = System.getenv("user");
	private static final String ACCOUNT_DB_PASSWORD = System.getenv("pass");
	
	public static  Connection systemConnection;
	
	

}
