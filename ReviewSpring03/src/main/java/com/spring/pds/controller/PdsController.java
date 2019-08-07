package com.spring.pds.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Controller
public class PdsController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PdsService pdsService;
	
	//자료실 목록조회
	@RequestMapping("/Pds/List")
	public ModelAndView pdsList(@RequestParam HashMap<String, Object> map) {
		List<MenuVo> menuList = menuService.getMenuList();
		List<PdsVo> pdsList = pdsService.getPdsList(map);
		PdsVo pagePdsVo = (PdsVo) map.get("pagePdsVo");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("pdsList", pdsList);
		mv.addObject("pagePdsVo", pagePdsVo);
		
		mv.addObject("menu_id", map.get("menu_id"));
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		
		mv.setViewName("pds/pdslist");
		return mv;
	}
	
	//자료실 글쓰기 form
	@RequestMapping("/Pds/WriteForm")
	public ModelAndView pdsWriteForm(@RequestParam HashMap<String, Object> map) {
		List<MenuVo> menuList = menuService.getMenuList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("map", map);
		mv.setViewName("pds/pdswrite");
		
		return mv;
	}
	
	//자료실 글쓰기
	@RequestMapping("/Pds/Write")
	public ModelAndView pdsWrite(@RequestParam HashMap<String, Object> map, HttpServletRequest request) {
		
		//넘어온 자료를 저장하는건데
		pdsService.pdsWrite(map, request);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menu_id", map.get("menu_id"));
		
		//페이징정보를 가져가야하는데
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		
		mv.setViewName("redirect:/Pds/List");
		
		return mv;
	}
	
	//자료실 본문조회
	@RequestMapping("/Pds/View")
	public ModelAndView pdsView(@RequestParam HashMap<String, Object> map) {
		
		//메뉴목록조회
		List<MenuVo> menuList = menuService.getMenuList();
		
		//본문정보조회
		PdsVo pdsVo = pdsService.getView(map);
		
		//파일목록조회
		List<FilesVo> fileList = pdsService.getFileList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.addObject("pdsVo", pdsVo);
		mv.addObject("fileList", fileList);
		mv.addObject("menuList", menuList);
		mv.setViewName("pds/view");
		
		return mv;
	}
	
	//파일다운로드
	
	// /download /{type}/{sfile:.+}
	// {type} : 첫번째 인자 --> internal(프로젝트 내부에 파일이 존재)
	//                      --> external(프로젝트 외부에 파일이 존재)
	// {sfile:.+} : 두번째 인자 --> 파일명
	//.+ : 정규식(--> .(dot)이 한개이상 있는파일)
	@RequestMapping(value="/download/{type}/{sfile:.+}", method=RequestMethod.GET)
	
	public void downloadFile(HttpServletResponse response, @PathVariable("type") String type, @PathVariable("sfile") String sfile) throws IOException {
		//download/external/aaa.jpg
		//type = external
		//sfile = aaa.jpg
		
		String INTERNAL_FILE = sfile;
		String EXTERNAL_FILE_PATH = "c:\\Upload\\" + sfile;
		
		File file = null;
		
		if(type.equalsIgnoreCase("internal")) {
			//현재 실행중인 웹서버의 파일경로
			//type이 internal일 경우
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			file = new File(classLoader.getResource(INTERNAL_FILE).getFile());
		} else {
			//type이 external일 경우
			file = new File(EXTERNAL_FILE_PATH);
		}
		
		//파일이 없을때 처리
		if(!file.exists()) {
			String errorMessage = "Sorry. this file are looking for does not exist";
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
	}
}
