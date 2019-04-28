/**
 * FileName: NoNitimeTest
 * Author:   Administrator
 * Date:     2019/2/21 10:30
 * Description:
 */
package time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoNitimeTest {
    public static void main(String[] args) {

        long l = System.nanoTime();

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh-mm-ss");
        System.out.println(dateFormat.format(new Date()));
    }
}
