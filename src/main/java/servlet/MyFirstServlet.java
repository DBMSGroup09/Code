package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2934850343940980757L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String userID = request.getParameter("userID");
		String pwd = request.getParameter("password");

		if (new UserAuthentication().authentic(userID, pwd)) {
			

		} else {
			try {
				PrintWriter printMessage = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {

	}

}
