package com.vae.domain;

import java.io.Serializable;

public class RelationBook implements Serializable {
	private int bid;
	private int cid;
	
	public void setBid(int bid) {
		this.bid=bid;
	}
	public void setCid(int cid) {
		this.cid=cid;
	}
	
	public int getBid() {
		return this.bid;
	}
	public int getCid() {
		return this.cid;
	}
}
