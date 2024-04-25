package stepdef;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resuable.BaseCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import resuable.ReadExcel;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalesForceSteps extends BaseCode {

    WebElement categoryElement;

    String amazonProdName ;


    @When("user enters the username {string} and password {string}")
    public void enterCredi(String userName, String password) {

//        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("");
//        driver.findElement(By.cssSelector("#username"));
       driver.findElement(By.id("username")).sendKeys(BaseCode.pro.getProperty("username"));
       driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("verify the title")
    public void verifyTitle(){

    }



    @And("user clicks on login button")
    public void clickLoginButton() {

        driver.findElement(By.id("Login")).click();
    }

    @Then("verfiy whether the user navigate to home page")
    public void verifyHomePage() {

    }


    @Then("verfify the error message")
    public void verfifyTheErrorMessage() {

       String actualResult = driver.findElement(By.id("error")).getText();
       String expectedResult = " check your username and password. If you still can't log in, contact your Salesforce administrator.";

     //  Assert.assertEquals(expectedResult,actualResult);

       if ( actualResult.equals(expectedResult)){

           Assert.assertTrue(true);
       }
       else{

           Assert.assertTrue(false);
       }
    }

    @When("user enter the product name {string} in search box")
    public void userEnterTheProductNameInSearchBox(String productName) {
        amazonProdName = productName;
        driver.findElement(By.xpath("//label[@for='twotabsearchtextbox']/following-sibling::input")).sendKeys(productName);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Then("verfiy the search result")
    public void verfiyTheSearchResult() {
        String acutalTitle = driver.getTitle();
        String expectedTitle = "Amazon.in : "+amazonProdName;

        Assert.assertEquals(acutalTitle,expectedTitle);



    }


    @When("user selects the required value from the category dropdown")
    public void selectCategory() {
      categoryElement = driver.findElement(By.id("searchDropdownBox"));
        Select selectCat = new Select(categoryElement);
       // selectCat.selectByIndex(4);
       // selectCat.selectByVisibleText("Books");
        selectCat.selectByValue("search-alias=automotive");
    }

    @And("extract the dropdown values")
    public void extractTheDropdownValues() {

       int categorySize = categoryElement.findElements(By.tagName("option")).size();
        for(int i =0 ; i < categorySize; i++ ){
           String value= categoryElement.findElements(By.tagName("option")).get(i).getText();
            System.out.println(value);
        }

    }

    @When("user extarct the column one value")
    public void userExtarctTheColumnOneValue() {

//       int colOneCount = driver.findElements(By.xpath("//table[@class='infobox vcard']/descendant::tr/child::th")).size();
//        for(int j=0; j < colOneCount ; j++){
//
//           String colOneValue= driver.findElements(By.xpath("//table[@class='infobox vcard']/descendant::tr/child::th")).get(j).getText();
//           System.out.println(colOneValue);
//        }
        List<String> val = new ArrayList<String>();
        List<WebElement> columnOneElement = driver.findElements(By.xpath("//table[@class='infobox vcard']/descendant::tr/child::th"));
        for(WebElement e:columnOneElement){
           val.add( e.getText());
        }

        System.out.println(val);
        for(String d:val){

           if(d.equals("Headquarters")){
               Assert.assertTrue(true);
               break;
           }
        }


 //       WebElement tab = driver.findElement(By.xpath("//table[@class='infobox vcard']"));

//        int sizzz =tab.findElements(By.tagName("th")).size();
//
//        List<String> columnOneValue = new ArrayList<String>(); //empty list
//        for(int k=0 ; k <sizzz; k++){
//
//            columnOneValue.add( tab.findElements(By.tagName("th")).get(k).getText());
//        }
//
//        System.out.println(columnOneValue);

//        List <WebElement> ce = tab.findElements(By.tagName("th"));
//        List <String> values = new ArrayList<String>();
//        for(WebElement h:ce){
//            values.add(h.getText());
//        }

//
//        int coln2 =tab.findElements(By.tagName("td")).size();
//
//        List <String> colTwoValues = new ArrayList<String>();
//        for(int k=2 ; k <coln2; k++){
//            colTwoValues.add(tab.findElements(By.tagName("td")).get(k).getText());
//        }
//
//        System.out.println(colTwoValues);
//
//       int acqtableCount= driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/child::tbody/child::tr/child::td[3]")).size();
//
//        for(int h =0 ; h < acqtableCount; h++){
//            driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/child::tbody/child::tr/child::td[3]")).get(h).getText();
//
//        }
//
//        WebElement acqElement= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']"));
//        acqElement.findElements(By.xpath("/child::tbody/child::tr/child::td[3]")).size();

    }

    @Given("user selects the baby wishlist")
    public void userSelectsTheBabyWishlist() {

        WebElement e = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions a = new Actions(driver);
        a.clickAndHold(e).build().perform();
        driver.findElement(By.linkText("Baby Wishlist")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));

    }

    @When("user navigates to child window")
    public void userNavigatesToChildWindow() {
        String parentProperty =driver.getWindowHandle();
        Set<String> handleValues = driver.getWindowHandles();

        for(String winPop:handleValues) {

            if (!winPop.equals(parentProperty)) {
                driver.switchTo().window(winPop);
                break;
            }
        }

        driver.findElement(By.linkText("Create your wishlist")).click();
        System.out.println(driver.getTitle());
        //  driver.switchTo().window(parentProperty);

    }

    @Given("user drag and drops")
    public void userDragAndDrops() {

        WebElement frameElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameElement);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        Actions drag = new Actions(driver);
        drag.dragAndDrop(dragElement,dropElement).build().perform();
        driver.switchTo().defaultContent();
    }

    @Given("user enter the credi")
    public void userEnterTheCredi() throws IOException {
        driver.findElement(By.id("username")).sendKeys(ReadExcel.getExcelData("login",0,0));
        driver.findElement(By.id("password")).sendKeys(ReadExcel.getExcelData("login",1,0));

    }

    @Given("enable disable")
    public void enableDisable() {

      boolean radio=  driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay")).isSelected();
        Assert.assertTrue(radio);

    boolean field =  driver.findElement(By.id("custom_date_picker_id_2"))  .isEnabled(); //false
        Assert.assertFalse(field);

        driver.findElement(By.xpath("//*[text()='FROM']")).isDisplayed();


       String s= driver.findElement(By.id("marketDate_2")).getAttribute("style");

        //display: block; opacity: 1; pointer-events: inherit;

        if(s.contains("0.5")){

        }

        driver.findElement(By.id("quote")).click();

        // 10 seconds
        try {
            driver.findElement(By.id("change_text")).getText();
        }
        catch(ElementClickInterceptedException e){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.pollingEvery(Duration.ofSeconds(10)); //6 times
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("change_text")));
            driver.findElement(By.id("change_text")).getText();
        }
        finally {

        }



    }

    @Given("user handles the alert")
    public void userHandlesTheAlert() {

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

       String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals("I am an alert box",alertMessage);
        driver.switchTo().alert().dismiss();
    }


}
