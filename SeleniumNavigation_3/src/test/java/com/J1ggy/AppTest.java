package com.J1ggy;
import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {
	WebDriver driver = null;

	@Before
	public void beforeEach() {
		if (driver == null)
			driver = new ChromeDriver();
		driver.get("https://www.qa.com/");
		driver.manage().window().setSize(new Dimension(1900, 1000));
	}

	@After
	public void afterAll() {
		driver.quit();
	}

	@Test
	public void testRequiredNumberOfJavaRelatedCourses() {

		getElementById("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll").click();
		
		//cssSelectors use '.' for class and '#' for id
		// Here the use of'>' states that we are looking for the child span of parent class .header__newSearch
		getElementByselector(".header__newSearch > span").click();  
		getElementByselector(".fc59__input").click();
		getElementByselector(".fc59__input").sendKeys("java");
		getElementByselector(".fc59__button > svg").click();
		String res = getElementByselector(".search__resultsSectionTitle i").getText();
		System.out.println("The number of available Java related courses is: " + res);
		assertEquals("226", res);  //****NOTE**** IF NECESSARY - Read the Failure Trace to see current number of courses!!!!
//****************NOTE*****************NOTE***************NOTE*****************NOTE************NOTE******************
	}

	WebElement getElementById(String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // A new wait of 10secs
		// Wait until the element becomes visible
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))); //Wait until found or 10secs whichever quicker
	}
	WebElement getElementByselector(String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait until the element becomes visible
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(id)));
	}
 
}
