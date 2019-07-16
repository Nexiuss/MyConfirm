/**
 * FileName: OkHttpClientTest
 * Author:   Administrator
 * Date:     2019/4/30 9:44
 * Description:
 */
package http.okhttp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.*;
import pojo.AlertInfoBean;
import pojo.Sensor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Logger;

public class OkHttpClientTest {
    private static Logger logger = Logger.getLogger(OkHttpClientTest.class.getName());
    private static boolean IS_RUN = true;

    private static int seq = 0;

    public static final SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd%HH:mm:ss");
    public static final SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
    public static final SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    static LinkedBlockingQueue<Map> queue = new LinkedBlockingQueue();

    public static void main(String[] args) throws IOException, InterruptedException {


        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(1, TimeUnit.SECONDS);
        client.setReadTimeout(1, TimeUnit.SECONDS);


        File file = new File("D:\\tmp/gx.jpg");

        byte[] fileToByte = getFileToByte(file);


        Function<String,String> function = (string) -> {
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd%HH:mm:ss");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String format1 = df1.format(new Date());
            String format2 = df2.format(new Date());
            Request request = new Request.Builder()
                    .url("http://"+string+":18082/picture/upload/byte?deviceid=21001112030F4247&channelid=1&alarmseq=" + uuid + "&datetime="+format1+"&name=ssd_s_15_0_devId21001112030F4247_ch0001_"+format2+".jpg&type=ssd")
                    .header("Content-Type", "application/octet-stream")
                    .addHeader("Accept", "*/*")
                    .post(RequestBody.create(MediaType.parse("application/octet-stream"), fileToByte))
                    .build();


            Response response = null;
            try {
                response = client.newCall(request).execute();
                boolean successful = response.isSuccessful();
                logger.info("response.isSuccessful():" + String.valueOf(successful));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "1";
        };




        // ================picture-licence=========================<<



        // ================================>>>
       final String[] deviceids = new String[]{
                "55000010000F4244",
                "55000010000F4246",
                "55000010000F4248",
                "55000010000F424A",
                "55000010000F424D",
                "55000010000F4251",
                "55000010000F4253",
                "55000010000F4254",
        };

        String[] deviceidsWeather = new String[]{
                "55000010000F4244-1",
                "55000010000F4246-2",
                "55000010000F4248-3",
                "55000010000F424A-4",
                "55000010000F424D-5",
                "55000010000F4251-6",
                "55000010000F4253-7",
                "55000010000F4254-8",
        };
        Function<String,String> functionWeather = (string) -> {
            double randomTemp = ( (Math.random() * 80 - 30));
            int randomInt = ((int) (Math.random() * 6));
            randomInt = 0;
            String deviceid = deviceidsWeather[randomInt];
            String[] split = deviceid.split("-");
            deviceid = split[0];
            Integer type = Integer.parseInt(split[1]);

            /*String body = "{" +
                    "    \"date\":    \"1970-01-01 06:17:03\"," +
                    "    \"deviceid\":    \""+deviceid+"\"," +
                    "    \"mac\":    \"00-84-14-85-20-41\"," +
                    "    \"sequence\":    0," +
                    "    \"sensors\":[{\"id\":1,\"name\":\"airTemp\",\"value\":\""+random+"\",\"unit\":\"°C\"},{\"id\":2,\"name\":\"airHumidity\",\"value\":\"50.0688\",\"unit\":\"%\"},{\"id\":3,\"name\":\"light\",\"value\":\"286.7156\",\"unit\":\"LUX\"},{\"id\":4,\"name\":\"CO2\",\"value\":\"405.000\",\"unit\":\"ppm\"},{\"id\":5,\"name\":\"noise\",\"value\":\"30.0\",\"unit\":\"db\"},{\"id\":6,\"name\":\"soilHumidity \",\"value\":\"49.9938\",\"unit\":\"%\"},{\"id\":7,\"name\":\"windDirection\",\"value\":\"1\",\"unit\":\"\"},{\"id\":8,\"name\":\"windSpeed\",\"value\":\"3.40\",\"unit\":\"m/s\"}]}";
           */



            String format1 = df1.format(new Date());
            String format2 = df2.format(new Date());
            String format3 = df3.format(new Date());

            List<Sensor> sensorArr = new ArrayList<>();
            Sensor sensor1 = new Sensor.Builder().id(1).name("airTemp").unit("°C").value(String.valueOf(randomTemp)).build();
            Sensor sensor2 = new Sensor.Builder().id(2).name("airHumidity").unit("%").value("50.0688").build();
            Sensor sensor3 = new Sensor.Builder().id(3).name("light").unit("LUX").value("286.7156").build();
            Sensor sensor4 = new Sensor.Builder().id(4).name("CO2").unit("ppm").value(String.valueOf(405.000)).build();
            Sensor sensor5 = new Sensor.Builder().id(5).name("noise").unit("db").value(String.valueOf(30.0)).build();
            Sensor sensor6 = new Sensor.Builder().id(6).name("soilHumidity").unit("%").value(String.valueOf(49.9938)).build();
            Sensor sensor7 = new Sensor.Builder().id(7).name("windDirection").unit("").value("1").build();
            Sensor sensor8 = new Sensor.Builder().id(8).name("windSpeed").unit("m/s").value("3.40").build();
            sensorArr.add(sensor1);
            sensorArr.add(sensor2);
            sensorArr.add(sensor3);
            sensorArr.add(sensor4);
            sensorArr.add(sensor5);
            sensorArr.add(sensor6);
            sensorArr.add(sensor7);
            sensorArr.add(sensor8);


            Sensor ensorsSend = sensorArr.get(type-1);
            /*String detail = "[[{\"id\": 1,\"name\": \"airTemp\",\"value\": \"0.7197718353544218\",\"unit\": \"°C\"},{\"id\": 2,\"name\": \"airHumidity\",\"value\": \"50.0688\",\"unit\": \"%\"},{\"id\": 3,\"name\": \"light\",\"value\": \"286.7156\",\"unit\": \"LUX\"},{\"id\": 4,\"name\": \"CO2\",\"value\": \"405.000\",\"unit\": \"ppm\"},{\"id\": 5,\"name\": \"noise\",\"value\": \"30.0\",\"unit\": \"db\"},{\"id\": 6,\"name\": \"soilHumidity \",\"value\": \"49.9938\",\"unit\": \"%\"},{\"id\": 7,\"name\": \"windDirection\",\"value\": \"1\",\"unit\": \"\"},{\"id\": 8,\"name\": \"windSpeed\",\"value\": \"3.40\",\"unit\": \"m/s\"}]]";
*/
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("sensors", new Sensor[]{ensorsSend});
            String detail = JSON.toJSONString(stringObjectHashMap );
            AlertInfoBean weather = new AlertInfoBean.Builder()
                    .alarmseq(UUID.randomUUID().toString())
                    .alarmtime(format3)
                    .type("weather")
                    .channelid(1)
                    .deviceid(deviceid)
                    .state(1)
                    .detail(detail).build();
            String s = JSON.toJSONString(weather);
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), s);
            Request request = new Request.Builder()
                    .url("http://"+string+":18102/api/v1/ams2.0/smart_alarm")
                    .addHeader("Accept", "*/*")
                    .post(requestBody)
                    .build();

            System.out.println(JSON.toJSONString(weather));
            Response response = null;
            try {
                response = client.newCall(request).execute();
                boolean successful = response.isSuccessful();
                logger.info("response.isSuccessful():" + String.valueOf(successful));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "1";
        };
        //  <<==============================



        // =============license==========>>



        // <<========== license ==============

        String s = "172.18.31.15";
        String s2 = "127.0.0.1";
        Runnable runnable = ()->{
            while (true){

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








    /**
     * 文件转为二进制数组
     * 等价于fileToBin
     * @param file
     * @return
     */
    public static byte[] getFileToByte(File file) {
        byte[] by;
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1) {
                bytestream.write(bb, 0, ch);
                ch = is.read(bb);
            }
            by = bytestream.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException("transform file into bin Array 出错",ex);
        }
        return by;
    }
}
