package com.mhj.s2.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerM {
	
	public String fileSave(String realPath, MultipartFile multipartFile) throws Exception {
		//3. 저장할 폴더의 정보를 갖고 있는 File 객체 선언
		File file = new File(realPath);
		
		//4. 만약 폴더가 존재하지 않을 경우 폴더 생성
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//5. 중복되지 않는 파일명 생성
		String fileName = UUID.randomUUID().toString();
		String oriName = multipartFile.getOriginalFilename();
		fileName = fileName + "_" + oriName;
		
		//6. HDD에 파일 저장
			//어떤 경로에 어떤 이름으로 저장할지 지정할 File 객체 생성
		file = new File(file, fileName);
		
			//파일 저장
		multipartFile.transferTo(file);
		
		return fileName;
		
	}

}
