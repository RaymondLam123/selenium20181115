package testNG20180905;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/11/4 0004.
 */
public class GridHub {
    @DataProvider(name = "browser1")
    public Object[][] data() {
        return new Object[][]{
                {"http://192.168.43.119:6666", "chrome"
                },
                {"http://192.168.43.119:5555", "phantomjs"
                }
        };
    }

    @Test(dataProvider = "browser1")
    public void testData(String url, String browser) throws MalformedURLException {
        
        DesiredCapabilities desiredCapabilities;
        if (browser == "chrome") {
            desiredCapabilities = DesiredCapabilities.chrome();

        } else {
            desiredCapabilities = DesiredCapabilities.phantomjs();

        }
        WebDriver driver = new RemoteWebDriver(new URL(url + "/wd/hub"), desiredCapabilities);
        driver.get("https://www.baidu.com/");
        driver.quit();
    }
}
