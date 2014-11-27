package servlet;

import helper.EmployeeAccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import utility.TransactionDetail;

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
		UserAuthentication authentication = new UserAuthentication();
		String type = authentication.authentic(userID, pwd);
		if (StringUtils.isNotBlank(type)) {
			if (type.equals("employee")) {
				EmployeeAccess access = new EmployeeAccess();
				Map<Integer, String> priceMap = new HashMap<Integer, String>();
				// This is done to allow three purchase at a time. if it is
				// insufficient , add key value pair and also add null check
				priceMap.put(Integer.valueOf(request.getParameter("price1")),
						request.getParameter("comodityName1"));
				priceMap.put(Integer.valueOf(request.getParameter("price2")),
						request.getParameter("comodityName2"));
				priceMap.put(Integer.valueOf(request.getParameter("price3")),
						request.getParameter("comodityName3"));
				@SuppressWarnings("unchecked")
				Map<? extends TransactionDetail, String> map = access.activity(
						userID, request.getParameter("rewardID"), priceMap);

				PrintWriter printWriter;
				try {
					// this is the second landing page posting total payable
					// amount and new reward
					printWriter = response.getWriter();
					printWriter.println("text/html");
					printWriter
							.println("<font color=blue>Thank you for shopping wit us.</font>");
					printWriter.println("<h2>Total Amount payable is "
							+ map.get(TransactionDetail.COST) + "</h2>");
					printWriter.println("<h2>Total Reward poinyt available is "
							+ map.get(TransactionDetail.NEWREWARD));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				// put managers call here
			}

		} else {
			// This block is called if user fails to get authentication
			try {
				PrintWriter printMessage = response.getWriter();
				printMessage.println("text/html");
				printMessage.println("<font color=blue>User not found.</font>");
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
