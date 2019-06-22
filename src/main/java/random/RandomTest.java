/**
 * FileName: RandomTest
 * Author:   Administrator
 * Date:     2019/6/4 8:53
 * Description:
 */
package random;

public class RandomTest {
    public static void main(String[] args) throws InterruptedException {
        int total = 0;
        int count = 0;
        while (true) {
            int random = ((int) (Math.random() * 80 - 30));
            System.out.println("当前随机数字：" + random);
            total += random;
            count++;
            System.out.println("当前平均数："+ total/count);
            Thread.sleep(1000);
        }
    }
}
