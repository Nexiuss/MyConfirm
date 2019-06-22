/**
 * FileName: LombokTest
 * Author:   Administrator
 * Date:     2019/5/24 9:48
 * Description:
 */
package lombok;
@Getter
@Setter
@ToString
public class LombokTest {
    TestBean testBean = new TestBean();
    @Getter
    @Setter
    @ToString
    class TestBean{

        private String string;
        private Integer integer;
    }



    public static void main(String[] args) {
        LombokTest lombokTest = new LombokTest();
        TestBean testBean = lombokTest.getTestBean();
        
    }
}
