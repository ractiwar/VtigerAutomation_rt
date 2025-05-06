package com.vtiger.pages;


import com.vtiger.utilities.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLeadPage extends HeaderPage {
    public WebDriver driver;


    public NewLeadPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    public WebElement txtbox_lastName;

    @FindBy(xpath = "//input[@name=\"company\"]")
    public WebElement txtbox_company;

    @FindBy(xpath = "//input[@title='Save [Alt+S]' and @name = 'button']")
    public WebElement btn_save;

    @FindBy(xpath = "//input[@type = 'radio' and @value = \"U\"]")
    public WebElement radioBtn_User;

    @FindBy(xpath = "//input[@type = 'radio' and @value = \"T\"]")
    public WebElement radioBtn_Team;

    @FindBy(xpath = "//td[contains(text(),\"Last Name\")]/following::*[1]")
    public WebElement lstnamevaluelbl;

    public void setLastName(String lname){
        setInput(txtbox_lastName, lname, "Entere last name");
    }

    public void setCompany(String cname){
            setInput(txtbox_company, cname, "Entered Company");
    }

    public void saveLead(){
            clickElement(btn_save,"Click save Lead");
    }

    public void verifyLead(String label, String val)
    {
        WebElement elm = driver.findElement(By.xpath("//td[text()='"+label+"']/following-sibling::td[1][text()='"+val+"']"));
        elementDisplayed(elm, val+ " is displayed against " + label);
    }

    public void createLead(String lastName, String companyName){
        setLastName(lastName);
        setCompany(companyName);
        saveLead();
    }




}
