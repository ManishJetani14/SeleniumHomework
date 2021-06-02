package org.example;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

public class Hooks extends Utils
{   //calling class and creating object
    BrowserSelector browserSelector = new BrowserSelector();

    @Before
    public void openBrowser()
    {   //open browser
        browserSelector.openSelectedBrowser();
    }

    @After
    public void closeBrowser(Scenario scenario)
    {   //test data
        String screenShotName = scenario.getName().replaceAll(".,;:?!", "") + dateStamp() + ".png";
        //capture screenshot if test fails
        if (scenario.isFailed())
        {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/target/Destination/screenshot/" + screenShotName);
            try
            {
                copyFile(sourcePath, destinationPath);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            //message fail note
            scenario.write(("....Scenario Failed...."));
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        //close browser
        driver.quit();
        }

}
