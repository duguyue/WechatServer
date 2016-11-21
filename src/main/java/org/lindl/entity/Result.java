package org.lindl.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result {

	private int status;  
	private Object data;  //业务数据
	private String msg;   //业务描述
	private Object extra; //其他业务数据


	public Result(int status, Object data, String msg) {
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	public Result(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public Result(int status, Object data, String msg, Object extra) {
		this.status = status;
		this.data = data;
		this.msg = msg;
		this.extra = extra;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
}

