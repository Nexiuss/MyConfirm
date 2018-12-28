/**
 * FileName: SubStringTest
 * Author:   Administrator
 * Date:     2018/12/5 18:41
 * Description:
 */
package substring;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringTest
{
    public static void main(String[] args) {
       /* String str = "123456789";
//        str = str.substring(0,str.length()-2);
//        System.out.println(str);

        str = str.substring(0, str.lastIndexOf("89"));
        System.out.println(str);

        Integer [] integers = {1,2,3,5,5};
        Set<Integer> integers1 =new HashSet<Integer>(Arrays.asList(integers)) ;
        integers1.remove(2);
        String string = JSON.toJSONString(integers1);

        System.out.println(string.replace("[", "(").replace("]",")"));*/

     /*  StringBuilder stringBuilder = new StringBuilder("(l.deviceid=6200011203000415 and l.alertnum=1) or (l.deviceid=6200011203000413 and l.alertnum=1) or (l.deviceid=6200011203000411 and l.alertnum=1) or (l.deviceid=620001120300040F and l.alertnum=1) or (l.deviceid=620000120300041A and l.alertnum=1) or (l.deviceid=EF560012030003EC and l.alertnum=1) or (l.deviceid=AB56001203000400 and l.alertnum=1) or (l.deviceid=CD343312030004C3 and l.alertnum=1) or");

        String or = stringBuilder.substring(0, stringBuilder.lastIndexOf("or"));
        System.out.println(or);*/

    }
}
