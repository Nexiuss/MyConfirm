/**
 * FileName: AtomicAdd
 * Author:   Administrator
 * Date:     2018/12/10 10:55
 * Description:
 */
package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAdd {
    private static AtomicInteger cmsSequence = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println();
        System.out.println(cmsSequence.getAndIncrement());
        System.out.println(cmsSequence.getAndIncrement());
        System.out.println(cmsSequence.getAndIncrement());
        System.out.println(cmsSequence.getAndIncrement());
    }
}
