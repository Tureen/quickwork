package com.tulane.quickwork.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tulane
 * 2019/11/5
 */
public class Version2Test {

    @Test
    public void filterSkusByCategory(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterSkusByCategory(cartSkuList, SkuCategoryEnum.BOOKS);
        System.out.println(JSON.toJSONString(result, true));
    }
}
