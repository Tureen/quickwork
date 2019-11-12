package com.tulane.quickwork.stream;

import com.alibaba.fastjson.JSON;
import com.tulane.quickwork.lambda.cart.CartService;
import com.tulane.quickwork.lambda.cart.Sku;
import com.tulane.quickwork.lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 对比: 原始集合操作与Stream集合操作
 * Created by Tulane
 * 2019/11/6
 */
public class StreamVs {

    /**
     * 1. 想看看购物车中都有什么商品
     * 2. 图书类商品都买
     * 3. 其余的商品买两件最贵的
     * 4. 只需要两件商品的名称和总价
     */

    /**
     * 原始
     */
    @Test
    public void oldCartHandle() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        /**
         * 1 打印所有
         */
        for (Sku sku : cartSkuList) {
            System.out.println(JSON.toJSONString(sku, true));
        }

        /**
         * 2 图书类过滤
         */
        List<Sku> notBooksSkuList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())) {
                notBooksSkuList.add(sku);
            }
        }

        notBooksSkuList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
                if (o1.getTotalPrice() > o2.getTotalPrice()) {
                    return -1;
                } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        /**
         * TOP2
         */
        List<Sku> top2SkuList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            top2SkuList.add(notBooksSkuList.get(i));
        }

        /**
         * 求总价
         */
        Double money = 0.0;
        for (Sku sku : top2SkuList) {
            money += sku.getTotalPrice();
        }

        /**
         * 获取两件商品名称
         */
        List<String> resultSkuNameList = new ArrayList<>();
        for (Sku sku : top2SkuList) {
            resultSkuNameList.add(sku.getSkuName());
        }

        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价: " + money);
    }

    /**
     * Stream流
     */
    @Test
    public void newCartHandle() {
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> resultSkuNameList = CartService.getCartSkuList()
                .stream()
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .limit(2)
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                .map(sku -> sku.getSkuName())
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价: " + money);
    }
}
