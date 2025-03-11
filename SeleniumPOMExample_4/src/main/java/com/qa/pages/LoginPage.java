package com.qa.pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")   //@FindBy used with an instance of PageFactory in a Selenium POM file to initialise element variables
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
//Something might be needed
        PageFactory.initElements(driver, this);
    }
    /* 
    PageFactory:
	A class in Selenium that provides support for the Page Object Model.
	It helps to initialize the elements of the page and facilitates the use of the @FindBy annotation. 
	*/

    public void setUsername(String strUsername) {
        username.sendKeys(strUsername);
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
























//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // Use Duration for timeout
//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
