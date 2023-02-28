package com.kuang.utils;

import com.kuang.pojo.Song;
import org.junit.jupiter.api.Test;

import static com.kuang.utils.KuwoAPI.searchSongListApi;

class KuwoAPITest {

    @Test
    void testApiTest() {
        for (Song song : searchSongListApi("b","1")) {
            System.err.println(song);
        }
    }
}