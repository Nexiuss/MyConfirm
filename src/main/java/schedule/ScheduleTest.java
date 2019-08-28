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

        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("1"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("2"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("3"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("4"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("5"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("6"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("7"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("8"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("9"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("10"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("11"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("12"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("13"), 0, 30, TimeUnit.SECONDS);
        ScheduleThreadPoolManager.getInstance().scheduleAtFixedRate(new MyRunnable("14"), 0, 30, TimeUnit.SECONDS);
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