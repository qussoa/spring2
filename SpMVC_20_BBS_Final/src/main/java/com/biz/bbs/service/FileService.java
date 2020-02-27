package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

/*
 * summernote에서 drag&drop으로 이미지 파일을 업로드하면
 * 일단 서버에 파일을 업로드하고
 * 파일 이름을 다시 내려보내서 base64로 encoding된 파일 정보를
 * img src="저장된 경로/파일이름" 형식으로 변경 
 * 
 */

@RequiredArgsConstructor
@Service
public class FileService {

	// servlet-context.xml에 설정된 파일 저장경로 정보를
	// 가져와서 사용하기
	private final String filePath;

	/*
	 * browser에서 file이 전송되어오면
	 * 원래 파일이름을 UUID 부착된 파일이름을 변경
	 * 변경된 이름으로 서버의 filePath에 저장을 하고
	 * 변경된 파일 이름을 return 
	 */
	public String fileUp(MultipartFile upFile) {
		
		
		// 파일 이름 추출(그림.jpg)
		String originalFileName = upFile.getOriginalFilename();

		//UUID가 부착된 새로운 이름 생성
		String strUUID = UUID.randomUUID().toString();
		strUUID += originalFileName; // (UUID그림.jpg)
		
		// filePath와 변경된 파일이름을 결합하여
		// File객체를 생성
		File serverFile = new File(filePath,strUUID);
		
		//upload할 filePath가 있는지 확인 없을시 폴더 생성
		File dir = new File(filePath);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		// upFile을 serverFile 이름으로 복사수행
		try {
			upFile.transferTo(serverFile);
			return strUUID;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

















