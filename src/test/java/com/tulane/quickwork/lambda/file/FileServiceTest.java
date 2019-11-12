package com.tulane.quickwork.lambda.file;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Tulane
 * 2019/11/6
 */
public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();
        //通过lambda表达式, 打印文件内容
        fileService.fileHandle("/Users/Tulane/项目/Github/quickwork/src/test/java/com/tulane/quickwork/lambda/file/FileServiceTest.java",
                fileContent -> System.out.println(fileContent));
    }
}
