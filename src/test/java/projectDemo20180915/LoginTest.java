package projectDemo20180915;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/9/15 0015.
 * qq邮箱登陆demo
 */
public class LoginTest {
    WebDriver wr;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "E:\\ideawork\\seleniumDemo20180905\\drivers\\chromedriver.exe");
        wr = new ChromeDriver();
        wr.get("https://mail.qq.com/");
    }

    @Test
    public void loginSuccess() {
        //控制权转交
        wr.switchTo().frame("login_frame");
        //切换账号密码登陆
        //  new WebDriverWait(wr, 3).until(ExpectedConditions.presenceOfElementLocated(By.id("switcher_plogin")));
        wr.findElement(By.id("switcher_plogin")).click();
        //输入账号
        wr.findElement(By.id("u")).sendKeys("849469088");
        //输入密码
        wr.findElement(By.id("p")).sendKeys("php963852741");
        //点击登陆
        wr.findElement(By.id("login_button")).click();
        new WebDriverWait(wr, 3).until(ExpectedConditions.presenceOfElementLocated(By.id("useralias")));
        //转交控制权
        wr.switchTo().frame("mainFrame");
        //  new WebDriverWait(wr, 3).until(ExpectedConditions.presenceOfElementLocated(By.linkText("on my way")));
        String linktext = wr.findElement(By.linkText("on my way")).getText();
        Assert.assertEquals(linktext, "on my way");


    }

    @AfterMethod
    public void after() {
        wr.quit();
    }
}
