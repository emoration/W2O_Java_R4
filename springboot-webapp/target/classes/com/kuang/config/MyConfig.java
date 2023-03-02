package com.kuang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义的配置，可以在application.yml中修改
 */
@Component
public class MyConfig {
    @Value("${my.config.searchFromTrueKuwoApiOrFalseDatabase}")
    private int searchFromTrueKuwoApiOrFalseDatabase = 0;


    public boolean isSearchFromTrueKuwoApiOrFalseDatabase() {
        return searchFromTrueKuwoApiOrFalseDatabase == 0;
    }

    @Value("${my.config.addApiSearchResultToDatabase}")
    private int addApiSearchResultToDatabase = 1;

    public boolean isAddApiSearchResultToDatabase() {
        return addApiSearchResultToDatabase == 1;
    }

    @Value("${my.config.downloadSongAddress}")
    private String downloadSongAddress = "";

    public String getDownloadSongAddress() {
        if ("".equals(downloadSongAddress)) {
            return System.getProperty("user.dir") + "\\songs\\";
        }
        return downloadSongAddress;
    }

    @Value("${my.config.generateSongFile}")
    private int generateSongFile = 1;

    public boolean isGenerateSongFile() {
        return generateSongFile == 1;
    }


    @Value("${my.config.recordNumberPerPage}")
    private int recordNumberPerPage = 10;

    public int getRecordNumberPerPage() {
        return recordNumberPerPage == 0 ? 10 : recordNumberPerPage;
    }
}
