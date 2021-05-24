package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest
{   //Creating object
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegisterResultPage registerResultPage = new RegisterResultPage();
    SearchNike searchNike = new SearchNike();
    NewOnlinePage newOnlinePage = new NewOnlinePage();
    ComputerPage computerPage = new ComputerPage();
    SoftwarePage softwarePage = new SoftwarePage();

    @Test
    public void userShouldBeAbleToRegisterSuccessfully()
    {   //click on register button
        homePage.clickOnRegisterButton();
        //enter registration details
        registerPage.enterRegistrationDetails();
        //verify registration success message
        registerResultPage.verifyRegisterMessage();
    }
    @Test
    public void userShouldBeAbleToChangeTheCurrency()
    {   //verifying currency symbol
        homePage.verifyCurrencySymbolFromEachPrice();
        //click on currency field
        homePage.ChangeCurrencyField();
        //verifying currency symbol
        homePage.verifyCurrencySymbolFromEachPrice();
    }
    @Test
    public void userShouldBeAbleToSearchProductSuccessfully()
    {   //typing name in search field
        homePage.typeNikeInSearchField();
        //clicking search button after typing product name
        searchNike.searchNikeName();
    }
    @Test
    public void addToCartButtonShouldBePresentInAllProduct()
    {   //checking add to cart button is present or not
        homePage.addToCartButtonShouldBePresent();
        //clicking on software
        computerPage.clickOnSoftware();
        //checking add to cart button is present
        softwarePage.verifyAddToCartButtonPresent();
    }
    @Test
    public void commentMessageAddedSuccessfully()
    {   //click on title
        homePage.commentAndTitleAddedForNewOnlineStore();
        //type title and comment
        newOnlinePage.typeCommentDetails();
        //verify comment added successfully
        newOnlinePage.verifyCommentAddedSuccessfully();
        //verify comment added is present in comment list
        newOnlinePage.verifyCommentPresentInComments();
        //verify newly added comment is present at last in comment list
        newOnlinePage.verifyNewCommentAddedLastInTheList();
    }
    @Test
    public void verifyAlertShouldHaveMessage()
    {   //verify alert message
        homePage.alertHandlingMethod();
    }
    @Test
    public void verifyLoginButtonIsPresentInFacebookWindow()
    {   //verify login button is present
        homePage.facebookPopUpWindowHandle();
    }

}
