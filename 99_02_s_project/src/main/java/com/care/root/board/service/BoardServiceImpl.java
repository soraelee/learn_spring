package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.common.SessionCommon;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired BoardMapper mapper;
	
	public Map<String, Integer> pageCnt () {
		BoardDTO dto = mapper.getCount();
		int cnt = dto.getCnt();
		
		System.out.println("cnt : " + cnt);
		
		int page = cnt / 3 == 0 ? 1 : cnt / 3;
		int totPage = cnt % 3 == 0 ? page : page + 1 ;
		
		int startPage = (page - 1) * 3 + 1 ;
		int endPage = page * 3;

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("totPage", totPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		System.out.println("map : " + map);
		
		return map;
	}
	
	@Override
	public void getAllList(Model model) {
		Map<String, Integer> map = pageCnt();
		
		int startPage = map.get("startPage");
		int endPage = map.get("endPage");
		ArrayList<BoardDTO> boardList = mapper.getAllList(startPage, endPage);
		
		
		model.addAttribute("boardList", boardList);		
		model.addAttribute("map", map);
	}

	public static String path = "E:/핀테크_이소래/spring/spring-workspace/99_02_s_project/src/main/webapp/resources/img";
	@Override
	public void uploadBoard(String id, String title, String content, MultipartFile file) {
		BoardDTO dto = new BoardDTO(0, title, content, "nan", id);
		
		
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
		mapper.getHit(dto.getWrite_no());
		
		model.addAttribute("dto", dto);
	}
	@Override
	public int modifyBoard(int write_no, String title, String content, MultipartFile imageFileName) {
		BoardDTO dto = new BoardDTO(write_no, title, content, "nan", SessionCommon.Login);
		if(!imageFileName.isEmpty()) {
			System.out.println(imageFileName.getOriginalFilename());
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			String fileName = format.format(new Date());
			fileName += imageFileName.getOriginalFilename();
			dto.setImageFileName(fileName);
			File saveFile = new File(path + "/" + fileName);
			try {
				imageFileName.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int result = mapper.modifyBoard(dto);
		return result;
	}
	@Override
	public void deleteBoard(int write_no) {
		mapper.deleteBoard(write_no);
	}
	
	
}
