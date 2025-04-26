package com.vtiger.stepdefinition;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class createLead extends BaseSteps{

    @When("User click on New lead and fill mandatory information and save")
    public void user_click_on_new_lead_and_fill_mandatory_information_and_save() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'New Lead')]")));
    driver.findElement(By.xpath("//a[contains(text(),'New Lead')]")).click();
    //driver.findElement(By.linkText("New Lead"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'lastname']")));
    driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("Rachna");
    driver.findElement(By.xpath("//input[@name = 'company']")).sendKeys("BSc");
    }
    @When("lead should be created")
    public void lead_should_be_created() {

    driver.findElement(By.xpath("//td[@class= \"dataLabel\"and contains(text(),\"Last Name:\") ]/following-sibling::td[1]")).isDisplayed();
    driver.quit();
    }


    @When("User need to create multiple leads and validate based on data")
    public void user_need_to_create_multiple_leads_and_validate_based_on_data(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> ls = dataTable.asLists();
        for (int i=0; i<-ls.size();i++){
            driver.findElement(By.xpath("//a[contains(text(),'New Lead')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'lastname']")));
            driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys(ls.get(i).get(0));
            driver.findElement(By.xpath("//input[@name = 'company']")).sendKeys(ls.get(i).get(1));
            driver.findElement(By.name("button")).click();
            driver.findElement(By.xpath("//td[text()='Last Name:']/following-sibling::td[1][text()='"+ls.get(i).get(0)+"']")).isDisplayed();
            driver.findElement(By.xpath("//td[text()='Company:']/following-sibling::td[1][text()='"+ls.get(i).get(1)+"']")).isDisplayed();
        }
    }
    @When("Close Browser")
    public void close_browser() {
        driver.close();
    }

}
