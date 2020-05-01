package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.mapper.CoachMapper;
import com.zshnb.ballplatform.request.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.ICoachService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.BeanUtils;
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
	public List<Coach> listCoaches(ListCoachRequest request) {
		QueryWrapper<Coach> wrapper = new QueryWrapper<>();
		if (!request.getName().isEmpty()) {
			wrapper.eq("name", request.getName());
		}
		Page<Coach> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return page(page, wrapper).getRecords();
	}


}
