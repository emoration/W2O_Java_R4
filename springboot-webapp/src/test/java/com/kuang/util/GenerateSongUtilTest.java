package com.kuang.util;

import com.kuang.exception.GenerateSongException;
import org.junit.jupiter.api.Test;

class GenerateSongUtilTest {

    @Test
    void writeFile() throws GenerateSongException {
        GenerateSongUtil.generateSongFile("123456");
    }
}