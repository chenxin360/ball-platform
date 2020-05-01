package com.zshnb.ballplatform.validation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.service.inter.ICoachService;
import com.zshnb.ballplatform.service.inter.ISportItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SportItemValidation {
	@Autowired
	private ISportItemService sportItemService;

	public void validate(String name) {
		QueryWrapper<SportItem> wrapper = new QueryWrapper<>();
		wrapper.eq("name", name);
		SportItem coach = sportItemService.getOne(wrapper);
		Assert.isNull(coach, "运动项目已存在");
	}
}
