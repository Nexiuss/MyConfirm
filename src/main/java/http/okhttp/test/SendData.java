/**
 * FileName: SendData
 * Author:   Administrator
 * Date:     2019/8/24 14:34
 * Description:
 */
package http.okhttp.test;

import pojo.AlertInfoBean;
import pojo.PictureInfoBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SendData {
    private final static int channelid = 1;
    public static String deviceid = "33010610000F4246";
    public static final String pictureDfStr = "yyyyMMdd_HHmmss";
    public static final String dfStrCommon = "yyyy-MM-dd HH:mm:ss";
    public  static String idCard = "123123234523452345";

    class Total {
        private AlertInfoBean alarm;
        private PictureInfoBean picR;
        private PictureInfoBean picB;
        private PictureInfoBean picS;

        Total() {
            final String alarmset = UUID.randomUUID().toString();
            DateFormat df = new SimpleDateFormat(pictureDfStr);
            DateFormat dfCommon = new SimpleDateFormat(dfStrCommon);
            final String dtPic = df.format(new Date());
            final String dtCommon = dfCommon.format(new Date());
            String detail = "{" +
                    " \"channelid\": \"" + deviceid + "$1\"," +
                    "  \"faceIdtResult\": [" +
                    "{" +
                    " \"desc\": {" +
                    "\"birth\": \"1994-10-09\"," +
                    "\"gender\": 2," +
                    " \"id\": 481," +
                    "\"idCard\": \""+idCard+"\"," +
                    " \"name\": \"ss\"," +
                    "\"role\": 1," +
                    " \"text\": \"平台注册\"" +
                    "  }," +
                    " \"matchRatio\": 92," +
                    " \"picNameR\": \"face_r_1_devId" + deviceid + "_ch0001_" + dtPic + ".jpg\"," +
                    "  \"picNameS\": \"face_s_1_devId" + deviceid + "_ch0001_" + dtPic + ".jpg\"," +
                    "   \"rect\": {" +
                    " \"h\": 137," +
                    " \"w\": 136," +
                    "\"x\": 562," +
                    "  \"y\": 286" +
                    " }" +
                    " }" +
                    "]," +
                    "  \"facenum\": 1" +
                    " }";
            final String picBName = "face_b_devId" + deviceid + "_ch0001_" + dtPic + ".jpg";
            final String picSName = "face_s_1_devId" + deviceid + "_ch0001_" + dtPic + ".jpg";
            final String picRName = "face_r_1_devId" + deviceid + "_ch0001_" + dtPic + ".jpg";
            this.alarm = new AlertInfoBean.Builder()
                    .alarmseq(alarmset)
                    .channelid(channelid)
                    .alarmtime(dtCommon)
                    .detail(detail)
                    .deviceid(deviceid)
                    .state(1)
                    .type("faceIdentify").build();

            this.picB = new PictureInfoBean.Builder()
                    .alarmseq(alarmset)
                    .channelid(1)
                    .datetime(dtCommon)
                    .deviceid(deviceid)
                    .type("faceIdentify")
                    .name(picBName).build();
            this.picS = new PictureInfoBean.Builder()
                    .alarmseq(alarmset)
                    .channelid(1)
                    .datetime(dtCommon)
                    .deviceid(deviceid)
                    .type("faceIdentify")
                    .name(picSName).build();

            this.picR = new PictureInfoBean.Builder()
                    .alarmseq(alarmset)
                    .channelid(1)
                    .datetime(dtCommon)
                    .deviceid(deviceid)
                    .type("faceIdentify")
                    .name(picRName).build();

        }

        public AlertInfoBean getAlarm() {
            return alarm;
        }

        public PictureInfoBean getPicR() {
            return picR;
        }

        public PictureInfoBean getPicB() {
            return picB;
        }

        public PictureInfoBean getPicS() {
            return picS;
        }
    }

    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat(pictureDfStr);
        DateFormat dfCommon = new SimpleDateFormat(dfStrCommon);
        final String dtPic = df.format(new Date());
        final String dtCommon = dfCommon.format(new Date());

        System.out.println(dtCommon + dtPic);
    }
}
