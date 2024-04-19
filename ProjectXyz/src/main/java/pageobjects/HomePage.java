package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;
    public void enterProductName(String productName){

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
    }

    public void clickSearchIcon(){

        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public void selectCategoryDropdownByIndex(int index){

        WebElement catEleemnt = driver.findElement(By.id("searchDropdownBox"));
        Select s = new Select(catEleemnt);
        s.selectByIndex(index);

    }
    public void selectCategoryDropdownByValue(String value){

        WebElement catEleemnt = driver.findElement(By.id("searchDropdownBox"));
        Select s = new Select(catEleemnt);
        s.selectByValue(value);

    }




}
