/**
 * FileName: FaceIdentitySenderImp
 * Author:   Administrator
 * Date:     2019/8/24 11:57
 * Description:
 */
package http.okhttp.test;

import bytes.Constants;
import com.alibaba.fastjson.JSON;
import pojo.PictureInfoBean;
import thread.ParalleTesk;

import java.io.File;

public class FaceIdentitySenderImp extends FaceIdentitySender {


    @Override
    void sendRPic(PictureInfoBean picR) {
        final String uuid = picR.getAlarmseq();
        final String address = "http://"+ip+":18082/picture/upload/byte?deviceid="+picR.getDeviceid()+"&channelid=1&alarmseq=" + uuid + "&datetime="+picR+"&name="+picR.getName()+"&type="+picR.getType();
        this.getClass().getClassLoader().getResource("文件名").getPath();
        File file = new File("classpath*:/pic/faceIdentify_R.jpg");

        byte[] fileToByte = getFileToByte(file);
        this.post(address, fileToByte);
    }

    @Override
    void sendBPic(PictureInfoBean picB) {
        final String uuid = picB.getAlarmseq();
        final String address = "http://"+ip+":18082/picture/upload/byte?deviceid="+picB.getDeviceid()+"&channelid=1&alarmseq=" + uuid + "&datetime="+picB+"&name="+picB.getName()+"&type="+picB.getType();

        File file = new File("classpath*:/pic/faceIdentify_B.jpg");

        byte[] fileToByte = getFileToByte(file);
        this.post(address, fileToByte);
    }

    @Override
    void sendSPic(PictureInfoBean picS) {
        final String uuid = picS.getAlarmseq();
        final String address = "http://"+ip+":18082/picture/upload/byte?deviceid="+picS.getDeviceid()+"&channelid=1&alarmseq=" + uuid + "&datetime="+picS+"&name="+picS.getName()+"&type="+picS.getType();

        File file = new File("classpath*:/pic/faceIdentify_S.jpg");

        byte[] fileToByte = getFileToByte(file);
        this.post(address, fileToByte);
    }

    @Override
    void sendAlarm(SendData.Total total) {
        final String requestbodyStr = JSON.toJSONString(total.getAlarm());
        super.postAlarm(requestbodyStr);
    }


    /**
     * 发送一组人脸识别报警（报警，大图，小图，注册图）
     */
    private static void send(){
        SendData sendData = new SendData();
        final SendData.Total total = sendData.new Total();
        final FaceIdentitySenderImp faceIdentitySenderImp = new FaceIdentitySenderImp();
        faceIdentitySenderImp.sendAlarm(total);
        faceIdentitySenderImp.sendPicture(total);

    }

    private static int threadNum = 1;
    /**
     *  示例
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Constants.strTheSun);
        for (String s : args) {
            final String[] split = s.split("=");
            if (split.length == 2) {
                final String key = split[0];
                final String value = split[1];
                dealMainArgs(key, value);
            }
            if (split.length == 1) {
                dealMainArgs(s);
                if (s.equalsIgnoreCase("-Help")) return;
            }
        }
        Runnable runnable = ()->{
            send();
        };


        if(args != null && args.length>0){

        }
        ParalleTesk.parallelTesk(threadNum,runnable);
    }

    private static void dealMainArgs(String param) {
        switch (param) {
            case "-Help": {
                System.out.println("-Thread 并发数量(默认1))");
                System.out.println("-Deviceid 设备id(默认33010610000F4246)");
                System.out.println("-Idcard 身份证号(默认123123234523452345)");
                System.out.println("-Ip ip地址(默认172.18.31.15)");
                System.out.println("-Channelid 通道号(默认1)");
                System.out.println("eg: java -jar nexius-1.3.1-SNAPSHOT.jar -Thread=1 -Deviceid=1111111111111 -Idcard=12212312311111111 等");
            }
            break;
        }
    }

    private static void dealMainArgs(String key, String value) {
        switch (key) {
            case "-Thread": {
                try {
                    final int i = Integer.parseInt(value);
                    logger.info("thread count is " + i);
                    threadNum = i;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println();
                }
            }
            case "-Deviceid": {
                SendData.deviceid = value;
                logger.info("deviceid is " + value);
            }
            break;
            case "-Idcard": {
                SendData.idCard = value;
                logger.info("idcard is" + value);
            }
            break;
            case "-Ip": {
                ip = value;
                logger.info("ip address is" + value);
            }break;
            case "-Channelid": {
                SendData.channelid = Integer.valueOf(value);
            }
            default:
                logger.info("不支持的参数配置");
        }
    }

}
