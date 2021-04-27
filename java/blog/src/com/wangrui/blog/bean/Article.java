package com.wangrui.blog.bean;

import java.sql.Date;

public class Article {

	private Integer aricleID;
	private String title;
	private Integer typeID;
	private String content;
	private Integer blogID;
	private Date publishDate;
	
	public Integer getAricleID() {
		return aricleID;
	}
	public void setAricleID(Integer aricleID) {
		this.aricleID = aricleID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getBlogID() {
		return blogID;
	}
	public void setBlogID(Integer blogID) {
		this.blogID = blogID;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Article(Integer aricleID, String title, Integer typeID, String content, Integer blogID, Date publishDate) {
		super();
		this.aricleID = aricleID;
		this.title = title;
		this.typeID = typeID;
		this.content = content;
		this.blogID = blogID;
		this.publishDate = publishDate;
	}
	
	
	
	
}
