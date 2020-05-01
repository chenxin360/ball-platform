package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.request.UpdatePasswordRequest;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import java.util.List;
import javax.jws.soap.SOAPBinding.Use;

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

	User detail(int id);

	void delete(int id);

	List<User> listCoaches(PageRequest request);
}
