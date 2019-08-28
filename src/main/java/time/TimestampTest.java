/**
 * FileName: TimestampTest
 * Author:   Administrator
 * Date:     2019/8/7 16:11
 * Description:
 */
package time;

import java.sql.Timestamp;
import java.time.Instant;

public class TimestampTest {
    public static void main(String[] args) {

        Timestamp timestamp = new Timestamp(1565166282L * 1000);
        final Instant instant = timestamp.toInstant();
        System.out.println(instant);
    }
}
