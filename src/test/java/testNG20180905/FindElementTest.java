package testNG20180905;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/9/7 0007.
 */
public class FindElementTest {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrower() {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void find() throws InterruptedException {
        driver.get("http://www.baidu.com/");
        //通过id属性查找
        WebElement e1 = driver.findElement(By.id("kw"));
        //通过name属性查找
        WebElement e2 = driver.findElement(By.name("wd"));
        //通过xpath表达式查找
        WebElement e3 = driver.findElement(By.xpath("/html//input[ @id='kw']"));
        String id = e3.getAttribute("id");
        // System.out.println("e1:" + e1);
        // System.out.println("e2:" + e2);
        System.out.println("id:" + id);
        Thread.sleep(3000);
    }

    @Test
    public void find2() throws InterruptedException {
        driver.get("http://www.baidu.com/");
        //<a>链接里的文本查找
        WebElement elements1 = driver.findElement(By.linkText("关于百度"));
        System.out.println(elements1.getText());
        //<a>链接里的部分文本查找
        List<WebElement> elements2 = driver.findElements(By.partialLinkText("百度"));
        for (WebElement e : elements2) {
            System.out.println(e.getText());
        }
        Thread.sleep(3000);
    }

    @AfterMethod
    public void quitBrower() {
        driver.quit();
    }


}
