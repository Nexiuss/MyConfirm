/**
 * FileName: Test
 * Author:   Administrator
 * Date:     2019/1/29 10:22
 * Description:
 */
package callback;

public class Test {

    void doSth(Callback callback, String param) {


        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                callback.onCall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        new Thread(runnable).start();

        //ExecutorService executorService = new ThreadPoolExecutor()
        System.out.println(param);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.doSth(new Callback() {
            @Override
            public void onCall() {


                System.out.println("收到 " + this.getClass() + " 回调");
            }
        }, "111111111111");


    }
}
