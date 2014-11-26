package servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class UserAuthentication {

public Boolean authentic(String userID, String pwd) {
	Connection connection=DBconnection.getInstance();
	Statement stmt;
	try {
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("");

		while (rs.next()) {
		String userID1 = rs.getString("userID");
		
		String pwd1 = rs.getString("pwd");
	if(userID.equals(userID1)&& pwd.equals(pwd1))
	{
		return true;
	}
		}
		
	
	}
 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}}

