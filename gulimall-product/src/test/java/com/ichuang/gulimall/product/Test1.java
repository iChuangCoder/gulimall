package com.ichuang.gulimall.product;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.ichuang.gulimall.product.entity.BrandEntity;
import com.ichuang.gulimall.product.entity.CategoryEntity;
import com.ichuang.gulimall.product.service.BrandService;
import com.ichuang.gulimall.product.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {


    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;    // 分类

    @Test
    public void t1() {
        List<CategoryEntity> list = categoryService.list();
        System.out.println(list.size());
        List<Object> collect = list.stream().filter(categoryEntity -> categoryEntity.getCatLevel() == 1).map(
                categoryEntity -> {
                    categoryEntity.setChildren(getCateGoryChildren(categoryEntity, list));
                    return categoryEntity;
                }
        ).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }


    private List<CategoryEntity> getCateGoryChildren(CategoryEntity category, List<CategoryEntity> list) {
        return list.stream().filter(c -> category.getCatId() == c.getParentCid())
                .map(c -> {
                    c.setChildren(getCateGoryChildren(c, list));
                    return c;
                }).sorted((c1, c2) -> (c1.getSort() == null || c2.getSort() == null) ? 0 : c1.getSort() - c2.getSort()).collect(Collectors.toList());
    }

}
