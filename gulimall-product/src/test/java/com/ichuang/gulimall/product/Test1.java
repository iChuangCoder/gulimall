package com.ichuang.gulimall.product;

import com.ichuang.gulimall.product.entity.BrandEntity;
import com.ichuang.gulimall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {


    @Autowired
    BrandService brandService;

    @Test
    public void t1() {
        BrandEntity brand = new BrandEntity();
        brand.setDescript("华为");
        brand.setName("HuaWei");
        brandService.save(brand);
        System.out.println(brand.getBrandId());
    }

}
