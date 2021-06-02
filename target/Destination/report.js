$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/registration.feature");
formatter.feature({
  "line": 1,
  "name": "registration",
  "description": "",
  "id": "registration",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6198795200,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "user should be able to register successfully",
  "description": "",
  "id": "registration;user-should-be-able-to-register-successfully",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "user is already on registration page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enter all required details for registration and click enter",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user should be able to register successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepsDefs.user_is_already_on_registration_page()"
});
formatter.result({
  "duration": 1926810900,
  "status": "passed"
});
formatter.match({
  "location": "MyStepsDefs.user_enter_all_required_details_for_registration_and_click_enter()"
});
formatter.result({
  "duration": 2945112100,
  "status": "passed"
});
formatter.match({
  "location": "MyStepsDefs.user_should_be_able_to_register_successfully()"
});
formatter.result({
  "duration": 51382600,
  "error_message": "java.lang.AssertionError: Your registration not successful expected [Your registration completed.] but found [Your registration completed]\r\n\tat org.testng.Assert.fail(Assert.java:99)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:1037)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:140)\r\n\tat org.testng.Assert.assertEquals(Assert.java:122)\r\n\tat org.testng.Assert.assertEquals(Assert.java:629)\r\n\tat org.example.RegisterResultPage.verifyRegisterMessage(RegisterResultPage.java:13)\r\n\tat org.example.MyStepsDefs.user_should_be_able_to_register_successfully(MyStepsDefs.java:28)\r\n\tat ✽.Then user should be able to register successfully(src/test/resources/features/registration.feature:6)\r\n",
  "status": "failed"
});
formatter.write("....Scenario Failed....");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1498310600,
  "status": "passed"
});
});