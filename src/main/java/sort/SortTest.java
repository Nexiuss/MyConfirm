/**
 * FileName: SortTest
 * Author:   Administrator
 * Date:     2019/1/23 15:49
 * Description:
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Integer [] intArr = {4,22,3,5,5,8,0};
        Arrays.sort(intArr);
        System.out.println(intArr);
        String [] strArr = {"6700001","6700001005", "6700001009", "6700001004", "6700001003", "6700001006", "6700001007", "6700001008"};
        Arrays.sort(strArr);
        System.out.println(strArr);

        String str1 = "37001";
        String str2 = "37001001";
        boolean b = str2.startsWith(str1);
        System.out.println(b);

        List<Integer> arrayList = Arrays.asList(intArr);
        arrayList= new ArrayList<>();

        Integer[] integers = arrayList.toArray(new Integer[arrayList.size()]);
        System.out.println(integers);

    }
}
