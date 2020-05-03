package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportSiteOrder;
import com.zshnb.ballplatform.request.AddCoachOrderRequest;
import com.zshnb.ballplatform.request.AddSportSiteOrderRequest;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.ISportSiteOrderService;
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
@RequestMapping("/front/order/sport-site")
public class SportSiteOrderController {
	@Autowired
	private ISportSiteOrderService sportSiteOrderService;

	@PostMapping("/list")
	public Response<List<SportSiteOrder>> list(@RequestBody PageRequest request) {
		return sportSiteOrderService.listOrders(request);
	}

	@DeleteMapping("/{id}")
	public Response<String> cancel(@PathVariable int id) {
		sportSiteOrderService.cancel(id);
		return Response.ok();
	}

	@PostMapping("/add")
	public Response<String> add(@RequestBody AddSportSiteOrderRequest request) {
		sportSiteOrderService.add(request);
		return Response.ok();
	}
}
