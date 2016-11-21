package org.lindl.entity;

//import android.graphics.Bitmap;

public class NoteBook {

	private int id;
	private String content;
	// private String picture_path;
	// private Bitmap picture;
	private int flag;
	private String userId;

	public static int HAS_SETPASSWORD_DELETE = 1;
	public static int HAS_SETPASSWORD_MODIFY = 2;
	public static int HAS_SETPASSWORD_SHARE = 3;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// public String getPicture_path() {
	// return picture_path;
	// }
	// public void setPicture_path(String picture_path) {
	// this.picture_path = picture_path;
	// }
	// public Bitmap getPicture() {
	// return picture;
	// }
	// public void setPicture(Bitmap picture) {
	// this.picture = picture;
	// }
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
