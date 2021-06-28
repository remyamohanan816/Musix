package com.ust.model;

import javax.persistence.Entity;


import org.springframework.data.annotation.Id;

@Entity
public class Recommendation {
	
	@javax.persistence.Id
	private int _id;
	private String userId;
	private String dataId;
	private String data;
	
	public Recommendation() {
		super();
	}
	
	public Recommendation(int _id, String userId, String dataId, String data) {
		super();
		this._id = _id;
		this.userId = userId;
		this.dataId = dataId;
		this.data = data;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public Object getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	

}
