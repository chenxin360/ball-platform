package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
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
	void add(Coach coach);

	void update(Coach coach);

	Coach detail(int id);

	void delete(int id);

	List<Coach> listCoaches(ListCoachRequest request);

}
