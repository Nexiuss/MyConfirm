/**
 * FileName: ScheduleThreadPoolManager
 * Author:   Administrator
 * Date:     2019/7/2 11:56
 * Description:
 */
package schedule;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.*;

/**
 * 类名称:ScheduleThreadPoolManager
 */


public class ScheduleThreadPoolManager {
    private static final int CPU_COUNT  = Runtime.getRuntime().availableProcessors();
    private static ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(CPU_COUNT +1);
    private Map<String, List<WeakReference<Future<?>>>> taskMap;
    private static ScheduleThreadPoolManager instance = null;

    /**
     * 创建一个新的实例 ThreadPoolManager.
     */
    public ScheduleThreadPoolManager(){
        taskMap = new WeakHashMap<String, List<WeakReference<Future<?>>>>();
    }

    /**
     * 获取ThreadPoolManager单例对象
     */
    public static ScheduleThreadPoolManager getInstance()
    {
        if (instance == null) {
            synchronized (ScheduleThreadPoolManager.class) {
                if (instance == null) {
                    instance = new ScheduleThreadPoolManager();
                }
            }
        }
        return instance;
    }

    /**
     * 释放ThreadPoolManager单例对象
     */
    public static void release(){
        synchronized (ScheduleThreadPoolManager.class) {
            if (instance != null) {
                instance.cancelAllTaskThreads();
            }
            instance = null;
        }
    }

    /**
     * 执行在给定延迟后启用的一次性操作
     * @param command 要执行的任务
     * @param delay 从现在开始延迟执行的时间
     * @param unit  延迟参数的时间单位
     */
    public ScheduledFuture<?> schedule(Runnable command,long delay,TimeUnit unit){
        ScheduledFuture<?>  request = threadPool.schedule(command, delay, unit);
        String classInvokeName = new Exception().getStackTrace()[1].getClassName();
        String methodInvokeName = new Exception().getStackTrace()[1].getMethodName();
        addTask(request, classInvokeName + "."+methodInvokeName);

        return request;
    }

    /**
     * 执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期
     * @param command  要执行的任务
     * @param initialDelay 首次执行的延迟时间
     * @param period  连续执行之间的周期
     * @param unit  参数的时间单位
     */
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit){
        ScheduledFuture<?> request;
        request = ((ScheduledExecutorService) threadPool).scheduleAtFixedRate(command, initialDelay, period, unit);
        String classInvokeName = new Exception().getStackTrace()[1].getClassName();
        String methodInvokeName = new Exception().getStackTrace()[1].getMethodName();
        addTask(request, classInvokeName +"."+ methodInvokeName);
        return request;
    }

    /**
     * 添加执行任务的Future到map中
     * @param request
     *void
     * @exception
     */
    private void addTask(Future<?> request, String methodName){
        synchronized (ScheduleThreadPoolManager.class) {
            if (methodName != null) {
                // 在请求集中添加本次请求
                List<WeakReference<Future<?>>> requestList = taskMap.get(methodName);
                if (requestList == null) {
                    requestList = new LinkedList<WeakReference<Future<?>>>();
                    taskMap.put(methodName, requestList);
                }
                requestList.add(new WeakReference<Future<?>>(request));
            }
        }
    }

    /**
     * 关闭当前方法的线程
     * @param methodName 对应的包含包名的类名方法名 如 com.focus.application.net_monitor_service.util.PollingUtil.polling
     * @param mayInterruptIfRunning  是否关闭正在运行的线程标志
     */
    public void cancelTaskThreads(String methodName,
                                  boolean mayInterruptIfRunning) {
        synchronized (ScheduleThreadPoolManager.class) {
            List<WeakReference<Future<?>>> requestList = taskMap.get(methodName);
            if (requestList != null) {
                for (WeakReference<Future<?>> requestRef : requestList) {
                    Future<?> request = requestRef.get();
                    if (request != null) {
                        request.cancel(mayInterruptIfRunning);
                    }
                }
            }
            taskMap.remove(methodName);
        }
    }

    /**
     * 取消所有的任务
     */
    private void cancelAllTaskThreads(){
        for (String clsName:taskMap.keySet()) {
            List<WeakReference<Future<?>>> requestList = taskMap.get(clsName);
            if (requestList != null) {
                Iterator<WeakReference<Future<?>>> iterator = requestList.iterator();
                while (iterator.hasNext()) {
                    Future<?> request = iterator.next().get();
                    if (request != null) {
                        request.cancel(true);
                    }

                }
            }
        }
        taskMap.clear();
    }
}