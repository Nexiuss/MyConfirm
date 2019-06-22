/**
 * FileName: MultipartfileTest
 * Author:   Administrator
 * Date:     2019/6/6 16:22
 * Description:
 */
package file;

import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MultipartfileTest {

    public static void main(String[] args) throws IOException {

        File pdfFile = new File("D:\\Documents\\Pictures/hqx.jpg");
        FileInputStream fileInputStream = new FileInputStream(pdfFile);
        MultipartFile multipartFile = new MockMultipartFile(pdfFile.getName(), pdfFile.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);

        byte[] bytes = multipartFile.getBytes();
        boolean format = checkFileFormat(bytes);
        System.out.println(format);
    }

    private static boolean checkFileFormat(byte[] faceImgBytes) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < faceImgBytes.length; ++i) {
            String hex = Integer.toHexString(faceImgBytes[i] & 0xFF);
            if (hex.length() < 2) {
                hex = "0" + hex;
            }
            buffer.append(hex);
        }
        String fileToHex = buffer.toString();//获取文件16进制编码
        String fileCode = fileToHex.substring(0, 8);
        if (fileCode.equalsIgnoreCase("ffd8ffe0")) {
            return true;
        } else {
            return false;
        }
    }
}
