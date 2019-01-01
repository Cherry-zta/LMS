package com.vae.domain;

import java.util.Date;

public class User{
	private int userid;
	private Date effective_date;
	private Date expiry_date;
	private String type;
	private String profession;
	
	public void setUserid(int userid) {
		this.userid=userid;
	}
	
	public int getUserid() {
		return this.userid;
	}
	
	public void setEffective_date(Date effective_date) {
		this.effective_date=effective_date;
	}
	
	public Date getEffective_date() {
		return this.effective_date;
	}
	
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date=expiry_date;
	}
	
	public Date getExpiry_date() {
		return this.expiry_date;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setProfession(String profession) {
		this.profession=profession;
	}
	
	public String getProfession() {
		return this.profession;
	}
}
