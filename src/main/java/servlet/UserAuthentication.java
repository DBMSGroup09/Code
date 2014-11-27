package servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAuthentication {
	/**
	 * @author
	 * @param userID
	 * @param pwd
	 * @return
	 */
	public String authentic(String userID, String pwd) {
		Connection connection = DBconnection.getInstance();
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("");

			while (rs.next()) {
				String userID1 = rs.getString("userID");
				String pwd1 = rs.getString("pwd");
				if (userID.equals(userID1) && pwd.equals(pwd1)) {
					return rs.getString("userType");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
