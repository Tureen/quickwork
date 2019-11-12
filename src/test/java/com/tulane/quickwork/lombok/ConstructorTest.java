package com.tulane.quickwork.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @AllArgsConstructor
 * @NoArgsConstructor
 * @RequiredArgsContructor 找出不能为空的字段帮我们构造方法
 * Created by Tulane
 * 2019/11/10
 */
@AllArgsConstructor
@RequiredArgsConstructor
public class ConstructorTest {

    private final String field1;

    @NonNull
    private String field2;

    private String field3;
}
