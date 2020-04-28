package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.Message;
import com.zshnb.ballplatform.mapper.MessageMapper;
import com.zshnb.ballplatform.service.inter.IMessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
