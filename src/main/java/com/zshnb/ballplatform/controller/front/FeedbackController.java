package com.zshnb.ballplatform.controller.front;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Feedback;
import com.zshnb.ballplatform.service.inter.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zsh
 * @since 2020-04-27
 */
@RestController
@RequestMapping("/front/feedback")
public class FeedbackController {
	@Autowired
	private IFeedbackService feedbackService;

	@PostMapping("/add")
	public Response<String> add(@RequestBody Feedback feedback) {
		feedbackService.add(feedback);
		return Response.ok();
	}
}
