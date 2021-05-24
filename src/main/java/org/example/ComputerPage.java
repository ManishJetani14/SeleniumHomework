package org.example;

import org.openqa.selenium.By;

public class ComputerPage extends Utils
{
    private By _clickOnSoftware = By.cssSelector(".active.last .sublist .inactive:nth-of-type(3)>a");
    private By _waitForClickable = By.cssSelector("button#newsletter-subscribe-button");

    public void clickOnSoftware ()
{   //adding wait for element to load
//    waitForClickable(_waitForClickable,120);
    sleep(5000);
    //click on sub category software
    clickOnElement(_clickOnSoftware);
}
}
