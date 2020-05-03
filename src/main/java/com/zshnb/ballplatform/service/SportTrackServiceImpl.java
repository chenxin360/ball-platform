package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportTrack;
import com.zshnb.ballplatform.mapper.SportTrackMapper;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.ISportTrackService;
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
public class SportTrackServiceImpl extends ServiceImpl<SportTrackMapper, SportTrack> implements ISportTrackService {

	@Override
	public void add(SportTrack sportTrack) {
		save(sportTrack);
	}

	@Override
	public Response<List<SportTrack>> list(PageRequest request) {
		Page<SportTrack> page = new Page<>(request.getPageNumber(), request.getPageSize());
		IPage<SportTrack> iPage = page(page);
		return Response.ok(iPage.getRecords(), iPage.getTotal());
	}
}
