package com.tulane.quickwork.lombok;

import lombok.ToString;

/**
 * Created by Tulane
 * 2019/11/9
 */
@ToString(
        includeFieldNames = false,
        // 关闭则会在输出属性时调用它的get方法作为输出
        doNotUseGetters = false
)
public class ToStringTest {

    private String field1;

    private String field2;
}
