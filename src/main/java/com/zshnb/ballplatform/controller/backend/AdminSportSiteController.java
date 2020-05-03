package com.zshnb.ballplatform.controller.backend;


import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.SportItem;
import com.zshnb.ballplatform.entity.SportSite;
import com.zshnb.ballplatform.request.backend.ListSportItemRequest;
import com.zshnb.ballplatform.request.backend.ListSportSiteRequest;
import com.zshnb.ballplatform.service.inter.ISportItemService;
import com.zshnb.ballplatform.service.inter.ISportSiteService;
import com.zshnb.ballplatform.validation.SportItemValidation;
import com.zshnb.ballplatform.validation.SportSiteValidation;
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
@RequestMapping("/backend/sport-site")
public class AdminSportSiteController {
	@Autowired
	private ISportSiteService sportSiteService;

	@Autowired
	private SportSiteValidation sportSiteValidation;

	@PostMapping("/add")
	public Response<String> add(@RequestBody SportSite site) {
		sportSiteValidation.validate(site.getName());
		sportSiteService.add(site);
		return Response.ok();
	}

	@PutMapping("/update")
	public Response<String> update(@RequestBody SportSite site) {
		SportSite old = sportSiteService.getById(site.getId());
		if (!old.getName().equals(site.getName())) {
			sportSiteValidation.validate(site.getName());
		}
		sportSiteService.update(site);
		return Response.ok();
	}

	@DeleteMapping("/{id}")
	public Response<String> delete(@PathVariable int id) {
		sportSiteService.delete(id);
		return Response.ok();
	}

	@GetMapping("/{id}")
	public Response<SportSite> detail(@PathVariable int id) {
		return Response.ok(sportSiteService.detail(id));
	}

	@PostMapping("/list")
	public Response<List<SportSite>> list(@RequestBody ListSportSiteRequest request) {
		return sportSiteService.listSportSites(request);
	}
}
