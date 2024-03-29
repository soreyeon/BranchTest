package com.spring.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.menu.dao.MenuDao;
import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	//메뉴목록조회
	@Override
	public List<MenuVo> getMenuList() {
		List<MenuVo> list = menuDao.getMenuList();
		return list;
	}

	//메뉴추가
	@Override
	public void insertMenu(MenuVo vo) {
		menuDao.insertMenu(vo);
		
	}
	
	//메뉴수정form
	@Override
	public MenuVo ContentView(MenuVo vo) {
		MenuVo menuVo = menuDao.ContentView(vo);
		return menuVo;
	}

	//메뉴수정
	@Override
	public void updateMenu(MenuVo vo) {
		menuDao.updateMenu(vo);
		
	}

	//메뉴삭제
	@Override
	public void deleteMenu(MenuVo vo) {
		menuDao.deleteMenu(vo);
		
	}

}
