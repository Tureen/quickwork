package com.tulane.quickwork;

import java.util.function.Consumer;

/**
 * Created by Tulane
 * 2019/11/5
 */
public class App {

    /**
     * (args) -> ClassName.staticMethod(args);
     * ClassName::staticMethod
     */
    public void test1() {
        Consumer<String> consumer1 = (String number) -> Integer.parseInt(number);
        Consumer<String> consumer2 = Integer::parseInt;
    }

    /**
     * (args) -> args.instanceMethod();
     * ClassName::instanceMethod;
     */
    public void test2() {
        Consumer<String> consumer1 = (String str) -> str.length();
        Consumer<String> consumer2 = String::length;
    }

    /**
     * (args) -> object.instanceMethod(args);
     * object::instanceMethod;
     */
    public void test3() {
        StringBuilder stringBuilder = new StringBuilder();
        Consumer<String> consumer1 = (String str) -> stringBuilder.append(str);
        Consumer<String> consumer2 = stringBuilder::append;
    }
}
