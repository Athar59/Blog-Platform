package com.blog.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Blog {
    private int id;
    private String title;
    private String content;
    private String imagePath;
    private int authorId;
    private String authorName; 
    private Timestamp createdAt;
    
 // Constructors
    
	public Blog() {
		super();
	}
	
	public Blog(int id, String title, String content, String imagePath, int authorId, String authorName,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.imagePath = imagePath;
		this.authorId = authorId;
		this.authorName = authorName;
		this.createdAt = createdAt;
	}
	
	 // Getters and Setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public int getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	 
}
