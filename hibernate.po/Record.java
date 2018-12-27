package hibernate.po;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable{
	private int record_id;
	private int bid;
	private int userid;
	private Date borrow_time;
	private Date return_time;
	
	public void setRecord_id(int record_id) {
		this.record_id=record_id;
	}
	
	public int getRecord_id() {
		return this.record_id;
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
	
	public void setReturn_time(Date return_time) {
		this.return_time=return_time;
	}
	
	public Date getReturn_time() {
		return this.return_time;
	}
}
