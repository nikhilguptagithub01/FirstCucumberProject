package com.webautomation.webdriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.webautomation.reports.extentManager;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class WebConnector {
	
	WebDriver driver;
//	public String wcpaymentoption;
	public Properties prop;
//	public readTestDataFromExcel readxl;
	public ExtentReports rep;
	public ExtentTest scenario;
	
	
	public WebConnector() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\project.Properties");
			prop.load(fs);
//			readxl = new readTestDataFromExcel();
		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Unable to load the properties file, below is the error message - "+e.getMessage());
//			infoLog("Unable to load the properties file, below is the error message - "+e.getMessage());
			reportfailure("Unable to load the properties file, below is the error message - "+e.getMessage());
		}	
	}
	
	
	
	public void openBrowser(String browserName) {
//		org.openqa.selenium.remote.UnreachableBrowserException: Could not start a new session. Possible causes are invalid address of the remote server or browser start-up failure.'
//	    org.openqa.selenium.SessionNotCreatedException: Unexpected error launching Internet Explorer. Protected Mode settings are not the same for all zones. Enable Protected Mode must be set to the same value (enabled or disabled) for all zones
//		org.openqa.selenium.NoSuchWindowException: Currently focused window has been closed.
//		https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver#required-configuration
//	      org.openqa.selenium.WebDriverException: Timed out waiting 45 seconds for Firefox to start.
//		 if grid = Y but server is not running -->org.openqa.selenium.remote.UnreachableBrowserException: Could not start a new session. Possible causes are invalid address of the remote server or browser start-up failure.
	      
		if(prop.getProperty("gridRun").equalsIgnoreCase("Y")) {
			// invoke browser through grid
			DesiredCapabilities cap = null;
			if(prop.getProperty(browserName).equals("Mozilla")) {
				cap = DesiredCapabilities.firefox();
				cap.setJavascriptEnabled(true);
				cap.setPlatform(Platform.WINDOWS);
			}else if(prop.getProperty(browserName).equals("Chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setJavascriptEnabled(true);
				cap.setPlatform(Platform.WINDOWS);
			}else if(prop.getProperty(browserName).equals("InternetExplorer")) {
				cap = DesiredCapabilities.internetExplorer();
				cap.setJavascriptEnabled(true);
				cap.setPlatform(Platform.WINDOWS);
			}
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
//		System.out.println("prop.getProperty(browserName)----"+prop.getProperty(browserName));
		}else if(prop.getProperty(browserName).equals("Mozilla")) {
//			System.setProperty("webdriver.firefox.marionette","F:\\software\\BrowserDriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(prop.getProperty(browserName).equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			} else if(prop.getProperty(browserName).equals("InternetExplorer")) {
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\BrowserDriver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		driver.manage().window().maximize();
//		IsAlertPresent();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		System.out.println("Opened "+prop.getProperty(browserName)+" Browser");
		infoLog("Opened "+prop.getProperty(browserName)+" Browser");
		
		}
	
	public void navigate(String urlkey) {
		driver.navigate().to(prop.getProperty(urlkey));
//		System.out.println("Launched given URL - "+ prop.getProperty(urlkey));
		infoLog("Launched given URL - "+ prop.getProperty(urlkey));
	}
	
	public void click(String objectkey) {
		try {
		//	System.out.println("register button ---"+prop.getProperty(objectkey));
		driver.findElement(By.xpath(prop.getProperty(objectkey))).click();
//		System.out.println("Successfully clicked on "+objectkey);
		infoLog("Successfully clicked on "+objectkey);
		}
		catch (Exception e){
		String existing_registered_email_id_error = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
		String invalid_email_id_error = "Invalid email address.";
		WebElement existing_registered_email_id_error_Display_Area = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
		WebElement invalid_email_id_error_Display_Area = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
		if(existing_registered_email_id_error_Display_Area.getText().equalsIgnoreCase(existing_registered_email_id_error)){
			infoLog("Email id is already registed");
//			System.out.println("Email id is already registed");
		} else if (invalid_email_id_error_Display_Area.getText().equalsIgnoreCase(invalid_email_id_error)){
			infoLog("Entered Email id is invalid");		
//			System.out.println("Entered Email id is invalid");
		} 
		}
		}
				

//	public void type(String objectkey, String data) {
//		System.out.println("fname xpath ---"+prop.getProperty(objectkey));
//		System.out.println("fname ----"+prop.getProperty(data));
//		String data1 = prop.getProperty(data);
//		driver.findElement(By.xpath(prop.getProperty(objectkey))).sendKeys(prop.getProperty(data));
//	}
	
//	public void type(String objectkey, int data) {
//		String data_tostring = Integer.toString(data);
//		driver.findElement(By.xpath(prop.getProperty(objectkey))).sendKeys(prop.getProperty(data_tostring));
//	}
	
	public void selectdropdown(String objectkey, String data) {
//		StringJoiner str = new StringJoiner("");
//		str.add(prop.getProperty(data));
//		str.add("  ");
		if (data.contains("day") ||data.contains("year")) {
			StringJoiner str = new StringJoiner("");
			str.add(prop.getProperty(data));
			str.add("  ");
			Select valuefromdropdown = new Select(driver.findElement(By.xpath(prop.getProperty(objectkey))));
			if(!valuefromdropdown.getFirstSelectedOption().getText().trim().equals(prop.getProperty(data))) {
				valuefromdropdown.selectByVisibleText(str.toString());
				infoLog("Data from the dropdown has been selected - "+prop.getProperty(data));
			}
		}else if(data.contains("month")) {
			   StringJoiner str = new StringJoiner("");
				str.add(prop.getProperty(data));
				str.add(" ");
				Select valuefromdropdown = new Select(driver.findElement(By.xpath(prop.getProperty(objectkey))));
				if(!valuefromdropdown.getFirstSelectedOption().getText().trim().equals(prop.getProperty(data))) {
					valuefromdropdown.selectByVisibleText(str.toString());
					infoLog("Data from the dropdown has been selected - "+prop.getProperty(data));
				}
		}else {
			
		
		Select valuefromdropdown = new Select(driver.findElement(By.xpath(prop.getProperty(objectkey))));
//		StringJoiner str = new StringJoiner("");
//		str.add(prop.getProperty(data));
//		str.add("  ");
		if(!valuefromdropdown.getFirstSelectedOption().getText().trim().equals(prop.getProperty(data))) {
			valuefromdropdown.selectByVisibleText(prop.getProperty(data));
			infoLog("Data from the dropdown has been selected - "+prop.getProperty(data));
		}
//		valuefromdropdown.selectByVisibleText(data);
//		valuefromdropdown.selectByVisibleText("12");
	}
		}
	
	public void selectradioption(List<String> Objectkey) {
//		System.out.println("Salutation --"+ prop.getProperty(data));
//		System.out.println("Objectkey.get(0)--- "+prop.getProperty(Objectkey.get(0)));
//		System.out.println("Objectkey.get(1)--- "+prop.getProperty(Objectkey.get(1)));
		try {
		if(prop.getProperty(Objectkey.get(0)).contentEquals("Mr.")) {
//			System.out.println("Salutation conditioned -- passed");
			driver.findElement(By.xpath(prop.getProperty(Objectkey.get(1)))).click();
			infoLog("Selected salutation is Mr.");
//			System.out.println("Clicked 1.....");
		}else {
//			System.out.println("Salutation conditioned -- failed");
			driver.findElement(By.xpath(prop.getProperty(Objectkey.get(2)))).click();
			infoLog("Selected salutation is Mrs.");
//			System.out.println("Clicked 2.....");
		}
	}catch (Exception e) {
//		System.out.println("exception occured ---"+e);
		reportfailure("Invalid salutation...!!");
		
	}
}




	public void type(List<String> data) {
		String login_data = prop.getProperty(data.get(0));
		String field_locator_xpath = prop.getProperty(data.get(1));
		driver.findElement(By.xpath(field_locator_xpath)).clear();
		driver.findElement(By.xpath(field_locator_xpath)).sendKeys(login_data);
		infoLog("Entered "+login_data+" at "+field_locator_xpath);
//		System.out.println("Entered "+login_data+" at "+field_locator_xpath);
	}
	
	public void closebrowser() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}



	public void verifyhomepage() {

		String actualTitle = driver.getTitle();
		//System.out.println("actual title ---- "+actualTitle);
		String expectedTitle = "My account - My Store";
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
//			System.out.println("Currently on the my account - my store page...!!");
			infoLog("Currently on the my account - my store page...!!");
		} else {
//			System.out.println("Not on the my account - my store page...!!");
			infoLog("Not on the my account - my store page...!!");
		}
		
	}



	public void VerifyTshirtShoppingPage() {

		String actualTitle = driver.getTitle();
		//System.out.println("actual title ---- "+actualTitle);
		String expectedTitle = "T-shirts - My Store";
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
//			System.out.println("Currently on the my account - my store page...!!");
			infoLog("Currently on the T-Shirt shopping page...!!");
		} else {
//			System.out.println("Not on the my account - my store page...!!");
			reportfailure("Not on the T-Shirt shopping page...!!");
		}
	}



	public void addtocart() {
		//TO avoid  org.openqa.selenium.ElementNotInteractableException: element not interactable
//		 org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: (524, 863) is out of bounds of viewport width (1366) and height (654)
		try {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("MoveToTShirt_Element_xpath"))));
		    Thread.sleep(500);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("MoveToAddToCart_Button_xpath"))));
		    Thread.sleep(500);
		Actions builder = new Actions(driver);
		Action movetoaddtocart = builder
								 .moveToElement(driver.findElement(By.xpath(prop.getProperty("MoveToTShirt_Element_xpath"))))
								 .moveToElement(driver.findElement(By.xpath(prop.getProperty("MoveToAddToCart_Button_xpath"))))
								 .click()
								 .build();
		
		movetoaddtocart.perform();
		//driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
		//driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Added_To_Cart_Message_Displayed_Element_xpath"))));
		driver.findElement(By.xpath(prop.getProperty("Added_To_Cart_Message_Displayed_Element_xpath"))).isDisplayed();
		String actualtext = driver.findElement(By.xpath(prop.getProperty("Added_To_Cart_Message_Displayed_Element_xpath"))).getText();
		String expectedtext = "Product successfully added to your shopping cart";
		if (actualtext.equals(expectedtext)){
//			System.out.println("Product added successfully..!!");
			infoLog("Product added successfully..!!");
		}else {
//			System.out.println("Product not added successfully - Please retry again..!!");
			reportfailure("Product not added successfully - Please retry again..!!");
//			driver.findElement(By.xpath(prop.getProperty("Continuing_Shopping_xpath"))).click();
		}
	}catch (Exception e) {
		reportfailure("Error occured -- "+e.getMessage());
		driver.quit();
		}
		}
	

	public void proceedtocheckoutonpopup() {

		driver.findElement(By.xpath(prop.getProperty("Proceed_To_CheckOut_OnPop_xpath"))).click();
		infoLog("Clicked Proceed To Check out on pop-up page display..!!");

	}
	
	

	public void shoppingcartsummarypage() {
		
		String actualTitle = driver.findElement(By.xpath(prop.getProperty("Navigation_Text_Message_Display_xpath"))).getText();
		String expectedTitle = "Your shopping cart";
		
		if(actualTitle.equals(expectedTitle)) {
			
//			driver.findElement(By.xpath(prop.getProperty("onshoppingcartsummarypage_proceed_To_CheckOut_xpath"))).click();
			infoLog("I on shopping cart summary page..!!");

		} else {
//			System.out.println("Not on the shopping cart summary page - Please retry...!!");
			reportfailure("Not on the shopping cart summary page - Please retry...!!");
		}
		
	}
	
	
	public void revisitqtyshoppingcartsummarypage(List<String> Objectkey) {
		
		String Qty_Plus_Minus_Var, Qty_Plus_By_Xpath, Qty_Minus_By_Xpath;
		
		Qty_Plus_Minus_Var = prop.getProperty(Objectkey.get(0));
		Qty_Plus_By_Xpath = Objectkey.get(1);
		Qty_Minus_By_Xpath = Objectkey.get(2);
		
		WebElement WE_Qty_Plus_By_Xpath = driver.findElement(By.xpath(prop.getProperty(Qty_Plus_By_Xpath)));
		WebElement WE_Qty_Minus_By_Xpath = driver.findElement(By.xpath(prop.getProperty(Qty_Minus_By_Xpath)));

		if(Integer.parseInt(Qty_Plus_Minus_Var.substring(1).trim())==0) {
			
			infoLog("User chose to order 1 quantity only..!!");
//			System.out.println(prop.getProperty("cart_summary_xpath"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("cart_summary_xpath"))));
		    try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
		
		if(Qty_Plus_Minus_Var.contains("+")) {
			String Increase_Count = Qty_Plus_Minus_Var.substring(1).trim();
			
			for(int i=0; i<(Integer.parseInt(Increase_Count));i++) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty(Qty_Plus_By_Xpath))));
			    try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WE_Qty_Plus_By_Xpath.click();
			}
			reportpass("Quantity increased by "+Increase_Count);
			} else if(Qty_Plus_Minus_Var.contains("-")) {
				String Decrease_Count = Qty_Plus_Minus_Var.substring(1);
				if((Integer.parseInt(Decrease_Count)) == 1) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty(Qty_Minus_By_Xpath))));
				    try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					WE_Qty_Minus_By_Xpath.click();
					infoLog("You Shopping Cart has become empty..!!");
					driver.quit();
				}else {
				reportfailure("The current order quanity is 1 so it can't decrease beyond 1. And you gave to decrease by "+Decrease_Count);
				driver.quit();
			    }
		   } else {
				reportfailure("Not a valid decrease (-) or increase (+) count has been given....Please recheck it...!!");
				driver.quit();
		   }
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("cart_summary_xpath"))));
//		System.out.println(prop.getProperty("cart_summary_xpath"));
	    try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	
	
	public void selectdeliveryaddress(String deliveryaddrs) {

		String actualTitle = driver.findElement(By.xpath(prop.getProperty("Navigation_Text_Message_Display_xpath"))).getText();
		String expectedTitle = "Addresses";
		WebElement onaddrpagecheckbox = driver.findElement(By.xpath(prop.getProperty("onaddrpagecheckbox_xpath")));
		WebElement messagebox = driver.findElement(By.xpath(prop.getProperty("Textarea_xpath")));
		
		if(actualTitle.equals(expectedTitle)) {
//			System.out.println("I am inside if loop - actualTitle.equals(expectedTitle)....");
			Select choosedeliveryaddress = new Select(driver.findElement(By.xpath(prop.getProperty("drpdwn_delivery_address_xpath"))));
//			System.out.println("prop.getProperty(deliveryaddrs)-----"+ prop.getProperty(deliveryaddrs));
//			System.out.println(".getFirstSelectedOption().getText()-----"+ choosedeliveryaddress.getFirstSelectedOption().getText().trim());

			if(!choosedeliveryaddress.getFirstSelectedOption().getText().trim().equals(prop.getProperty(deliveryaddrs))) {
				choosedeliveryaddress.selectByVisibleText(prop.getProperty(deliveryaddrs));
//				System.out.println("inside choosedeliveryaddress-----");
					if (!onaddrpagecheckbox.isSelected()) {
						onaddrpagecheckbox.click();
//					System.out.println("inside choosedeliveryaddress-----");
//					System.out.println("inside checkbox-----");
					if (messagebox.isDisplayed()) {
//						System.out.println("inside choosedeliveryaddress-----");
//						System.out.println("inside checkbox-----");
//						System.out.println("inside messagebox-----");
						messagebox.clear();
						messagebox.sendKeys("Please send between 8am - 5 pm on Monday to Friday. Thank you..!!");
						driver.findElement(By.xpath(prop.getProperty("addr_proceed_To_CheckOut_xpath"))).click();
						infoLog("Proceeding from address delivery page...!!");
					} else {
						driver.findElement(By.xpath(prop.getProperty("addr_proceed_To_CheckOut_xpath"))).click();
						infoLog("Proceeding from address delivery page...!!");
					}
				}
			}else if (!onaddrpagecheckbox.isSelected()) {
//				System.out.println("outside choosedeliveryaddress-----");
//				System.out.println("inside checkbox-----");
				onaddrpagecheckbox.click();
				if (messagebox.isDisplayed()) {
//					System.out.println("outside choosedeliveryaddress-----");
//					System.out.println("inside checkbox-----");
//					System.out.println("Inside checkbox-----");
					messagebox.sendKeys("Please send between 8am - 5 pm on Monday to Friday. Thank you..!!");
					driver.findElement(By.xpath(prop.getProperty("addr_proceed_To_CheckOut_xpath"))).click();
					infoLog("Proceeding from address delivery page...!!");
				} else {
					driver.findElement(By.xpath(prop.getProperty("addr_proceed_To_CheckOut_xpath"))).click();
					infoLog("Proceeding from address delivery page...!!");
				}
			} else if (messagebox.isDisplayed()) {
//				System.out.println("outside choosedeliveryaddress-----");
//				System.out.println("Outside checkbox-----");
//				System.out.println("Inside messagebox-----");
				messagebox.sendKeys("Please send between 8am - 5 pm on Monday to Friday. Thank you..!!");
				driver.findElement(By.xpath(prop.getProperty("addr_proceed_To_CheckOut_xpath"))).click();
				infoLog("Proceeding from address delivery page...!!");
			} else {
				driver.findElement(By.xpath(prop.getProperty("addr_proceed_To_CheckOut_xpath"))).click();
				infoLog("Proceeding from address delivery page...!!");
			}
			
		} else {
//			System.out.println("Not on the address delivery page - Please retry...!!");
			reportfailure("Not on the address delivery page - Please retry...!!");
		}
		
	}
	

	public void acktermncondition() {
		try {
		String actualTitle = driver.findElement(By.xpath(prop.getProperty("Navigation_Text_Message_Display_xpath"))).getText();
		String expectedTitle = "Shipping";
		WebElement ackcheckbox = driver.findElement(By.xpath(prop.getProperty("ack_checkbox_xpath")));
		WebElement readterms = driver.findElement(By.xpath(prop.getProperty("open_read_terms_xpath")));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions builder = new Actions(driver);
		Action movetoelement = builder.moveToElement(ackcheckbox).build();

		if(actualTitle.equals(expectedTitle)) {
			
			if (!ackcheckbox.isSelected()) {

//				int iframesize = driver.findElements(By.tagName("iframe")).size();
				
//				System.out.println("iframe size -- "+iframesize);
//				if (iframesize <= 1) {
//					System.out.println("I am inside iframe loop");
//				driver.findElements(By.tagName("iframe"));
//				driver.findElements(By.className("iframe"));
//				driver.switchTo().frame(0);
				readterms.click();
//				System.out.println("I switched to iframe...");
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fancybox-frame1563103468537"));
				//driver.switchTo().alert();
				driver.findElement(By.xpath(prop.getProperty("close_read_terms_xpath"))).click();
//				System.out.println("I closed the iframe...");
				driver.switchTo().defaultContent();
//				System.out.println("back to default content");
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cgv\"]")));
				//wait.until(ExpectedConditions.elementToBeClickable(checkbox));
			    Thread.sleep(500);
				
				movetoelement.perform();
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("ack_checkbox_xpath"))));
			    Thread.sleep(500);
//				org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <input type="checkbox" name="cgv" id="cgv" value="1"> is not clickable at point (115, 605). Other element would receive the click: <div class="fancybox-overlay fancybox-overlay-fixed" style="display: block; width: auto; height: auto;">...</div>
				ackcheckbox.click();
				driver.findElement(By.xpath(prop.getProperty("ack_proceed_To_CheckOut_xpath"))).click();
				infoLog("Acknowledged terms and conditions..!!");
				
			} else {
				driver.findElement(By.xpath(prop.getProperty("ack_proceed_To_CheckOut_xpath"))).click();
				infoLog("Acknowledged terms and conditions..!!");
			}
			
		} else {
//			System.out.println("Not on the shipping page - Please retry...!!");
			reportfailure("Not on the shipping page - Please retry...!!");
		}
		
	}catch(Exception e) {
		reportfailure("Error occured --"+e.getMessage());
		driver.quit();
	}}
	

	public void choosepaymentoptionandproceedtocheckout(String paymentoption) {
		String actualTitle = driver.findElement(By.xpath(prop.getProperty("Navigation_Text_Message_Display_xpath"))).getText();
		String expectedTitle = "Your payment method";
		WebElement paybywire = driver.findElement(By.xpath(prop.getProperty("pay_by_wire_link_xpath")));
		WebElement paybycheck = driver.findElement(By.xpath(prop.getProperty("pay_by_check_link_xpath")));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		if(actualTitle.equals(expectedTitle)) {
//			System.out.println("prop.getProperty(paymentoption) ---"+prop.getProperty(paymentoption));
			if(prop.getProperty(paymentoption).endsWith("-wire")) {
//				System.out.println("inside loop...");
				wait.until(ExpectedConditions.visibilityOf(paybywire));
				paybywire.click();
				infoLog("Paying by pay by wire payment method..!!");
			}else {
				wait.until(ExpectedConditions.visibilityOf(paybycheck));
				paybycheck.click();
				infoLog("Paying by pay by check payment method..!!");
			}
			
		} else {
//			System.out.println("Not on the payment method page - Please retry...!!");
			reportfailure("Not on the payment method page - Please retry...!!");
		}
		
	}
	

	public void confirmmyorderandcaptureorderdetails() {
		String actualTitle = driver.findElement(By.xpath(prop.getProperty("Navigation_Text_Message_Display_xpath"))).getText();
		String expectedpaybywire = "Bank-wire payment.";
		String expectedpaybycheck = "Check payment";
//		WebElement choosecorrectpaymentmethod = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/a"));
		WebElement confirmmyorder = driver.findElement(By.xpath(prop.getProperty("confirm_my_order_button_xpath")));
		WebDriverWait wait = new WebDriverWait(driver, 10);

		if((actualTitle.equals(expectedpaybywire)) || (actualTitle.equals(expectedpaybycheck))) {
			
			wait.until(ExpectedConditions.visibilityOf(confirmmyorder));
			confirmmyorder.click();	
			infoLog("I confirmed my order..!!");
			
			} else {
//			System.out.println("Not on the order summary page...Please retry...Thank you!!");
				reportfailure("Not on the order summary page...Please retry...Thank you!!");
		}
	
	}
	
	public void verifyorder() {
//		 org.openqa.selenium.InvalidSelectorException: invalid selector: The result of the xpath expression "//*[@id="center_column"]/div/text()[6]" is: [object Text]. It should be an element.
		
		String actualTitle = driver.findElement(By.xpath(prop.getProperty("Navigation_Text_Message_Display_xpath"))).getText();
		
		String expectedTitle = "Order confirmation";

//		WebDriverWait wait = new WebDriverWait(driver, 10);
		String OrderConfirmation_YourOrderIsComplete, OrderConfirmation_Amount, OrderConfirmation_OwnerName, OrderConfirmation_IncludeDetails, OrderConfirmation_BankName, OrderConfirmation_OrderReference;
		String OrderHistory_Amount, OrderHistory_OwnerName, OrderHistory_IncludeDetails, OrderHistory_BankName, OrderHistory_OrderReference;
		if(prop.getProperty("payment_option").endsWith("-wire")) {
			
//		WebElement WE_OrderConfirmation_YourOrderIsComplete = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_YourOrderIsComplete_Text_Display_xpath")));
		WebElement WE_OrderConfirmation_Amount = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_Amount_Text_Display_xpath")));
		WebElement WE_OrderConfirmation_OwnerName = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_OwnerName_Text_Display_xpath")));
		WebElement WE_OrderConfirmation_IncludeDetails = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_IncludeDetails_Text_Display_xpath")));
		WebElement WE_OrderConfirmation_BankName = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_BankName_Text_Display_xpath")));
		WebElement WE_OrderConfirmation_OrderReference = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_OrderReference_Text_Display_xpath")));
		

//		OrderConfirmation_YourOrderIsComplete = WE_OrderConfirmation_YourOrderIsComplete.getText();
//		System.out.println("OrderConfirmation_YourOrderIsComplete----"+OrderConfirmation_YourOrderIsComplete);
		OrderConfirmation_Amount = WE_OrderConfirmation_Amount.getText();
//		System.out.println("OrderConfirmation_Amount----"+OrderConfirmation_Amount);
		OrderConfirmation_OwnerName = WE_OrderConfirmation_OwnerName.getText();
//		System.out.println("OrderConfirmation_OwnerName----"+OrderConfirmation_OwnerName);
		OrderConfirmation_IncludeDetails = WE_OrderConfirmation_IncludeDetails.getText();
//		System.out.println("OrderConfirmation_IncludeDetails----"+OrderConfirmation_IncludeDetails);
		OrderConfirmation_BankName = WE_OrderConfirmation_BankName.getText();
//		System.out.println("OrderConfirmation_BankName----"+OrderConfirmation_BankName);
		OrderConfirmation_OrderReference = WE_OrderConfirmation_OrderReference.getText();
//		System.out.println("OrderConfirmation_OrderReference----"+OrderConfirmation_OrderReference);
		
		if (actualTitle.equals(expectedTitle)) {
		//wait.until(ExpectedConditions.textToBePresentInElementValue(WE_OrderConfirmation_YourOrderIsComplete, OrderConfirmation_YourOrderIsComplete));
		
		reportpass("Yah! your order is complete..!!.....Going to verify the order in Order history....");
		
		WebElement BackToOrders = driver.findElement(By.xpath(prop.getProperty("Back_To_Order_xpath")));
		BackToOrders.click();
		
		
		
		
					
		// No. of columns 
		List<WebElement> cols = driver.findElements(By.xpath(prop.getProperty("Web_Table_Columns_Reference_Xpath")));
		
		infoLog("Column size = " +cols.size());
		
//		List<WebElement> rows = driver.findElements(By.xpath(prop.getProperty("Web_Table_Rows_Reference_Xpath")));
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"order-list\"]/tbody/tr"));
		
		infoLog("Row size = " +rows.size());
		
		for(int i=0; i<rows.size(); i++) {
			infoLog("Order Reference -- "+driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]")).getText());
			//*[@id="order-list"]/tbody/tr[1]/td[1]
		OrderHistory_OrderReference = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]")).getText();
//		System.out.println("OrderHistory_OrderReference"+OrderHistory_OrderReference);
			if(OrderConfirmation_OrderReference.contains(OrderHistory_OrderReference)) {
				System.out.println("I am inside the loop....");
				 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]/a")));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]/a")).click();
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td/div/div[3]/div[2]/a[1]/span")));
//				driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td/div/div[3]/div[2]/a[1]/span")).isDisplayed();
//				driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td/div/div[3]/div[2]/a[1]/span")).click();
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-detail-content\"]/table/tfoot/tr[4]/td[2]/span")));
//				driver.findElement(By.xpath("//*[@id=\"order-detail-content\"]/table/tfoot/tr[4]/td[2]/span")).isDisplayed();
				
				 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("order_history_amount_xpath"))));
				 try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 OrderHistory_Amount = driver.findElement(By.xpath(prop.getProperty("order_history_amount_xpath"))).getText();
				if(OrderHistory_Amount.equals(OrderConfirmation_Amount)) {
//					System.out.println("Order has been verified and successfully placed...!!");
					reportpass("Order has been verified and successfully placed...!!");
					break;
				}
			}else {
//				System.out.println("I am outside the loop..");
			}
			
		}	
			} else {
//			System.out.println("Not on the order history page...Please retry...Thank you!!");
				reportfailure("Not on the order history page...Please retry...Thank you!!");
		}
		
	}
		else {
			//*[@id="center_column"]/p[1]
//			WebElement WE_OrderConfirmation_YourOrderIsComplete = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_YourOrderIsComplete_Text_Display_xpath")));
			WebElement WE_OrderConfirmation_Amount = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_Amount_Text_Display_xpath")));
			WebElement WE_OrderConfirmation_OwnerName = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_OwnerName_Text_Display_xpath")));
			WebElement WE_OrderConfirmation_IncludeDetails = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_IncludeDetails_Text_Display_xpath")));
//			WebElement WE_OrderConfirmation_BankName = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_BankName_Text_Display_xpath")));
			WebElement WE_OrderConfirmation_OrderReference = driver.findElement(By.xpath(prop.getProperty("OrderConfirmation_OrderReference_Text_Display_xpath")));
			

//			OrderConfirmation_YourOrderIsComplete = WE_OrderConfirmation_YourOrderIsComplete.getText();
//			System.out.println("OrderConfirmation_YourOrderIsComplete----"+OrderConfirmation_YourOrderIsComplete);
			OrderConfirmation_Amount = WE_OrderConfirmation_Amount.getText();
//			System.out.println("OrderConfirmation_Amount----"+OrderConfirmation_Amount);
			OrderConfirmation_OwnerName = WE_OrderConfirmation_OwnerName.getText();
//			System.out.println("OrderConfirmation_OwnerName----"+OrderConfirmation_OwnerName);
			OrderConfirmation_IncludeDetails = WE_OrderConfirmation_IncludeDetails.getText();
//			System.out.println("OrderConfirmation_IncludeDetails----"+OrderConfirmation_IncludeDetails);
//			OrderConfirmation_BankName = WE_OrderConfirmation_BankName.getText();
//			System.out.println("OrderConfirmation_BankName----"+OrderConfirmation_BankName);
			OrderConfirmation_OrderReference = WE_OrderConfirmation_OrderReference.getText();
//			System.out.println("OrderConfirmation_OrderReference----"+OrderConfirmation_OrderReference);
			
			if (actualTitle.equals(expectedTitle)) {
			//wait.until(ExpectedConditions.textToBePresentInElementValue(WE_OrderConfirmation_YourOrderIsComplete, OrderConfirmation_YourOrderIsComplete));
			
			reportpass("Yah! your order is complete..!!.....Going to verify the order in Order history....");
			
			WebElement BackToOrders = driver.findElement(By.xpath(prop.getProperty("Back_To_Order_xpath")));
			BackToOrders.click();
			
			
			
//			String OrderHistory_Amount, OrderHistory_OwnerName, OrderHistory_IncludeDetails, OrderHistory_BankName, OrderHistory_OrderReference;
						
			// No. of columns 
			List<WebElement> cols = driver.findElements(By.xpath(prop.getProperty("Web_Table_Columns_Reference_Xpath")));
			
			infoLog("Column size = " +cols.size());
			
//			List<WebElement> rows = driver.findElements(By.xpath(prop.getProperty("Web_Table_Rows_Reference_Xpath")));
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"order-list\"]/tbody/tr"));
			
			infoLog("Row size = " +rows.size());
			
			for(int i=0; i<rows.size(); i++) {
				infoLog("Order Reference -- "+driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]")).getText());
				//*[@id="order-list"]/tbody/tr[1]/td[1]
			OrderHistory_OrderReference = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]")).getText();
//			System.out.println("OrderHistory_OrderReference"+OrderHistory_OrderReference);
				if(OrderConfirmation_OrderReference.contains(OrderHistory_OrderReference)) {
					System.out.println("I am inside the loop....");
					 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]/a")));
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr["+(i+1)+"]/td[1]/a")).click();
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td/div/div[3]/div[2]/a[1]/span")));
//					driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td/div/div[3]/div[2]/a[1]/span")).isDisplayed();
//					driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td/div/div[3]/div[2]/a[1]/span")).click();
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-detail-content\"]/table/tfoot/tr[4]/td[2]/span")));
//					driver.findElement(By.xpath("//*[@id=\"order-detail-content\"]/table/tfoot/tr[4]/td[2]/span")).isDisplayed();
					
					 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("order_history_amount_xpath"))));
					 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 OrderHistory_Amount = driver.findElement(By.xpath(prop.getProperty("order_history_amount_xpath"))).getText();
					if(OrderHistory_Amount.equals(OrderConfirmation_Amount)) {
//						System.out.println("Order has been verified and successfully placed...!!");
						reportpass("Order has been verified and successfully placed...!!");
						break;
					}
				}else {
//					System.out.println("I am outside the loop..");
				}
				
			}	
				} else {
//				System.out.println("Not on the order history page...Please retry...Thank you!!");
					reportfailure("Not on the order history page...Please retry...Thank you!!");
			}
			
		}
	}
	

	public void gotopersonalinformationpage() {
		driver.findElement(By.xpath(prop.getProperty("Personal_Info_Link_Xpath"))).click();
		infoLog("Clicking Personal Information link");
		
	}



//	public void changename(String change_fname) {
//		System.out.println("prop.getProperty(change_fname)---"+prop.getProperty(change_fname));
//			String actualTitle = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[3]")).getText().trim();
//			String expectedTitle ="Your personal information";
//			if (actualTitle.equals(expectedTitle)) {
//				driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
//				driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(prop.getProperty(change_fname));
//				infoLog("Changed first name has been entered...!!");
//			}
//	}



//	public void entercurrentpassword(String current_password) {
//		driver.findElement(By.xpath("//*[@id=\"old_passwd\"]")).sendKeys(prop.getProperty(current_password));
//		
//	}



//	public void clicksave() {
//		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button/span")).click();
//		
//	}



	public void verifysuccessfulsavemessage(String successful_saving_message) {
//		AsserEquals("First Name successfully got changed..!!", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText().trim(),successful_saving_message);
		String actual_successful_msg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText().trim();
//		System.out.println("actual_successful_msg---"+actual_successful_msg);
		if (actual_successful_msg.equals(prop.getProperty(successful_saving_message))) {
//			System.out.println("I am inisde loop....");
//			System.out.println("Successfully first name got changed...!!");
			reportpass("Successfully first name got changed...!!");
		}else {
			reportfailure("It seems first name has not got changed - please retry...!!");
//			System.out.println("It seems first name has not got changed - please retry...!!");
		}
	}



	public void verifychangedfname(String change_fname) {
		String actual_name = driver.findElement(By.xpath(prop.getProperty("UserName_Display_Xpath"))).getText().trim();
		String[] str = actual_name.split(" ");
//		System.out.println("str [0]--"+ str[0]);
//		System.out.println("str [1]--"+ str[1]);
		for(String streach:str) {
//			System.out.println("str [0]--"+ streach);
			if(streach.equals(prop.getProperty(change_fname))) {
//				System.out.println("Successfully first name changes has been verified...!!");
				reportpass("Successfully first name changes has been verified...!!");
				break;
			}else {
				reportfailure("Failed to change the first name...!!");
//				System.out.println("Failed first name has not got changed...!!");
			}
		}
		
	}

	
/**************logging****************************/
	public void infoLog(String msg) {
//		This method will replace the system.out.println
		scenario.log(Status.INFO, msg);
		takeSceenShot();
		
	}
	
	
	public void reportpass(String passmsg) {
		scenario.log(Status.PASS, passmsg);
		takeSceenShot();
	}
	
	public void reportfailure(String errmsg) {
//		This method will print any error or catch the exception or e.printstack() or e.getmessage()....etc...
		scenario.log(Status.FAIL, errmsg);
		takeSceenShot();
		//assertThat(false);
	}



	public void takeSceenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(extentManager.screenshotfolderpath+screenshotFile));
			//put screenshot file in reports
			//new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
			scenario.addScreenCaptureFromPath(extentManager.screenshotfolderpath+screenshotFile);
			scenario.log(Status.INFO,"Screenshot captured at -> "+extentManager.screenshotfolderpath+screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	
		/**************Reporting******************/
		public void quit() {
			if(rep!=null)
				rep.flush();
			if(driver !=null)
				driver.quit();
		}
		public void initReports(String scenarioName) {
			rep = extentManager.getInstance(prop.getProperty("reportPath"));
			scenario = rep.createTest(scenarioName);
			scenario.log(Status.INFO, "Starting " +scenarioName);
			
		}
		
		public void IsAlertPresent() {
			try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			
		}}



		public void verifylogin() {
			
			String ActualText = driver.findElement(By.xpath(prop.getProperty("Sign_Out_Xpath"))).getText().trim();
			String ExpectedText = "Sign out";
			if (ActualText.equals(ExpectedText)) {
//				System.out.println("Login Successfull...!!");
				reportpass("Login Successfull...!!");
			}else {
//				System.out.println("Login Unsuccessfull - please retry...!!");
				infoLog("Login Unsuccessfull - please retry...!!");
				reportfailure("Login Unsuccessfull - please retry...!!");
			}
					
			
		}















	
	
}
