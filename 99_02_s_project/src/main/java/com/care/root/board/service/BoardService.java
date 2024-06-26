package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	public void getAllList(int page, Model model);
	public void uploadBoard(String id, String title, String content, 
					MultipartFile file);
	public void getList(String write_no, Model model);
	public int modifyBoard(int write_no, String title, String content, MultipartFile imageFileName);
	public void deleteBoard(int write_no);
}
