/**
 * FileName: HashSetTest
 * Author:   Administrator
 * Date:     2019/1/23 9:09
 * Description:
 */
package hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class HashSetTest
{
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");

        HashSet<String> stringSet = new HashSet<>(stringList);
        System.out.println(stringSet);
        UUID.randomUUID();

    }
}
