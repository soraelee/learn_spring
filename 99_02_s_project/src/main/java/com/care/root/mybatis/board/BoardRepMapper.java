package com.care.root.mybatis.board;

import java.util.ArrayList;

import com.care.root.board.dto.BoardRepDTO;

public interface BoardRepMapper {
	public int replyUpload(BoardRepDTO dto);
	public ArrayList<BoardRepDTO> replyGetList(String writeGroup);
}
