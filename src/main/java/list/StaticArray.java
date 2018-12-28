/**
 * FileName: StaticArray
 * Author:   Administrator
 * Date:     2018/11/26 17:22
 * Description:
 */
package list;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

public class StaticArray
{
    public static void main(String[] args) {
        int [] stcArry = {1,2,3,4};
        String string = JSON.toJSONString(stcArry);

        System.out.println(string);
        String substring = string.substring(0).substring(1, string.length()-1);
        System.out.println(substring);

        final ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        System.out.println(JSON.toJSON(arrayList));
    }
}
