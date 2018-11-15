package testNG20180905;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/9/6 0006.
 */
public class BrowerActionTest {

    @Test
    public void ChromeAction() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        WebDriver WebDriver = new ChromeDriver();
        //访问百度首页
        //  WebDriver.get("https://www.google.com.hk/");
        WebDriver.get("http://www.baidu.com/");
        //等待2s
        Thread.sleep(2000);
        //后退
        // WebDriver.navigate().back();
        //等待2s
        // Thread.sleep(2000);
        //前进
        // WebDriver.navigate().forward();
        //刷新
        WebDriver.navigate().refresh();
        Thread.sleep(5000);
        //关闭当前页
        //WebDriver.close();
        //关闭浏览器
        WebDriver.quit();


    }

    @Test
    public void chromeAction2() {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        WebDriver WebDriver = new ChromeDriver();
        //访问百度首页
        WebDriver.get("http://www.baidu.com/");
        //获取当前页面url
        String url = WebDriver.getCurrentUrl();
        //获取当前页面标题
        String title = WebDriver.getTitle();
        System.out.println("当前浏览器地址：" + url);
        System.out.println("当前浏览器标题：" + title);
        //关闭浏览器
        WebDriver.quit();
    }


}
