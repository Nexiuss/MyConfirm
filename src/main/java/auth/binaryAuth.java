/**
 * FileName: binaryAuth
 * Author:   Administrator
 * Date:     2019/8/9 15:52
 * Description: 二进制权限设计
 */
package auth;

public class binaryAuth {
    enum AuthEnum{
        x1,x2,x3,x4,x5,x6,x7,x8,x9
    }
}


class AuthBean{
    String id;
    Integer right = 0;
}