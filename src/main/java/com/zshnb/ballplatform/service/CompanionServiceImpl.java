package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Companion;
import com.zshnb.ballplatform.mapper.CompanionMapper;
import com.zshnb.ballplatform.request.ListCompanionRequest;
import com.zshnb.ballplatform.request.UploadCompanionRequest;
import com.zshnb.ballplatform.service.inter.ICompanionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
@Service
public class CompanionServiceImpl extends ServiceImpl<CompanionMapper, Companion> implements ICompanionService {
	@Autowired
	private CompanionMapper companionMapper;

	@Override
	public void uploadCompanion(UploadCompanionRequest request) {
		Companion companion = new Companion();
		BeanUtils.copyProperties(request, companion);
		save(companion);
	}

	@Override
	public Response<List<Companion>> listCompanion(ListCompanionRequest request) {
		QueryWrapper<Companion> wrapper = new QueryWrapper<>();
		wrapper.eq("user_id", request.getUserId());
		if (request.getSportItemId() != 0) {
			wrapper.eq("sport_item_id", request.getSportItemId());
		}
		if (!request.getSex().isEmpty()) {
			wrapper.eq("sex", request.getSex());
		}
		if (!request.getSportLevel().isEmpty()) {
			wrapper.and(i -> i.eq("sport_level", request.getSportLevel()));
		}
		wrapper.and(i -> i.between("time", request.getStartAt(), request.getEndAt()));
		Page<Companion> page = new Page<>(request.getPageNumber(), request.getPageSize());
		IPage<Companion> iPage = page(page, wrapper);
		return Response.ok(iPage.getRecords(), iPage.getTotal());
	}

	@Override
	public void deleteCompanion(Integer id) {
		companionMapper.deleteById(id);
	}
}
