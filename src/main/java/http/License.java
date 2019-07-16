/**
 * FileName: License
 * Author:   Administrator
 * Date:     2019/7/11 17:26
 * Description:
 */
package http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.*;
import http.okhttp.OkHttpCLient;
import http.okhttp.OkHttpClientTest;
import org.springframework.beans.factory.annotation.Value;
import pojo.AlertInfoBean;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Logger;

import static http.okhttp.OkHttpClientTest.getFileToByte;

public class License {
    Integer param1;

    private static Logger logger = Logger.getLogger(OkHttpClientTest.class.getName());


    static LinkedBlockingQueue<Map> queue = new LinkedBlockingQueue();


    /**
     * 车牌信息
     */
    public static final String[] LICENSE= new String[]{
            "川A88888","赣AQ7182","赣D00009","冀E59437",
            "辽H9987E","鲁PI5396","浙B999AA","浙C5S250"
    };

    /**
     * 省份信息
     */
    public enum Province{
        京(11000,"京"),津(12000,"津"),冀(13000,"冀"),晋(14000,"晋"),蒙(15000,"蒙"),辽(21000,"辽"),吉(22000,"吉"),
        黑(23000,"黑"),沪(31000,"沪"),苏(32000,"苏"),浙(33000,"浙"),皖(34000,"皖"),闽(35000,"闽"),赣(36000,"赣"),
        鲁(37000,"鲁"),豫(41000,"豫"),鄂(42000,"鄂"),湘(43000,"湘"),粤(44000,"粤"),桂(45000,"桂"),琼(46000,"琼"),
        渝(50000,"渝"),川(51000,"川"),贵(52000,"贵"),云(53000,"云"),藏(54000,"藏"),陕(61000,"陕"),甘(62000,"甘"),
        青(63000,"青"),宁(64000,"宁"),新(65000,"新"),台(71000,"台"),港(81000,"港"),澳(82000,"澳");

        private Integer code;
        private String province;

        public Integer getCode() {
            return code;
        }

        Province(Integer code, String province) {
            this.code = code;
            this.province = province;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }
    }

    /**
     * 设备信息
     */
   public static final String[] DEVICEIDS = new String[]{
            "55000010000F4244",
            "55000010000F4246",
            "55000010000F4248",
            "55000010000F424A",
            "55000010000F424D",
            "55000010000F4251",
            "55000010000F4253",
            "55000010000F4254",
    };


    /**
     * 车牌图片上报到图片服务器
     */
    private static Function<String,String> functionLicencePic = (string) -> {

        Map map = null;
        try {
            map = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String uuid = ((String) map.get("uuid"));
        String deviceid = ((String) map.get("deviceid"));
        String detail = (String) map.get("detail");
        int stateThat = (int) map.get("state");
        if(stateThat == 2){
            return "";
        }
        JSONObject jsonObject = JSON.parseObject(detail, JSONObject.class);
        String detailjson = jsonObject.getString("detailjson");
        List<Map> maps = JSON.parseArray(detailjson, Map.class);
        String completedLicense = (String) maps.get(0).get("CompletedLicense");
        String cropPicName = (String) maps.get(0).get("CropPicName");



        File licensPic = new File("D:\\tmp\\licence/" + completedLicense + ".jpg");
        byte[] fileToByteLicence = getFileToByte(licensPic);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd%HH:mm:ss");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
        SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df3.format(new Date());
        Request request = new Request.Builder()
                .url("http://"+string+":18082/picture/upload/byte?deviceid="+deviceid+"&channelid=1&alarmseq=" + uuid + "&datetime="+format+"&name="+cropPicName+"&type=parkingState")
                .header("Content-Type", "application/octet-stream")
                .addHeader("Accept", "*/*")
                .post(RequestBody.create(MediaType.parse("application/octet-stream"), fileToByteLicence))
                .build();


        Response response;
        try {
            response = OkHttpCLient.client.newCall(request).execute();
            boolean successful = response.isSuccessful();
            logger.info("response.isSuccessful():" + String.valueOf(successful));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "1";
    };


    /**
     * 车牌识别上报 到ams
     */
    private static BiFunction<String, String, String> functionLicense = (deviceid, ip)->{
        String uuid = UUID.randomUUID().toString();
        String detail = getDetail("parkingState", deviceid);



        AlertInfoBean carLicense = new AlertInfoBean.Builder()
                .alarmseq(uuid)
                .alarmtime(OkHttpClientTest.df3.format(new Date()))
                .type("card")
                .channelid(1)
                .deviceid(deviceid)
                .state(1)
                .detail(detail).build();

        Map map = new HashMap();
        map.put("uuid", uuid);
        map.put("detail", detail);
        map.put("deviceid", deviceid);
        map.put("channelid", 1);
        int state = 1;
        String post= null;
        while (state < 3){
            carLicense.setState(state);

            map.put("state", state);
            queue.offer(map);
            String s = JSON.toJSONString(carLicense);
            post = OkHttpCLient.post(ip, s);

            state ++;
        }
        return post;
    };

    private static String getDetail(String type, String deviceid) {
        String restr = "";
        switch (type){
            case "parkingState":{

                Map licenseJson = new HashMap();
                double random = Math.random();
                int rd5 = (int) (random * 5);
                int rd2 = (Math.random() > 0.5 ? 1:0);
                String license = LICENSE[rd5];
                String provinceStr = license.substring(0,1);
                Province province = Province.valueOf(provinceStr);
                license = license.substring(1,license.length());
                Integer code = Province.valueOf(provinceStr).code;

                licenseJson.put("License", license);
                licenseJson.put("Type", 1);
                licenseJson.put("Province", code);
                licenseJson.put("ParkingIndex", rd2);
                licenseJson.put("CompletedLicense", province.getProvince() + license);
                licenseJson.put("CropPicName", "card_s_1_"+new Date().getTime()/1000 + ".jpg");
                Map mapDetailJson = new HashMap();
                mapDetailJson.put("detailjson", new Map[]{licenseJson});

                String fullPicNmae = "card_b_devId%s_ch0001_%s.jpg";
                DateFormat df = new SimpleDateFormat("YYYYMMDD-hh:mm:ss");
                String format = df.format(new Date());

                fullPicNmae = String.format(fullPicNmae, deviceid,"20190710_185954", format);

                mapDetailJson.put("FullPicName", fullPicNmae);

                restr = JSON.toJSONString(mapDetailJson);



            }break;
            default:break;
        }

        return restr;
    }







    //=======================run===========================================


    public static void main(String[] args) {

        String deviceid = System.getProperty("deviceid");
        License license = new License();
        Integer param1 = license.param1;
        System.out.println(param1);
        String s1 = "172.18.31.15";
        String s2 = "127.0.0.1";
        Runnable runnable = ()->{
            while (true){
                String ip = s1;
                license.functionLicense.apply(deviceid, ip);
                functionLicencePic.apply(ip);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //===============================================

        new Thread(runnable).start();
        System.out.println(1111);
    }

}
