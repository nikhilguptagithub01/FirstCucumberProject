$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/resources/com/webautomation/feature/Login.feature");
formatter.feature({
  "name": "Login into web portal",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "name": "Login into Online Shopping portal",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browsername",
  "keyword": "Given "
});
formatter.match({
  "location": "genericsteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I launch URL of Online Shopping portal",
  "keyword": "When "
});
formatter.match({
  "location": "genericsteps.launchsite(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Link",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside sign-in page",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.SignInPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my registered email id",
  "rows": [
    {
      "cells": [
        "login_email_id",
        "login_email_id_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredEmailId(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my password",
  "rows": [
    {
      "cells": [
        "current_password",
        "login_password_field_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredPassword(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Submit_Btn",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside the application",
  "keyword": "Then "
});
formatter.match({
  "location": "genericsteps.loginsuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/resources/com/webautomation/feature/OrderTShirt.feature");
formatter.feature({
  "name": "Order T-Shirt and verify in your order history",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@OrderTShirt"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browsername",
  "keyword": "Given "
});
formatter.match({
  "location": "genericsteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I launch URL of Online Shopping portal",
  "keyword": "When "
});
formatter.match({
  "location": "genericsteps.launchsite(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Link",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside sign-in page",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.SignInPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my registered email id",
  "rows": [
    {
      "cells": [
        "login_email_id",
        "login_email_id_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredEmailId(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my password",
  "rows": [
    {
      "cells": [
        "current_password",
        "login_password_field_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredPassword(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Submit_Btn",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside the application",
  "keyword": "Then "
});
formatter.match({
  "location": "genericsteps.loginsuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Order T-Shirt from Online Shopping Portal",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@OrderTShirt"
    },
    {
      "name": "@OrderTShirtWithOneQuantity"
    }
  ]
});
formatter.step({
  "name": "I am on online shopping My Account - My Store page",
  "keyword": "Given "
});
formatter.match({
  "location": "applicationsteps.verifyhomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I want to buy T-Shirt then I click on TShirt_Link_Xpath",
  "keyword": "When "
});
formatter.match({
  "location": "applicationsteps.clickTShirtLink(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken into T-Shirt shopping page",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.clickTShirtMenu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I choose a T-Shirt of my choice and add to cart",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.ChooseTShirtAndAddToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select proceed to checkout instead continuing shopping option",
  "keyword": "But "
});
formatter.match({
  "location": "applicationsteps.ProceedToCheckoutonpopup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken into shopping cart summary page",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.ShippingCartSummarPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on shopping_cart_summary_page_proceed_To_CheckOut_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken to choose a delivery address page where I select my office_delivery_address and then proceed to checkout option",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.SelectDeliveryAddress(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I landed to a shipping page where I acknowledge the terms and condition and click to proceed to checkout",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.AckTermsAndConditions()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken into payment option page where I proceed to pay by chossing one of payment_option",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.PaymentOptionPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I confirm my order and capture the order reference details",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.ConfirmMyOrderAndCaptureOrderDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click back to order from order confimation page to verify the placed order",
  "keyword": "Then "
});
formatter.match({
  "location": "applicationsteps.clickToVerifyOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browsername",
  "keyword": "Given "
});
formatter.match({
  "location": "genericsteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I launch URL of Online Shopping portal",
  "keyword": "When "
});
formatter.match({
  "location": "genericsteps.launchsite(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Link",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside sign-in page",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.SignInPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my registered email id",
  "rows": [
    {
      "cells": [
        "login_email_id",
        "login_email_id_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredEmailId(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my password",
  "rows": [
    {
      "cells": [
        "current_password",
        "login_password_field_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredPassword(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Submit_Btn",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside the application",
  "keyword": "Then "
});
formatter.match({
  "location": "genericsteps.loginsuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Order T-Shirt from Online Shopping Portal",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@OrderTShirt"
    },
    {
      "name": "@IncreaseOrDecreaseYourQuantityDuringPurchasingTShirt"
    }
  ]
});
formatter.step({
  "name": "I am on online shopping My Account - My Store page",
  "keyword": "Given "
});
formatter.match({
  "location": "applicationsteps.verifyhomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I want to buy T-Shirt then I click on TShirt_Link_Xpath",
  "keyword": "When "
});
formatter.match({
  "location": "applicationsteps.clickTShirtLink(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken into T-Shirt shopping page",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.clickTShirtMenu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I choose a T-Shirt of my choice and add to cart",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.ChooseTShirtAndAddToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select proceed to checkout instead continuing shopping option",
  "keyword": "But "
});
formatter.match({
  "location": "applicationsteps.ProceedToCheckoutonpopup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken into shopping cart summary page where I revisit my quantity",
  "rows": [
    {
      "cells": [
        "Qty_Plus_Minus_Var",
        "Qty_Plus_By_Xpath",
        "Qty_Minus_By_Xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.RevisitQtyOnShippingCartSummarPage(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on shopping_cart_summary_page_proceed_To_CheckOut_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken to choose a delivery address page where I select my office_delivery_address and then proceed to checkout option",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.SelectDeliveryAddress(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I landed to a shipping page where I acknowledge the terms and condition and click to proceed to checkout",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.AckTermsAndConditions()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken into payment option page where I proceed to pay by chossing one of payment_option",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.PaymentOptionPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I confirm my order and capture the order reference details",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.ConfirmMyOrderAndCaptureOrderDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click back to order from order confimation page to verify the placed order",
  "keyword": "Then "
});
formatter.match({
  "location": "applicationsteps.clickToVerifyOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/resources/com/webautomation/feature/RegisterUsers.feature");
formatter.feature({
  "name": "Register User on automation practice online shopping portal",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@RegisterUser"
    }
  ]
});
formatter.scenario({
  "name": "User create an account",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegisterUser"
    },
    {
      "name": "@GoToSignUpPage:"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browsername",
  "keyword": "Given "
});
formatter.match({
  "location": "genericsteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I launch URL of Online Shopping portal",
  "keyword": "When "
});
formatter.match({
  "location": "genericsteps.launchsite(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Link",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside sign-in page",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.SignInPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter email id for registration",
  "rows": [
    {
      "cells": [
        "register_email_id",
        "register_email_id_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterEmailToRegister(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on create_an_account_button_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on create an account page",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.iamoncreateanaccountpage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select my salutation",
  "rows": [
    {
      "cells": [
        "salutation_var",
        "Mr_Salutation_xpath",
        "Mrs_Salutation_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.select_salutation(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter first name",
  "rows": [
    {
      "cells": [
        "fname_var",
        "fname_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterFirstName(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter last name",
  "rows": [
    {
      "cells": [
        "lname_var",
        "lname_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterLastName(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set your password",
  "rows": [
    {
      "cells": [
        "registering_password",
        "password_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.password(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select day",
  "rows": [
    {
      "cells": [
        "day_var",
        "drpdwn_day_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.day(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select month",
  "rows": [
    {
      "cells": [
        "month_var",
        "drpdwn_month_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.month(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select year",
  "rows": [
    {
      "cells": [
        "year_var",
        "drpdwn_year_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.year(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter company",
  "rows": [
    {
      "cells": [
        "company_var",
        "company_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterCompany(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter address",
  "rows": [
    {
      "cells": [
        "address_var",
        "address_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterAddress(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter city",
  "rows": [
    {
      "cells": [
        "city_var",
        "city_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterCity(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select state",
  "rows": [
    {
      "cells": [
        "state_var",
        "drpdwn_state_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.state(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter zipcode",
  "rows": [
    {
      "cells": [
        "zipcode_var",
        "zipcode_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterZipcode(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select country",
  "rows": [
    {
      "cells": [
        "country_var",
        "drpdwn_country_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.country(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter mobile number",
  "rows": [
    {
      "cells": [
        "mob_num_var",
        "mob_num_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterMobNum(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter address alias",
  "rows": [
    {
      "cells": [
        "address_alias_var",
        "address_alias_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterAddressAlias(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on register_button_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken to My Account page",
  "keyword": "Then "
});
formatter.match({
  "location": "genericsteps.registered()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/resources/com/webautomation/feature/UpdatePersonalInfo.feature");
formatter.feature({
  "name": "Update Personal Information",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@UpdatePersonalInformation"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browsername",
  "keyword": "Given "
});
formatter.match({
  "location": "genericsteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I launch URL of Online Shopping portal",
  "keyword": "When "
});
formatter.match({
  "location": "genericsteps.launchsite(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Link",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside sign-in page",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.SignInPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my registered email id",
  "rows": [
    {
      "cells": [
        "login_email_id",
        "login_email_id_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredEmailId(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my password",
  "rows": [
    {
      "cells": [
        "current_password",
        "login_password_field_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.EnterRegisteredPassword(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign_In_Submit_Btn",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am taken inside the application",
  "keyword": "Then "
});
formatter.match({
  "location": "genericsteps.loginsuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update Personal Information (first name) in My Account",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@UpdatePersonalInformation"
    },
    {
      "name": "@UpdateFirstName"
    }
  ]
});
formatter.step({
  "name": "I am on online shopping My Account - My Store page",
  "keyword": "Given "
});
formatter.match({
  "location": "applicationsteps.verifyhomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click My Personal Information link",
  "keyword": "When "
});
formatter.match({
  "location": "applicationsteps.gotopersonalinformationpage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my changed first name",
  "rows": [
    {
      "cells": [
        "change_fname",
        "PI_fname_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.changefname(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter my current password",
  "rows": [
    {
      "cells": [
        "current_password",
        "current_password_xpath"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.entercurrentpassword(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on save_btn",
  "keyword": "And "
});
formatter.match({
  "location": "genericsteps.ClickOptionOrButton(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The successful_personal_info_saved_message is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "applicationsteps.verifysuccessfulsavemessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "on top right corner, my change_fname can be verified",
  "keyword": "And "
});
formatter.match({
  "location": "applicationsteps.verifychangedfname(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});