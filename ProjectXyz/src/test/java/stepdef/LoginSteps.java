package stepdef;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.SignInPage;
import resuable.BaseCode;

public class LoginSteps {

    HomePage h;
    SignInPage signInPage;
    WebDriver driver = BaseCode.driver;
    public LoginSteps(){
        h = new HomePage(driver);
        signInPage = new SignInPage(driver);

    }

    @Given("user enter the user name and password")
    public void enter(){

        h.clickSignIn();
        signInPage.enterMail().clickContinue();
        Assert.assertEquals(true,signInPage.verifyEnable());
    }
}
