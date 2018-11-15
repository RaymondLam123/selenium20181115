package testNG20180905;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * 执行js脚本
 * Created by Administrator on 2018/11/3 0003.
 */
public class JsTest {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrower() {
        //  System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.get("https://www.baidu.com/");
     
    }

    /**
     * 执行js脚本（主要有些操作通过js执行）
     */
    @Test
    public void exJS() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"123\");\n");
        //  Thread.sleep(3000);

    }

    /**
     * 通过PJS跑脚本
     */
    @Test
    public void testPJS() {
        System.setProperty("phantomjs.binary.path", "E:\\ideawork\\seleniumDemo20180905\\drivers\\phantomjs.exe");
        PhantomJSDriver driver2 = new PhantomJSDriver();
        driver2.get("https://www.baidu.com");
        String title = driver2.getTitle();
        System.out.println("title:" + title);
        driver2.quit();
    }

    @AfterMethod
    public void quitBrower() throws InterruptedException {

        Thread.sleep(3000);
        //   driver.quit();
    }
}
