package com.zshnb.ballplatform.controller.backend;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.dto.UserDto;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.User;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.RegisterRequest;
import com.zshnb.ballplatform.request.UpdateInfoRequest;
import com.zshnb.ballplatform.request.UpdatePasswordRequest;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.ISportItemService;
import com.zshnb.ballplatform.service.inter.IUserService;
import com.zshnb.ballplatform.validation.UserValidation;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/backend/user")
public class AdminUserController {
	@Autowired
	private IUserService userService;

	@DeleteMapping("/{id}")
	public Response<String> delete(@PathVariable int id) {
		userService.delete(id);
		return Response.ok();
	}

	@GetMapping("/{id}")
	public Response<User> detail(@PathVariable int id) {
		return Response.ok(userService.detail(id));
	}

	@PostMapping("/list")
	public Response<List<User>> list(@RequestBody ListCoachRequest request) {
		return Response.ok(userService.listCoaches(request));
	}
}
