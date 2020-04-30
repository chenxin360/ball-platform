package com.zshnb.ballplatform.service.inter;

import com.zshnb.ballplatform.entity.Companion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshnb.ballplatform.request.ListCompanionRequest;
import com.zshnb.ballplatform.request.UploadCompanionRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface ICompanionService extends IService<Companion> {
	void uploadCompanion(UploadCompanionRequest request);

	List<Companion> listCompanion(ListCompanionRequest request);
}
