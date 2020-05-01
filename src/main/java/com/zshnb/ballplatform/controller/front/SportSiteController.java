package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportSite;
import com.zshnb.ballplatform.request.ListSportSiteRequest;
import com.zshnb.ballplatform.service.inter.ISportSiteService;
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
@RequestMapping("/front/sport-site")
public class SportSiteController {
	@Autowired
	private ISportSiteService sportSiteService;

	@GetMapping("/{id}")
	public Response<SportSite> detail(@PathVariable int id) {
		return Response.ok(sportSiteService.detail(id));
	}

	@PostMapping("/list")
	public Response<List<SportSite>> list(@RequestBody ListSportSiteRequest request) {
		return Response.ok(sportSiteService.listSportSites(request));
	}
}
