package com.spring.pds.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

public interface PdsDao {

	public List<PdsVo> getPdsList(HashMap<String, Object> map);

	public void pdsWrite(HashMap<String, Object> map);

	public PdsVo getView(HashMap<String, Object> map);

	public List<FilesVo> getFileList(HashMap<String, Object> map);

}
