package com.spring.board.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.board.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> getBoardList(HashMap<String, Object> map);

	public BoardVo getBoardView(BoardVo boardVo);

	public void boardWrite(BoardVo boardVo);

	public void boardUpdate(BoardVo boardVo);

	public void boardDelete(BoardVo boardVo);

}
