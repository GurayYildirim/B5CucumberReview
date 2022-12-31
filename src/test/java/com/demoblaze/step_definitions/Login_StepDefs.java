package com.demoblaze.step_definitions;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.ProductStorePage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {
    LoginPage loginPage=new LoginPage();
    ProductStorePage productStorePage=new ProductStorePage();
    @Given("The user ist on the login page")
    public void the_user_ist_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login_Mtd();
    }
    @Then("verify {string}")
    public void verify(String welcomeMessage) {
        productStorePage.verifyWelcomeMessage_Mtd(welcomeMessage );
    }

    @When("The user enters with {string} and {string} credentials")
    public void theUserEntersWithAndCredentials(String username, String password) {
        loginPage.loginWithParameters_Mtd(username, password);
    }

    @When("The user enters with valid username und password")
    public void theUserEntersWithValidUsernameUndPassword(Map<String,String>userInfo ) {
        loginPage.loginWithParameters_Mtd(userInfo.get("username"),userInfo.get("password"));
    }
}