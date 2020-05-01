package com.zshnb.ballplatform.controller.backend;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Coach;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.request.backend.ListCoachRequest;
import com.zshnb.ballplatform.request.backend.ListSportItemRequest;
import com.zshnb.ballplatform.service.inter.ICoachService;
import com.zshnb.ballplatform.service.inter.ISportItemService;
import com.zshnb.ballplatform.validation.CoachValidation;
import com.zshnb.ballplatform.validation.SportItemValidation;
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
@RequestMapping("/backend/sport-item")
public class AdminSportItemController {
	@Autowired
	private ISportItemService sportItemService;

	@Autowired
	private SportItemValidation sportItemValidation;

	@PostMapping("/add")
	public Response<String> add(@RequestBody SportItem item) {
		sportItemValidation.validate(item.getName());
		sportItemService.add(item);
		return Response.ok();
	}

	@PutMapping("/update")
	public Response<String> update(@RequestBody SportItem item) {
		SportItem old = sportItemService.getById(item.getId());
		if (!old.getName().equals(item.getName())) {
			sportItemValidation.validate(item.getName());
		}
		sportItemService.update(item);
		return Response.ok();
	}

	@DeleteMapping("/{id}")
	public Response<String> delete(@PathVariable int id) {
		sportItemService.delete(id);
		return Response.ok();
	}

	@GetMapping("/{id}")
	public Response<SportItem> detail(@PathVariable int id) {
		return Response.ok(sportItemService.detail(id));
	}

	@PostMapping("/list")
	public Response<List<SportItem>> list(@RequestBody ListSportItemRequest request) {
		return Response.ok(sportItemService.listSportItems(request));
	}
}
