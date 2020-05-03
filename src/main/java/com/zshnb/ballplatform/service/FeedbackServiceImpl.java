package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Feedback;
import com.zshnb.ballplatform.mapper.FeedbackMapper;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.IFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
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

	@Override
	public Response<List<Feedback>> listFeedbacks(PageRequest request) {
		IPage<Feedback> iPage = page(new Page<>(request.getPageNumber(), request.getPageSize()));
		return Response.ok(iPage.getRecords(), iPage.getTotal());
	}
}
