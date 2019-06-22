/**
 * FileName: MyException
 * Author:   Administrator
 * Date:     2019/5/28 14:57
 * Description:
 */
package exception;

public class MyException extends RuntimeException {

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public static void main(String[] args) {


        try {
            System.out.println(111111111);

            throw new MyException(MyException.class.getName());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
