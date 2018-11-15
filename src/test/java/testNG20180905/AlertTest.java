package testNG20180905;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/10/30 0030.
 */
public class AlertTest {
    WebDriver driver = null;


    public void openBrower() {
//        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        //   System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");


        //    driver = new InternetExplorerDriver();

        // driver.get("file:///E:/selenium_html/index.html");
    }

    @Test
    public void alertTest1() throws InterruptedException {
        System.setProperty("phantomjs.binary.path", "E:\\ideawork\\seleniumDemo20180905\\drivers\\phantomjs.exe");
        PhantomJSDriver driver2 = new PhantomJSDriver();
        driver2.get("file:///E:/selenium_html/index.html");
        WebElement element = driver2.findElement(By.className("confirm"));

        //WebElement element = driver.findElement(By.xpath("//*[@id=\"confirm\"]/input"));
        element.click();
        Thread.sleep(3000);
        Alert alert = driver2.switchTo().alert();
        //点击取消按钮,然后弹出警告框，点击确定
        alert.dismiss();
        Thread.sleep(3000);
        //点击确定按钮
        alert.accept();


    }

    @Test
    public void alertTest2() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.className("alert"));
        element.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        //点击确定按钮
        alert.accept();
        System.out.println("text:" + text);

    }

    @Test
    public void prompTest3() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.className("prompt"));
        element.click();
        //Thread.sleep(3000);
        Alert promp = driver.switchTo().alert();
        Thread.sleep(3000);
        //chrome浏览器有bug输入不了
        promp.sendKeys("nimeimei....");
        Thread.sleep(1000);
        //点击确定按钮
        promp.accept();
        Thread.sleep(3000);
        promp.accept();


    }


    @AfterMethod
    public void quitBrower() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

}
