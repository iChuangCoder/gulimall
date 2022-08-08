package com.ichuang.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ichuang.common.utils.PageUtils;
import com.ichuang.gulimall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author iChuang
 * @email 963592390@qq.com
 * @date 2022-08-08 16:22:05
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

