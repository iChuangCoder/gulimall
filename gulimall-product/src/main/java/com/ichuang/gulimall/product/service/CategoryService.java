package com.ichuang.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ichuang.common.utils.PageUtils;
import com.ichuang.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author iChuang
 * @email 963592390@qq.com
 * @date 2022-04-21 12:59:12
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> getTreeList();
}

