package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.entity.CoachOrder;
import com.zshnb.ballplatform.mapper.CoachOrderMapper;
import com.zshnb.ballplatform.request.PageRequest;
import com.zshnb.ballplatform.service.inter.ICoachOrderService;
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
public class CoachOrderServiceImpl extends ServiceImpl<CoachOrderMapper, CoachOrder> implements ICoachOrderService {

	@Override
	public List<CoachOrder> listOrders(PageRequest request) {
		Page<CoachOrder> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return page(page).getRecords();
	}
}
