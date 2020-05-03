package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.dto.ActivityDto;
import com.zshnb.ballplatform.entity.Activity;
import com.zshnb.ballplatform.mapper.ActivityMapper;
import com.zshnb.ballplatform.request.ListActivityRequest;
import com.zshnb.ballplatform.service.inter.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private ActivityMapper activityMapper;

	@Override
	public Response<List<Activity>> listActivities(ListActivityRequest request) {
		QueryWrapper<Activity> wrapper = new QueryWrapper<>();
		if (request.getSportItemId() != 0) {
			wrapper.eq("sport_item_id", request.getSportItemId());
		}
		Page<Activity> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return Response.ok(page(page, wrapper).getRecords(), page.getTotal());
	}

	@Override
	public void add(Activity activity) {
		save(activity);
	}

	@Override
	public void update(Activity activity) {
		updateById(activity);
	}

	@Override
	public ActivityDto detail(int id) {
		return activityMapper.findDtosById(id);
	}

	@Override
	public void delete(int id) {
		getBaseMapper().deleteById(id);
	}

	@Override
	public Response<List<ActivityDto>> listActivities(
		com.zshnb.ballplatform.request.backend.ListActivityRequest request) {
		Page<Activity> page = new Page<>(request.getPageNumber(), request.getPageSize());
		IPage<ActivityDto> activityIPage = activityMapper.findDtosByTheme(page, request.getTheme());
		return Response.ok(activityIPage.getRecords(), activityIPage.getTotal());
	}
}
