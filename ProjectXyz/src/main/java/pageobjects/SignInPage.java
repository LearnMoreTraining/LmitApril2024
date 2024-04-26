package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    WebDriver driver ;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public SignInPage enterMail(){

        driver.findElement(By.id("ap_email")).sendKeys("an.aravinth22@gmail.com");
        return this;
    }

    public SignInPage enterMail(String email){

        driver.findElement(By.id("ap_email")).sendKeys(email);
        return this;
    }

    public SignInPage clickContinue(){

        driver.findElement(By.id("continue")).click();
        return this;
    }

    public boolean verifyEnable(){

       return  driver.findElement(By.id("abc")).isEnabled();
    }



}
