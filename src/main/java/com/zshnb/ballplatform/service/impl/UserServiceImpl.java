package com.zshnb.ballplatform.service.impl;

import com.zshnb.ballplatform.entity.User;
import com.zshnb.ballplatform.mapper.UserMapper;
import com.zshnb.ballplatform.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-04-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
