package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired BoardMapper mapper;

	@Override
	public void getAllList(Model model) {
		ArrayList<BoardDTO> boardList = mapper.getAllList();
		
		model.addAttribute("boardList", boardList);		
	}

	public static String path = "c:/spring";
	@Override
	public void uploadBoard(String id, String title, String content, MultipartFile file) {
		BoardDTO dto = new BoardDTO(0, 0, title, content, "nan", id, null);
		
		
		if (!file.isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			String fileName = format.format(new Date());
			fileName += file.getOriginalFilename();
			dto.setImageFileName(fileName);
			File saveFile = new File(path + "/" + fileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mapper.saveData(dto);
	}
	@Override
	public void getList(String write_no, Model model) {
		BoardDTO dto = mapper.getList(write_no);
		
		System.out.println("dto.getHit() : " + dto.getHit());
		mapper.getHit(dto.getWrite_no());
		System.out.println("dto.getHit() : " + dto.getHit());
		
		dto.setImageFileName(path +"/"+ dto.getImageFileName());
		
		model.addAttribute("dto", dto);
	}
	

}