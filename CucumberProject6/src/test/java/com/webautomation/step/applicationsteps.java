package com.webautomation.step;

import java.util.List;

import com.webautomation.webdriver.WebConnector;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class applicationsteps {
	
	WebConnector con;

	public applicationsteps(WebConnector con) {
		this.con = con;
	}
	
	@Given ("^I am on online shopping My Account - My Store page$")
	public void verifyhomepage() {
		con.verifyhomepage();
	}

	  @When ("^I want to buy T-Shirt then I click on ([^\"]*)$")
	  public void clickTShirtLink(String data) {
		  con.click(data);
	  }
	
	@And ("^I am taken into T-Shirt shopping page$")
	public void clickTShirtMenu() {
		con.VerifyTshirtShoppingPage();
	}
    @And ("^I choose a T-Shirt of my choice and add to cart$")
    public void ChooseTShirtAndAddToCart() {
		con.addtocart();
	}
    @But ("^I select proceed to checkout instead continuing shopping option$")
    public void ProceedToCheckoutonpopup() {
		con.proceedtocheckoutonpopup();
	}
    @And ("^I am taken into shopping cart summary page$")
    public void ShippingCartSummarPage() {
		con.shoppingcartsummarypage();
	}
    
//    @And ("^I click proceed to checkout option$")
//    public void ShippingCartSummarPage() {
//		con.shoppingcartsummarypage();
//	}
    
    @And ("^I am taken into shopping cart summary page where I revisit my quantity$")
    public void RevisitQtyOnShippingCartSummarPage(List<String> data) {
		con.revisitqtyshoppingcartsummarypage(data);
	}
    
    
    
//    @And ("^I am taken to login page asking me to login where I enter my login details and click login button$")
//    public void clickTShirtMenu() {
//		
//	}
//    cucumber.runtime.CucumberException: Step [^I am taken to choose a delivery address page where I select my [^"]* delivery address and then proceed to checkout option$] is defined with 1 parameters at 'com.webautomation.step.applicationsteps.SelectDeliveryAddress(String) in file:/F:/Eclipse-Cucumber-WS/CucumberProject2/target/test-classes/'.
//However, the gherkin step has 0 arguments.
    @And ("^I am taken to choose a delivery address page where I select my ([^\"]*) and then proceed to checkout option$")
    public void SelectDeliveryAddress(String deliveryaddrs) {
		con.selectdeliveryaddress(deliveryaddrs);
	}
    @And ("^I landed to a shipping page where I acknowledge the terms and condition and click to proceed to checkout$")
    public void AckTermsAndConditions() {
		con.acktermncondition();
	}
    @And ("^I am taken into payment option page where I proceed to pay by chossing one of ([^\"]*)$")
    public void PaymentOptionPage(String paymentoption) {
//    	System.out.println("paymentoption ---"+paymentoption);
//    	System.out.println("con.prop.getProperty(paymentoption) ---"+con.prop.getProperty(paymentoption));
    	con.choosepaymentoptionandproceedtocheckout(paymentoption);
		
	}
    @And ("^I confirm my order and capture the order reference details$")
    public void ConfirmMyOrderAndCaptureOrderDetails() {
		con.confirmmyorderandcaptureorderdetails();
	}
    @Then ("^I click back to order from order confimation page to verify the placed order$")
    public void clickToVerifyOrder() {
		con.verifyorder();
	}
    
    @When ("^I click My Personal Information link$")
    public void gotopersonalinformationpage() {
		con.gotopersonalinformationpage();
	}
    @And ("^I enter my changed first name$")
    public void changefname(List<String> data) {
		con.type(data);
	}
    @And ("^I enter my current password$")
    public void entercurrentpassword(List<String> data) {
    	con.type(data);
	}
//    cucumber.runtime.DuplicateStepDefinitionException: Duplicate step definitions in com.webautomation.step.applicationsteps.clicksave(String) in file:/F:/Eclipse-Cucumber-WS/CucumberProject4/target/test-classes/ and com.webautomation.step.genericsteps.ClickSignIn(String) in file:/F:/Eclipse-Cucumber-WS/CucumberProject4/target/test-classes/
//    @And ("^I click on ([^\"]*)$")
//    public void clicksave(String data){
//    	 con.click(data);
//	}
    @Then ("^The ([^\"]*) is displayed$")
    public void verifysuccessfulsavemessage(String successful_saving_message) {
		con.verifysuccessfulsavemessage(successful_saving_message);
	}
	
    @And ("^on top right corner, my ([^\"]*) can be verified$")
    public void verifychangedfname(String change_fname) {
    	con.verifychangedfname(change_fname);
    }
	
}
