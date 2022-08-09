package com.ichuang.gulimall.product.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ichuang.common.utils.PageUtils;
import com.ichuang.common.utils.Query;

import com.ichuang.gulimall.product.dao.CategoryDao;
import com.ichuang.gulimall.product.entity.CategoryEntity;
import com.ichuang.gulimall.product.service.CategoryService;


@Service("categoryService")
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询分类树
     */
    @Override
    public List<CategoryEntity> getTreeList() {
        List<CategoryEntity> list = list();
        //peek接收一个没有返回值的λ表达式，可以做一些输出，外部处理等。
        // map接收一个有返回值的λ表达式，之后Stream的泛型类型将转换为map参数λ表达式返回的类型
        List<CategoryEntity> res = list.stream().filter(categoryEntity -> categoryEntity.getCatLevel() == 1).peek(
                categoryEntity -> categoryEntity.setChildren(getCateGoryChildren(categoryEntity, list))
        ).collect(Collectors.toList());
        log.info("查询分类树成功，共{}个一级分类，{}个分类。",res.size(),list.size());
        return res;
    }

    private List<CategoryEntity> getCateGoryChildren(CategoryEntity category, List<CategoryEntity> list) {
        return list.stream()
                .filter(c -> Objects.equals(category.getCatId(), c.getParentCid()))
                .peek(c -> c.setChildren(getCateGoryChildren(c, list)))
                .sorted((c1, c2) -> (c1.getSort() == null || c2.getSort() == null) ? 0 : c1.getSort() - c2.getSort()).collect(Collectors.toList());
    }

}
