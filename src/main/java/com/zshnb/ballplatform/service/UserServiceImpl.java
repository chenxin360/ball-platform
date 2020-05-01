package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.User;
import com.zshnb.ballplatform.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zshnb.ballplatform.request.LoginRequest;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.request.UpdatePasswordRequest;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.IUserService;
import java.util.List;
import javax.jws.soap.SOAPBinding.Use;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public User login(LoginRequest request) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", request.getUsername())
			.and(c -> c.eq("password", request.getPassword()));
		User user = getOne(wrapper);
		Assert.notNull(user, "用户名或密码错误");
		return user;
	}

	@Override
	public void updatePassword(UpdatePasswordRequest request) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", request.getUsername());
		User user = getOne(wrapper);
		user.setPassword(request.getPassword());
		updateById(user);
	}

	@Override
	public User detail(int id) {
		return getById(id);
	}

	@Override
	public void delete(int id) {
		getBaseMapper().deleteById(id);
	}

	@Override
	public List<User> listCoaches(PageRequest request) {
		Page<User> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return page(page).getRecords();
	}
}
