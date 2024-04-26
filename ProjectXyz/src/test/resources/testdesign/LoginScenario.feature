Feature: PageObject


  @LoginAmazon
  Scenario: Login Sc
    Given user enter the user name and password
    Then verify the login status
