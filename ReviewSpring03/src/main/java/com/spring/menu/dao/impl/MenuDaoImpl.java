package com.spring.menu.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.menu.dao.MenuDao;
import com.spring.menu.vo.MenuVo;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SqlSession sqlSession;
	
	//메뉴목록조회
	@Override
	public List<MenuVo> getMenuList() {
		HashMap<String, Object> map = new HashMap<>();
		
		sqlSession.selectList("Menu.MenuList", map);
		List<MenuVo> list = (List<MenuVo>) map.get("result");
		return list;
	}

	//메뉴추가
	@Override
	public void insertMenu(MenuVo vo) {
		sqlSession.insert("Menu.MenuInsert", vo);
	}

	//메뉴수정
	@Override
	public MenuVo ContentView(MenuVo vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("menu_id", vo.getMenu_id());
		sqlSession.selectList("Menu.GetMenuContent", map);
		
		List<MenuVo> list = (List<MenuVo>) map.get("result");
		MenuVo menuVo = list.get(0);
		return menuVo;
	}

	//메뉴수정
	@Override
	public void updateMenu(MenuVo vo) {
		sqlSession.update("Menu.MenuUpdate", vo);
	}

	//메뉴삭제
	@Override
	public void deleteMenu(MenuVo vo) {
		sqlSession.delete("Menu.MenuDelete", vo);
		
	}

	

}
