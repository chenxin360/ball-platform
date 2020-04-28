package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.Activity;
import com.zshnb.ballplatform.mapper.ActivityMapper;
import com.zshnb.ballplatform.service.inter.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

}
