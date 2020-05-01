package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Activity;
import com.zshnb.ballplatform.request.ListActivityRequest;
import com.zshnb.ballplatform.service.inter.IActivityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/front/activity")
public class ActivityController {
	@Autowired
	private IActivityService activityService;

	@PostMapping("/list")
	public Response<List<Activity>> list(@RequestBody ListActivityRequest request) {
		return Response.ok(activityService.listActivities(request));
	}
}
