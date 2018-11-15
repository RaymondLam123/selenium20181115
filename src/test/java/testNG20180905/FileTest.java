package testNG20180905;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/11/2 0002.
 */
public class FileTest {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrower() {
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }

    /**
     * w文件上传
     *
     * @throws InterruptedException
     */
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Administrator\\Desktop\\abc.txt");
        Thread.sleep(3000);
    }


    @AfterMethod
    public void quitBrower() {
        driver.quit();
    }
}
