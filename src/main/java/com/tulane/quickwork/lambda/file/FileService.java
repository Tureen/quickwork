package com.tulane.quickwork.lambda.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件服务类
 * Created by Tulane
 * 2019/11/6
 */
public class FileService {

    /**
     * 从过url获取本地文件内容，调用函数式接口处理
     *
     * @param url
     * @param fileConsumer
     */
    public void fileHandle(String url, FileConsumer fileConsumer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        //调用函数式接口方法, 将文件内容传递给lambda表达式, 实现逻辑
        fileConsumer.fileHandler(stringBuilder.toString());
    }
}
