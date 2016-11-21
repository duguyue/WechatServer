package org.lindl.entity;

public class Income {
	private int id;
	private String userId;
	private int incomeTypeId;
	private String incomeType;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getIncomeTypeId() {
		return incomeTypeId;
	}

	public void setIncomeTypeId(int incomeTypeId) {
		this.incomeTypeId = incomeTypeId;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
