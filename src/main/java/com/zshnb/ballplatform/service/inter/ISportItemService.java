package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.request.backend.ListSportItemRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface ISportItemService extends IService<SportItem> {
	void add(SportItem item);

	void update(SportItem item);

	SportItem detail(int id);

	void delete(int id);

	List<SportItem> listSportItems(ListSportItemRequest request);

}
