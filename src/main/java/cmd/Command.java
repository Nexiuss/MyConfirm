/**
 * FileName: Command
 * Author:   Administrator
 * Date:     2019/1/16 17:00
 * Description:
 */
package cmd;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Command {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String format = dateFormat.format(new Date());
        System.out.println("datetime:" + format);
        String command = "date -s " + "\"" + format + "\"";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("datetime: error :: " + format);
        }
    }
}
