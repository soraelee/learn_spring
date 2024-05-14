package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl {
	@Autowired FileMapper mapper;
	
	public static final String IMG_REPO = "c:/spring";
	
	public void fileProcess(MultipartFile file, String id, String name) {
		FileDTO dto = new FileDTO(id, name, "nan"); //dto 객체를 만듦과 동시에 저장
		
		if(!file.isEmpty()) { //file.isEmpty() == false
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-"); //날짜 포맷 지정
			String sysFileName = format.format( new Date() ); //java_util
			System.out.println("sysfieNm : "+ sysFileName);
			sysFileName += file.getOriginalFilename();
			//sysFileName = 202405~ -img.png
			
			dto.setImgName(sysFileName); // 파일명 설정하여 저장 (파일이 존재하면 파일명 저장, 없으면 nan으로 저장
			
			File saveFile = new File(IMG_REPO + "/" + sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mapper.saveData(dto);
	}
	public void getData( Model model ) {
		model.addAttribute("list", mapper.getData());
	}
	public void delete(String file, String id) {
		int result = mapper.delete(id);
		if(result == 1) {
			File d = new File(IMG_REPO + "/" + file);
			d.delete();
		}
	}
}
