/**
 * FileName: ScheduleAtFixedRateTest
 * Author:   Administrator
 * Date:     2019/5/8 15:45
 * Description:
 */
package schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Logger;

public class ScheduleAtFixedRateTest {

    private static Logger logger = Logger.getLogger(ScheduleAtFixedRateTest.class.getName());
   static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
    public static void main(String[] argss) throws InterruptedException {
        Function<Object[],Integer> function = (args)->{

            String arg0 = args[0].toString();
            Long arg1 = Long.valueOf((Integer) args[1]);

            DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            System.out.println("runable begin:" + arg0 +"|"+ df.format(new Date()));



            long time = new Date().getTime();
            long curTime = new Date().getTime() ;
            while (curTime - time >= arg1)
            {
                curTime = new Date().getTime();
            }
            System.out.println("runable end:" + arg0 +"|"+ df.format(new Date()));
            return 1;
        };


        Runnable runnable1 = ()->{
            function.apply(new Object[]{"1", 50000});
        };



        Runnable runnable2 = ()->{
            function.apply(new Object[]{"2", 0});
        };


        ScheduledFuture<?> scheduledFuture1 = executorService.scheduleAtFixedRate(runnable1, 0, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture2 = executorService.scheduleAtFixedRate(runnable2, 0, 2, TimeUnit.SECONDS);

        Map<String, ScheduledFuture> map = new HashMap<>();
        map.put("1",scheduledFuture1);
        map.put("2",scheduledFuture2);

        Thread.sleep(5000);
        executorService.shutdownNow();
        logger.info("状态轮询-发起关闭");
        if (!executorService.isShutdown()){
            while (!executorService.awaitTermination(1, TimeUnit.SECONDS)){
                logger.info("状态轮询-线程池没有关闭");

                map.forEach((k,v)->{
                    boolean cancelled = v.isCancelled();
                    logger.info("runnable "+k +"cancelled状态" + cancelled);
                });
            }
        }

    }
}
