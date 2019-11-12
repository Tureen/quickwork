package com.tulane.quickwork.lombok;

import lombok.NonNull;

/**
 * Created by Tulane
 * 2019/11/10
 */
public class NonNullTest {

    public NonNullTest(@NonNull String field){
        System.out.println(field);
    }
}
