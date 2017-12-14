package com.turing.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;

import javax.crypto.Cipher;

public class TuringRsa
{
    public static final String   RSA_PRIVATE_KEY     = "43913869422492532741541122802830540809075430299847119629464185418649070596242479653306969463561555408417944277759378330201355079448651275368124178194060495755176609141764810374984204801182152163302551828599974247108168362084829628911614483308789780165229688110370836081907469242321651400104315911268125408825";
    public static final String   RSA_PRIVATE_MODULUS = "120705584882015397319229147553961546491816318230133820373115560952145457352931400790117806389021249708572193689196677331980296432572505919297099956645730119379165322546967314084996427334984220166243296101053923686940118871314019505872353883262835473644795588786559762959328176865091436459927407672623038406043";
    // private static String public_exponent = "65537";
    private static RSAPrivateKey privateKey          = null;
    private static boolean       useOpenSSL          = false;

    static
    {
        String path = TuringRsa.class.getClassLoader().getResource("/")
                .getPath()
                + File.separator + "librsa.so";
        if (new File(path).exists())
        {
            System.load(path); // 服务器端需要添加
            System.loadLibrary("rsa");
            useOpenSSL = true;
        }
    }

    /**
     * 生成公钥和私钥
     * 
     * @throws NoSuchAlgorithmException
     * 
     */
    public static HashMap<String, Object> getKeys()
            throws NoSuchAlgorithmException
    {
        HashMap<String, Object> map = new HashMap<String, Object>();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        map.put("public", publicKey);
        map.put("private", privateKey);
        return map;
    }

    /**
     * 使用模和指数生成RSA公钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     * 
     * @param modulus
     *            模
     * @param exponent
     *            指数
     * @return
     */
    public static RSAPublicKey getPublicKey(String modulus, String exponent)
    {
        try
        {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用模和指数生成RSA私钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     * 
     * @param modulus
     *            模
     * @param exponent
     *            指数
     * @return
     */
    public static RSAPrivateKey getPrivateKey(String modulus, String exponent)
    {
        try
        {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            if (useOpenSSL)
            {
                turingRsaInit(modulus, "65537", exponent);
            }
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 公钥加密
     * 
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, RSAPublicKey publicKey)
            throws Exception
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        // 模长
        int key_len = publicKey.getModulus().bitLength() / 8;
        // 加密数据长度 <= 模长-11
        String[] datas = splitString(data, key_len - 11);
        String mi = "";
        // 如果明文长度大于模长-11则要分组加密
        for (String s : datas)
        {
            mi += bcd2Str(cipher.doFinal(s.getBytes()));
        }
        return mi;
    }

    public static String encryptByPrivateKey(String data,
            RSAPrivateKey privateKey) throws Exception
    {
        if (useOpenSSL)
        {
            byte[] datatmp = turingRsaEncryptByPrivate(data.getBytes("UTF-8")); // 在服务器需要打开
            return bcd2Str(datatmp);
        }
        else
        {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            // 模长
            int key_len = privateKey.getModulus().bitLength() / 8;
            // 加密数据长度 <= 模长-11
            String[] datas = splitString(data, key_len - 11);
            String mi = "";
            // 如果明文长度大于模长-11则要分组加密
            for (String s : datas)
            {
                mi += bcd2Str(cipher.doFinal(s.getBytes()));
            }
            return mi;
        }
    }

    /**
     * 私钥解密
     * 
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data,
            RSAPrivateKey privateKey) throws Exception
    {
        if (useOpenSSL)
        {
            byte[] bytes = data.getBytes("UTF-8");
            byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
            byte[] datatmp = turingRsaDecryptByPrivate(bcd);
            return new String(datatmp);
        }
        else
        {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            // 模长
            int key_len = privateKey.getModulus().bitLength() / 8;
            byte[] bytes = data.getBytes("UTF-8");
            byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
            // System.err.println(bcd.length);
            // 如果密文长度大于模长则要分组解密
            String ming = "";
            byte[][] arrays = splitArray(bcd, key_len);
            for (byte[] arr : arrays)
            {
                ming += new String(cipher.doFinal(arr));
            }
            return ming;
        }
    }

    public static String decryptByPublicKey(String data, RSAPublicKey publicKey)
            throws Exception
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        // 模长
        int key_len = publicKey.getModulus().bitLength() / 8;
        byte[] bytes = data.getBytes("UTF-8");
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
        // System.err.println(bcd.length);
        // 如果密文长度大于模长则要分组解密
        String ming = "";
        byte[][] arrays = splitArray(bcd, key_len);
        for (byte[] arr : arrays)
        {
            ming += new String(cipher.doFinal(arr));
        }
        return ming;
    }

    /**
     * ASCII码转BCD码
     * 
     */
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len)
    {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++)
        {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    public static byte asc_to_bcd(byte asc)
    {
        byte bcd;

        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);
        return bcd;
    }

    /**
     * BCD转字符串
     */
    public static String bcd2Str(byte[] bytes)
    {
        char temp[] = new char[bytes.length * 2], val;

        for (int i = 0; i < bytes.length; i++)
        {
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * 拆分字符串
     */
    public static String[] splitString(String string, int len)
    {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if (y != 0)
        {
            z = 1;
        }
        String[] strings = new String[x + z];
        String str = "";
        for (int i = 0; i < x + z; i++)
        {
            if (i == x + z - 1 && y != 0)
            {
                str = string.substring(i * len, i * len + y);
            }
            else
            {
                str = string.substring(i * len, i * len + len);
            }
            strings[i] = str;
        }
        return strings;
    }

    /**
     * 拆分数组
     */
    public static byte[][] splitArray(byte[] data, int len)
    {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if (y != 0)
        {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++)
        {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0)
            {
                System.arraycopy(data, i * len, arr, 0, y);
            }
            else
            {
                System.arraycopy(data, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    public static String encryptByPrivate(String ming)
    {
        String mi = "";
        try
        {
            if (privateKey == null)
            {
                privateKey = TuringRsa.getPrivateKey(
                        TuringRsa.RSA_PRIVATE_MODULUS,
                        TuringRsa.RSA_PRIVATE_KEY);
            }
            mi = TuringRsa.encryptByPrivateKey(ming, privateKey);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return mi;
    }

    public static String decryptByPrivate(String mi)
    {
        String ming = "";
        try
        {
            if (privateKey == null)
            {
                privateKey = TuringRsa.getPrivateKey(
                        TuringRsa.RSA_PRIVATE_MODULUS,
                        TuringRsa.RSA_PRIVATE_KEY);
            }
            ming = TuringRsa.decryptByPrivateKey(mi.trim(), privateKey);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ming;
    }

    public native static void turingRsaInit(String modulus,
            String pubExponent, String priExponent);

    public native static void turingRsaUninit();

    public native static byte[] turingRsaDecryptByPrivate(byte[] data);

    public native static byte[] turingRsaEncryptByPrivate(byte[] data);

    public native static byte[] turingRsaDecryptByPublic(byte[] data);

    public native static byte[] turingRsaEncryptByPublic(byte[] data);
}
