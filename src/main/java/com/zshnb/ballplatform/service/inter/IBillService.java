package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.common.Response;
import com.zshnb.ballplatform.entity.Bill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.AddBillRequest;
import com.zshnb.ballplatform.request.ListBillRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface IBillService extends IService<Bill> {
	double addBill(AddBillRequest request);

	Response<List<Bill>> listBill(ListBillRequest request);
}
