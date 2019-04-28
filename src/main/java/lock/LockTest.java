/**
 * FileName: LockTest
 * Author:   Administrator
 * Date:     2019/1/5 14:06
 * Description:
 */
package lock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LockTest
{
    static DateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");

    private String key;
    private Lock lock;
    KeyLock keyLock = new KeyLock();

    public LockTest() {
        this.lock = new ReentrantLock();
    }

    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            keyLock.lock("111111");
            try {
                System.out.println("begin :"+Thread.currentThread() +format.format(new Date())  );
                System.out.println("111111");
                sleep(10000);
                System.out.println("end :"+Thread.currentThread()+format.format(new Date())  );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                keyLock.unlock("111111");
            }
        }
    };

    Runnable runnable2 = new Runnable() {

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("begin :"+Thread.currentThread() +format.format(new Date())  );
                System.out.println("111111");
                sleep(10000);
                System.out.println("end :"+Thread.currentThread()+format.format(new Date())  );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                keyLock.unlock("111111");
            }
        }
    };

    public static void main(String[] args) {



        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(lockTest.runnable);
        Thread t2 = new Thread(lockTest.runnable);
        t1.start();
        t2.start();



    }
}
