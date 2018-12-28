/**
 * FileName: HttpResponseTest
 * Author:   Administrator
 * Date:     2018/12/18 9:40
 * Description:
 */
package http;


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

public class HttpResponseTest
{
    public static void main(String[] args) throws URISyntaxException {
        HttpResponse response= new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");


        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("172.18.31.15")
                .setPort(18080)
                .setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "")
                .build();
        HttpGet httpget = new HttpGet(uri);
        httpget.addHeader("date_param", "wewewwwwwwwwwwwwwwwwwwwwwwww");
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("date_param", "wewewwwwwwwwwwwwwwwwwwwwwwww");
        StringEntity myEntity = new StringEntity("{1,2,3}", ContentType.create("application/json", "UTF-8"));
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
