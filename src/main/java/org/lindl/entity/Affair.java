package org.lindl.entity;

import java.io.Serializable;
import java.util.Date;

public class Affair implements Serializable {

	private int id;
	private String userId;
	private String content;
	private String address;
	private Date planStartTime;
	private Date planEndTime;
	private Date actualStartTime;
	private Date actualEndTime;
	private int rank;
	private String addContent;
	private int belongToType;
	private String belongToTypeName;
	private int alarmTime;
	private int notificatonId;

	public static final int AFFAIR_RANK_IMPORTANT_HURRY = 1;
	public static final int AFFAIR_RANK_IMPORTANT_TO_DO = 2;
	public static final int AFFAIR_RANK_DELAY = 3;
	public static final int AFFAIR_RANK_NOT_IMPORTANT = 4;

	public static final int BEFORE_FIVE_MINUTE = 0;
	public static final int BEFORE_TEN_MINUTE = 1;
	public static final int BEFORE_FIFTEEN_MINUTE = 2;
	public static final int BEFORE_ONE_HOUR = 3;
	public static final int BEFORE_TWO_HOUR = 4;
	public static final int BEFORE_FIVE_HOUR = 5;
	public static final int BEFORE_ONE_DAY = 6;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public Date getActualStartTime() {
		return actualStartTime;
	}

	public void setActualStartTime(Date actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public Date getActualEndTime() {
		return actualEndTime;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getAddContent() {
		return addContent;
	}

	public void setAddContent(String addContent) {
		this.addContent = addContent;
	}

	public int getBelongToType() {
		return belongToType;
	}

	public void setBelongToType(int belongToType) {
		this.belongToType = belongToType;
	}

	public String getBelongToTypeName() {
		return belongToTypeName;
	}

	public void setBelongToTypeName(String belongToTypeName) {
		this.belongToTypeName = belongToTypeName;
	}

	public int getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(int alarmTime) {
		this.alarmTime = alarmTime;
	}

	public int getNotificatonId() {
		return notificatonId;
	}

	public void setNotificatonId(int notificatonId) {
		this.notificatonId = notificatonId;
	}

}
