package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.mapper.SportItemMapper;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.request.backend.ListSportItemRequest;
import com.zshnb.ballplatform.service.inter.ISportItemService;
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
public class SportItemServiceImpl extends ServiceImpl<SportItemMapper, SportItem> implements ISportItemService {

	public void add(SportItem item) {
		save(item);
	}

	@Override
	public void update(SportItem item) {
		updateById(item);
	}

	@Override
	public SportItem detail(int id) {
		return getById(id);
	}

	@Override
	public void delete(int id) {
		getBaseMapper().deleteById(id);
	}

	@Override
	public List<SportItem> listSportItems(ListSportItemRequest request) {
		QueryWrapper<SportItem> wrapper = new QueryWrapper<>();
		if (!request.getName().isEmpty()) {
			wrapper.eq("name", request.getName());
		}
		Page<SportItem> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return page(page, wrapper).getRecords();
	}
}
