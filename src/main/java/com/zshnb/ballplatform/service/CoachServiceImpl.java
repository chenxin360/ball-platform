package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.mapper.CoachMapper;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.ICoachService;
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
public class CoachServiceImpl extends ServiceImpl<CoachMapper, Coach> implements ICoachService {
	public void add(Coach coach) {
		save(coach);
	}

	@Override
	public void update(Coach coach) {
		updateById(coach);
	}

	@Override
	public Coach detail(int id) {
		return getById(id);
	}

	@Override
	public void delete(int id) {
		getBaseMapper().deleteById(id);
	}

	@Override
	public Response<List<Coach>> listCoaches(ListCoachRequest request) {
		QueryWrapper<Coach> wrapper = new QueryWrapper<>();
		if (!request.getName().isEmpty()) {
			wrapper.eq("name", request.getName());
		}
		Page<Coach> page = new Page<>(request.getPageNumber(), request.getPageSize());
		IPage<Coach> iPage = page(page, wrapper);
		return Response.ok(iPage.getRecords(), iPage.getTotal());
	}

	@Override
	public Response<List<Coach>> listCoaches(com.zshnb.ballplatform.request.ListCoachRequest request) {
		QueryWrapper<Coach> wrapper = new QueryWrapper<>();
		if (request.getSportItemId() != 0) {
			wrapper.eq("sport_item_id", request.getSportItemId());
		}
		if (!request.getSportLevel().isEmpty()) {
			wrapper.eq("sport_level", request.getSportLevel());
		}
		wrapper.between("price", request.getMinPrice(), request.getMaxPrice());
		Page<Coach> page = new Page<>(request.getPageNumber(), request.getPageSize());
		IPage<Coach> iPage = page(page, wrapper);
		return Response.ok(iPage.getRecords(), iPage.getTotal());
	}
}
