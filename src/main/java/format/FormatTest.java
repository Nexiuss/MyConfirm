/**
 * FileName: FormatTest
 * Author:   Administrator
 * Date:     2019/7/12 11:20
 * Description:
 */
package format;

public class FormatTest {
    static String string = "card_b_devId%s_ch0001_%s.jpg";

    public static void main(String[] args) {
        String format = String.format(string, "55000010000F4277", "20190710_185954");
        System.out.println(format);
    }
}
