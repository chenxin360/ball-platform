package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Coach;
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
public interface ICoachService extends IService<Coach> {
	void add(Coach coach);

	void update(Coach coach);

	Coach detail(int id);

	void delete(int id);

	Response<List<Coach>> listCoaches(ListCoachRequest request);

	Response<List<Coach>> listCoaches(com.zshnb.ballplatform.request.ListCoachRequest request);
}
