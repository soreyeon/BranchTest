package com.spring.menu.dao;

import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuDao {

	public List<MenuVo> getMenuList();

	public void insertMenu(MenuVo vo);

	public MenuVo ContentView(MenuVo vo);

	public void updateMenu(MenuVo vo);

	public void deleteMenu(MenuVo vo);

	

}
