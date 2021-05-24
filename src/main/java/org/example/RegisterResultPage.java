package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


public class RegisterResultPage extends Utils
{
    private By _actualResult = By.xpath("//div[text()='Your registration completed']");

    public void verifyRegisterMessage()
    {   //verify user has registered successfully
        Assert.assertEquals(getTextFromElement(_actualResult),"Your registration completed","Your registration not successful");
        //message print
        System.out.println("User successfully registered");
    }

}
