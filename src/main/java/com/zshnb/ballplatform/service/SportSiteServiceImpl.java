package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.entity.SportSite;
import com.zshnb.ballplatform.mapper.SportSiteMapper;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.request.backend.ListSportItemRequest;
import com.zshnb.ballplatform.request.backend.ListSportSiteRequest;
import com.zshnb.ballplatform.service.inter.ISportSiteService;
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
public class SportSiteServiceImpl extends ServiceImpl<SportSiteMapper, SportSite> implements ISportSiteService {

	public void add(SportSite site) {
		save(site);
	}

	@Override
	public void update(SportSite site) {
		updateById(site);
	}

	@Override
	public SportSite detail(int id) {
		return getById(id);
	}

	@Override
	public void delete(int id) {
		getBaseMapper().deleteById(id);
	}

	@Override
	public List<SportSite> listSportSites(ListSportSiteRequest request) {
		QueryWrapper<SportSite> wrapper = new QueryWrapper<>();
		if (!request.getName().isEmpty()) {
			wrapper.eq("name", request.getName());
		}
		Page<SportSite> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return page(page, wrapper).getRecords();
	}

	@Override
	public List<SportSite> listSportSites(com.zshnb.ballplatform.request.ListSportSiteRequest request) {
		QueryWrapper<SportSite> wrapper = new QueryWrapper<>();
		if (!request.getName().isEmpty()) {
			wrapper.eq("name", request.getName());
		}
		wrapper.between("person_count", request.getMinPersonCount(), request.getMaxPersonCount());
		wrapper.le("end_at", request.getEndAt());
		wrapper.ge("start_at", request.getStartAt());
		Page<SportSite> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return page(page, wrapper).getRecords();
	}
}
