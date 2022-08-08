package com.ichuang.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ichuang.common.utils.PageUtils;
import com.ichuang.gulimall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author iChuang
 * @email 963592390@qq.com
 * @date 2022-08-08 14:40:26
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

