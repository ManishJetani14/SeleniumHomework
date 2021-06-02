Feature: registration
  @test
  Scenario: user should be able to register successfully
    Given user is already on registration page
    When user enter all required details for registration and click enter
    Then user should be able to register successfully