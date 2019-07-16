/**
 * FileName: Test
 * Author:   Administrator
 * Date:     2019/7/8 13:39
 * Description:
 */
package thread;

import java.util.UUID;
import java.util.concurrent.*;

public class Test {
    public static int seq = 0;
    public static Long l = 1000L;
    private static BlockingQueue<ScheduleBean> queue = new LinkedBlockingQueue();
    public static ConcurrentHashMap<Integer, ScheduledFuture> map = new ConcurrentHashMap();
    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public static Runnable runnable = ()->{
        System.out.println(1111111111);
        seq++;
        if(seq == 10){
            System.out.println("stop");
            ScheduleBean scheduleBean = new ScheduleBean();
            scheduleBean.delay = 2;
            scheduleBean.peroid=2;
            scheduleBean.timeUnit = TimeUnit.SECONDS;
            queue.offer(scheduleBean);
            map.get(1).cancel(true);


        }
    };

    public static Runnable addSchedule = ()->{
      while (true){
          try {
              System.out.println("addSchedule run");
              ScheduleBean take = queue.take();
              Thread.sleep(1000);
              boolean cancelled = map.get(1).isCancelled();
              while (true){
                  if(cancelled)break;
                  Thread.sleep(1000);
                  cancelled = map.get(1).isCancelled();
              }
              ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, take.delay, take.peroid, take.timeUnit);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    };

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
        map.put(1, scheduledFuture);
        new Thread(addSchedule).start();

    }


}
class ScheduleBean{
    public Runnable runnable;
    public int delay;
    public int peroid;
    public TimeUnit timeUnit;
    public UUID uuid;

    @Override
    public String toString() {
        return "ScheduleBean{" +
                "runnable=" + runnable +
                ", delay=" + delay +
                ", peroid=" + peroid +
                ", timeUnit=" + timeUnit +
                '}';
    }

    public ScheduleBean() {
        this.uuid = UUID.randomUUID();
    }
}