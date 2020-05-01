package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.PageRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface IMessageService extends IService<Message> {
	List<Message> listMessages(PageRequest request);
}
