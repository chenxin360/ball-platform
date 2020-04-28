package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.mapper.SportItemMapper;
import com.zshnb.ballplatform.service.inter.ISportItemService;
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
public class SportItemServiceImpl extends ServiceImpl<SportItemMapper, SportItem> implements ISportItemService {

}
