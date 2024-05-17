package com.care.root.mybatis.board;

import java.util.ArrayList;

import com.care.root.board.dto.BoardDTO;

public interface BoardMapper {
	public ArrayList<BoardDTO> getAllList();
	public int saveData(BoardDTO dto);
	public BoardDTO getList(String write_no);
	public int getHit(int write_no);
}
