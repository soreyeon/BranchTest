package com.spring.pds.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService {

	@Autowired
	private PdsDao pdsDao;
	
	//자료실목록조회
	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		
		//페이지설정
		int pagetotalcount = 10;
		int pagecount = 5;
		
		//db에 전달하기위해 보관
		map.put("pagecount", pagecount);
		
		//db조회
		List<PdsVo> pdsList = pdsDao.getPdsList(map);
		
		//조회된 이후처리
		int nowpage = Integer.parseInt((String) map.get("nowpage"));
		int pagegrpnum = Integer.parseInt((String) map.get("pagegrpnum"));
		
		int totalcount = (int) map.get("totalcount"); //myBatis에서 넘겨준(out)정보
		
		//paging.jspf에 필요한 값을 처리
		BoardPaging bp = new BoardPaging(nowpage, pagecount, totalcount, pagetotalcount, pagegrpnum);
		
		PdsVo vo = bp.getPdsPagingInfo();
		
		vo.setMenu_id((String) map.get("menu_id"));
		
		map.put("pagePdsVo", vo);
		
		return pdsList;
	}

	//자료실 글쓰기(파일 업로드)
	@Override
	public void pdsWrite(HashMap<String, Object> map, HttpServletRequest request) {
		
		//중복파일을 처리합니다
		CheckFileName checkFile = new CheckFileName();
		
		//업로드된 파일이 저장되는 경로를 지정해줍니다.
		String filePath = "c:\\Upload\\";
		
		//업로드된 파일을 저장하는 처리를 담당해줍니다.
		MultipartHttpServletRequest multipartServletRequest = (MultipartHttpServletRequest) request;
		
		Iterator<String> iterator = multipartServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		
		//저장된 파일의 목록정보
		List<String> filenames = new ArrayList<>(); 
		List<String> fileexts = new ArrayList<>(); 
		List<String> sfilenames = new ArrayList<>(); 
		
		String fileName = null; //파일이름(중복있음)
		String orgFileName = null; //확장자가 포함되지 않은 파일이름
		String fileExt = null; //파일확장자
		String sFileName = null; //DB에서 구분하는 파일이름(중복없음)
		
		int i = 0;
		while(iterator.hasNext()) {
			multipartFile = multipartServletRequest.getFile(iterator.next());
			
			HashMap<String, String> hashMap = new HashMap<>();
			
			if(!multipartFile.isEmpty()) {
				fileName = multipartFile.getOriginalFilename(); //업로드된 파일명
				
				int dotIdx = fileName.lastIndexOf('.');
				orgFileName = fileName.substring(0, dotIdx);
				fileExt = fileName.substring(dotIdx);
				
				//중복파일이 존재하면 번호추가 후 실제파일명 처리
				sFileName = checkFile.getCheckFileName(filePath, orgFileName, fileExt);
				
				filenames.add(fileName);
				fileexts.add(fileExt);
				sfilenames.add(sFileName);
				
				map.put("filenames", filenames);
				map.put("fileexts", fileexts);
				map.put("sfilenames", sfilenames);
				
				//저장
				File file = new File(filePath + sFileName);
				i += 1;
				
				try {
					multipartFile.transferTo(file); // 실제 파일명으로 저장
				} catch (IllegalStateException e) {
					System.out.println("오류: " + e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("오류: " + e.getMessage());
					e.printStackTrace();
				}
			}
		
		} //file 저장 end
		
		pdsDao.pdsWrite(map);
	}

	//자료실 본문 조회
	@Override
	public PdsVo getView(HashMap<String, Object> map) {
		PdsVo pdsVo = pdsDao.getView(map);
		return pdsVo;
	}

	//파일목록조회
	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
		List<FilesVo> fileList = pdsDao.getFileList(map);
		return fileList;
	}

}
