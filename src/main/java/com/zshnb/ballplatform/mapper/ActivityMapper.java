package com.zshnb.ballplatform.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshnb.ballplatform.dto.ActivityDto;
import com.zshnb.ballplatform.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public interface ActivityMapper extends BaseMapper<Activity> {
	List<ActivityDto> findDtosByTheme(Page<?> page, @Param("theme") String theme);
	ActivityDto findDtosById(int id);
}
