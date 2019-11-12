package com.tulane.quickwork.lambda.cart;

/**
 * 对Sku的商品类型为图书类的判断标准
 * Created by Tulane
 * 2019/11/5
 */
public class SkuBooksCategoryPredicate implements SkuPredicate{

    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}
