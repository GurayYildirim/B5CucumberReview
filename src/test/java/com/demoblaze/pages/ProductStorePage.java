package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductStorePage extends BasePage{
    @FindBy (css = "#nameofuser")
    public WebElement welcomeUsername_lc;

    public void verifyWelcomeMessage_Mtd(String expectedMessage){
        BrowserUtils.waitFor(2);
        String actualMessage=welcomeUsername_lc.getText();

        Assert.assertEquals("Username does NOT match",expectedMessage,actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
    }
}
