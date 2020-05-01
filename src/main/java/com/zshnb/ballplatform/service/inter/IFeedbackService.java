package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface IFeedbackService extends IService<Feedback> {
	void add(Feedback feedback);
}
