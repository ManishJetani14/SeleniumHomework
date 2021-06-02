package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{   //creating object for class
    BrowserSelector browserSelector = new BrowserSelector();
    @BeforeMethod
    public void openBrowser()
    {  //open the browser
       browserSelector.openSelectedBrowser();

    }
    @AfterMethod
    public void closeBrowser(ITestResult result)
    {   //condition to capture screenshot
        if (!result.isSuccess())
        {
            captureScreenshot(result.getName());
        }
        //close the browser after test
        driver.quit();
       }
}
