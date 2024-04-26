package stepdef;

import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;
import resuable.BaseCode;

public class Step2 {

    HomePage homePage;
    SearchResultPage searchResultPage;
    WebDriver driver = BaseCode.driver;
    public Step2(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }



}
