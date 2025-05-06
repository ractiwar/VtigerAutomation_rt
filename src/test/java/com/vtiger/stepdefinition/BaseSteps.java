package com.vtiger.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.NewLeadPage;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static LoginPage lp;
    public  static HomePage hp;
    public  static NewLeadPage nlp;
    public static HeaderPage headerpage;

    public void initiation()
    {


        if (prop == null){
            readProperties();
        }
        if (driver == null)
        {
            System.out.println("Launching app");
         launchApp();
        }
    }

    public void launchApp(){
        System.out.println("Launching browser: " + prop.getProperty("browser"));

        if (prop.getProperty("browser").equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver();
        }else if (prop.getProperty("browser").equalsIgnoreCase("FireFox"))
        {
            driver = new FirefoxDriver();
        }else if (prop.getProperty("browser").equalsIgnoreCase("Edge"))
        {
            driver = new EdgeDriver();
        }else if (prop.getProperty("browser").equalsIgnoreCase("headless"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }else{
            driver = new ChromeDriver();
        }
        System.out.println(prop.getProperty("appurl"));

        driver.get(prop.getProperty("appurl"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        headerpage = new HeaderPage(driver);
        nlp = new NewLeadPage(driver);
    }
    public void readProperties(){
        try {
            prop = new Properties();
            Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "Configuration", "settings.properties");
            FileInputStream fis = new FileInputStream(path.toFile());

            //FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Configuration\\settings.properties");
            prop.load(fis);
            System.out.println("FIS Loaded");
            System.out.println("Browser: " + prop.getProperty("browser"));
            System.out.println("App URL: " + prop.getProperty("appurl"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
