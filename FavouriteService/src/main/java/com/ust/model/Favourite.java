package com.ust.model;


import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Favourite {

	@Id
	private int id;
	private String userId;
	private String songId;
	private String song;
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
	public String getSongId() {
		return songId;
	}
	public void setSongId(String songId) {
		this.songId = songId;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public Favourite() {
		super();
		
	}
	
	
	
}