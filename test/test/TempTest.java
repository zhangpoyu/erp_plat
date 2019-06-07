package test;

import gaozhu.francis.util.JDBCHelper;
import gaozhu.francis.util.String_;
import org.junit.Test;

public class TempTest
{

    @Test
    public void testStringNull()
    {
        for(int i = 0; i < 1000; i ++)
        {
            System.out.println(JDBCHelper.getPKL20());
        }

    }


}
