/**
 * FileName: TimeUnitTest
 * Author:   Administrator
 * Date:     2019/3/1 16:52
 * Description:
 */
package time_unit;

import java.util.concurrent.TimeUnit;

public class TimeUnitTest
{
    public static void main(String[] args) {
        long convert = TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
        System.out.println(convert);
    }
}
