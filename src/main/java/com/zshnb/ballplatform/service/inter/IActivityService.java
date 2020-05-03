package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.dto.ActivityDto;
import com.zshnb.ballplatform.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.request.ListActivityRequest;
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
public interface IActivityService extends IService<Activity> {
	Response<List<Activity>> listActivities(ListActivityRequest request);

	void add(Activity activity);

	void update(Activity activity);

	ActivityDto detail(int id);

	void delete(int id);

	Response<List<ActivityDto>> listActivities(com.zshnb.ballplatform.request.backend.ListActivityRequest request);
}
