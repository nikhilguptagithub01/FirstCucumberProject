
@OrderTShirt
Feature: Order T-Shirt and verify in your order history
	
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
    
  @OrderTShirtWithOneQuantity
  Scenario: Order T-Shirt from Online Shopping Portal
		Given I am on online shopping My Account - My Store page
    When I want to buy T-Shirt then I click on TShirt_Link_Xpath
    And I am taken into T-Shirt shopping page
    And I choose a T-Shirt of my choice and add to cart
    But I select proceed to checkout instead continuing shopping option
    And I am taken into shopping cart summary page
    And I click on shopping_cart_summary_page_proceed_To_CheckOut_xpath
		#And I am taken to login page asking me to login where I enter my login details and click login button
    And I am taken to choose a delivery address page where I select my office_delivery_address and then proceed to checkout option
    And I landed to a shipping page where I acknowledge the terms and condition and click to proceed to checkout
    And I am taken into payment option page where I proceed to pay by chossing one of payment_option
    And I confirm my order and capture the order reference details
    Then I click back to order from order confimation page to verify the placed order

   @IncreaseOrDecreaseYourQuantityDuringPurchasingTShirt
  	Scenario: Order T-Shirt from Online Shopping Portal
		Given I am on online shopping My Account - My Store page
    When I want to buy T-Shirt then I click on TShirt_Link_Xpath
    And I am taken into T-Shirt shopping page
    And I choose a T-Shirt of my choice and add to cart
    But I select proceed to checkout instead continuing shopping option
    And I am taken into shopping cart summary page where I revisit my quantity
    |Qty_Plus_Minus_Var|Qty_Plus_By_Xpath|Qty_Minus_By_Xpath|
    And I click on shopping_cart_summary_page_proceed_To_CheckOut_xpath
		#And I am taken to login page asking me to login where I enter my login details and click login button
    And I am taken to choose a delivery address page where I select my office_delivery_address and then proceed to checkout option
    And I landed to a shipping page where I acknowledge the terms and condition and click to proceed to checkout
    And I am taken into payment option page where I proceed to pay by chossing one of payment_option
    And I confirm my order and capture the order reference details
    Then I click back to order from order confimation page to verify the placed order
    
    
    