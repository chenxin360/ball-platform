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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/backend/activity")
public class AdminActivityController {
	@Autowired
	private IActivityService activityService;

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
		return Response.ok(activityService.listActivities(request));
	}
}
