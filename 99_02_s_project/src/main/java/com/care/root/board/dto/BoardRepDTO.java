package com.care.root.board.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardRepDTO {
	String id, title, content;
	int writeGroup;
	Date writeDate;
	
	public BoardRepDTO() {
		
	}
	public BoardRepDTO(String id, String title, String content, int writeGroup) {
		this.id = id; this.title = title;
		this.content = content; this.writeGroup = writeGroup;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getWriteGroup() {
		return writeGroup;
	}
	public void setWriteGroup(int writeGroup) {
		this.writeGroup = writeGroup;
	}
	public String getWriteDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
		return format.format(writeDate);
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
