package com.vtiger.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class loginsteps extends BaseSteps{


    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver.get("http://localhost:100");
    }
    @When("User entered valid user name and password")
    public void user_entered_valid_user_name_and_password() {
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");

    }
    @When("Click on Login Button")
    public void click_on_login_button() {
        driver.findElement(By.name("Login")).click();

    }
    @Then("User is navigated to home Page")
    public void user_is_navigated_to_home_page() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Logout")).isDisplayed();

    }
    @Then("Logout button is visible")
    public void logout_button_is_visible() {
        driver.findElement(By.linkText("Logout")).isDisplayed();
        driver.quit();
    }


    @When("User entered invalid user name and password")
    public void user_entered_invalid_user_name_and_password() {
        driver.findElement(By.name("user_name")).sendKeys("admin12");
        driver.findElement(By.name("user_password")).sendKeys("admin12");

    }
    @Then("User is not navigated to home Page")
    public void user_is_not_navigated_to_home_page() {
        driver.findElement(By.name("user_name")).isDisplayed();

    }
    @Then("Login error is displayed")
    public void login_error_is_displayed() {
        driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
        //driver.quit();
    }

    @When("User entered invalid user name as {string} and password as {string}")
    public void user_entered_invalid_user_name_as_and_password_as(String uid, String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name")));
        driver.findElement(By.name("user_name")).clear();
        driver.findElement(By.name("user_name")).sendKeys(uid);
        driver.findElement(By.name("user_password")).clear();
        driver.findElement(By.name("user_password")).sendKeys(pwd);
    }
}
