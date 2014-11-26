package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	private static Connection connection=null;
	private DBconnection(){
		
		
	}
	
	public static Connection getInstance(){
		if(connection==null){
			 connection=getConnection();
		}
return connection;
	}
	private static  Connection getConnection(){
	String dbtime=null;
	String dbUrl = "jdbc:mysql://your.database.domain/yourDBname";
	String dbClass = "com.mysql.jdbc.Driver";
	Connection con=null;



		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection (dbUrl);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return con;
	}
}
