package com.vtiger.stepdefinition;

import com.vtiger.pages.NewLeadPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class createLead extends BaseSteps{


    @When("User click on New lead and fill mandatory information and save")
    public void user_click_on_new_lead_and_fill_mandatory_information_and_save() {
        hp.clickNewLead();
        nlp.createLead("Rachna", "BSC");
    }

    @When("lead should be created")
    public void lead_should_be_created() {

        nlp.verifyLead("Last Name:", "Rachna");
        nlp.verifyLead("Company:", "BSC");
    }


    @When("User need to create multiple leads and validate based on data")
    public void user_need_to_create_multiple_leads_and_validate_based_on_data(io.cucumber.datatable.DataTable dataTable) {

        List<List<String>> ls = dataTable.asLists();
        for (int i=0; i<ls.size();i++){
            hp.clickNewLead();
            nlp.createLead(ls.get(i).get(0), ls.get(i).get(1));
            System.out.println("Last Name entered is : "+ls.get(i).get(0));
            System.out.println("Company Name entered is : "+ls.get(i).get(1));
            nlp.verifyLead("Last Name:", ls.get(i).get(0));
            nlp.verifyLead("Company:", ls.get(i).get(1));                   }
    }
//    @When("Close Browser")
//    public void close_browser(){
//        hp.closeBrowser();
//    }

}
