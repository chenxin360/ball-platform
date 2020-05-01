package com.zshnb.ballplatform.controller.backend;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.service.inter.ICoachService;
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
@RequestMapping("/backend/coach")
public class AdminCoachController {
	@Autowired
	private ICoachService coachService;

	@Autowired
	private CoachValidation coachValidation;

	@PostMapping("/add")
	public Response<String> add(@RequestBody Coach coach) {
		coachValidation.validate(coach.getName());
		coachService.add(coach);
		return Response.ok();
	}

	@PutMapping("/update")
	public Response<String> update(@RequestBody Coach coach) {
		Coach old = coachService.getById(coach.getId());
		if (!old.getName().equals(coach.getName())) {
			coachValidation.validate(coach.getName());
		}
		coachService.update(coach);
		return Response.ok();
	}

	@DeleteMapping("/{id}")
	public Response<String> delete(@PathVariable int id) {
		coachService.delete(id);
		return Response.ok();
	}

	@GetMapping("/{id}")
	public Response<Coach> detail(@PathVariable int id) {
		return Response.ok(coachService.detail(id));
	}

	@PostMapping("/list")
	public Response<List<Coach>> list(@RequestBody ListCoachRequest request) {
		return Response.ok(coachService.listCoaches(request));
	}
}
