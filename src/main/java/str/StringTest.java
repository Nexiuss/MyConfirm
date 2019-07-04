/**
 * FileName: StringTest
 * Author:   Administrator
 * Date:     2019/6/10 18:14
 * Description:
 */
package str;

public class StringTest {
    public static void main(String[] args) {
        String s = "/virtualFilePath/ims/";
      String str = "http://172.18.31.15:18080/virtualFilePath/ims/1562209554777.jpg";
        int i = str.indexOf(s);
        str = str.substring(i, str.length());
        str = str.replace(s,"1111");


        System.out.println(str);

    }


}
