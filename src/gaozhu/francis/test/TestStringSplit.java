package gaozhu.francis.test;

import org.junit.Test;

public class TestStringSplit
{

    @Test
    public void testSplit()
    {
        String str = "/erp/manager/roleMgr?_sign=getAll";
        String a = -1 < str.indexOf("?") ? str.split("\\?")[0] : str;
        System.out.println(a);
    }

}
