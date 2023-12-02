import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;

public class RegisterPage extends Utils
{
    String email = "Ali234alia"+timeStamp()+"@yahoo.com";
    public static String timeStamp()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }

    public void verifyUserIsOnRegisterPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    }
    public void enterRegistrationDetails()
    {
        waitForClickable(By.name("register-button"), 10);
        clickOnElement(By.linkText("Register"));
        //  driver.findElement(By.id("FirstName")).sendKeys("Alia");
        // type the first name
        typeText(By.id("FirstName"),"Alia");
        // driver.findElement(By.id("LastName")).sendKeys("Ali");//to type the last name
        typeText(By.id("LastName"),"Ali");
        selectByText(By.name("DateOfBirthDay"), "8");
        //to select the date of birthday
        //to select the month of the birth
        selectByText(By.name("DateOfBirthMonth"), "May");
        //to select month of birthday
        selectByText(By.name("DateOfBirthYear"), "1990");
        //to select year of birth
//        driver.findElement(By.id("Email")).sendKeys("Ali234alia"+timeStamp()+"@yahoo.com");
//        typeText(By.id("Email"), "Ali234alia"+timeStamp()+"@yahoo.com");
        System.out.println(email);
        typeText(By.id("Email"), email);
        //driver.findElement(By.id("Company")).sendKeys("AA Ltd");
        typeText(By.id("Company"),("AA Ltd"));
        //driver.findElement(By.id("Password")).sendKeys("Aali2012@A");
        typeText(By.id("Password"),("Aali2012@A"));
        //driver.findElement(By.id("ConfirmPassword")).sendKeys("Aali2012@A");
        typeText(By.id("ConfirmPassword"),("Aali2012@A"));
        //driver.findElement(By.linkText("register-button")).click();
        clickOnElement(By.id("register-button"));

    }
}
