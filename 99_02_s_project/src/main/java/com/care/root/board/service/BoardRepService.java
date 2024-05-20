package com.care.root.board.service;

import java.util.ArrayList;

import com.care.root.board.dto.BoardRepDTO;

public interface BoardRepService {
	public int replyUpload(BoardRepDTO dto);
	public ArrayList<BoardRepDTO> replyGetList(String no);
}
