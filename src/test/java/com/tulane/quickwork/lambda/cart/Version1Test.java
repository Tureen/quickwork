package com.tulane.quickwork.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tulane
 * 2019/11/5
 */
public class Version1Test {

    @Test
    public void filterElectronicsSkus(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterElectronicsSkus(cartSkuList);

        System.out.println(JSON.toJSONString(result, true));
    }
}
