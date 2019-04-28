/**
 * FileName: JsonMapTest
 * Author:   Administrator
 * Date:     2018/11/13 17:37
 * Description:
 */
package json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMapTest {
    public static void main(String[] args) {
       /* List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");
        Map map = new HashMap();
        map.put("list", stringList);

        Object list = map.get("list");
        stringList =  (ArrayList<String>)list;
        System.out.println(list);*/

        List<CameraBean> list = new ArrayList<>();
        CameraBean cameraBean = new CameraBean();
        cameraBean.setId("11111111");
        cameraBean.setInformation("23423432");
        cameraBean.setLocation("12231");
        cameraBean.setName("234234");
        cameraBean.setPurpose("234234");

        list.add(cameraBean);

        Map map = new HashMap();
        map.put("list", list);
        String string = JSON.toJSONString(map);
        map = JSON.parseObject(string, Map.class);

        list = (List<CameraBean>) map.get("list");
        System.out.println(list.get(0).getId());
        System.out.println(list);
    }
}
