package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (css = "#login2")
    public WebElement loginHomePage_lc;

    @FindBy (id = "loginusername")
    public WebElement loginusername_lc;

    @FindBy (id = "loginpassword")
    public WebElement loginpassword_lc;

    @FindBy (css = "button[onclick='logIn()']")
    public WebElement loginBtn_lc;

    public void login_Mtd(){
        loginHomePage_lc.click();
        loginusername_lc.sendKeys(ConfigurationReader.get("etsb5_username"));
        loginpassword_lc.sendKeys(ConfigurationReader.get("etsb5_password"));
        //BrowserUtils.waitFor(2);
        loginBtn_lc.click();
    }
    public void loginWithParameters_Mtd(String username, String password){
       BrowserUtils.waitForClickablility(loginHomePage_lc,2).click();
        loginusername_lc.sendKeys(username);
        loginpassword_lc.sendKeys(password);
        loginBtn_lc.click();
        BrowserUtils.waitFor(2);
    }
    public  void verifyWithPopUpMessage_Mtd(String expectedMessage){
        Alert alert= Driver.get().switchTo().alert();
        String actualMesssage=alert.getText();
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMesssage = " + actualMesssage);
        Assert.assertEquals("Message does NOT match",expectedMessage,actualMesssage);
    }

}
