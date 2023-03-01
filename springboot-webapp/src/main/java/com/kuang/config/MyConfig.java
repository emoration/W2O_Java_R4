package com.kuang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {
    @Value("${my.config.searchFromTrueKuwoApiOrFalseDatabase}")
    private int searchFromTrueKuwoApiOrFalseDatabase = 0;

    @Value("${my.config.addApiSearchResultToDatabase}")
    private int addApiSearchResultToDatabase = 1;

    public boolean isSearchFromTrueKuwoApiOrFalseDatabase() {
        System.err.println("searchFromTrueKuwoApiOrFalseDatabase:" + searchFromTrueKuwoApiOrFalseDatabase);
        return searchFromTrueKuwoApiOrFalseDatabase == 0;
    }

    public boolean isAddApiSearchResultToDatabase() {
        return addApiSearchResultToDatabase == 1;
    }

}
