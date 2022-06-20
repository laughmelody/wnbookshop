package wnbook.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog {
    @Test
    public void one(){
        System.out.println("-------test----------");
        //系统默认配置
        BasicConfigurator.configure();
        //得到logger对象
        Logger logger = Logger.getLogger(TestLog.class);
        //使用logger
        logger.fatal("----fatal:最严重的错误，一般会造成系统崩溃或终止运行");
        logger.error("----error:错误信息，不会影响系统运行");
        logger.warn("-----warn：警告信息，可能会有问题");
        logger.info("----info：运行信息，数据库连接，网络连接，io操作等");
        logger.debug("----debug：调试信息，一般在开发中使用，记录程序的变量参数的值传递等操作");
        logger.trace("----trace：追踪信息，记录程序所有的流程信息");
    }
}
