package com.zshnb.ballplatform.controller.backend;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.Feedback;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.ICoachService;
import com.zshnb.ballplatform.service.inter.IFeedbackService;
import com.zshnb.ballplatform.validation.CoachValidation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/backend/feedback")
public class AdminFeedbackController {
	@Autowired
	private IFeedbackService feedbackService;

	@PostMapping("/list")
	public Response<List<Feedback>> list(@RequestBody ListCoachRequest request) {
		return Response.ok(feedbackService.listFeedbacks(request));
	}
}
