package com.tulane.quickwork.lambda.cart;

/**
 * Sku选择谓词接口
 * Created by Tulane
 * 2019/11/5
 */
public interface SkuPredicate {

    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);
}
