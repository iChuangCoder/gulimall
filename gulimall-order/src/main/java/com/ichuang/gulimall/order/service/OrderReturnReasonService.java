package com.ichuang.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ichuang.common.utils.PageUtils;
import com.ichuang.gulimall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * ้่ดงๅๅ 
 *
 * @author iChuang
 * @email 963592390@qq.com
 * @date 2022-08-08 14:40:26
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

