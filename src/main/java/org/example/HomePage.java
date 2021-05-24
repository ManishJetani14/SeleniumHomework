package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils
{   LoadProperty loadProperty = new LoadProperty();
    private By _clickOnRegister = By.cssSelector("a.ico-register");
    private By _currencyName = By.cssSelector("select#customerCurrency");
    private By _listOfPrice = By.xpath("//span[contains(@class,'price actual-price')]");
    private By _searchTerm = By.xpath("//input[contains(@class,'box-text')]");
    private By _clickOnSearch = By.xpath("//button[text()='Search']");
    private By _clickOnComputer = By.xpath("//a[text()='Computers ']");
    private By _clickOnTitle = By.cssSelector(".news-head:first-of-type>a");
    private By _clickSearchButtonForAlert = By.cssSelector("button.button-1.search-box-button");
    private By _facebookSymbol = By.cssSelector("li.facebook");
    private By _loginButtonInFacebook = By.cssSelector("input[value='Log In']");
    private By _cookieAcceptMessage = By.xpath("//button[contains(@id,'1y')]");

    public void clickOnRegisterButton()
    {
        //click on Register button
        clickOnElement(_clickOnRegister);
    }
    public static String getCurrencySymbol(String currencyName)
    {   //test data
        String currencySymbol = null;
        //apply condition
        switch (currencyName) {
            case "US Dollar":
                currencySymbol = "$";
                break;
            case "Euro":
                currencySymbol = "€";
                break;
            default:
                System.out.println("Currency is not recognised");
        }
        return currencySymbol;
    }
    public void verifyCurrencySymbolFromEachPrice()
    {   //getting name of currency selected
        String currencyNameSelected = getSelectedTextFromDropdown(_currencyName);
        //getting currency symbol
        String expectedCurrencySymbol = getCurrencySymbol(currencyNameSelected);
        //list of product price
        List<WebElement> priceList = driver.findElements(_listOfPrice);
        //item list
        for (WebElement element : priceList)
        {
            String actualCurrencySymbol = element.getText().substring(0,1);
            //asserting actual currency symbol with expected currency symbol
            Assert.assertEquals(actualCurrencySymbol,expectedCurrencySymbol,"Actual currency symbol not matching with expected currency symbol");
        }
        //printing output
        System.out.println("Currency Verified successfully:" + currencyNameSelected +" as " + expectedCurrencySymbol);
    }
    public void ChangeCurrencyField()
    {   //select Euro currency
        selectFromDropdownByVisibleText(_currencyName,loadProperty.getProperty("currency"));
    }
    public void typeNikeInSearchField()
    {   //type product name
        enterText(_searchTerm,loadProperty.getProperty("searchTerm"));
        //click on Search button
        clickOnElement(_clickOnSearch);
    }
    public void addToCartButtonShouldBePresent()
    {   //click on Computer Menu from product category
        clickOnElement(_clickOnComputer);

    }
    public void commentAndTitleAddedForNewOnlineStore()
    {   //click on New online Store title
        clickOnElement(_clickOnTitle);
    }
    public void alertHandlingMethod()
    {   //click on search button
        clickOnElement(_clickSearchButtonForAlert);
        //switch to alert
        Alert alert = driver.switchTo().alert();
        //capture alert message
        String alertMessage = driver.switchTo().alert().getText();
        //expected message
        String expectedAlertMessage = loadProperty.getProperty("alertMessageText");
        //verify captured message match with expected message
        Assert.assertEquals(alertMessage,expectedAlertMessage,"Alert message is not as per requirement");
        //print message
        System.out.println("Alert Message display as: " + alertMessage);
        //accept alert
        alert.accept();

    }
    public void facebookPopUpWindowHandle()
    {   //click on facebook symbol
        clickOnElement(_facebookSymbol);
        //Main window
        String MainWindow = driver.getWindowHandle();
        //For Handling all new opened windows
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext())
        {
            String ChildWindow = i1.next();
            //applying condition
            if (!MainWindow.equalsIgnoreCase(ChildWindow))
            {   //switch to child window
                driver.switchTo().window(ChildWindow);
                //click on cookie message
                driver.findElement(_cookieAcceptMessage).click();
                //verify login button is present or not
                Assert.assertTrue(driver.findElement(_loginButtonInFacebook).isDisplayed(),"Log in button is not displayed");
                //close the child window
                driver.close();
            }
        }
        //switch to main window
        driver.switchTo().window(MainWindow);
    }
}
