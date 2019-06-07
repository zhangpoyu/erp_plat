package gaozhu.francis.util;

/**
 * 字符串工具类
 * @author FrancisGaozhu
 *
 */
public final class String_
{

    /**
     * 验证一个字符串的保存内容是否是空引用/空字符串
     * @param str
     * @return
     */
    public static Boolean isNullOrEmpty(String str)
    {
        return null == str || str.isEmpty();
    }

}
