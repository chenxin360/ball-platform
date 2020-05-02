package com.zshnb.ballplatform.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	private Path fileStorageLocation; // 文件在本地存储的地址

	@Value("${spring.file.user-upload-dir}")
	private String userUploadDir;

//	public FileService() {
//		this.fileStorageLocation = Paths.get(userUploadDir).toAbsolutePath().normalize();
//		try {
//			Files.createDirectories(this.fileStorageLocation);
//		} catch (Exception ex) {
//			throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
//		}
//	}


}
