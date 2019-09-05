/**
 * FileName: NoNitimeTest
 * Author:   Administrator
 * Date:     2019/2/21 10:30
 * Description:
 */
package time;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoNitimeTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        final LocalDateTime parse1 = LocalDateTime.parse("2019-09-04 15:43:40", df);


        final Duration between = Duration.between(now, parse1);
        final String s = DurationFormatUtils.formatDuration(between.toMillis(), "yyyy-MM-dd hh:mm:ss");

    }
}
