package stepdef;

import resuable.PageObjectManger;

public class MagagerSteps {

    PageObjectManger pageObjectManger;
    public MagagerSteps(){
        pageObjectManger = new PageObjectManger();
    }

    public void m1(){

        pageObjectManger.homePage.clickSignIn();
        pageObjectManger.signPage.enterMail().clickContinue();
    }
}
