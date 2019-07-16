
@Login
Feature: Login into web portal

  @Login
  Scenario: Login into Online Shopping portal
    Given I open browsername
    When I launch URL of Online Shopping portal
    And I click on Sign_In_Link
    And I am taken inside sign-in page
    And I enter my registered email id
    |login_email_id|login_email_id_xpath|
    And I enter my password
    |current_password|login_password_field_xpath|
    And I click on Sign_In_Submit_Btn
    Then I am taken inside the application
