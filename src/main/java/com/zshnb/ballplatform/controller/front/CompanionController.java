package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Companion;
import com.zshnb.ballplatform.request.ListCompanionRequest;
import com.zshnb.ballplatform.request.UploadCompanionRequest;
import com.zshnb.ballplatform.service.inter.ICompanionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zsh
 * @since 2020-04-27
 */
@RestController
@RequestMapping("/front/companion")
public class CompanionController {
	@Autowired
	private ICompanionService companionService;

	@PostMapping("/upload")
	public Response<String> upload(@RequestBody UploadCompanionRequest request) {
		companionService.uploadCompanion(request);
		return Response.ok();
	}

	@PostMapping("/list")
	public Response<List<Companion>> list(@RequestBody ListCompanionRequest request) {
		return companionService.listCompanion(request);
	}

	@DeleteMapping("/front/companion/{id}")
	public Response<String> delete(@PathVariable Integer id) {
		companionService.deleteCompanion(id);
		return Response.ok();
	}
}
