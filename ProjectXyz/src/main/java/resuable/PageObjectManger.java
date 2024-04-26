package resuable;

import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.SignInPage;

public class PageObjectManger {

    public HomePage homePage;
    public SignInPage signPage;
   public WebDriver driver = BaseCode.driver;

    public PageObjectManger getHomePage(){

        homePage = new HomePage(driver);
        return this;
    }

    public PageObjectManger getSignInPage(){

        signPage = new SignInPage(driver);
        return this;
    }




}
