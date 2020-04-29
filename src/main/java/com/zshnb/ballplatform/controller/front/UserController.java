package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.dto.UserDto;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.entity.User;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.RegisterRequest;
import com.zshnb.ballplatform.request.UpdateInfoRequest;
import com.zshnb.ballplatform.request.UpdatePasswordRequest;
import com.zshnb.ballplatform.service.inter.ISportItemService;
import com.zshnb.ballplatform.service.inter.IUserService;
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

	@Autowired
	private ISportItemService sportItemService;

	@PostMapping("/register")
	public Response<String> register(@RequestBody RegisterRequest request) {
		userValidation.validate(request.getUsername());
		User user = new User();
		BeanUtils.copyProperties(request, user);
		userService.save(user);
		return Response.ok();
	}

	@PostMapping("/login")
	public Response<UserDto> login(@RequestBody LoginRequest request) {
		User user = userService.login(request);
//		SportItem sportItem = sportItemService.getById(user.getSportItemId());
		UserDto userDto = new UserDto();
//		userDto.setSportItemName(sportItem.getName());
		BeanUtils.copyProperties(user, userDto);
		return Response.ok(userDto);
	}

	@PostMapping("/update-info")
	public Response<User> updateInfo(@RequestBody UpdateInfoRequest request) {
		User user = userService.getById(request.getId());
		BeanUtils.copyProperties(request, user);
		userService.updateById(user);
		return Response.ok(user);
	}

	@PostMapping("/update-password")
	public Response<String> updatePassword(@RequestBody UpdatePasswordRequest request) {
		userService.updatePassword(request);
		return Response.ok();
	}
}
