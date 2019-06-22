/**
 * FileName: Test
 * Author:   Administrator
 * Date:     2019/6/19 17:03
 * Description:
 */
package custome_comment;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test implements MethodInterceptor {
    @ParamName(flied ="param1" )
    public void doSomcething(String param1, String param2){
        System.out.println(param1);
        System.out.println(param2);
    }

    public static void main(String[] args) {


    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("执行AOP织入的代码!!!");
        Object ret = proxy.invokeSuper(obj, args);



        return ret;
    }
}
