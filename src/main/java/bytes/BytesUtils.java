/**
 * FileName: BytesUtils
 * Author:   Administrator
 * Date:     2019/2/14 9:50
 * Description:
 */
package bytes;

import java.io.UnsupportedEncodingException;

public class BytesUtils {


    public static String bytes2Hex(byte[] bArr)
    {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;

        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2) sb.append(0);
            sb.append(sTmp.toUpperCase());
        }

        return sb.toString();
    }

    public static byte[] hex2Bytes(String s) {
        s = s.replace(" ", "");
        byte[] bArr = new byte[s.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            try {
                bArr[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bArr;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

//        byte[] bytes1 = hex2Bytes(Constants.OrgXML);
//        String gbk1 = new String(bytes1, "GBK");
        byte[] bytes = hex2Bytes(Constants.casstr);
        String gbk2 = new String(bytes, "GBK");
        System.out.println(gbk2);


    }
}
