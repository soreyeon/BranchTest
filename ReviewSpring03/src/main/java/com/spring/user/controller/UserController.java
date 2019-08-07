package com.spring.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.user.service.UserService;
import com.spring.user.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm";
	}
	
	//로그인
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, @RequestParam HashMap<String, Object> map) {
		String returnURL = "";
		
		//기존에 login이란 session 값이 존재하면
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login"); //기존값 제거
		}
		
		//로그인에 성공하면 UserVo 값 리턴
		UserVo vo = userService.login(map);
		System.out.println("map1 = " + map);
		System.out.println("vo = " + vo);
		
		if(vo != null) {
			//session.setAttribute("login", vo);
			returnURL = "redirect:/Board/List?menu_id=MENU01&nowpage=1&pagecount=5&pagegrpnum=1";
		} else {
			returnURL = "redirect:/login";
		}
		
		System.out.println(returnURL);
		return returnURL;
	}
	
	
}
