import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager extends Utils {
    LoadProp loadProp = new LoadProp();
    //    String browserName = loadProp.getProperty("browser");
    String browserName = System.getProperty("browser");
    URL url = null;
    //boolean sauce = false;
    boolean sauce = Boolean.parseBoolean(System.getProperty("sauce"));

    public void openBrowser() {  //deciding locally or in sauce

        if (sauce) {
            //running in sauce
            System.out.println("running in sauce..........");
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("username"));
                sauceOptions.put("accessKey", loadProp.getProperty("key"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if (browserName.equalsIgnoreCase("firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("username"));
                sauceOptions.put("accessKey", loadProp.getProperty("key"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if (browserName.equalsIgnoreCase("edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("username"));
                sauceOptions.put("accessKey", loadProp.getProperty("key"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);

            }
        } else {
            System.out.println("running in local.............");

            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                //to open site in firefox browser
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                //to open site in edge browser
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();

            }
            // when does not open in right browser print wrong browser name
            else {
                System.out.println("Wrong browsername  :" + browserName);
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
    }public void closeBrowser()
    {
        driver.close();
    }
}
