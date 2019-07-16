
@UpdatePersonalInformation
Feature: Update Personal Information
  I want to use this template for my feature file
  
  Background: 
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

  @UpdateFirstName
  Scenario: Update Personal Information (first name) in My Account
		Given I am on online shopping My Account - My Store page
    When I click My Personal Information link
    #And I change the First Name to change_fname
    And I enter my changed first name
    |change_fname|PI_fname_xpath|
    #And I enter my current password i.e. secret_registered_password
    And I enter my current password
    |current_password|current_password_xpath|
    #And finally I click Save button
    And I click on save_btn
    Then The successful_personal_info_saved_message is displayed
    And on top right corner, my change_fname can be verified

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
