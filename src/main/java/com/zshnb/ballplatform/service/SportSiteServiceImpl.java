package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportSite;
import com.zshnb.ballplatform.mapper.SportSiteMapper;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
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

	@Override
	public void add(Coach coach) {

	}

	@Override
	public void update(Coach coach) {

	}

	@Override
	public Coach detail(int id) {
		return null;
	}

	@Override
	public void delete(int id) {

	}

	@Override
	public List<Coach> listCoaches(ListCoachRequest request) {
		return null;
	}
}
