package com.vtiger.pages;

import com.vtiger.utilities.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HeaderPage extends CommonActions {
    public WebDriver driver;

    public HeaderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//b[contains(text(),\' 2025\')]")
    public WebElement lbl_calanderYear;

    @FindBy(xpath = "//td[contains(text(),\'Calculator\')]")
    public WebElement lbl_calculator;

    @FindBy(xpath = "//input[@type = \'text\'][1]")
    public WebElement tb_searchBox;

    @FindBy(xpath = "//div[@id = 'theClockLayer']")
    public WebElement ctrl_clock;

    //Links on home screen
    @FindBy(xpath = "//a[@class = 'moduleMenu' and contains(text(), 'New Contact')]")
    public WebElement link_newContact;

    //@FindBy(xpath = "//a[@href='index.php?module=Leads&action=index']")
    //@FindBy(xpath = "//a[@href='index.php?module=Leads&action=EditView&return_module=Leads&return_action=DetailView']")
//    @FindBy(xpath = "//a[text() = 'New Lead']")
    // public WebElement link_newLead;

    @FindBy(linkText = "New Lead")
    public WebElement lnk_newLead;

    @FindBy(xpath = "//a[@class = 'moduleMenu' and contains(text(), 'New Account')]")
    public WebElement link_newAccount;

    @FindBy(xpath = "//a[@class = 'moduleMenu' and contains(text(), 'New Potential')]")
    public WebElement link_newPotential;

    @FindBy(xpath = "//a[contains(@href , \"Logout\")]")
    public WebElement btn_logout;

    @FindBy(xpath = "//a[contains(@href, 'Leads&action')]")
    public WebElement tab_lead;


    public boolean navigatedToHomePage(){

        ArrayList<WebElement> elements = new  ArrayList<>();
        //elements.add(pendingAndActiveActivity);
        elements.add(lbl_calanderYear);
        elements.add(lbl_calculator);
        elements.add(tb_searchBox);
        elements.add(ctrl_clock);
        boolean ctrlVisible = true;
        for (int i =0;i<elements.size();i++){
            if (elements.get(i).isDisplayed()){
                System.out.println("Element is available on Home page"+ elements.get(i));

            }
            else {
                ctrlVisible =false;
                System.out.println("Element is not available on Home page"+ elements.get(i));
            }
        }
        return ctrlVisible;
    }

    public void verifyLogoutButton(){
        boolean ispresent =  btn_logout.isDisplayed();
        if (ispresent == true)
        {
            System.out.println("Logout button is displayed");
        }

    }

    public void clickLogout(){
        clickElement(btn_logout, "Clicked Logout button");
    }

    public void clickNewLead()
    {
        clickElement(lnk_newLead,"Link New Lead clicked");
    }

    public void closeBrowser(){
        driver.close();
    }



}
