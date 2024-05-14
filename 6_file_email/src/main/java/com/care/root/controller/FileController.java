package com.care.root.controller;


import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.service.FileServiceImpl;

@Controller
public class FileController {
	@Autowired FileServiceImpl fs;
	public FileController() {
		System.out.println("컨트롤러 실행");
	}
	
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	@PostMapping("upload")
	public String upload(@RequestParam String id,
			@RequestParam String name,
			MultipartFile file,
			HttpServletRequest req,
			MultipartHttpServletRequest mReq
			) {
		System.out.println("id : " + req.getParameter("id"));
		System.out.println("name : " + mReq.getParameter("name"));
		System.out.println("file : " + file.getOriginalFilename());
		MultipartFile file02 = mReq.getFile("file"); //name 이 file인 정보를 가져옴
		System.out.println("file02 : "+file02.getOriginalFilename());
		fs.fileProcess(file, id, name);
		return "redirect:form";
	}
	@GetMapping("views")
	public String views(Model model) {
		fs.getData( model );
		return "result";
	}
	@GetMapping("download")
	public void download(@RequestParam String file, HttpServletResponse res) throws Exception{
		//파일명과 파일명을 토대로 전송
		res.addHeader("Content-disposition", "attachment;fileName="+file); //Content에 오타가 발생하면 다운 되지 X 보여지기만 함
		File f = new File(FileServiceImpl.IMG_REPO + "/" + file); //원하는 경로 지정
		FileInputStream in = new FileInputStream(f); //파일을 찾는 inputstream을 생성
		FileCopyUtils.copy(in,  res.getOutputStream()); //응답하는 객체를 output스트림으로 꺼내옴 
	}
	@GetMapping("delete")
	public String delete(@RequestParam String file,
						@RequestParam String id) {
		//파일 삭제
		fs.delete(file, id);
		return "redirect:views";
	}
}
