@RegisterUser
Feature: Register User on automation practice online shopping portal

	@GoToSignUpPage:
	Scenario: User create an account
	 Given I open browsername
	 When I launch URL of Online Shopping portal
	 And I click on Sign_In_Link
   #And I am at sign-up page
	 And I am taken inside sign-in page
   #When I enter the register-email_id at the register-email-id-xpath field
   And I enter email id for registration
    |register_email_id|register_email_id_xpath|
   And I click on create_an_account_button_xpath
   #And I am taken to create an account page
   
   #@EnterYourPersonalDetails
   #Scenario: Enter Personal and Address details
   And I am on create an account page
   And I select my salutation
   |salutation_var|Mr_Salutation_xpath|Mrs_Salutation_xpath|
   And enter first name
   |fname_var|fname_xpath|
   And enter last name
   |lname_var|lname_xpath|
   And set your password
   |registering_password|password_xpath|
   And select day
   |day_var|drpdwn_day_xpath|
   And select month
   |month_var|drpdwn_month_xpath|
   And select year
   |year_var|drpdwn_year_xpath|
   And enter company
   |company_var|company_xpath|
   And enter address
   |address_var|address_xpath|
   And enter city
   |city_var|city_xpath|
   And select state
   |state_var|drpdwn_state_xpath|
   And enter zipcode
   |zipcode_var|zipcode_xpath|
   And select country
   |country_var|drpdwn_country_xpath|
   And enter mobile number
   |mob_num_var|mob_num_xpath|
   And enter address alias
   |address_alias_var|address_alias_xpath|
   And I click on register_button_xpath
   Then I am taken to My Account page
   
   #Examples:
   #|salutation|fname |lname|password   |day|month |year|company|address  |city    |state|zipcode|country      |mob-number|address-alias|
   #|Mr.       |Nikhil|Gupta|password123|23 |August|1988|RBS    |Cybercity|Gurugram|Texas|00001  |United States|9498070042|Office-Addr  |
