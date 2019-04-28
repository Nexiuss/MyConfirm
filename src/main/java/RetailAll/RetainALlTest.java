/**
 * FileName: RetainALlTest
 * Author:   Administrator
 * Date:     2019/1/22 17:00
 * Description:
 */
package RetailAll;

import java.util.ArrayList;
import java.util.List;

public class RetainALlTest
{
    public static void main(String[] args) {

        List<String> strArr1 = new ArrayList<>();
        List<String> strArr2 = new ArrayList<>();

        strArr1.add("A");
        strArr1.add("B");
        strArr1.add("C");

        strArr2.add("B");
        strArr2.add("C");
        strArr2.add("E");

        strArr1.retainAll(strArr2);

        System.out.println(strArr1);
    }
}
