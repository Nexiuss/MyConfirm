/**
 * FileName: Calendar
 * Author:   Administrator
 * Date:     2018/11/15 18:16
 * Description:
 */
package calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar
{

    public static void main(String[] args) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(new Date()));
        int i = calendar.get(7);
        System.out.println(i);
    }

}
