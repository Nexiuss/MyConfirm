/**
 * FileName: SystemConsole
 * Author:   Administrator
 * Date:     2019/2/11 11:49
 * Description:
 */
package console;

import java.io.Console;

public class SystemConsole {
    public static void main(String[] args) {
        Console console = System.console();
        if(console != null)
        {
            System.out.println("请输入");
            String s = console.readLine();
            System.out.println(s);
        }
    }
}
