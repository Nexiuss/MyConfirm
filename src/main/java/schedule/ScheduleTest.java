/**
 * FileName: ScheduleTest
 * Author:   Administrator
 * Date:     2019/2/28 16:47
 * Description:
 */
package schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTest {
    static String now(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

        MyRunnable runnable1 = new MyRunnable("Thread" + 1);
        MyRunnable runnable2 = new MyRunnable("Thread" + 2);

        System.out.println("main start time" + now());
        pool.schedule(runnable1, 1, TimeUnit.DAYS);

        pool.schedule(runnable2,7,TimeUnit.SECONDS);
    }


}
class MyRunnable implements Runnable{
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(getName()+"true start:"+now());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+"true end:"+now());
    }
    static String now(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}