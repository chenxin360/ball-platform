package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportTrack;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.ISportTrackService;
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
@RequestMapping("/front/sport-track")
public class SportTrackController {
	@Autowired
	private ISportTrackService sportTrackService;

	@PostMapping("/add")
	public Response<String> add(@RequestBody SportTrack sportTrack) {
		sportTrackService.add(sportTrack);
		return Response.ok();
	}

	@PostMapping("/list")
	public Response<List<SportTrack>> list(@RequestBody PageRequest request) {
		return sportTrackService.list(request);
	}
}
