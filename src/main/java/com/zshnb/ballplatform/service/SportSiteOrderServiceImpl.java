package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportSiteOrder;
import com.zshnb.ballplatform.mapper.SportSiteOrderMapper;
import com.zshnb.ballplatform.request.AddSportSiteOrderRequest;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.ISportSiteOrderService;
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
public class SportSiteOrderServiceImpl extends ServiceImpl<SportSiteOrderMapper, SportSiteOrder> implements ISportSiteOrderService {

	@Override
	public Response<List<SportSiteOrder>> listOrders(PageRequest request) {
		Page<SportSiteOrder> page = new Page<>(request.getPageNumber(), request.getPageSize());
		IPage<SportSiteOrder> iPage = page(page);
		return Response.ok(iPage.getRecords(), iPage.getTotal());
	}

	@Override
	public void cancel(int id) {
		SportSiteOrder sportSiteOrder = getById(id);
		sportSiteOrder.setDeleted(1);
		updateById(sportSiteOrder);
	}

	@Override
	public void add(AddSportSiteOrderRequest request) {
		SportSiteOrder sportSiteOrder = new SportSiteOrder();
		sportSiteOrder.setDeleted(0);
		BeanUtils.copyProperties(request, sportSiteOrder);
		save(sportSiteOrder);
	}
}
