package hookspack;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resuable.BaseCode;

import java.io.IOException;

public class Hooks {

    @Before()
    public void preCondition() throws IOException {
        System.out.println("Execution Starts...........");
        BaseCode.lauchBrowser();
         }


    @After()
    public void postCondition(){

        BaseCode.driver.quit();
        System.out.println("Execution Ended");
    }


    @BeforeStep()
    public void beforeStep(){
        System.out.println("beforestep");
    }

    @AfterStep()
    public void afterStep(Scenario sc){

        byte[] bytedata =((TakesScreenshot)BaseCode.driver).getScreenshotAs(OutputType.BYTES);
        sc.attach(bytedata,"image/png",sc.getName());
    }


}
