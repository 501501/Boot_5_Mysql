package com.sol.b5.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ResourceLoader resourceLoader;
	
	// -------------------- static에 저장 --------------------
	// 1. ClassPathResources
	public String getUseClassPathResources(String filePath, MultipartFile multipartFile) throws Exception {
		
		String path = "static";
		
		ClassPathResource classPathResource = new ClassPathResource(path);
		
		File file = new File(classPathResource.getFile(), filePath);
		
		if (!file.exists()) {
			file.mkdirs();
		}
		
		// 파일 저장
		// 1. unique 이름 만들기
		String fileName = "";
		fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();

		// File(경로, 파일 이름)
		file = new File(file, fileName);
		// 저장
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	// 2. ResourceLoader
	public String getUseResourceLoader(String filePath, MultipartFile multipartFile) throws Exception {
		
		String path = "classpath:/static/";
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		
		if (!file.exists()) {
			file.mkdirs();
		}
		
		// 파일 저장
		// 1. unique 이름 만들기
		String fileName = "";
		fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();

		// File(경로, 파일 이름)
		file = new File(file, fileName);
		// 저장
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	
	// -------------------- webapp에 저장 --------------------
	// 3. ServletContext 사용
	public String getUseServletContext(String filePath, MultipartFile multipartFile) throws Exception {
		
		filePath = servletContext.getRealPath(filePath);
		File file = new File(filePath);
		
		if (!file.exists()) {
			file.mkdirs();
		}
		
		// 파일 저장
		// 1. unique 이름 만들기
		String fileName = "";
		fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		// File(경로, 파일 이름)
		file = new File(file, fileName);
		// 저장
		multipartFile.transferTo(file);
		
		return fileName;
	}

}
