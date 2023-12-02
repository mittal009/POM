import org.openqa.selenium.By;

public class HomePage extends Utils
{

        public void clickOnRegisterButton() {
            clickOnElement(By.linkText("Register"));
        }

        public void clickOnSearchButton() {
            clickOnElement(By.xpath("//button[@type='submit']"));
            driver.switchTo().alert().accept();
        }

        public void clickOnVoteButton() {
            clickOnElement(By.xpath("//button[@id=\"vote-poll-1\"]"));
            driver.switchTo().alert().accept();
//       Assert.assertTrue(driver.getTitle().equals("Please select an answer"));

        }

        public void selectEuroCurrency() {
            //select the euro currency on homepage
            selectByText(By.xpath("//select[@id=\"customerCurrency\"]"), "Euro");

        }
    }

