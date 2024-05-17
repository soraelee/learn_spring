package com.care.root.board.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDTO {
	int write_no, hit;
	String title, content, imageFileName, id; 
	Date savedate;
	
	public BoardDTO() {
		
	}
	public BoardDTO(int write_no, int hit, String title, String content, 
			String imageFileName, String id, Date savedate) {
		this.write_no = write_no;
		this.hit = hit;
		this.title = title;
		this.content = content;
		this.imageFileName = imageFileName;
		this.id = id;
	}
	
	public int getWrite_no() {
		return write_no;
	}
	public void setWrite_no(int write_no) {
		this.write_no = write_no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
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
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSavedate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(savedate);
	}
	public void setSavedate(Date savedate) {
		this.savedate = savedate;
	}
	
	
}
