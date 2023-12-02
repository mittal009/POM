import org.testng.annotations.Test;

public class TestSuite extends BaseTest
{
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void userShouldAbleTORegisterSuccessfully() {
        //click on registration button
        homePage.clickOnRegisterButton();
        //verify user is on register page
       registerPage.verifyUserIsOnRegisterPage();
        //enter registration details
       registerPage.enterRegistrationDetails();
        //verify user registered successfully;
    }

    @Test
    public void userShouldAbleToLoginSuccessfully()
    {

        homePage.clickOnRegisterButton();
       registerPage.enterRegistrationDetails();
        loginPage.clickOnLoginButton();
        loginPage.LoginDetails();}


    @Test
    public void acceptAlertPopUp() {
        //click on search button
        homePage.clickOnSearchButton();
    }

    @Test
    public void voteButtonAlert() {
        //click on vote button
        homePage.clickOnVoteButton();
    }

    @Test
    public void changeCurrency() {
        //select pound currency
        homePage.selectEuroCurrency();
    }


}
