package com.zshnb.ballplatform.validation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.entity.SportSite;
import com.zshnb.ballplatform.service.inter.ISportItemService;
import com.zshnb.ballplatform.service.inter.ISportSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SportSiteValidation {
	@Autowired
	private ISportSiteService sportSiteService;

	public void validate(String name) {
		QueryWrapper<SportSite> wrapper = new QueryWrapper<>();
		wrapper.eq("name", name);
		SportSite coach = sportSiteService.getOne(wrapper);
		Assert.isNull(coach, "运动项目已存在");
	}
}
