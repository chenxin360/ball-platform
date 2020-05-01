package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.CoachOrder;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.ICoachOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/order/coach")
public class CoachOrderController {
	@Autowired
	private ICoachOrderService coachOrderService;

	@PostMapping("/list")
	public Response<List<CoachOrder>> list(PageRequest request) {
		return Response.ok(coachOrderService.listOrders(request));
	}
}
