/**
 * FileName: Enum2StrTest
 * Author:   Administrator
 * Date:     2018/11/30 17:36
 * Description:
 */
package test;

import java.util.*;

public class Enum2StrTest {


    public enum enum1 {IPC, IPZM, NVR, IPC2_0}



    public static void main(String[] args) {

        Set<enum1> list = new HashSet<>();
        enum1.valueOf("IPC2_0");

        list.add(enum1.IPC);
        list.add(enum1.IPC2_0);
        list.add(enum1.IPZM);

        Collection collection = list;

        Iterator it = list.iterator();
        StringBuffer sb = new StringBuffer();
        sb.append("");
        sb.append(it.next().toString());

        while (it.hasNext())
        {
            sb.append('\u0000');
            sb.append(' ');
            sb.append(it.next().toString());
        }
        System.out.println(sb.toString());
    }
}
