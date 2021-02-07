/**
 * #################### Test With A Smile ####################
 *                  Written by Andreas Popp
 *  For more informations visit https://test-with-a-smile.de
 *        or mailto andreas.popp@testautomation-popp.de
 * ###########################################################
 */

package com.tws.twsframework.tests;

import com.tws.twsframework.framework.Browser;
import com.tws.twsframework.framework.BrowserProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class FirstTest{

    // Create a public variable for the browser class to call the driver
    public Browser browser;

    /**
     * The test case opens the website https://test-with-a-smile.de and verify, that the logo is displayed
     * 
     * @param browsername   The browser defined in the data provider given from the -Dbrowsers parameter of the maven call
     * @throws Exception
     */
    @Test(dataProvider = "browser-data-provider", dataProviderClass = BrowserProvider.class)
    private void testCase(String browsername) throws Exception{
        browser = new Browser(browsername, 10);
        browser.driver.get("https://test-with-a-smile.de");
        Assert.assertEquals(true, browser.driver.findElement(By.xpath("//*[@id='headimg']/a/img")).isDisplayed());
    }
    
    /**
     * The after method will close the browser when the execution of the test method is done.
     */
    @AfterMethod
    private void closeBrowsers(){
        browser.driver.quit();
    }
}