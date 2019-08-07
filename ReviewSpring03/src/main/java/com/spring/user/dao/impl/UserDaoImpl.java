package com.spring.user.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.user.dao.UserDao;
import com.spring.user.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserVo login(HashMap<String, Object> map) {
		sqlSession.selectList("User.Login", map);
		List<UserVo> list = (List<UserVo>) map.get("result");
		UserVo vo = list.get(0);
		//System.out.println("map3 = " + map);
		return vo;
	}
	
	
}
