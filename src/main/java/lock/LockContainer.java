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




}
