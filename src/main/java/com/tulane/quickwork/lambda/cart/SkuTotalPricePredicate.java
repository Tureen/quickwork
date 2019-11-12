package com.tulane.quickwork.lambda.cart;

/**
 * 对Sku的总价是否超过2000作为判断标准
 * Created by Tulane
 * 2019/11/5
 */
public class SkuTotalPricePredicate implements SkuPredicate{

    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}
