/**
 * FileName: MapTest
 * Author:   Administrator
 * Date:     2018/11/6 17:01
 * Description:
 */
package map;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class MapTest
{


    public static void main(String[] args) {
        String  str = "{\"id\":6011,\"deviceid\":\"21000012030F4243\",\"type\":\"motionDetect\",\"state\":2,\"alarmtime\":\"2019-01-28 14:28:06\",\"channelid\":1,\"confirmtime\":null,\"confirmstate\":0,\"confirmUser\":null,\"alarmseq\":\"3c34a4d4-659d-4f67-9b73-30c096289c73\",\"domain\":null,\"detail\":\"\",\"alarmEndTime\":\"2019-01-28 14:28:20\",\"picUrl\":\"{\\\"name\\\":\\\"devId21000012030F4243_ch0001_20190128_142806.jpg\\\",\\\"url\\\":\\\"http://172.18.31.113:18086/group1/M04/00/38/rBIfcVxOoPiAYt4kAALO-PizPEU200.jpg\\\"}\",\"alarmLevel\":2,\"location\":\"1\",\"deviceIp\":\"172.18.30.85\",\"alarmDeviceName\":\"30.85\",\"types\":null,\"deviceids\":null,\"timeBegin\":null,\"timeEnd\":null,\"channelType\":null,\"message\":null,\"strAlarmtime\":null,\"alarmtimeStr\":null,\"deviceName\":null,\"coding\":null,\"title\":null,\"devicesid\":null,\"alertlistisuse\":null,\"alertid\":null,\"alertlisttype\":null,\"alertlistgrade\":null,\"alertDeviceChannellist\":null,\"alertImgUrls\":[\"http://172.18.31.113:18086/group1/M04/00/38/rBIfcVxOoPiAYt4kAALO-PizPEU200.jpg\"],\"subtype\":null,\"confirmTimeBegin\":null,\"confirmTimeEnd\":null,\"serverIP\":null}";
        Map map = JSON.parseObject(str, Map.class);
        String url = null;
        if(map.containsKey("picUrl"))
        {
             String picUrl= (String) map.get("picUrl");
            Map map1 = JSON.parseObject(picUrl, Map.class);
            if(map1.containsKey("url")) {

                url = (String) map1.get("url");
            }
        }
        System.out.println(url);
    }
}
