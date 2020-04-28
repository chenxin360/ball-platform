package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.User;
import com.zshnb.ballplatform.request.RegisterRequest;
import com.zshnb.ballplatform.service.IUserService;
import com.zshnb.ballplatform.validation.UserValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/front/user")
public class UserController {
	@Autowired
	private UserValidation userValidation;

	@Autowired
	private IUserService userService;

	@PostMapping("/register")
	public Response<String> register(@RequestBody RegisterRequest request) {
		userValidation.validate(request.getUsername());
		User user = new User();
		BeanUtils.copyProperties(request, user);
		userService.save(user);
		return Response.ok();
	}
}
