package com.webautomation.step;

import java.util.List;
import com.webautomation.webdriver.WebConnector;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class genericsteps {
	
	WebConnector con;

	public genericsteps(WebConnector con) {
		this.con = con;
	}
	
	@Given("^I open ([^\"]*)$")
	public void openBrowser(String browserName){		
//		System.out.println("Opening Browser "+browserName);
//		System.out.println("prop.getProperty(browserName)----"+con.prop.getProperty(browserName));
		con.openBrowser(browserName);
		}
	

	@And("^I launch ([^\"]*) of Online Shopping portal$")
	public void launchsite(String URL) {
//		System.out.println("Navigate to Automation Practice shopping portal" + URL);
		con.navigate(URL);
	}
	


//	@And("^I am at sign-up page$")
//	public void registerpage() {
//		System.out.println("I am on sign-up page");
//	}
	
	@And("^I am taken inside sign-in page$")
	public void SignInPage() {
//		System.out.println("I am on sign-in page");
		con.infoLog("Now, I am on Sign-In page of Online Shopping Portal.");
	}
	   
//	   
//	 @When("^I enter the ([^\"]*) at the ([^\"]*) field$")
//	 public void enteremail(String emailid, String email_field_locator) {
//			System.out.println("enter the email id"+emailid+ "email xpath - "+email_field_locator);
//		 con.type(email_field_locator, emailid);
//		 
//		}
	
	 @And ("^I enter email id for registration$")
	  public void EnterEmailToRegister(List<String> data) {
		  con.type(data);
	  }
	 
//	  @And("^click ([^\"]*)$")
//	  public void clickcreateanaccountbtn(String create_an_account_button_xpath) {
//		  System.out.println("Clicked create an account button");
//		  con.click(create_an_account_button_xpath);
//	  }
	   
//	  @Then("^I am taken to create an account page$")
//	  public void intocreateanaccountpage() {
//		  System.out.println("I am inside create an account page");
//	  }
	  
	  @And ("^I am on create an account page$")
	  public void iamoncreateanaccountpage() {
		  con.infoLog("I am on create an account page");
	  }
	  
	  @And ("^I select my salutation$")
	  public void select_salutation(List<String> data) {
		  con.selectradioption(data);
	  }
	  
	  @And ("^I enter my registered email id$")
	  public void EnterRegisteredEmailId(List<String> data) {
		  con.type(data);
	  }
	  
	  @And ("^I enter my password$")
	  public void EnterRegisteredPassword(List<String> data) {
		  con.type(data);
	  }
	  
	  @And ("^I click on ([^\"]*)$")
	  public void ClickOptionOrButton(String data) {
		  con.click(data);
	  }
	  
//    cucumber.runner.AmbiguousStepDefinitionsException: "I click on Sign_In_Link from top right corner of the homepage" matches more than one step definition:
//"^I click ([^"]*)$" in genericsteps.ClickSignInSubmitButton(String)
//"^I click on ([^"]*) from top right corner of the homepage$" in genericsteps.ClickSignInLink(String)
//	@When ("^I click on ([^\"]*) from top right corner of the homepage$")   
//	public void ClickSignInLink(String link) {
//		System.out.println("Clicked sign-in option" + link);
//		con.click(link);
//	}
	  
	  @And ("^enter first name$")
	  public void EnterFirstName(List<String> data) {
		  con.type(data);
	  }
	  @And ("^enter last name$")
	  public void EnterLastName(List<String> data) {
		  con.type(data);
	  }
	  
//	   @And ("^enter3 ([^\"]*) at ([^\"]*)$")
//	   public void password(String password_var, String password_xpath) {
//			  con.type(password_xpath, password_var);
//		  }
	  
	  @And ("^set your password$")
	  public void password(List<String> data) {
		  con.type(data);
	  }
	  
	  
	  
	   @And ("^select day$")
	   public void day(List<String> data) {
//		   String day_var_tostring = Integer.toString(day_var);
     	   con.selectdropdown(data.get(1), data.get(0));
		  }
	   
	   @And ("^select month$")
	   public void month(List<String> data) {
     	   con.selectdropdown(data.get(1), data.get(0));
		  }
	   
	   @And ("^select year$")
	   public void year(List<String> data) {
     	   con.selectdropdown(data.get(1), data.get(0));
		  }
	   
	   @And ("^enter company$")
		  public void EnterCompany(List<String> data) {
			  con.type(data);
		  }
	   @And ("^enter address$")
		  public void EnterAddress(List<String> data) {
			  con.type(data);
		  }
	   @And ("^enter city$")
		  public void EnterCity(List<String> data) {
			  con.type(data);
		  }
	   @And ("^select state$")
	   public void state(List<String> data) {
     	   con.selectdropdown(data.get(1), data.get(0));
		  }
	   @And ("^enter zipcode$")
		  public void EnterZipcode(List<String> data) {
			  con.type(data);
		  }
	   @And ("^select country$")
	   public void country(List<String> data) {
     	   con.selectdropdown(data.get(1), data.get(0));
		  }
	   @And ("^enter mobile number$")
		  public void EnterMobNum(List<String> data) {
			  con.type(data);
		  }
	   @And ("^enter address alias$")
		  public void EnterAddressAlias(List<String> data) {
			  con.type(data);
		  }
//	   @And ("^click ([^\"]*)$")
//	   public void registerbutton(String register_button_var) {
//		   con.click(register_button_var);
//		  }
	   @Then ("^I am taken to My Account page$")
	   public void registered() {
//			  System.out.println("Successfully registered...!!");
		   con.reportpass("Successfully registered...!!");
		  }
	   
	   @Then ("^I am taken inside the application$")
	   public void loginsuccessful() {
			 con.verifylogin();
		  }
	  
	  
	  
		@Before
		public void before(Scenario s) {
//			System.out.println("***Before***"+s.getName());
			con.initReports(s.getName());
			
		}
		
		@After
		public void after() {
//			System.out.println("***Aft***");	
			con.quit();
		}
	
}
