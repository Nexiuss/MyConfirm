/**
 * FileName: LockContainer
 * Author:   Administrator
 * Date:     2018/11/22 14:04
 * Description:
 */
package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockContainer {
    private Map<String, Lock> lockMap = new HashMap<String, Lock>();

    private Lock lock2 = new ReentrantLock();

    public Lock getLock (String key)
    {
        Lock lock = null;
        lock2.lock();
        try {
            lock = lockMap.get(key);
            if (lock == null) {
                lockMap.put(key, new ReentrantLock());
                lock = lockMap.get(key);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            //lock2.unlock();
        }
        return lock;
    }

    public synchronized void remove(String key) {
        this.lockMap.remove(key);
    }

    public void doSth(String key) {
//        Lock lock = null;
//        lock = lockMap.get(key);
//        if (lock == null) {
//            lock = new ReentrantLock();
//            lock.lock();
//            lockMap.put(key, lock);
//        }
//        try {
//            System.out.println(Thread.currentThread() + " || key:" + key);
//            this.wait(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//            lockMap.remove(key);
//        }
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " || key" + key + " || time "+ System.currentTimeMillis()) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        LockContainer lockContainer = new LockContainer();


        new Thread(() -> {
            Lock lock = lockContainer.getLock("1111111");
            lockContainer.doSth("1111111");
            lock.unlock();

        }, "tread-1").start();
        new Thread(() -> {
            Lock lock = lockContainer.getLock("1111111");
            lockContainer.doSth("1111111");
            lock.unlock();
        }, "tread-2").start();
        new Thread(() -> {
            Lock lock = lockContainer.getLock("1111111");
            lockContainer.doSth("1111111");
            lock.unlock();
        }, "tread-3").start();
        new Thread(() -> {
            Lock lock = lockContainer.getLock("1111111");
            lockContainer.doSth("1111111");
            lock.unlock();
        }, "tread-4").start();
        new Thread(() -> {
            Lock lock = lockContainer.getLock("1111111");
            lockContainer.doSth("1111111");
            lock.unlock();
        }, "tread-5");
        new Thread(() -> {
            Lock lock = lockContainer.getLock("22222");
            lockContainer.doSth("22222");
            lock.unlock();
        }, "tread-6").start();


    }
}
