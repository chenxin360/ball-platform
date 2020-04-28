package com.zshnb.ballplatform.service;

import com.zshnb.ballplatform.entity.Bill;
import com.zshnb.ballplatform.mapper.BillMapper;
import com.zshnb.ballplatform.service.inter.IBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {

}
