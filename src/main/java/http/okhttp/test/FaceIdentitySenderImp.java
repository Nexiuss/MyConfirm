/**
 * FileName: FaceIdentitySenderImp
 * Author:   Administrator
 * Date:     2019/8/24 11:57
 * Description:
 */
package http.okhttp.test;

import com.alibaba.fastjson.JSON;
import pojo.PictureInfoBean;
import thread.ParalleTesk;
import thread.ThreadPoolManager;

import java.io.File;

public class FaceIdentitySenderImp extends FaceIdentitySender {


    @Override
    void sendRPic(PictureInfoBean picR) {
        final String uuid = picR.getAlarmseq();
        final String address = "http://"+ip+":18082/picture/upload/byte?deviceid="+picR.getDeviceid()+"&channelid=1&alarmseq=" + uuid + "&datetime="+picR+"&name="+picR.getName()+"&type="+picR.getType();

        File file = new File("D:\\Documents\\Pictures/faceIdentify_R.jpg");

        byte[] fileToByte = getFileToByte(file);
        this.post(address, fileToByte);
    }

    @Override
    void sendBPic(PictureInfoBean picB) {
        final String uuid = picB.getAlarmseq();
        final String address = "http://"+ip+":18082/picture/upload/byte?deviceid="+picB.getDeviceid()+"&channelid=1&alarmseq=" + uuid + "&datetime="+picB+"&name="+picB.getName()+"&type="+picB.getType();

        File file = new File("D:\\Documents\\Pictures/faceIdentify_B.jpg");

        byte[] fileToByte = getFileToByte(file);
        this.post(address, fileToByte);
    }

    @Override
    void sendSPic(PictureInfoBean picS) {
        final String uuid = picS.getAlarmseq();
        final String address = "http://"+ip+":18082/picture/upload/byte?deviceid="+picS.getDeviceid()+"&channelid=1&alarmseq=" + uuid + "&datetime="+picS+"&name="+picS.getName()+"&type="+picS.getType();

        File file = new File("D:\\Documents\\Pictures/faceIdentify_S.jpg");

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
     *
     * @param args arg[0] 并发数量； arg[1] 设备id
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < args.length; i++) {
            dealMainArgs(i,args);
        }
        Runnable runnable = ()->{
            send();
        };


        if(args != null && args.length>0){

        }

        ParalleTesk.parallelTesk(threadNum,runnable);


    }

    private static void dealMainArgs(int index, String[] args){
        switch (index){
            case 0:{
                try {
                    final int i = Integer.parseInt(args[0]);
                    logger.info("thread count is "+ i);
                    threadNum = i;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println();
                }
            }
            break;
            case 1:{
                SendData.deviceid = args[1];
                logger.info("deviceid is "+args[1]);
            }
            break;
            case 2:{
                SendData.idCard = args[2];
                logger.info("idcard is" +args[2]);
            }break;
            default:
                logger.info("不支持的参数配置");
        }
    }

}
