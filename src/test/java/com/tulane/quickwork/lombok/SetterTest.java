package com.tulane.quickwork.lombok;

import lombok.AccessLevel;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by Tulane
 * 2019/11/9
 */
@Setter
public class SetterTest {

    private String field1;

    @Setter(
            value = AccessLevel.PRIVATE,
            onParam_={@NotNull}
    )
    private String field2;
}
