package com.kuang.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JasyptUtilTest {

    @Test
    public void testEncrypt(){
        String plainText = "Glrs@1234";
        String ciperText = JasyptUtil.encrypt(plainText);
        log.info("加密后的密文为：{}", ciperText);
    }

    @Test
    public void testDecrypt(){
        String ciperText = "KZeGx0ixuy4UrBp1HuhiDNnKB0cJr0cW";
        String plainText = JasyptUtil.decrypt(ciperText);
        log.info("解密后的明文为：{}", plainText);
    }

    @Test
    public void test(){
        String plainText = "Glrs@1234";
        String ciperText = JasyptUtil.encrypt(plainText);
        log.info("加密后的密文为：{}", ciperText);
        log.info("解密后的明文为：{}", JasyptUtil.decrypt(ciperText));;
    }
}
