package com.vae.domain;


import java.io.Serializable;

public class Book implements Serializable {
	private int bid;
	private String title;
	private String author;
	private String location;
	
	public void setBid(int bid) {
		this.bid=bid;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	
	public int getBid() {
		return this.bid;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getLocation() {
		return this.location;
	}
}
