package com.care.root.mybatis.board;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.care.root.board.dto.BoardDTO;

public interface BoardMapper {
	public ArrayList<BoardDTO> getAllList(@Param("startPage") int startPage, @Param("endPage") int endPage);
	public BoardDTO getCount();
	public int saveData(BoardDTO dto);
	public BoardDTO getList(String write_no);
	public int getHit(int write_no);
	public int modifyBoard(BoardDTO dto);
	public int deleteBoard(int write_no);
}
