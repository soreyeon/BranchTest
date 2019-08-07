package com.spring.pds.service.impl;

import java.io.File;

public class CheckFileName {
	//파일의 중복여부를 체크해주는 클래스입니다.

	public String getCheckFileName(String filePath, String orgFileName, String fileExt) {
		boolean isCheck = true;
		String returnFileName = null;
		String fullFilePath = null;
		File file = null;
		
		int i = 0;
		while(isCheck) {
			fullFilePath = filePath + orgFileName + fileExt;
			file = new File(fullFilePath);
			if(file.exists()) {
				i++;
				orgFileName = orgFileName + String.valueOf(i);
			} else {
				isCheck = false;
			}
		}
		
		returnFileName = orgFileName + fileExt;
		
		return returnFileName;
	}
	
}
