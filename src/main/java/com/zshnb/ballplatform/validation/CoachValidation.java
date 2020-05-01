package com.zshnb.ballplatform.validation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.mapper.CoachMapper;
import com.zshnb.ballplatform.service.inter.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CoachValidation {
	@Autowired
	private ICoachService coachService;

	public void validate(String name) {
		QueryWrapper<Coach> wrapper = new QueryWrapper<>();
		wrapper.eq("name", name);
		Coach coach = coachService.getOne(wrapper);
		Assert.isNull(coach, "教练已存在");
	}
}
