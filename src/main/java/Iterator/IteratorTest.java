/**
 * FileName: IteratorTest
 * Author:   Administrator
 * Date:     2019/1/17 10:58
 * Description:
 */
package Iterator;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest
{


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext())
        {
            String next = iterator.next();
            if(next.equals("4"))  iterator.remove();
        }
        System.out.println(stringList);
        String string = JSON.toJSONString(stringList);
        string = string.replace("[", "(");
        string = string.replace("]", ")");
        string = string.replace("\"", "'");
        System.out.println(string);

    }
}
