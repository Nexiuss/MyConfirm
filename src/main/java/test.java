/**
 * FileName: test
 * Author:   Administrator
 * Date:     2018/7/20 13:46
 * Description:
 */

public class test {



    public static void main(String[] args) {
        final String s = "111111111111111111$111";
        final boolean contains = s.contains("$");
        final String[] $s = s.split("\\$");
        System.out.println($s);

    }

}
