package com.spring.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDao;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	//게시물목록조회
	@Override
	public List<BoardVo> getBoardList(HashMap<String, Object> map) {
		
		int pagetotalcount = 10;
		int pagecount = 5;
		
		map.put("pagecount", pagecount);
		
		List<BoardVo> list = boardDao.getBoardList(map);
		//System.out.println("map2 = " + map);
		
		int nowpage =  Integer.parseInt((String) map.get("nowpage"));
		int pagegrpnum =  Integer.parseInt((String) map.get("pagegrpnum"));
		
		//int nowpage =  (int) map.get("nowpage");
		//int pagegrpnum = (int) map.get("pagegrpnum");
		
		int totalcount = (int) map.get("totalcount");
		
		BoardPaging bp = new BoardPaging(nowpage, pagecount, totalcount, pagetotalcount, pagegrpnum);
		
		BoardVo vo = bp.getBoardPagingInfo();
		
		vo.setMenu_id((String) map.get("menu_id"));
		
		map.put("pageBoardVo", vo);

		return list;
	}
	
	//게시물본문조회
	@Override
	public BoardVo getBoardView(BoardVo boardVo) {
		BoardVo vo = boardDao.getBoardView(boardVo);
		return vo;
	}

	//게시물작성
	@Override
	public void boardWrite(BoardVo boardVo) {
		boardDao.boardWrite(boardVo);
		
	}

	//게시물 수정
	@Override
	public void boardUpdate(BoardVo boardVo) {
		boardDao.boardUpdate(boardVo);
		
	}

	//게시물 삭제
	@Override
	public void boardDelete(BoardVo boardVo) {
		boardDao.boardDelete(boardVo);
		
	}

}
