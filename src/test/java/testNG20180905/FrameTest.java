package testNG20180905;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/10/31 0031.
 */
public class FrameTest {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrower() {
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///E:/selenium_html/index.html");
    }

    /**
     * 获取iframe
     *
     * @throws InterruptedException
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.tagName("iframe"));
        //通过id或name的方式转交控制权
        //    driver.switchTo().frame("aa");
        //通过元素的形式转交
        driver.switchTo().frame(element);
        Thread.sleep(3000);
        driver.findElement(By.id("user")).sendKeys("旁观者悲");
        Thread.sleep(3000);
        //将控制权转交回当前页面
        driver.switchTo().defaultContent();

    }

    @Test
    public void selectedTest() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("select"));
        Select select = new Select(element);
        //索引
        select.selectByIndex(1);
        Thread.sleep(2000);
        //value值
        select.selectByValue("vivo");
        Thread.sleep(2000);
        //文本值
        //  select.deselectByVisibleText("huawei");
        Thread.sleep(2000);

    }


    @AfterMethod
    public void quitBrower() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

}
