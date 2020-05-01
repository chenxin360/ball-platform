package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportSite;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.request.backend.ListSportSiteRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface ISportSiteService extends IService<SportSite> {
	void add(SportSite site);

	void update(SportSite site);

	SportSite detail(int id);

	void delete(int id);

	List<SportSite> listSportSites(ListSportSiteRequest request);

	List<SportSite> listSportSites(com.zshnb.ballplatform.request.ListSportSiteRequest request);
}
