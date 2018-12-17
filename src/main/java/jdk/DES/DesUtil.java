package jdk.DES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * DES加密 解密算法
 *
 * @author Fangjs
 * @date 2017-03-16
 */
public class DesUtil {

    private final static String DES = "DES";
    private final static String ENCODE = "UTF-8";
    private final static String defaultKey = "gddxbdhp";//8字节key长度

    /**
     * 使用 默认key加密
     */
    public static String encrypt(String express) throws Exception {
        if (express == null) return null;
        byte[] bCiphertext = encrypt(express.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String ciphertext = new sun.misc.BASE64Encoder().encode(bCiphertext);
        return ciphertext;//返回密文
    }

    /**
     * 使用 默认key 解密
     */
    public static String decrypt(String ciphertext) throws IOException, Exception {
        if (ciphertext == null) return null;
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(ciphertext);
        byte[] bExpress = decrypt(buf, defaultKey.getBytes(ENCODE));
        return new String(bExpress, ENCODE);//返回明文
    }

    /**
     * Description 根据键值进行加密
     * @param express
     * @param key 加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String express, String key) throws Exception {
        if (express == null) return null;
        byte[] bCiphertext = encrypt(express.getBytes(ENCODE), key.getBytes(ENCODE));
        String ciphertext = new sun.misc.BASE64Encoder().encode(bCiphertext);
        return ciphertext;//返回密文
    }

    /**
     * Description 根据键值进行解密
     * @param ciphertext
     * @param key 加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String ciphertext, String key) throws IOException, Exception {
        if (ciphertext == null) return null;
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(ciphertext);
        byte[] bExpress = decrypt(buf, key.getBytes(ENCODE));
        return new String(bExpress, ENCODE);
    }

    /**
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }


    public static void main(String[] args) throws Exception {
        String express = "hz15AccessUser";  //hz15AccessUser hz15Password
        String ciphertext=encrypt(express,defaultKey);
        System.out.println(ciphertext);
        String rexpress=decrypt(ciphertext,defaultKey);
        System.out.println(express);
    }

}
