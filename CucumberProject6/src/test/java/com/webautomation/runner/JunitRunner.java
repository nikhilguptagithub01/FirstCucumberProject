package com.webautomation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	
	@CucumberOptions(
	  		dryRun=false,
			strict=true,
			monochrome=true,
			features= {"src/test/resources/"},
			glue = {"com.webautomation.step"},
			plugin= {"pretty",
					"html:target/site/cucumber-html",
					"json:target/cucumber.json",
					"junit:target/site/cucumber.xml"},
//			tags= {"@Login,@OrderTShirt,@UpdatePersonalInformation,@RegisterUser"}
	  		tags= {"@Login,@OrderTShirtWithOneQuantity,@IncreaseOrDecreaseYourQuantityDuringPurchasingTShirt,@UpdatePersonalInformation,@RegisterUser"}
//			tags= {"@OrderTShirt"}
	)
	
	public class JunitRunner {

	}