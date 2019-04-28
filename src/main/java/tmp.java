import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileName: tmp
 * Author:   Administrator
 * Date:     2019/2/15 11:14
 * Description:
 */

public class tmp {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = dateFormat.format(new Date(1550112857000L));
        String format2 = dateFormat.format(new Date(43200000L));
        String format3 = dateFormat.format(new Date(8640000));
        String format4 = dateFormat.format(new Date(0L));
        System.out.println(format1+ " ||" + format2 + "||" + format3 + "|| " + format4);
    }
}
