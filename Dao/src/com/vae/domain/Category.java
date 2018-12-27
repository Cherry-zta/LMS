package com.vae.domain;

import java.io.Serializable;

public class Category implements Serializable {
	private int cid;
	private String cname;
	
	public void setCid(int cid) {
		this.cid=cid;
	}
	public void setCname(String cname) {
		this.cname=cname;
	}
	
	public int getCid() {
		return this.cid;
	}
	public String getCname() {
		return this.cname;
	}
}
