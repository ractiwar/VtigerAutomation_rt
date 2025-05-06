package com.vtiger.stepdefinition;

import com.vtiger.pages.NewLeadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import java.time.Duration;

public class loginsteps extends BaseSteps{


    @Given("User is on login page")
    public void user_is_on_login_page() {

        initiation();
//        driver.get(prop.getProperty("appurl"));
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
//        lp = new LoginPage(driver);
//        hp = new HomePage(driver);
//        headerpage = new HeaderPage(driver);
//        nlp = new NewLeadPage(driver);
    }
    @When("User entered valid user name and password")
    public void user_entered_valid_user_name_and_password() {
            lp.login("admin", "admin");
    }
    @When("Click on Login Button")
    public void click_on_login_button() {
        lp.clickLogin();

    }
    @Then("User is navigated to home Page")
    public void user_is_navigated_to_home_page() {
       hp.navigatedToHomePage();
    }
    @Then("Logout button is visible")
    public void logout_button_is_visible() {
        hp.verifyLogoutButton();

    }


    @When("User entered invalid user name and password")
    public void user_entered_invalid_user_name_and_password() {
       lp.login("admin1","admin12");

    }
    @Then("User is not navigated to home Page")
    public void user_is_not_navigated_to_home_page() {
        lp.verifyErrormsg();
    }
    @Then("Login error is displayed")
    public void login_error_is_displayed() {
       lp.verifyErrormsg();
    }

    @When("User entered invalid user name as {string} and password as {string}")
    public void user_entered_invalid_user_name_as_and_password_as(String uid, String pwd) {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name")));
       lp.login(uid, pwd);
    }

    @Then("Click on logout button")
    public void click_on_logout_button() {

        hp.clickLogout();
    }
}
