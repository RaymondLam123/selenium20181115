package testNG20180905;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/9/6 0006.
 */
public class AssertDemo1 {
    @Test
    public void test1() {
        String a = "111";
        String b = "222";
        Assert.assertEquals(a, b);
        //抛异常后不会执行
        System.out.println("test1....");
    }

    @Test
    public void test2() {
        String a = "111";
        String b = "222";
        Assert.assertNotEquals(a, b);
        //会执行
        System.out.println("test2....");
    }

    @Test
    public void test3() {
        String a = null;
        Assert.assertNull(a);
    }


}
