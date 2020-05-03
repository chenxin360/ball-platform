package com.zshnb.ballplatform.controller.backend;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.dto.ActivityDto;
import com.zshnb.ballplatform.entity.Activity;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.request.backend.ListActivityRequest;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.IActivityService;
import com.zshnb.ballplatform.service.inter.ICoachService;
import com.zshnb.ballplatform.validation.CoachValidation;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/backend/activity")
public class AdminActivityController {
	@Autowired
	private IActivityService activityService;

	@Value("${spring.file.admin-upload-dir}")
	private String userUploadDir;

	private Path fileStorageLocation;

	@PostConstruct
	public void setUp() throws IOException {
		this.fileStorageLocation = Paths.get(userUploadDir).toAbsolutePath().normalize();
		if (!fileStorageLocation.toAbsolutePath().toFile().exists()) {
			Files.createDirectories(this.fileStorageLocation);
		}
	}

	@PostMapping("/add")
	public Response<String> add(@RequestBody Activity activity) {
		activityService.add(activity);
		return Response.ok();
	}

	@PutMapping("/update")
	public Response<String> update(@RequestBody Activity activity) {
		activityService.update(activity);
		return Response.ok();
	}

	@DeleteMapping("/{id}")
	public Response<String> delete(@PathVariable int id) {
		activityService.delete(id);
		return Response.ok();
	}

	@GetMapping("/{id}")
	public Response<ActivityDto> detail(@PathVariable int id) {
		return Response.ok(activityService.detail(id));
	}

	@PostMapping("/list")
	public Response<List<ActivityDto>> list(@RequestBody ListActivityRequest request) {

		return activityService.listActivities(request);
	}

	@PostMapping("/upload")
	public Response<String> uploadFile(@RequestParam("file") MultipartFile file,
	                                   @RequestParam("id") int id) {

		String fileName = storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("/backend/activity/downloadFile/")
			.path(fileName)
			.toUriString();
		Activity activity = activityService.getById(id);
		activity.setExcel(fileDownloadUri);
		activityService.updateById(activity);
		return Response.ok();
	}

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Fallback to the default content type if type could not be determined
		if(contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok()
			.contentType(MediaType.parseMediaType(contentType))
			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
			.body(resource);
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
