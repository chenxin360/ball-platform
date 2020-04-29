package com.zshnb.ballplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.entity.Bill;
import com.zshnb.ballplatform.entity.User;
import com.zshnb.ballplatform.mapper.BillMapper;
import com.zshnb.ballplatform.mapper.UserMapper;
import com.zshnb.ballplatform.request.AddBillRequest;
import com.zshnb.ballplatform.request.ListBillRequest;
import com.zshnb.ballplatform.service.inter.IBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public double addBill(AddBillRequest request) {
		User user = userMapper.selectById(request.getUserId());
		Bill bill = new Bill();
		bill.setPrice(request.getPrice());
		bill.setUserId(user.getId());
		bill.setMoney(user.getMoney() + request.getPrice());
		bill.setTime(LocalDateTime.now());
		save(bill);

		user.setMoney(user.getMoney() + request.getPrice());
		userMapper.updateById(user);
		return bill.getMoney();
	}

	@Override
	public List<Bill> listBill(ListBillRequest request) {
		QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", request.getUserId());
		Page<Bill> page = new Page<>(request.getPageNumber(), request.getPageSize());
		return page(page, queryWrapper).getRecords();
	}


}
