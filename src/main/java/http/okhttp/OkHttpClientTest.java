/**
 * FileName: OkHttpClientTest
 * Author:   Administrator
 * Date:     2019/4/30 9:44
 * Description:
 */
package http.okhttp;

import com.squareup.okhttp.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Logger;

public class OkHttpClientTest {
    private static Logger logger = Logger.getLogger(OkHttpClientTest.class.getName());
    public static void main(String[] args) throws IOException, InterruptedException {


        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(1, TimeUnit.SECONDS);
        client.setReadTimeout(1, TimeUnit.SECONDS);


        File file = new File("D:\\tmp/rBIfb1zHuqCAfPUDAAJvE59MXIU010.jpg");

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

        String s = "172.18.31.111";
        String s2 = "127.0.0.1";
        Runnable runnable = ()->{function.apply(s);};
        while (true){
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            runnable.run();
            Thread.sleep(1000);
        }




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
