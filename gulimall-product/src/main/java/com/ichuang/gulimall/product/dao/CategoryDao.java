package com.ichuang.gulimall.product.dao;

import com.ichuang.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author iChuang
 * @email 963592390@qq.com
 * @date 2022-04-21 12:59:12
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
