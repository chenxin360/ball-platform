package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.mapper.CoachMapper;
import com.zshnb.ballplatform.service.inter.ICoachService;
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
public class CoachServiceImpl extends ServiceImpl<CoachMapper, Coach> implements ICoachService {

}
