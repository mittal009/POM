import org.openqa.selenium.By;

public class LoginPage extends Utils{
    public void clickOnLoginButton()
    {
        clickOnElement(By.className("ico-login"));
        waitForClickable(By.xpath("//a[@class=\"ico-login\"]"),(10));
    }
    String email = "Ali234alia"+timestamp()+"@yahoo.com";
    public void LoginDetails()
    {
        typeText(By.id("Email"), email);
        System.out.println(email);
        //type the email address
        typeText(By.id("Password"),"Aali2012@A");
        //type the password
//        clickOnElement(By.xpath("//label[@for=\"RememberMe\"]"));
        //click on login button
        clickOnElement(By.xpath("//button[contains(@class,' login-button')]"));
        //click on login button

    }
}

