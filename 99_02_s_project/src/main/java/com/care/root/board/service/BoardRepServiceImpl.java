package com.care.root.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dto.BoardRepDTO;
import com.care.root.mybatis.board.BoardRepMapper;

@Service
public class BoardRepServiceImpl implements BoardRepService {
	@Autowired BoardRepMapper mapper;
	
	public int replyUpload(BoardRepDTO dto) {
		int result = mapper.replyUpload(dto);
		return result;
	}

	@Override
	public ArrayList<BoardRepDTO> replyGetList(String no) {
		 ArrayList<BoardRepDTO> arr = mapper.replyGetList(no);
		
		return arr;
	}
	
}
