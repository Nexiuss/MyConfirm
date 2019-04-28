/**
 * FileName: BinaryWeight
 * Author:   Administrator
 * Date:     2019/2/25 15:10
 * Description:
 */
package weightVal;

public class BinaryWeight {
    static int i = 1;

    public static void main(String[] args) {
        System.out.println(i + "" + i + i);

        String weightVal = "" +  i + i + i ;

        int i = Integer.parseInt(weightVal, 2);
        System.out.println(i);
    }
}
