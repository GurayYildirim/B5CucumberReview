package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductStorePage extends BasePage{
    @FindBy (css = "#nameofuser")
    public WebElement welcomeUsername_lc;

    @FindBy(css = "a#itemc")
    public List<String> categories_lc;

    @FindBy(linkText = "Add to cart")
    public WebElement addToChart;



    public void verifyWelcomeMessage_Mtd(String expectedMessage){
        BrowserUtils.waitFor(2);
        String actualMessage=welcomeUsername_lc.getText();

        Assert.assertEquals("Username does NOT match",expectedMessage,actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
    }

    public void addProduct_Mtd(String product, String category){
        WebElement categoryModul = Driver.get().findElement(By.xpath("//*[text()='" + category + "']"));
        BrowserUtils.waitForClickablility(categoryModul,3).click();
        WebElement productItem = Driver.get().findElement(By.xpath("//*[text()='"+product+"']"));
        BrowserUtils.scrollToElement(productItem);
        BrowserUtils.waitForClickablility(productItem,3).click();
        BrowserUtils.waitForClickablility(addToChart,3).click();
        BrowserUtils.waitFor(2);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();
        BrowserUtils.waitFor(2);
        home_lc.click();


    }
}

