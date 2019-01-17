package com.vae.domain;

import java.util.Date;

public class Borrow_curr {
	private int borrow_crr_id;
	private int bid;
	private int userid;
	private Date borrow_time;
	private Date should_return_time;
	
	public void setBorrow_crr_id(int borrow_crr_id) {
		this.borrow_crr_id=borrow_crr_id;
	}
	
	public int getBorrow_crr_id() {
		return this.borrow_crr_id;
	}
	
	public void setBid(int bid) {
		this.bid=bid;
	}
	
	public int getBid() {
		return this.bid;
	}
	
	public void setUserid(int userid) {
		this.userid=userid;
	}
	
	public int getUserid() {
		return this.userid;
	}
	
	public void setBorrow_time(Date borrow_time) {
		this.borrow_time=borrow_time;
	}
	
	public Date getBorrow_time() {
		return this.borrow_time;
	}
	
	public void setShould_return_time(Date should_return_time) {
		this.should_return_time=should_return_time;
	}
	
	public Date getShould_return_time() {
		return this.should_return_time;
	}
}
