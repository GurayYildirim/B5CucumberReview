package com.demoblaze.step_definitions;

import com.demoblaze.pages.CardPage;
import com.demoblaze.pages.ProductStorePage;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EndtoEndTest_StepDefs {
    ProductStorePage productStorePage=new ProductStorePage();
    CardPage cardPage=new CardPage();

    @And("The user adds {string} from {string}")
    public void the_user_adds_from(String product, String category) {
        productStorePage.addProduct_Mtd(product,category);
        //Driver.get().navigate().back();
    }

    @And("The user removes {string} from cart")
    public void theUserRemovesFromCart(String productdeleted) {
        cardPage.removeProduct_Mtd(productdeleted);
    }

    @And("The user places order and captures and log amount")
    public void theUserPlacesOrderAndCapturesAndLogAmount() {
        cardPage.finishPurchase();

    }

    @Then("The user verifies purchase amount equals {int}")
    public void theUserVerifiesPurchaseAmountEquals(int expectedAmount) {
        cardPage.verifyPurchaseAmount_Mtd(expectedAmount);
    }
}
