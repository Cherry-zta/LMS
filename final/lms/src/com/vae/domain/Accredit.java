package com.vae.domain;

public class Accredit {
	private String accredit_id;
	private String accredit_type;
	private int status;
	private int userid;
	
	public String getAccredit_id() {
		return accredit_id;
	}
	public void setAccredit_id(String accredit_id) {
		this.accredit_id = accredit_id;
	}
	public String getAccredit_type() {
		return accredit_type;
	}
	public void setAccredit_type(String accredit_type) {
		this.accredit_type = accredit_type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
