/**
 * FileName: ByteBufferTest
 * Author:   Administrator
 * Date:     2019/9/2 17:40
 * Description:
 */
package bytes;

import java.nio.Buffer;

public class ByteBufferTest {

    //观察Buffer底层存储情况
    public static void print(Buffer buffer, byte[] bs) {
        System.out.println(buffer.toString());
        for (int i = 0; i < bs.length; i++) {
            if (bs[i] != 0) {
                char c = (char)bs[i];
                System.out.print(c);
            } else {
                System.out.print("$");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {

      /*  java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.allocate(1024);
        byteBuffer.put((byte) 'H').put((byte) 'E').put((byte) 'L').put((byte) 'L').put((byte) 'O');
        System.out.println(byteBuffer);*/
        byte[] bs = new byte[10];
        java.nio.ByteBuffer buffer = java.nio.ByteBuffer.wrap(bs);
        System.out.println(buffer.toString());
        buffer.put((byte) 'H').put((byte) 'E').put((byte) 'L').put((byte) 'L').put((byte) 'O');
        buffer.mark();
        buffer.put((byte)' ').put((byte) 'W').put((byte) 'o').put(new byte[]{'r','l','d'});
        print(buffer,bs);

        buffer.reset();
        buffer.flip();
        byte b;
        while ((b = buffer.get()) !=0){
            System.out.println(b);
        }
        buffer.limit(buffer.position()).position(0);

    }
}
