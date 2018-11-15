package testNG20180905;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/11/2 0002.
 */
public class ActionTest {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrower() {
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //   driver = new FirefoxDriver();
        //  driver.get("https://www.baidu.com/");
    }

    @Test
    public void clickTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.contextClick(element).perform();//右击元素
        Thread.sleep(3000);
        actions.doubleClick(element).perform();//双击元素
        Thread.sleep(3000);
    }

    @Test
    public void moveTest() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("tj_briicon"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        //模拟移动，看到的鼠标是不会动的
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
    }

    @Test
    public void dragTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/dragAndDrop.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 200, 200).perform();
        Thread.sleep(3000);
    }

    @Test
    public void multipleSelect() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        Actions builder = new Actions(driver);
        driver.manage().window().maximize();
        WebElement select = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        //先选中第三个option，再按shift键，再选第四个option
        Action multipleSelect = builder.click(options.get(2)).keyDown(Keys.SHIFT).click(options.get(3)).build();
        multipleSelect.perform();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void quitBrower() {
        driver.quit();
    }
}
