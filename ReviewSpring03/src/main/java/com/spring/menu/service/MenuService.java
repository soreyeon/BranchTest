package com.spring.menu.service;

import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuService {

	public List<MenuVo> getMenuList();

	public void insertMenu(MenuVo vo);

	public MenuVo ContentView(MenuVo vo);

	public void updateMenu(MenuVo vo);

	public void deleteMenu(MenuVo vo);

	
	
}
