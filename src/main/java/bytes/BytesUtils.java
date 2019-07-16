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
        /*byte[] bytes = hex2Bytes(Constants.casstr);
        String gbk2 = new String(bytes, "GBK");
        System.out.println(gbk2);*/

        byte[] bytes = hex2Bytes("485454502f312e3120323030204f4b0d0a436f6e74656e742d547970653a206170706c69636174696f6e2f6a736f6e0d0a436f6e74656e742d4c656e6774683a203239330d0a0d0a7b2022646576696365496422203a202245353030303031303030303030353132222c2022696d61676522203a20312c20226f70496e666f22203a205b207b20226465736322203a207b2022626972746822203a2022313233342d31322d3334222c202267656e64657222203a20322c2022696422203a203433312c202269644361726422203a2022313233343536313233343132333431323334222c20226e616d6522203a20227979222c2022726f6c6522203a20312c20227465787422203a2022c6bdcca8b1e0bcadc8cbd4b1d0c5cfa222207d207d205d2c20226f705479706522203a20342c2022726573756c7422203a207b20226d65737361676522203a20224f4b222c20226e756d22203a20323030207d2c2022746f74616c22203a2031207d0a");
        String gbk = new String(bytes, "GBK");

        System.out.println(gbk);
    }
}
