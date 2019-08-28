/**
 * FileName: CameraBean
 * Author:   Administrator
 * Date:     2018/11/16 9:44
 * Description: cas向cms推送设备的格式。
 */
package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import json.Gson.JsonUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CameraBean
{
    private String id; //设备id
    private String name; //设备名称
    private String location; //安装位置
    private String purpose; // 用途
    private String information; //详细信息
    private Integer state; //在线状态 1在线 其他不在线


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public static void main(String[] args) throws IOException {

        String cameras = "{\n" +
                "    \"operation\": 1,\n" +
                "    \"cameras\": [\n" +
                "        {\n" +
                "            \"id\": \"Edca11111\",\n" +
                "            \"name\": \"ipc111\",\n" +
                "            \"location\": \"中国\",\n" +
                "            \"purpose\": \"purpose\",\n" +
                "            \"infomation\": \"infomation\",\n" +
                "            \"state\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"Edca11111\",\n" +
                "            \"name\": \"ipc111\",\n" +
                "            \"location\": \"中国\",\n" +
                "            \"purpose\": \"purpose\",\n" +
                "            \"infomation\": \"infomation\",\n" +
                "            \"state\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"Edca11111\",\n" +
                "            \"name\": \"ipc111\",\n" +
                "            \"location\": \"中国\",\n" +
                "            \"purpose\": \"purpose\",\n" +
                "            \"infomation\": \"infomation\",\n" +
                "            \"state\": 1\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        String str2 = "{\n" +
                "    \"operation\": 1,\n" +
                "    \"cameras\": [\n" +
                "        {\n" +
                "            \"id\": \"Edca11111\",\n" +
                "            \"state\": 1\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        Map objectFromJson = JsonUtils.getObjectFromJson(cameras, Map.class);
        Object camerasObj = objectFromJson.get("cameras");

        String jsonFromObject = JsonUtils.getJsonFromObject(camerasObj);
        List<CameraBean> arrayListFromJson = JsonUtils.getArrayListFromJson(jsonFromObject, CameraBean.class);
        System.out.println(arrayListFromJson.get(0).getId());
        Map map = JSONObject.parseObject(cameras, Map.class);
        jsonFromObject = JSON.toJSONString(map.get("cameras"));

        arrayListFromJson = JSONObject.parseArray(jsonFromObject, CameraBean.class);
        System.out.println(arrayListFromJson.get(0).getId());

        String rootCoding = "CD34001";

        Integer lastIndexCoding = Integer.parseInt(rootCoding.substring(rootCoding.length()-1));
        System.out.println(lastIndexCoding);
        String s = rootCoding.substring(0, rootCoding.length()) + (lastIndexCoding+1);
        System.out.println(s+"*****");

        String str = "{\"id\":0,\"deviceid\":\"679A0012030003EE\",\"type\":\"motionDetect\",\"state\":1,\"alarmtime\":\"2018-11-15 11:55:55\",\"channelid\":1,\"confirmtime\":null,\"confirmstate\":null,\"confirmUser\":null,\"alarmseq\":\"94c298b7-8877-4eda-8559-4a774c129a38\",\"domain\":null,\"detail\":null,\"alarmEndTime\":\"2018-11-15 12:00:00\",\"picUrl\":\"[{\\\"name\\\":\\\"图片1\\\",\\\"url\\\":\\\"http://172.17.1.22:18080/virtualFilePath/ims/devIdF900001000000431_ch01_20180824_003147.jpg\\\"},{\\\"name\\\":\\\"图片2\\\",\\\"url\\\":\\\"http://172.17.1.22:18080/virtualFilePath/ims/devIdF900001000000431_ch01_20180825_121758.jpg\\\"}]\",\"alarmLevel\":1,\"location\":\"浦沿街道\",\"deviceIp\":\"172.17.1.22\",\"alarmDeviceName\":\"集光IPC\",\"types\":null,\"message\":null,\"strAlarmtime\":null,\"alarmtimeStr\":null,\"deviceName\":null,\"timeBegin\":null,\"timeEnd\":null,\"channelType\":null,\"coding\":null,\"title\":null,\"devicesid\":null,\"alertlistisuse\":null,\"alertid\":null,\"alertlisttype\":null,\"alertlistgrade\":null,\"alertDeviceChannellist\":null,\"alertImgUrls\":null,\"subtype\":null,\"confirmTimeBegin\":null,\"confirmTimeEnd\":null,\"serverIP\":null}";

        String s2 = "{\"datetime\":\"2018-11-21 16:02:53\",\"data\":[{\"alarmDeviceName\":\"MTS\",\"alarmLevel\":2,\"deviceIp\":\"172.17.1.12\",\"deviceid\":\"2800000000000000\",\"location\":\"\",\"serverid\":1001,\"type\":\"serverOn\"}]}";
        String s1 = "{\"alarmDeviceName\":\"设备名\",\"alarmLevel\":1,\"datetime\":\"2018-11-16 10:00:00\",\"deviceIp\":\"172.17.88.202\",\"deviceid\":\"679A0012030003AA\",\"location\":\"333室\",\"serverid\":3001,\"type\":\"cpuTemp\"}";
    }
}
