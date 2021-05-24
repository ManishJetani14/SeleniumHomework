package org.example;

import org.openqa.selenium.By;

import java.sql.Timestamp;


public class RegisterPage extends Utils
{   LoadProperty loadProperty = new LoadProperty();
    private By _radioButton = By.cssSelector("input#gender-male");
    private By _firstName = By.xpath("//input[contains(@id,'FirstName')]");
    private By _lastName = By.xpath("//input[contains(@id,'LastName')]");
    private By _dateOfBirth = By.xpath("//select[contains(@name,'DateOfBirthDay')]");
    private By _monthOfBirth = By.xpath("//select[contains(@name,'DateOfBirthMonth')]");
    private By _yearOfBirth = By.xpath("//select[contains(@name,'DateOfBirthYear')]");
    private By _email = By.cssSelector("input#Email");
    private By _companyName = By.xpath("//input[starts-with(@name,'Company')]");
    private By _password = By.cssSelector("input#Password");
    private By _confirmPassword = By.cssSelector("input#ConfirmPassword");
    private By _clickOnRegister = By.xpath("//button[text()='Register']");
    private By _waitForClickable = By.cssSelector("button#newsletter-subscribe-button");

    public void enterRegistrationDetails()
    {   //timestamp for current time - to create unique email value each time we run the program
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //wait for clickable element
        waitForClickable(_waitForClickable,100);
        //sleep(5000);
        //click on Male or Female button
        clickOnElement(_radioButton);
        //Type FirstName
        enterText(_firstName,loadProperty.getProperty("firstName"));
        //Type LastName
        enterText(_lastName, loadProperty.getProperty("lastName"));
        //Select Day of Date of Birth
        selectFromDropdownByValue(_dateOfBirth, loadProperty.getProperty("dateOfBirth"));
        //Select Month of Birth
        selectFromDropdownByVisibleText(_monthOfBirth, loadProperty.getProperty("monthOfBirth"));
        //Select Year of Birth
        selectFromDropdownByValue(_yearOfBirth,loadProperty.getProperty("yearOfBirth"));
        //Type Email address
        enterText(_email,loadProperty.getProperty("email")+timestamp.getTime()+"@gmail.com");
        //Type Company name
        enterText(_companyName,loadProperty.getProperty("companyName"));
        //Type Password
        enterText(_password,loadProperty.getProperty("password"));
        //Confirm Password
        enterText(_confirmPassword,loadProperty.getProperty("confirmPassword"));
        //Click on Register
        clickOnElement(_clickOnRegister);
    }
}
