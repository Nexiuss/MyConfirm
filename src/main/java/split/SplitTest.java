/**
 * FileName: SplitTest
 * Author:   Administrator
 * Date:     2019/3/1 16:42
 * Description:
 */
package split;

public class SplitTest {
    public static void main(String[] args) {
        String str =  "CD34001203000576$172.18.30.17(IPC)";

        String[] $s = str.split("\\$");
        System.out.println($s);
    }
}
