package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.Feedback;
import com.zshnb.ballplatform.mapper.FeedbackMapper;
import com.zshnb.ballplatform.service.inter.IFeedbackService;
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
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {

	@Override
	public void add(Feedback feedback) {
		save(feedback);
	}
}
