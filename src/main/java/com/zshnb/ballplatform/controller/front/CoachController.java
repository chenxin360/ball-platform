package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.request.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.ICoachService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/front/coach")
public class CoachController {
	@Autowired
	private ICoachService coachService;

	@PostMapping("/list")
	public Response<List<Coach>> list(@RequestBody ListCoachRequest request) {
		return Response.ok(coachService.listCoaches(request));
	}

	@GetMapping("/{id}")
	public Response<Coach> detail(@PathVariable int id) {
		return Response.ok(coachService.detail(id));
	}
}
