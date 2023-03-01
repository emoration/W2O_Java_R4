package com.kuang.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateSong {
    public static int writeFile(String fileName, byte[] content) {
        System.err.println("开始写文件:[" + fileName + "]");
        File file = new File(fileName);
        File fileparent = file.getParentFile();
        if (!fileparent.exists()) {
            System.err.println("文件夹不存在，创建该目录");
            fileparent.mkdirs();
        }
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(fileName);
            os.write(content);
            os.flush();
        } catch (Exception e) {
            System.err.println("写文件:[" + fileName + "]异常，异常信息为:[" + e.getMessage() + "]");
            return -1;
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ignored) {
            }
        }
        System.err.println("写文件:[" + fileName + "]完成!");
        return 0;
    }
}