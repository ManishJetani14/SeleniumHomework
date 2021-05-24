package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends BasePage
{   //Creating Object for LoadProperty
    LoadProperty loadProperty = new LoadProperty();
    //Storing browser name
    String browserName = loadProperty.getProperty("browser");

    public void openSelectedBrowser()
    {   //applying condition to open browser
        if (browserName.equalsIgnoreCase("chrome"))
        {   //webdriver path
            System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDriver/chromedriver.exe");
            //initiating the object
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {   //webdriver path
            System.setProperty("webdriver.edge.driver", "src/test/resources/BrowserDriver/msedgedriver.exe");
            //initiating the object
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {   //webdriver path
            System.setProperty("webdriver.gecko.driver", "src/test/resources/BrowserDriver/geckodriver.exe");
            //initiating the object
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("In correct browser name :" +browserName);
        }
        //maximising browser window
        driver.manage().window().maximize();
        //applying implicitly wait to driver object
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


}
