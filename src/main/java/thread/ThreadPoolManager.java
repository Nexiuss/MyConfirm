package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 报警相关 线程池工具类
 */
public class ThreadPoolManager {
    /**
     * 根据cpu的数量动态的配置核心线程数和最大线程数
     */
    private static final int CPU_COUNT         = Runtime.getRuntime().availableProcessors();
    /**
     * 核心线程数 = CPU核心数 + 1
     */
    private static final int CORE_POOL_SIZE    = CPU_COUNT + 1;
    /**
     * 线程池最大线程数 = CPU核心数 * 2 + 1
     */
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    /**
     * 非核心线程闲置时超时1s
     */
    private static final int KEEP_ALIVE        = 1;
    /**
     *  线程池的对象
     */
    public static ThreadPoolExecutor executor;
    
    private static AtomicInteger threadNum = new AtomicInteger(1);
    
    static {
    	/**
         * corePoolSize:核心线程数
         * maximumPoolSize：线程池所容纳最大线程数(workQueue队列满了之后才开启)
         * keepAliveTime：非核心线程闲置时间超时时长
         * unit：keepAliveTime的单位
         * workQueue：等待队列，存储还未执行的任务
         * threadFactory：线程创建的工厂
         * handler：异常处理机制
         */
        if (executor == null) {
            executor = new ThreadPoolExecutor(CORE_POOL_SIZE, 100,
                    KEEP_ALIVE, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(200),
                    newThread(), new ThreadPoolExecutor.AbortPolicy());
        }
    }
    
    /**
     * 自定义线程名称的线程创建工厂
     * @return
     */
	private static ThreadFactory newThread() {
		 ThreadFactory threadFactory = new ThreadFactory() {
			public Thread newThread(Runnable r) {
				
				return new Thread(r, "ams_pool-" + threadNum.getAndIncrement());
			}
		};
		
		return threadFactory;
	}

    private void checkThread() {
    	// 检查线程池负荷
    	int queueSize = executor.getQueue().size();
    	int poolSize = executor.getPoolSize();
    	// 正在活动的线程数量
    	int activeCount = executor.getActiveCount();
    	// 如排队数量已经超过线程池大小就记录日志
    	if (activeCount == poolSize && queueSize > poolSize) {
    		//logger.error("线程池负荷过大!! activeCount=" + activeCount + "  poolSize=" + poolSize + "  queueSize " + queueSize);
    	}
    }

    
    /**
     * 开启一个无返回结果的线程
     *
     * @param runnable
     */
    public void execute(Runnable runnable) {
    	checkThread();
        
        // 把一个任务丢到线程池中
        executor.execute(runnable);
    }

    /**
     * 开启一个有返回结果的线程
     *
     * @param r
     * @return
     */
    public <T> Future<T> submit(Callable<T> r) {
    	checkThread();
        // 把一个任务丢到线程池中
        return executor.submit(r);
    }
    
    /**
     * 提交一个有返回结果的多线程任务,并且指定该任务的超时时间
     * @param r
     * @param timeOut
     * @return
     * @throws ExecutionException 
     * @throws TimeoutException 
     */
    public <T> Future<T> submit(Callable<T> r, int timeOut) throws TimeoutException {
    	checkThread();
		Future<T> future = executor.submit(r);
		try {
			// 若该任务超时则该任务必然已经结束
			future.get(timeOut, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
        
        return future;
    }

    /**
     * 把任务移除等待队列
     * @param runnable
     */
    public void cancel(Runnable runnable) {
        if (runnable != null) {
            executor.getQueue().remove(runnable);
        }
        checkThread();
    }


}
