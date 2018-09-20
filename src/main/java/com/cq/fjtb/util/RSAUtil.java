package com.cq.fjtb.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

/**
 * @Author Celine Q
 * @Create 20/09/2018 4:44 PM
 **/
public class RSAUtil {
    //指定加密算法为RSA
    private static String ALGORITHM = "RSA";
    //指定key的大小
    private static int KEYSIZE = 1024;
    //指定公钥存放文件和私钥存放文件
    private static String PUBLIC_KEY_FILE = "applog/public.key";
    private static String PRIVATE_KEY_FILE = "applog/private.key";

    //生成公钥和私钥并分别存放在文件中
    private static void generateKeyPair() throws Exception{
        //生成密钥对
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
        kpg.initialize(KEYSIZE, new SecureRandom());
        KeyPair kp = kpg.generateKeyPair();
        //通过密钥对分别得到公钥和私钥
        Key publicKey = kp.getPublic();
        Key privateKey = kp.getPrivate();
        //将生成的密钥写入文件
        ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        ObjectOutputStream output2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
        output1.writeObject(publicKey);
        output2.writeObject(privateKey);
        output1.close();
        output2.close();
    }

    //RSA加密方法
    public static String encrypt(String source, String publicKeyFile) throws Exception {
        //读出文件中的公钥对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(publicKeyFile));
        Key key = (Key) ois.readObject();
        ois.close();
        //得到Cipher对象来实现对源数据的RSA加密
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] b = source.getBytes();
        String cryptograph = encoder.encode(cipher.doFinal(b));
        return cryptograph;
    }

    //RSA解密方法
    public static String decrypt(String cryptograph, String privateKeyFile) throws Exception {
        //读出文件中的私钥对象
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(privateKeyFile));
        Key key = (Key) input.readObject();
        input.close();
        //对已经加密的数据进行RSA解密
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(cryptograph);
        //执行解密操作
        byte[] b = cipher.doFinal(b1);
        String source = new String(b);
        return source;
    }

    //调用方法举例
    public static void main(String[] args) {
        String source = "11111111";
        System.out.println("明文字符串：[" + source + "]");
        try{
            //生成可用的密钥对并分别保存在文件中
            generateKeyPair();
            System.out.println("生成的公钥文件为：" + PUBLIC_KEY_FILE);
            System.out.println("生成的私钥文件为：" + PRIVATE_KEY_FILE);
            String cryptograph = encrypt(source, PUBLIC_KEY_FILE);//生成的密文
            System.out.println("加密之后的字符串为：[" + cryptograph + "]");
            String text = decrypt(cryptograph, PRIVATE_KEY_FILE);//解密密文
            System.out.println("解密之后的字符串为：[" + text + "]");
        }catch(Exception e){
            System.out.println("加解密过程中发生错误：" + e.getMessage());
            return;
        }
    }
}
