package helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import servlet.DBconnection;
import utility.TransactionDetail;

public class EmployeeAccess {
	/**
	 * @author
	 * @param uid
	 * @param rewardId
	 */
	private Map<TransactionDetail, String> transactionDetail = new HashMap<TransactionDetail, String>();

	public Map activity(String uid, String rewardId,
			Map<String, Integer> priceMap) {
		Connection connection = DBconnection.getInstance();
		Statement stmt;
		String value = null;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("");

			while (rs.next()) {
				String rewarId1 = rs.getString("rewardID");
				if (rewardId.equals(rewarId1)) {
					value = rs.getString("price");
					break;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (StringUtils.isNotBlank(value)) {
			Integer sum = null;
			Collection<Integer> priceList = priceMap.values();
			Iterator<Integer> itr = priceList.iterator();
			while (itr.hasNext()) {
				sum = sum + itr.next();
			}
			if (sum > Integer.getInteger(value)) {
				transactionDetail.put(TransactionDetail.COST,
						String.valueOf(sum - Integer.getInteger(value)));
				transactionDetail.put(TransactionDetail.NEWREWARD,
						String.valueOf("0"));
			} else {
				transactionDetail.put(TransactionDetail.COST,
						String.valueOf("0"));
				transactionDetail.put(TransactionDetail.NEWREWARD,
						String.valueOf(Integer.getInteger(value) - sum));
			}
		} else {

		}
		return transactionDetail;
	}
}
