package com.zshnb.ballplatform.controller.front;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Bill;
import com.zshnb.ballplatform.request.AddBillRequest;
import com.zshnb.ballplatform.request.ListBillRequest;
import com.zshnb.ballplatform.service.inter.IBillService;
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
@RequestMapping("/front/bill")
public class BillController {
	@Autowired
	private IBillService billService;

	@PostMapping("/add")
	public Response<Double> add(@RequestBody AddBillRequest request) {
		double money = billService.addBill(request);
		return Response.ok(money);
	}

	@PostMapping("/list")
	public Response<List<Bill>> list(@RequestBody ListBillRequest request) {
		return Response.ok(billService.listBill(request));
	}
}
