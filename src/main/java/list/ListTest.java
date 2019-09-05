/**
 * FileName: ListTest
 * Author:   Administrator
 * Date:     2019/4/23 11:42
 * Description:
 */
package list;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {
    public static void main(String[] args) throws InterruptedException {

       String[]  str = {"-Deviceid=E500001000000539","-Ip=172.18.31.15","-Channelid=1"};

        for (String s : str) {
            final String[] split = s.split("=");
            if(split.length == 2){
                final String key = split[0];
                final String value = split[1];

            }
        }

    }
}
