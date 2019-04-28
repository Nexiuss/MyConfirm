/**
 * FileName: RegularEx
 * Author:   Administrator
 * Date:     2018/12/29 10:27
 * Description:
 */
package regex;

import org.apache.commons.lang3.ArrayUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx {
    public static void main(String[] args) {

        long versionLong = 0;
        long l = 0;
        String version = "2.9.1.0";

        String reg="^[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{1,2}[.][0-9]{1,2}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(version);
        boolean ismatch = matcher.matches();
        if(ismatch)
        {
            String[] versionSplit = version.split("\\.");
            if(versionSplit.length > 0){
                ArrayUtils.reverse(versionSplit);

            }
            for(int i = 0; i< versionSplit.length; i++)
            {
                int versionSplit$i = Integer.parseInt(versionSplit[i]);
                long pow = (long)Math.pow(10, 2 * i) * versionSplit$i;
                l += pow;
            }
            versionLong = l;
        }




        String reg2 = "^[m]\\d+$";
        Pattern pattern2 = Pattern.compile(reg2);
        Matcher matcher2 = pattern2.matcher("M1");
       ismatch = matcher2.matches();
        System.out.println(ismatch);

        String osName = "Linux";
        boolean matches = osName.matches("^(?i)Linux.*$");
        System.out.println(matcher);

    }
}
