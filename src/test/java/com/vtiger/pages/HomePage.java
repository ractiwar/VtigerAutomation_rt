package com.vtiger.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage extends HeaderPage {

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
// Labels on Home screen
    @FindBy(xpath = "//td[@valign='middle' and @class='formHeader'][1]")
    WebElement pendingAndActiveActivity;

    @FindBy(xpath = "//td[contains(text(), 'My Pipeline')]")
    WebElement lbl_myPipeline;



    public boolean navigatedToHomePage(){

        ArrayList<WebElement> elements = new  ArrayList<>();
        elements.add(pendingAndActiveActivity);
//        elements.add(lbl_calanderYear);
//        elements.add(lbl_calculator);
//        elements.add(tb_searchBox);
//        elements.add(ctrl_clock);
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

}
