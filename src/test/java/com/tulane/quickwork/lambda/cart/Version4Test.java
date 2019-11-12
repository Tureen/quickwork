package com.tulane.quickwork.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tulane
 * 2019/11/5
 */
public class Version4Test {

    @Test
    public void filterSkusByCategory(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkus(
                cartSkuList, new SkuBooksCategoryPredicate());

        System.out.println(JSON.toJSONString(result, true));
    }
}
