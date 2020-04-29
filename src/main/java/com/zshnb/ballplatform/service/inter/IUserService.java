package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.UpdatePasswordRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface IUserService extends IService<User> {
	User login(LoginRequest request);

	void updatePassword(UpdatePasswordRequest request);
}
