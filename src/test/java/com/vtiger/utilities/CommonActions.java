package com.vtiger.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonActions(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setInput(WebElement elm, String value,String msg){
        try{
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);
            System.out.println(msg);
        }
        catch(Exception e){
            System.out.println("error occurred for element"+ elm + e.getMessage());

        }
    }

    public void clickElement(WebElement elm, String msg){
        try{
            //wait.until(ExpectedConditions.elementToBeClickable(elm));
            System.out.println("element found is : "+elm);
            elm.click();
            System.out.println(msg);
        }
        catch(Exception e){
            System.out.println("error occurred for element"+ elm + e.getMessage());

        }
    }

    public void elementDisplayed(WebElement elm, String msg){
        try{
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            System.out.println(msg);
        }
        catch(Exception e){
            System.out.println("error occurred for element"+ elm + e.getMessage());

        }
    }
}
