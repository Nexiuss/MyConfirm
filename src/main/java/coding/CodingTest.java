/**
 * FileName: CodingTest
 * Author:   Administrator
 * Date:     2019/1/22 17:18
 * Description:
 */
package coding;

import java.util.ArrayList;
import java.util.List;

public class CodingTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1001");
        strings.add("1001001");
        strings.add("1001002");
        strings.add("1001003");
        strings.add("1001003001");
        strings.add("1001003002");
        strings.add("1001003003");



        List<String> willBeRemoveStrs = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++)
        {
            if(i+1 < strings.size())
            {
                for (int j = i+1; j < strings.size(); j++)
                {
                    String strI = strings.get(i);
                    String strJ = strings.get(j);

                    int length$I = strI.length();
                    int length$J = strJ.length();
                    if(length$I > length$J)
                    {
                        String substring = strI.substring(0, strJ.length());
                        if(substring.equals(strJ)) willBeRemoveStrs.add(strI);
                    }else
                    {
                        String substring = strJ.substring(0, strI.length());
                        if(substring.equals(strI)) willBeRemoveStrs.add(strJ);
                    }
                }
            }
        }
        strings.removeAll(willBeRemoveStrs);
    }
}
