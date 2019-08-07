package com.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;
import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Controller
public class BoardController {

	protected static Logger logger = Logger.getLogger(Main.class.getName());
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MenuService menuService;
	  
	@RequestMapping("/")
	public String home() {
		logger.info("인터셉터 테스트");
		return "home";
	}
   
	
	//게시글목록조회
	@RequestMapping("/Board/List")
	public ModelAndView boardList(@RequestParam HashMap<String, Object> map) {
		
		//메뉴목록조회
		List<MenuVo> menuList = menuService.getMenuList();
		
		//게시물목록조회
		List<BoardVo> list = boardService.getBoardList(map);
		//System.out.println("map1 = " + map);
		
		BoardVo pageBoardVo = (BoardVo) map.get("pageBoardVo");
		ModelAndView mv = new ModelAndView();
	   
		mv.addObject("menuList", menuList);
		mv.addObject("boardList", list);
		mv.addObject("pageBoardVo", pageBoardVo);

		mv.addObject("menu_id", map.get("menu_id"));
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		
		mv.setViewName("boards/boardlist");
		return mv;
	}
	
	//게시글본문조회
	@RequestMapping("/Board/View")
	public ModelAndView view(BoardVo boardVo) {
		BoardVo vo = boardService.getBoardView(boardVo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boards/boardview");
		mv.addObject("boardVo", vo);
		mv.addObject("menu_id", boardVo.getMenu_id());
		//mv.addObject("nowpage", boardVo.getNowpage());
		//mv.addObject("pagegrpnum", boardVo.getPagegrpnum());
		return mv;
	}
	
	//게시글 작성form
	@RequestMapping("/Board/WriteForm")
	public ModelAndView writeForm(BoardVo boardVo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/boards/boardwrite");
		mv.addObject("boardVo", boardVo);
		mv.addObject("menu_id", boardVo.getMenu_id());
		return mv;
	}
	
	//게시글 작성
	@RequestMapping("/Board/Write")
	public ModelAndView wirte(BoardVo boardVo) {
		boardService.boardWrite(boardVo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Board/List?menu_id=" + boardVo.getMenu_id());
		mv.addObject("boardVo", boardVo);
		mv.addObject("nowpage", boardVo.getNowpage());
		mv.addObject("pagegrpnum", boardVo.getPagegrpnum());
		mv.addObject("menu_id", boardVo.getMenu_id());
		return mv;
	}
	
	//게시글 수정form
	@RequestMapping("/Board/UpdateForm")
	public ModelAndView updateForm(BoardVo boardVo) {
		BoardVo vo = boardService.getBoardView(boardVo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/boards/boardupdate");
		mv.addObject("boardVo", vo);
		mv.addObject("menu_id", boardVo.getMenu_id());
		return mv;
	}
	
	//게시글 수정
	@RequestMapping("/Board/Update")
	public ModelAndView update(BoardVo boardVo) {
		boardService.boardUpdate(boardVo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardVo", boardVo);
		mv.addObject("menu_id", boardVo.getMenu_id());
		mv.setViewName("redirect:/Board/List?nowpage=1&pagecount=5&pagegrpnum=1");
		return mv;
	}
	
	//게시글 삭제
	@RequestMapping("/Board/Delete")
	public ModelAndView delete(BoardVo boardVo) {
		boardService.boardDelete(boardVo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Board/List?menu_id=" + boardVo.getMenu_id() + "&nowpage=1&pagecount=5&pagegrpnum=1");
		return mv;
	}
}
