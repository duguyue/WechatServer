package org.lindl.entity;

public class AffairType {

	private int id;
	private String affairType;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAffairType() {
		return affairType;
	}

	public void setAffairType(String affairType) {
		this.affairType = affairType;
	}

}
