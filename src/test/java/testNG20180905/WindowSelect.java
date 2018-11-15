package testNG20180905;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/10/31 0031.
 * 选择window句柄
 */

public class WindowSelect {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrower() {
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///E:/selenium_html/index.html");
    }

    @Test
    public void winTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        String handle = driver.getWindowHandle();
        for (String handle2 : driver.getWindowHandles()) {
            if (handle2.equals(handle))
                continue;
            driver.switchTo().window(handle2);

        }
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(handle);
        driver.findElement(By.id("user")).sendKeys("123");


    }

    @AfterMethod
    public void quitBrower() {
        driver.quit();
    }
}
