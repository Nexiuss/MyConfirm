/**
 * FileName: Person
 * Author:   Administrator
 * Date:     2019/8/15 17:20
 * Description:
 */
package pojo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Person {
    private  int age;
    private  String year;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public static void main(String[] args) {
        final Person person = new Person();
        System.out.println(JSON.toJSONString(person));
        ObjectMapper m =new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String str = " {\"age\":0,\"ages\":2}";
        final Person person1 = JSON.parseObject(str, Person.class);
        try {
            final Person person2 = m.readValue(str, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(person1);
    }
}
