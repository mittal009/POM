import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage {
    public  void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void waitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static String timestamp() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void selectByText(By by, String text) {

        Select selectcurrency = new Select(driver.findElement(by));
        selectcurrency.selectByVisibleText(text);
    }


    public static String typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
        return text;
    }

    public static void captureScreenshot(String screenShotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(source, new File("ScreenshotsTS\\" + screenShotName + timestamp() + ".png"));
            System.out.println("Screenshot taken");
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }
}