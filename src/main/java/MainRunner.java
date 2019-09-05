import resource.ResourceReadTest;

import java.io.InputStream;
import java.net.URL;

/**
 * FileName: MainRunner
 * Author:   Administrator
 * Date:     2019/9/4 11:29
 * Description:
 */

public class MainRunner {
    public static void main(String[] args) {
        final InputStream resourceAsStream = ResourceReadTest.class.getResourceAsStream("/faceIdentify_B.jpg");
        final ClassLoader classLoader = ResourceReadTest.class.getClassLoader();
        URL resource = classLoader.getResource("faceIdentify_B.jpg");
        resource = classLoader.getResource("allatori.xml");
        final String path = resource.getPath();
        System.out.println(path);
    }
}
