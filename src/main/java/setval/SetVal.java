/**
 * FileName: SetVal
 * Author:   Administrator
 * Date:     2018/12/12 9:20
 * Description:
 */
package setval;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SetVal
{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        student.setAge(111);
        student.setHeight(112.02f);
        student.setName("test");

        Map map = new HashMap();
        map.put("age", 1111);
        map.put("height", 123123.33f);
        map.put("name", "nameCh");
       setProperty(student ,map);

        System.out.println(JSON.toJSONString(student));
    }

    /**
     * 该方法的参数列表是一个类的 类名、成员变量、给变量的赋值
     * @param obj
     * @param propertyNameAndVal Map<propertyName,propertyValue>
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setProperty(final Object obj, Map<String,Object> propertyNameAndVal)
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {


        Iterator<Map.Entry<String, Object>> iterator = propertyNameAndVal.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Object> next = iterator.next();
            Object value = next.getValue();
            String propertyName = next.getKey();
            Class c = obj.getClass();

            // 获取该类的成员变量
            Field f = c.getDeclaredField(propertyName);

            // 取消语言访问检查
            f.setAccessible(true);

            // 给变量赋值
            f.set(obj, value);
        }
    }


}
