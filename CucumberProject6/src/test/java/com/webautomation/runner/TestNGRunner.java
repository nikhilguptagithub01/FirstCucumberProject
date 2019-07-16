package com.webautomation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  		dryRun=false,
		strict=true,
		monochrome=true,
		features= {"src/test/resources/"},
		glue = {"com.webautomation.step"},
		plugin= {"pretty",
				"html:target/site/cucumber-html",
				"json:target/cucumber.json",
				"testng:target/site/cucumber.xml"},
//		tags= {"@Login,@OrderTShirtWithOneQuantity,@IncreaseOrDecreaseYourQuantityDuringPurchasingTShirt,@UpdatePersonalInformation,@RegisterUser"}
		tags= {"@OrderTShirt,@UpdatePersonalInformation"}
)

public class TestNGRunner extends AbstractTestNGCucumberTests {

}
