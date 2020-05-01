package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.request.ListSportItemRequest;
import com.zshnb.ballplatform.service.inter.ISportItemService;
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
 * @since 2020-04-28
 */
@RestController
@RequestMapping("/front/sport-item")
public class SportItemController {
	@Autowired
	private ISportItemService sportItemService;

	@PostMapping("/list")
	public Response<List<SportItem>> list(@RequestBody ListSportItemRequest request) {
		return Response.ok(sportItemService.listSportItems(request));
	}
}
