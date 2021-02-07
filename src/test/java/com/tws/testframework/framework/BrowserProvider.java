/**
 * #################### Test With A Smile ####################
 *                  Written by Andreas Popp
 *  For more informations visit https://test-with-a-smile.de
 *        or mailto andreas.popp@testautomation-popp.de
 * ###########################################################
 */

package com.tws.twsframework.framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserProvider
{
    /**
     * The data provider will read the -Dbrowsers parameter from the maven call and add
     * them to a two dimensional Object. This information will be given to every test
     * that contains the DataProvider as input data.
     * @return browsers The two dimensional Object Array.
     */
    @DataProvider (name = "browser-data-provider")
    public Object[][] dpMethod(){
        String givenBrowsers[] = System.getProperty("browsers").split(",");
        Object browsers[][] = new Object[givenBrowsers.length][1];
        for (int browserNo = 0; browserNo < givenBrowsers.length; browserNo++) {     
            browsers[browserNo][0] = givenBrowsers[browserNo];
        }
        return browsers;
    }
	
}