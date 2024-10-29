
package com.qa.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.qa.pages.LoginPage;


public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
@Before public void setUp() {
    	System.setProperty("webdriver.edge.driver", "C:\\DevTools\\selenium-java-4.25.0\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://txmike2.glitch.me/login");
        loginPage = new LoginPage(driver);
    }

@Test 
public void testLogin() {
    // Set the username and password
    loginPage.setUsername("Frank");
    loginPage.setPassword("test$password");

    // Execute the JavaScript validation function and get the result
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    Boolean validationResult = (Boolean) jsExecutor.executeScript("return validate();");

    // Assert that the validation result is true
    assertTrue("Validation should pass", validationResult != null && validationResult); //assertTrue takes a String message and a Boolean condition

    // If validation passes, proceed to click the login button
    loginPage.clickLogin();


}

@After 
public void tearDown() {
        driver .quit();
    }
}
