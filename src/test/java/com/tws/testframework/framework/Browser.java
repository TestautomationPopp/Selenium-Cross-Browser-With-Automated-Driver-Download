/**
 * #################### Test With A Smile ####################
 *                  Written by Andreas Popp
 *  For more informations visit https://test-with-a-smile.de
 *        or mailto andreas.popp@testautomation-popp.de
 * ###########################################################
 */

package com.tws.twsframework.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class Browser{

    // Create a globale variable for the WebDriver
    public WebDriver driver;

    /**
     * This function will use the variable driver and set the WebDriver for a selected Browser.
     * After that, it will set an implicy wait and maximize the Window. This way the public driver
     * can be called by every test and run in parallel, without having an effect on each other
     * 
     * @param browserName The Name of the Browser you want to start
     * @param implicyWait The implicy wait in seconds you want to set
     */
    public Browser(String browserName, int implicyWait){
        
        // Set the driver Variable using the WebDriverManager
        if(browserName.toLowerCase().equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();    
        }else if(browserName.toLowerCase().equals("firefox") || browserName.toLowerCase().equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browserName.toLowerCase().equals("edge") || browserName.toLowerCase().equals("eg")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserName.toLowerCase().equals("opera") || browserName.toLowerCase().equals("op")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }else{
            // Display an error message, if the browser is not supported
            System.out.println("The browser " + browserName + " is not supported by this framework.");
        }

        // Set the implicy wait for the driver
        driver.manage().timeouts().implicitlyWait(implicyWait, TimeUnit.SECONDS);

        // Maximize the browser window
        driver.manage().window().maximize();
    }

}