package testNG20180905;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class TestNGDemo1 {
    @Test
    public void testCase1() {
        System.out.println("这是test1注解");

    }

    @Test
    public void testCase2() {
        System.out.println("这是test2注解");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("这是beforeTest");
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("这是beforeMethod");
    }


   /* @Test
    public void aaa() {
        System.out.println("aaa");
    }

    @Test
    public void bbb() {
        System.out.println("bbb");
    }*/

}
