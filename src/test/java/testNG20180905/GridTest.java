package testNG20180905;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/11/4 0004.
 */
public class GridTest {
    @Test
    public void gridTest() throws InterruptedException {
        DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
        try {
            WebDriver driver = new RemoteWebDriver(new URL("http://192.168.43.119:6666/wd/hub"), chromeDC);
            driver.get("https://www.baidu.com/");
            Thread.sleep(3000);
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
