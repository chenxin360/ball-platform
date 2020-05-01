package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.Admin;
import com.zshnb.ballplatform.mapper.AdminMapper;
import com.zshnb.ballplatform.service.inter.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-05-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
