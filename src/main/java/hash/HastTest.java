/**
 * FileName: HastTest
 * Author:   Administrator
 * Date:     2019/1/9 14:30
 * Description:
 */
package hash;

import java.util.HashSet;
import java.util.Set;

public class HastTest {
    public static void main(String[] args) {
        String str1 = new String("1111111");
        String str2 = new String("1111111");
        String str3 = new String("3333333");

        Set<String> hashSet = new HashSet<>();
        hashSet.add(str1);
        hashSet.add(str2);
        int i1 = str1.hashCode();
        int i2 = str2.hashCode();
        int i3 = str3.hashCode();
        System.out.println(hashSet);
    }
}
