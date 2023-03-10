package com.kuang.util;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.text.BasicTextEncryptor;

@Slf4j
public final class JasyptUtil {
    /**
     * 加密使用密钥
     */
    private static final String PRIVATE_KEY = "lybgeek";

    private static BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

    static {
        basicTextEncryptor.setPassword(PRIVATE_KEY);
    }

    /**
     * 私有构造方法，防止被意外实例化
     */
    private JasyptUtil() {
    }

    /**
     * 密码加密
     */
    public static String encrypt(String plaintext) {
//        log.info("明文字符串为：{}", plaintext);
        // 使用的加密算法参考2.2节内容，也可以在源码的类注释中看到
        String ciphertext = basicTextEncryptor.encrypt(plaintext);
//        log.info("密文字符串为：{}", ciphertext);
        return ciphertext;
    }

    /**
     * 解密密码
     */
    public static String decrypt(String ciphertext) {
//        log.info("密文字符串为：{}", ciphertext);
        ciphertext = "ENC(" + ciphertext + ")";
        if (PropertyValueEncryptionUtils.isEncryptedValue(ciphertext)) {
            String plaintext = PropertyValueEncryptionUtils.decrypt(ciphertext, basicTextEncryptor);
//            log.info("明文字符串为：{}", plaintext);
            return plaintext;
        }
//        log.error("解密失败！");
        return "";
    }

    /**
     * 校验密码是否正确
     */
    public static boolean checkCrypt(String plaintext,String ciphertext) {
        return plaintext.equals(decrypt(ciphertext));
    }
}
