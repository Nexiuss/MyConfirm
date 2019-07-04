/**
 * FileName: HttpResponseTest
 * Author:   Administrator
 * Date:     2018/12/18 9:40
 * Description:
 */
package http;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpResponseTest
{
    public static void main(String[] args) throws URISyntaxException, JsonProcessingException {
        HttpResponse response= new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");


        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("172.18.31.15")
                .setPort(18082)
                .setPath("/picture")
                .build();

        HttpPost httpPost = new HttpPost(uri);
        Map map = new HashMap();
        map.put("picUrl", new String[]{"http://172.18.31.15:18080/virtualFilePath/ims/1562209554777.jpg"});
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(map);
        StringEntity myEntity = new StringEntity(body, ContentType.create("application/json", "UTF-8"));
        httpPost.setEntity(myEntity);
        CloseableHttpResponse execute = null;
        try {

            execute = HttpClientBuilder.create().build().execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(execute);

    }

}
