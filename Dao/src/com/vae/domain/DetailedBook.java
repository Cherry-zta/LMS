package com.vae.domain;

import java.io.Serializable;

public class DetailedBook implements Serializable {
	private int bid;
	private String status;
	private String publishinghouse;
	private String series;
	private String isbn;
	private int borrowtimes=0;
	private String categorynumber;
	private String author;
	private String secondauthor;
	private String introduction;
	private String summary;
	private String authornotes;
	private String readernotes;
	private String bookspecification;
	private String doubanintroduce;
	
	public void setBid(int bid) {
		this.bid=bid;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public void setPublishinghouse(String publishinghouse) {
		this.publishinghouse=publishinghouse;
	}
	public void setSeries(String series) {
		this.series=series;
	}
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}
	public void setBorrowtimes(int borrowtimes) {
		this.borrowtimes=borrowtimes;
	}
	public void setCategorynumber(String categorynumber) {
		this.categorynumber=categorynumber;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public void setSecondauthor(String secondauthor) {
		this.secondauthor=secondauthor;
	}
	public void setIntroduction(String introduction) {
		this.introduction=introduction;
	}
	public void setSummary(String summary) {
		this.summary=summary;
	}
	public void setAuthornotes(String authornotes) {
		this.authornotes=authornotes;
	}
	public void setReadernotes(String readernotes) {
		this.readernotes=readernotes;
	}
	public void setBookspecification(String bookspecification) {
		this.bookspecification=bookspecification;
	}
	public void setDoubanintroduce(String doubanintroduce) {
		this.doubanintroduce=doubanintroduce;
	}
	
	public int getBid() {
		return this.bid;
	}
	public String getStatus() {
		return this.status;
	}
	public String getPublishinghouse() {
		return this.publishinghouse;
	}
	public String getSeries() {
		return this.series;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public int getBorrowtimes() {
		return this.borrowtimes;
	}
	public String getCategorynumber() {
		return this.categorynumber;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getSecondauthor() {
		return this.secondauthor;
	}
	public String getIntroduction() {
		return this.introduction;
	}
	public String getSummary() {
		return this.summary;
	}
	public String getAuthornotes() {
		return this.authornotes;
	}
	public String getReadernotes() {
		return this.readernotes;
	}
	public String getBookspecification() {
		return this.bookspecification;
	}
	public String getDoubanintroduce() {
		return this.doubanintroduce;
	}
}
