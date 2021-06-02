package org.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepsDefs
{   //calling class and creating object
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegisterResultPage registerResultPage = new RegisterResultPage();

    @Given("^user is already on registration page$")
    public void user_is_already_on_registration_page()
    {   //click on register
        homePage.clickOnRegisterButton();
    }

    @When("^user enter all required details for registration and click enter$")
    public void user_enter_all_required_details_for_registration_and_click_enter()
    {   //enter registration details
        registerPage.enterRegistrationDetails();
    }

    @Then("^user should be able to register successfully$")
    public void user_should_be_able_to_register_successfully()
    {  //verify register success message
       registerResultPage.verifyRegisterMessage();
    }

}
