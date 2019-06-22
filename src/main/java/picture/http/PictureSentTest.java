/**
 * FileName: PictureSentTest
 * Author:   Administrator
 * Date:     2019/4/30 8:58
 * Description:
 */
package picture.http;

import bytes.BytesUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PictureSentTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\tmp/tmp.txt");

        InputStream is = new FileInputStream(file);


        StringBuilder sb = new StringBuilder();
        int read;
        while ((read=is.read())!= -1){
            sb.append(read);
        }
        is.close();

        byte[] bytes = BytesUtils.hex2Bytes("6e616d653d22e7bb84e7bb87e7bb93e69e84726f6f742220");
        String s = new String(bytes,"GBK");
        System.out.println(s);


        System.out.println(sb.toString());

    }
}
