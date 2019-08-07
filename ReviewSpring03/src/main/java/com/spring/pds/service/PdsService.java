package com.spring.pds.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

public interface PdsService {

	public List<PdsVo> getPdsList(HashMap<String, Object> map);

	public void pdsWrite(HashMap<String, Object> map, HttpServletRequest request);

	public PdsVo getView(HashMap<String, Object> map);

	public List<FilesVo> getFileList(HashMap<String, Object> map);
	
}
