/**
 * FileName: ListTest
 * Author:   Administrator
 * Date:     2019/4/23 11:42
 * Description:
 */
package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Map<String, List<String>> listMap = new HashMap<>();

        listMap.put("1", list);

        list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(listMap);

        int i = 1;
        String str = "";
        while (i <= 100){
            str = (str + i +";");
            i++;
        }
        System.out.println(str);

        String[] objects = list.toArray(new String[list.size()]);
        System.out.println(objects);

        Integer[] arr=new Integer[]{7,5,2};
       /* ArrayLooper arrayLooper=new ArrayLooper(arr);
        arrayLooper.handle(new Callback() {
            @Override
            public void callback(Integer num) {
                System.out.println(num);
            }
        });*/

    }
}
