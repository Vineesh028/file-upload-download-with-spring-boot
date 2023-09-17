package com.file.server.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.file.server.entity.FileEntity;
import com.file.server.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	FileRepository fileRepository;

	public String uploadFile(MultipartFile request) {
		try {
			FileEntity fileEntity = new FileEntity();
			fileEntity.setFileName(StringUtils.cleanPath(request.getOriginalFilename()));
			fileEntity.setFileContent(request.getBytes());
	        fileEntity.setContentType(request.getContentType());
	     
			
			fileRepository.save(fileEntity);
			return "File submitted successfully";
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public FileEntity downloadFile(String fileName) {
		FileEntity fileEntity = fileRepository.findByFileName(fileName);
		return fileEntity;

	}

}
