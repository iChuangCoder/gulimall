package com.ichuang.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ichuang.common.utils.PageUtils;
import com.ichuang.gulimall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author iChuang
 * @email 963592390@qq.com
 * @date 2022-08-08 16:14:58
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

