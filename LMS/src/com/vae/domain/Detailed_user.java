package com.vae.domain;

import java.util.Date;

public class Detailed_user  {
	private int userid;
	private String id_number;
	private String departement;
	private String sex;
	private String identify;
	private String company;
	private String degree;
	private Date birth;
	private int borrow_max;
	private int appionent_max;
	private int entrust_max;
	private String phone;
	private String postcode;
	private float cash_pledge;
	private String position;
	private int borrow_account;
	private int break_rules_account;
	private float handing_charge;
	private int borrow_grade;
	private String address;
	
	public void setUserid(int userid) {
		this.userid=userid;
	}
	
	public int getUserid() {
		return this.userid;
	}
	
	public void setId_number(String id_number) {
		this.id_number=id_number;
	}
	
	public String getId_number() {
		return this.id_number;
	}
	
	public void setDepartement(String departement) {
		this.departement=departement;
	}
	
	public String getDepartement() {
		return this.departement;
	}
	
	public void setSex(String sex) {
		this.sex=sex;
	}
	
	public String getSex() {
		return this.sex;
	}
	
	public void setIdentify(String identify) {
		this.identify=identify;
	}
	
	public String getIdentify() {
		return this.identify;
	}
	
	public void setCompany(String company) {
		this.company=company;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public void setDegree(String degree) {
		this.degree=degree;
	}
	
	public String getDegree() {
		return this.degree;
	}
	
	public void setBirth(Date birth) {
		this.birth=birth;
	}
	
	public Date getBirth() {
		return this.birth;
	}
	
	public void setBorrow_max(int borrow_max) {
		this.borrow_max=borrow_max;
	}
	
	public int getBorrow_max() {
		return this.borrow_max;
	}
	
	public void setAppionent_max(int appionent_max) {
		this.appionent_max=appionent_max;
	}
	
	public int getAppionent_max() {
		return this.appionent_max;
	}
	
	public void setEntrust_max(int entrust_max) {
		this.entrust_max=entrust_max;
	}
	
	public int getEntrust_max() {
		return this.entrust_max;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPostcode(String postcode) {
		this.postcode=postcode;
	}
	
	public String getPostcode() {
		return this.postcode;
	}
	
	public void setCash_pledge(float cash_pledge) {
		this.cash_pledge=cash_pledge;
	}
	
	public float getCash_pledge() {
		return this.cash_pledge;
	}
	
	public void setPosition(String position) {
		this.position=position;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public void setBorrow_account(int borrow_account) {
		this.borrow_account=borrow_account;
	}
	
	public int getBorrow_account() {
		return this.borrow_account;
	}
	
	public void setBreak_rules_account(int break_rules_account) {
		this.break_rules_account=break_rules_account;
	}
	
	public int getBreak_rules_account() {
		return this.break_rules_account;
	}
	
	public void setHanding_charge(float handing_charge) {
		this.handing_charge=handing_charge;
	}
	
	public float getHanding_charge() {
		return this.handing_charge;
	}
	
	public void setBorrow_grade(int borrow_grade) {
		this.borrow_grade=borrow_grade;
	}
	
	public int getBorrow_grade() {
		return this.borrow_grade;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getAddress() {
		return this.address;
	}
}
