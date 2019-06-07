package gaozhu.francis.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具
 * 
 * @author sgdjava
 * @date 2013-4-1 下午5:35:33
 */
public class KeyedMD5 {

    public static String getMd5Gbk(String str, String key) {
        return getKeyedDigest(str, key, "GBK");
    }

    public static String getMd5Utf8(String str, String key) {
        return getKeyedDigest(str, key, "UTF-8");
    }

    private static String getKeyedDigest(String strSrc, String key, String enc) {
        if (enc == null || enc.length() == 0)
            enc = "UTF-8";
        if (key == null)
            key = "";
        try {
            String result = "";
            byte[] temp = getKeyedDigest(strSrc.getBytes(enc), key.getBytes(enc));
            for (int i = 0; i < temp.length; i++) {
                result += Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static byte[] getKeyedDigest(byte[] buffer, byte[] key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(buffer);
            return md5.digest(key);
        } catch (NoSuchAlgorithmException e) {
        }
        return new byte[0];
    }

    public static void main(String[] args)
    {
        System.out.println(getMd5Utf8("gaozhu",""));
    }

}
