/**
 * FileName: TaskTest
 * Author:   Administrator
 * Date:     2019/7/1 9:57
 * Description:
 */
package task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.logging.Logger;

class MyRunnable implements Runnable {
    private static Logger logger = Logger.getLogger(MyRunnable.class.getName());
    private TaskBean taskBean;

    public TaskBean getTaskBean() {
        return taskBean;
    }

    public MyRunnable(TaskBean taskBean) {
        this.taskBean = taskBean;
    }

    @Override
    public void run() {
        logger.info("执行————" + taskBean.toString());
    }
}

class TaskBean {
    private String idcard;
    private Date createTime;
    private Date startTime;
    private long period;
    private TimeUnit periodUint;


    public TaskBean() {
    }

    public TaskBean(String idcard, Date createTime, Date startTime, Long period, TimeUnit periodUint) {
        this.idcard = idcard;
        this.createTime = createTime;
        this.startTime = startTime;
        this.period = period;
        this.periodUint = periodUint;
    }

    public static TaskBeanBuilder builder() {
        TaskBeanBuilder taskBeanBuilder = new TaskBeanBuilder();
        taskBeanBuilder.taskBean = new TaskBean();
        return taskBeanBuilder;
    }

    public static TaskBeanBuilder builder(TaskBean taskBean) {
        TaskBeanBuilder taskBeanBuilder = new TaskBeanBuilder();
        taskBeanBuilder.taskBean = taskBean == null ? new TaskBean() : taskBean;
        return taskBeanBuilder;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public long getPeriod() {
        return this.period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public TimeUnit getPeriodUint() {
        return this.periodUint;
    }

    public void setPeriodUint(TimeUnit periodUint) {
        this.periodUint = periodUint;
    }

    @Override
    public String toString() {
        return "TaskBean{idcard='" + idcard + "'" +
                ", createTime='" + createTime + "'" +
                ", startTime='" + startTime + "'" +
                ", period='" + period + "'" +
                ", periodUint='" + periodUint + "'" +
                "}";
    }

    public static class TaskBeanBuilder {

        private TaskBean taskBean;

        public TaskBeanBuilder idcard(String idcard) {
            taskBean.idcard = idcard;
            return this;
        }

        public TaskBeanBuilder createTime(Date createTime) {
            taskBean.createTime = createTime;
            return this;
        }

        public TaskBeanBuilder startTime(Date startTime) {
            taskBean.startTime = startTime;
            return this;
        }

        public TaskBeanBuilder period(Long period) {
            taskBean.period = period;
            return this;
        }

        public TaskBeanBuilder periodUint(TimeUnit periodUint) {
            taskBean.periodUint = periodUint;
            return this;
        }

        public TaskBean build() {
            return this.taskBean;
        }

    }
}

public class TaskTest {
    private static Logger logger = Logger.getLogger(TaskTest.class.getName());

   private static ConcurrentHashMap<String, ScheduledFuture> map = new ConcurrentHashMap();









    public static void main(String[] args) throws ParseException, InterruptedException {
        final DateFormat df = new SimpleDateFormat("YYYY-mm-dd HH:MM:SS");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        TaskBean taskBean1 = TaskBean.builder()
                .startTime(df.parse(df.format(new Date(new Date().getTime() - 1000))))
                .idcard("11111111111111111")
                .period(2L)
                .periodUint(TimeUnit.SECONDS)
                .build();
        TaskBean taskBean2 = TaskBean.builder()
                .startTime(df.parse(df.format(new Date(new Date().getTime() - 2000))))
                .idcard("22222222222222222")
                .period(3L)
                .periodUint(TimeUnit.SECONDS)
                .build();
        TaskBean[] taskBeans = new TaskBean[]{taskBean1, taskBean2};
        for (TaskBean taskBean : taskBeans) {
            Runnable runnable = new MyRunnable(taskBean);
            long startTime = taskBean.getStartTime().getTime();
            long currentTime = new Date().getTime();
            long convert = TimeUnit.MILLISECONDS.convert(taskBean.getPeriod(), TimeUnit.SECONDS);
            while (startTime - currentTime < 0) {
                startTime += convert;
            }
            Long delay = TimeUnit.SECONDS.convert(startTime - currentTime, TimeUnit.MILLISECONDS);

            ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, delay, taskBean.getPeriod(), taskBean.getPeriodUint());
            map.put(taskBean.getIdcard(), scheduledFuture);
        }



        Thread.sleep(30000);
       map.get("11111111111111111").cancel(true);
        logger.info("cancel" + "11111111111111111");
    }
}
