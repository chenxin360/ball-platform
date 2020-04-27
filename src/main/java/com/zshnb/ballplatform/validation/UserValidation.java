package com.zshnb.ballplatform.validation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zshnb.ballplatform.entity.User;
import com.zshnb.ballplatform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserValidation {
	@Autowired
	private IUserService userService;

	public void validate(String username) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", username);
		User user = userService.getOne(wrapper);
		Assert.isNull(user, "用户名已存在");
	}
}
