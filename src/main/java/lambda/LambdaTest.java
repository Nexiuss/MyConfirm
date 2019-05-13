/**
 * FileName: LambdaTest
 * Author:   Administrator
 * Date:     2019/4/28 16:15
 * Description:
 */
package lambda;

import java.util.function.BiFunction;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class LambdaTest {
   private static Logger logger = Logger.getLogger(LambdaTest.class.getName());

    public static void main(String[] args) {


        /*Supplier*/
        Supplier<String>stringSupplier = ()->{return "1111111111";};
        String s = stringSupplier.get();

        /*Function*/
        Function<String,String> function = (str)->{
            logger.info(str);
            return "111111111";
        };
        String apply = function.apply("111");
        logger.info(s);

        /*BitFunction*/
        BiFunction<String, Integer, String >  biFunction = (param1, param2)->{
            logger.info(param1);
            logger.info(param2.toString());
            return "1111111111";
        };

        DoubleSupplier doubleSupplier = () -> {
            System.out.println(111);
            return 1;
        };

        doubleSupplier.getAsDouble();


    }
}
