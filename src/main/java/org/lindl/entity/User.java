package org.lindl.entity;

public class User {

	private int id;
	private String userId;
	private String username;
	private String password;
	private int coin;
	private String last_get;
	
	final static String PWD_FLAG="%#(&)@!";

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public String getLast_get() {
		return last_get;
	}

	public void setLast_get(String last_get) {
		this.last_get = last_get;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", username="
				+ username + ", password=" + password + ", coin=" + coin
				+ ", last_get=" + last_get + "]";
	}
	
	
}
