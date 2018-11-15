package testNG20180905;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2018/9/7 0007.
 */
public class OperateElementTest {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrower() {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //访问百度首页
        //driver.get("https://www.baidu.com/");
        //访问贴吧首页
        driver.get("https://tieba.baidu.com/index.html");
    }

    @Test
    public void test1() throws InterruptedException {

        // WebElement e = driver.findElement(By.id("kw"));
        WebElement e = driver.findElement(By.linkText("关于百度"));
        //点击时间
        e.click();
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
        //设置文本
        WebElement element = driver.findElement(By.id("wd1"));
        element.sendKeys("林峰");
        Thread.sleep(3000);
        //清空文本
        element.clear();
        Thread.sleep(3000);
        //点击事件
        // driver.findElement(By.linkText("进入贴吧")).click();
        Thread.sleep(3000);
    }

    @Test
    public void test3() throws InterruptedException {

        String text = driver.findElement(By.linkText("进入贴吧")).getText();
        System.out.println("text:" + text);
        Thread.sleep(3000);
    }

    @Test
    public void test4() throws IOException, InterruptedException {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new FileOutputStream("d://baidu.png"));

        Thread.sleep(3000);
    }

    @AfterMethod
    public void quitBrower() {
        driver.quit();
    }
}
