package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CardPage extends BasePage{



    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderBtn_loc;
    @FindBy(id = "name")
    public WebElement name_lc;
    @FindBy(id = "country")
    public WebElement country_lc;
    @FindBy(id = "city")
    public WebElement city_lc;
    @FindBy(id = "card")
    public WebElement creditCard_lc;
    @FindBy(id = "month")
    public WebElement month_lc;
    @FindBy(id = "year")
    public WebElement year_lc;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchase_lc;
    @FindBy(css = "[class='lead text-muted ']")
    public WebElement confirmation_lc;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement okButton;

    int actualAmount;
    public void removeProduct_Mtd(String productDeleted){
        cart_lc.click();
        WebElement productDeleted_lc = Driver.get().findElement(By.xpath
                ("(//*[text()='"+productDeleted+"']/../td)[4]/a"));
        //farkli bir locate
        //WebElement productDeleted_lc = Driver.get().findElement
          //      (By.xpath("//td[.='"+productDeleted+"']/..//td[.='Delete']/a"));
        BrowserUtils.waitForClickablility(productDeleted_lc,2).click();
        cart_lc.click();
    }

    public void fillForm_mtd(){
        Faker faker=new Faker();
        BrowserUtils.waitFor(1);
        name_lc.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(1);
        country_lc.sendKeys(faker.country().name());
        BrowserUtils.waitFor(1);
        city_lc.sendKeys(faker.country().capital());
        BrowserUtils.waitFor(1);
        creditCard_lc.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        month_lc.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        BrowserUtils.waitFor(1);
        year_lc.sendKeys(String.valueOf(faker.number().numberBetween(1940,2005)));
        BrowserUtils.waitFor(1);
    }

    public void finishPurchase(){
        BrowserUtils.waitFor(4);
        //BrowserUtils.waitForClickablility(placeOrderBtn_loc,4).click();
        placeOrderBtn_loc.click();
        fillForm_mtd();
        BrowserUtils.waitForClickablility(purchase_lc,4).click();
        BrowserUtils.waitForClickablility(okButton,4);
        String confirmationMessage = confirmation_lc.getText();
        System.out.println("confirmation = " + confirmationMessage);

        String[] confirmationArray=confirmationMessage.split("\n");
        System.out.println("Arrays.toString(confirmationArray) = " + Arrays.toString(confirmationArray));
        List<String> confirmationList= List.of(confirmationMessage.split("\n"));
        System.out.println("confirmationList.toString() = " + confirmationList.toString());
        actualAmount=Integer.parseInt(confirmationArray[1].split(" ")[1]);
        int actualAmount1=Integer.parseInt(List.of(confirmationList.get(1).split(" ")).get(1));
        System.out.println("actualAmount = " + actualAmount);
        System.out.println("actualAmount1 = " + actualAmount1);
        okButton.click();
    }

        public void verifyPurchaseAmount_Mtd(int expectedAmount){
            Assert.assertEquals("amount does not match",expectedAmount,actualAmount);
        }
}
