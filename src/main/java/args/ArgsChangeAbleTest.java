/**
 * FileName: ArgsChangeAbleTest
 * Author:   Administrator
 * Date:     2019/5/10 15:06
 * Description:
 */
package args;

import java.util.function.Function;

public class ArgsChangeAbleTest
{


    private  static int fun(String... args){
        return 1;
    };

    Function<String,Integer> fun = (string)->{
        System.out.println(this.getClass().getCanonicalName());
        return 1;
    };

    public static void main(String[] args) {

        new ArgsChangeAbleTest().fun.apply("111");
    }
}
