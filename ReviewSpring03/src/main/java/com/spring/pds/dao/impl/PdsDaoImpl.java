package com.spring.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {

	@Autowired
	private SqlSession sqlSession;
	
	//자료실 목록조회
	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		sqlSession.selectList("Pds.PdsList", map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		return pdsList;
	}

	//자료실 글쓰기
	@Override
	public void pdsWrite(HashMap<String, Object> map) {
		sqlSession.insert("Pds.PdsInsert", map);
		
	}

	//자료실 본문조회
	@Override
	public PdsVo getView(HashMap<String, Object> map) {
		sqlSession.selectList("Pds.PdsView", map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		PdsVo pdsVo = pdsList.get(0);
		return pdsVo;
	}

	//파일목록조회
	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
		sqlSession.selectList("Pds.FileList", map);
		List<FilesVo> fileList = (List<FilesVo>) map.get("result");
		return fileList;
	}

}
