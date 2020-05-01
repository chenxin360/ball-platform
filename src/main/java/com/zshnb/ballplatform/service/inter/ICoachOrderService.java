package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.CoachOrder;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface ICoachOrderService extends IService<CoachOrder> {
	List<CoachOrder> listOrders(PageRequest request);
}
