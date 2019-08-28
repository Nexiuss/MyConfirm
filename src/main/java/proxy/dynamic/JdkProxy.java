/**
 * FileName: JdkProxy
 * Author:   Administrator
 * Date:     2019/8/16 17:02
 * Description:
 */
package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {

    interface Star {
        default public void sing(String name) {
            System.out.println(String.format("%s is singing", name));
        }
    }

    static class ProxyInvocationHandler implements InvocationHandler {
        private Star star;

        public ProxyInvocationHandler(Star star) {
            this.star = star;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("增强");
            return method.invoke(star, args);
        }
    }


    public static void main(String[] args) {
        Star star = new Star() {
        };
        final Star starProxy = (Star) Proxy.newProxyInstance(star.getClass().getClassLoader(), star.getClass().getInterfaces(), new ProxyInvocationHandler(star));
        starProxy.sing("刘德华");

    }
}
