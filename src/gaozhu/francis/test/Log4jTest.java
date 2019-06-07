package gaozhu.francis.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest
{

    Logger log = Logger.getLogger(Log4jTest.class);

    @Test
    public void testLog()
    {
        log.debug("aaaaa");
    }


}
