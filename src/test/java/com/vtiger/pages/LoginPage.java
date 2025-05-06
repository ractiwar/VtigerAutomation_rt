package com.vtiger.pages;


import com.vtiger.utilities.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonActions {
    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    @FindBy(xpath = "//input[@name = 'user_name' and @type='text']")
    public WebElement tb_userid;

    @FindBy(xpath = "//input[@name = 'user_password' and @type='password']")
    public WebElement tb_pwd;

    @FindBy(xpath = "//select[@name = 'login_theme']")
    public WebElement dropdwntheme;

    @FindBy(xpath = "//input[@name='Login']")
    public WebElement btn_login;

    @FindBy(xpath = "//td[contains(text() , \"valid username and password\")]")
    public WebElement loginError;


    public void login(String uid, String pwd){
        setUsername(uid);
        setPassword(pwd);

    }

    public void setUsername(String userName){

        setInput(tb_userid, userName,"Entering User name");
    }

    public void setPassword(String password) {
        setInput(tb_pwd, password,"Entering password");
    }

    public void clickLogin(){

        clickElement(btn_login, "Clicked Login Button");

    }

    public  void verifyErrormsg(){
        elementDisplayed(loginError, "Login Error is displayed");

    }
    }

