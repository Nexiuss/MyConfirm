/**
 * FileName: OkHttpCLient
 * Author:   Administrator
 * Date:     2018/10/12 14:06
 * Description:
 */
package http.okhttp;

import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class OkHttpCLient
{

    private static Logger logger = Logger.getLogger(OkHttpCLient.class.getName());
    public static OkHttpClient client;

    static void init(){
        client= new OkHttpClient();
        client.setConnectTimeout(1, TimeUnit.SECONDS);
        client.setReadTimeout(1, TimeUnit.SECONDS);
    }

    public static String post(String ip, String s) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), s);
        Request request = new Request.Builder()
                .url("http://"+ip+":18102/api/v1/ams2.0/smart_alarm")
                .addHeader("Accept", "*/*")
                .post(requestBody)
                .build();

        System.out.println("请求参数为》"+s);
        Response response;
        try {
            response = client.newCall(request).execute();
            boolean successful = response.isSuccessful();
            logger.info("response.isSuccessful():" + String.valueOf(successful));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "1";
    }
}
