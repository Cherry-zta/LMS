package com.vae.domain;

import java.util.Date;

public class Penalty {
	private int pid;
	private int userid;
	private int bid;
	private Date returntime;
	private Date shouldreturntime;
	private float assessment;
	private float paid;
	
	public void setPid(int pid) {
		this.pid=pid;
	}
	public void setUserid(int userid) {
		this.userid=userid;
	}
	public void setBid(int bid) {
		this.bid=bid;
	}
	public void setReturntime(Date returntime) {
		this.returntime=returntime;
	}
	public void setShouldreturntime(Date shouldreturntime) {
		this.shouldreturntime=shouldreturntime;
	}
	public void setAssessment(float assessment) {
		this.assessment=assessment;
	}
	public void setPaid(float paid) {
		this.paid=paid;
	}
	
	public int getPid() {
		return this.pid;
	}
	public int getUserid() {
		return this.userid;
	}
	public int getBid() {
		return this.bid;
	}
	public Date getReturntime() {
		return this.returntime;
	}
	public Date getShouldreturntime() {
		return this.shouldreturntime;
	}
	public float getAssessment() {
		return this.assessment;
	}
	public float getPaid() {
		return this.paid;
	}
}
