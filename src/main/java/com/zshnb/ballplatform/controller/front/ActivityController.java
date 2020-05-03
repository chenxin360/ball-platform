package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Activity;
import com.zshnb.ballplatform.request.ListActivityRequest;
import com.zshnb.ballplatform.service.FileService;
import com.zshnb.ballplatform.service.inter.IActivityService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zsh
 * @since 2020-04-27
 */
@RestController
@RequestMapping("/front/activity")
public class ActivityController {
	@Autowired
	private IActivityService activityService;

	@Value("${spring.file.user-upload-dir}")
	private String userUploadDir;

	private Path fileStorageLocation;

	@PostConstruct
	public void setUp() throws IOException {
		this.fileStorageLocation = Paths.get(userUploadDir).toAbsolutePath().normalize();
		if (!fileStorageLocation.toAbsolutePath().toFile().exists()) {
			Files.createDirectories(this.fileStorageLocation);
		}
	}

	@PostMapping("/list")
	public Response<List<Activity>> list(@RequestBody ListActivityRequest request) {
		return activityService.listActivities(request);
	}

	@PostMapping("/upload")
	public Response<String> uploadFile(@RequestParam("file") MultipartFile file,
	                                   @RequestParam("id") int activityId) {

		Activity activity = activityService.getById(activityId);
		activity.setPersonCount(activity.getPersonCount() + 1);
		activityService.updateById(activity);
//		String fileName = storeFile(file);
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//			.path("/backend/downloadFile/")
//			.path(fileName)
//			.toUriString();

		return Response.ok();
	}

	/**
	 * 存储文件到系统
	 *
	 * @param file 文件
	 * @return 文件名
	 */
	public String storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if(fileName.contains("..")) {
				throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (IOException ex) {
			throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	/**
	 * 加载文件
	 * @param fileName 文件名
	 * @return 文件
	 */
	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			} else {
				throw new RuntimeException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new RuntimeException("File not found " + fileName, ex);
		}
	}
}
