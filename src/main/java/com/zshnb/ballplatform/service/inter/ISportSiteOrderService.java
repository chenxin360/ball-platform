package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportSiteOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.AddSportSiteOrderRequest;
import com.zshnb.ballplatform.request.PageRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface ISportSiteOrderService extends IService<SportSiteOrder> {
	Response<List<SportSiteOrder>> listOrders(PageRequest request);

	void cancel(int id);

	void add(AddSportSiteOrderRequest request);
}
