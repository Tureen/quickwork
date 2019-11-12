package com.tulane.quickwork.lombok;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * Created by Tulane
 * 2019/11/9
 */
public class GetterTest {

    @Getter(
            lazy = true
    )
    private final String field1 = "tulane";

    @Getter(
            value = AccessLevel.PRIVATE,
            onMethod_ = {@NotNull}
    )
    private String field2;
}
