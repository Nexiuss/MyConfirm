/**
 * FileName: InnerClass
 * Author:   Administrator
 * Date:     2018/11/15 10:33
 * Description: 内部类测试
 */
package inner_class;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class InnerClass
{
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

    public String getParam3() {
        return param3;
    }

    public String getParam4() {
        return param4;
    }

    public String getParam5() {
        return param5;
    }

    public InnerClass() {
    }

    private InnerClass(Builder builder) {
        param1 = builder.param1;
        param2 = builder.param2;
        param3 = builder.param3;
        param4 = builder.param4;
        param5 = builder.param5;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public void setParam5(String param5) {
        this.param5 = param5;
    }

    public static final class Builder {
        private String param1;
        private String param2;
        private String param3;
        private String param4;
        private String param5;

        public Builder() {
        }

        public Builder param1(String val) {
            param1 = val;
            return this;
        }

        public Builder param2(String val) {
            param2 = val;
            return this;
        }

        public Builder param3(String val) {
            param3 = val;
            return this;
        }

        public Builder param4(String val) {
            param4 = val;
            return this;
        }

        public Builder param5(String val) {
            param5 = val;
            return this;
        }

        public InnerClass build() {
            return new InnerClass(this);
        }
    }

    public static void main(String[] args) throws IOException {
        InnerClass innerClass = new Builder().param1("1").param2("2").param3("3").build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);  //不需要继承序列化类
        //objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String string = objectMapper.writeValueAsString(innerClass);
        System.out.println(string);

        //InnerClass innerClass1 = objectMapper.readValue(string, JSON.class);

        System.out.println(innerClass.toString());
    }
}
