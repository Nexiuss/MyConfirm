/**
 * FileName: ResourceReadTest
 * Author:   Administrator
 * Date:     2019/9/4 11:14
 * Description:
 */
package resource;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class ResourceReadTest {
    public static void main(String[] args) throws FileNotFoundException {
        final InputStream resourceAsStream = ResourceReadTest.class.getResourceAsStream("/faceIdentify_B.jpg");

        final ClassLoader classLoader = ResourceReadTest.class.getClassLoader();
        URL resource;
        resource = classLoader.getResource("allatori.xml");
        final String path = resource.getPath();
        System.out.println(path);
    }
}
