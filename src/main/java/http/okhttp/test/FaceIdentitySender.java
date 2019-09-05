/**
 * FileName: FaceIdentitySender
 * Author:   Administrator
 * Date:     2019/8/24 14:31
 * Description:
 */
package http.okhttp.test;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.*;
import pojo.PictureInfoBean;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class FaceIdentitySender {
     static OkHttpClient client;

    static {
        client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
    }

    protected static String ip = "172.18.31.15";
    protected static Logger logger = Logger.getLogger(FaceIdentitySender.class.getName());

    protected void sendPicture(SendData.Total total){
        Runnable runnable1 = ()->{
            this.sendBPic(total.getPicB());
        };
        Runnable runnable2 = ()->{
            this.sendSPic(total.getPicS());
        };
        Runnable runnable3 = ()->{
            this.sendRPic(total.getPicR());
        };

        logger.info(JSON.toJSONString(total));
        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();
    }

    protected void post(String address, String  requestbodyStr){
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), requestbodyStr);
        this.post(address, requestBody);
    }

    protected void post(String address, byte[] bytes){
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), bytes);
        this.post(address, requestBody);
    }

    private void post(String address, RequestBody requestBody){
        Request request = new Request.Builder()
                .url(address)
                .addHeader("Accept", "*/*")
                .post(requestBody)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            boolean successful = response.isSuccessful();
            logger.info("response.isSuccessful():" + String.valueOf(successful));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void postAlarm(String  requestbodyStr){
        final String address = "http://" + ip + ":18102/api/v1/ams2.0/smart_alarm";
        this.post(address, requestbodyStr);
    }


    abstract void sendRPic(PictureInfoBean picR);

    abstract void sendBPic(PictureInfoBean picS);

    abstract void sendSPic(PictureInfoBean picS);

    abstract void sendAlarm(SendData.Total total);


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
