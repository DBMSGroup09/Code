package utility;

public enum TransactionDetail {

	COST("cost"),NEWREWARD("newReward");

	private String value;

	private TransactionDetail(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
