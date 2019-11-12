package com.tulane.quickwork.guava;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Tulane
 * 2019/11/7
 */
public class OptionalTest {

    @Test
    public void test() throws Throwable {
        /**
         * 三种创建的方法
         */

        //创建空的Optional对象
        Optional.empty();

        //使用非null值创建
        Optional.of("tulane");

        //使用任意值创建
        Optional optional = Optional.ofNullable("tulane null");

        /**
         * 判断是否引用缺失 (建议不直接使用)
         */
        optional.isPresent();

        /**
         * 当optional引用存在时执行
         * 类似的方法: map filter flatMap
         */
        optional.ifPresent(System.out::println);

        optional.filter(x -> x.equals("tulane null")).ifPresent(System.out::println);

        /**
         * 当optional引用缺失时执行
         */
        optional.orElse("引用缺失");

        optional.orElseGet(() -> {
            // 自定义引用缺失时的返回值, 可使用任意返回类, 并做业务处理
            // Supplier接口 实现T get() 方法
            return 1L;
        });

        optional.orElseThrow(() -> {
            throw new RuntimeException("引用缺失异常");
        });
    }


    public static void stream(List<String> list){
//        list.forEach(System.out::println);

        //防止list空值
        Optional.ofNullable(list)
                .map(List::stream)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        stream(null);
    }
}
