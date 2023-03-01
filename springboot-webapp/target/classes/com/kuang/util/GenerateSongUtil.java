package com.kuang.util;

import com.kuang.config.MyConfig;
import com.kuang.exception.GenerateSongException;

import java.io.File;
import java.io.FileWriter;

public class GenerateSongUtil {
    public static void generateSongFile(String rid) throws GenerateSongException {
        MyConfig myConfig = new MyConfig();
        String filePath = myConfig.getDownloadSongAddress() + rid + ".mp3";
        String content = "a false song";
        FileWriter fw = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(filePath);
            fw.write(content);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenerateSongException(e);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}