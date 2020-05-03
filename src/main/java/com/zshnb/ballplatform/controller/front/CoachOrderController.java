package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.CoachOrder;
import com.zshnb.ballplatform.request.AddCoachOrderRequest;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.ICoachOrderService;
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
@RequestMapping("/front/order/coach")
public class CoachOrderController {
	@Autowired
	private ICoachOrderService coachOrderService;

	@PostMapping("/list")
	public Response<List<CoachOrder>> list(@RequestBody PageRequest request) {
		return coachOrderService.listOrders(request);
	}

	@DeleteMapping("/{id}")
	public Response<String> cancel(@PathVariable int id) {
		coachOrderService.cancel(id);
		return Response.ok();
	}

	@PostMapping("/add")
	public Response<String> add(@RequestBody AddCoachOrderRequest request) {
		coachOrderService.add(request);
		return Response.ok();
	}
}
