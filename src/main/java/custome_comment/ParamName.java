package custome_comment;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ParamName {



    String flied() default "";

    String value() default "";


    class ParameterNameUtil{
        public static List<String> getParameterNameJava8(Class clazz, String methodName) {
            List<String> paramterList = new ArrayList<>();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    //直接通过method就能拿到所有的参数
                    Parameter[] params = method.getParameters();
                    for (Parameter parameter : params) {
                        paramterList.add(parameter.getName());
                    }
                }
            }
            return paramterList;
        }
    }

}
