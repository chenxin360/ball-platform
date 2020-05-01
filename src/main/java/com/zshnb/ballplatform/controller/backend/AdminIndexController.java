package com.zshnb.ballplatform.controller.backend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Admin;
import com.zshnb.ballplatform.entity.Message;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.service.inter.IAdminService;
import com.zshnb.ballplatform.service.inter.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class AdminIndexController {
	@Autowired
	private IMessageService messageService;

	@Autowired
	private IAdminService adminService;

	@PostMapping("/send-message")
	public Response<String> sendMessage(@RequestBody Message message) {
		messageService.sendMessage(message);
		return Response.ok();
	}

	@PostMapping("/login")
	public Response<Admin> login(@RequestBody LoginRequest request) {
		QueryWrapper<Admin> wrapper = new QueryWrapper<>();
		wrapper.eq("username", request.getUsername())
			.eq("password", request.getPassword());
		Admin admin = adminService.getOne(wrapper);
		Assert.notNull(admin, "用户名或密码错误");
		return Response.ok(admin);
	}
}
