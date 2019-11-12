package com.tulane.quickwork.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基于JDK7之后, 实现正确关闭流资源方式
 * try - with - resource
 * Created by Tulane
 * 2019/11/7
 */
public class NewFileCopyTest {

    @Test
    public void copyFile() {

        // 先定义输入/输出路径
        String originalUrl = "lib/NewFileCopyTest.java";
        String targetUrl = "targetTest/new.txt";

        //初始化输入/输出流对象
        try (
                FileInputStream originalFileInputStream =
                        new FileInputStream(originalUrl);

                FileOutputStream targetFileOutputStream =
                        new FileOutputStream(targetUrl);
        ) {
            int content;
            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutputStream.write(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
