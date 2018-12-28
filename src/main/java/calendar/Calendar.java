/**
 * FileName: Calendar
 * Author:   Administrator
 * Date:     2018/11/15 18:16
 * Description:
 */
package calendar;

public class Calendar
{

    public static void main(String[] args) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int i = calendar.get(6);
        System.out.println(i);
    }

}
