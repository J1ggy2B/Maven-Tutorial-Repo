package com.J1ggy.com;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;

public class IntroToSelenium {
	    public static void main(String[] args) {
	    	System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64 _134.0.3124.51\\msedgedriver.exe");
	        WebDriver driver = new EdgeDriver();
	        driver.get("https://www.qa.com/");
	        //1 | Get the title - Check the browser tab to see what you'll get
	        String title = driver.getTitle();
	        System.out.println("We have accessed the website with  a Selenium WebDriver and the title is: " + title);
	        // 2 | setWindowSize | 1920x780 | 
	        driver.manage().window().setSize(new Dimension(1920, 1020));
	        // 3 | click | id=CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll |  - Accept All Cookies
	        driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();
	        System.out.println("We have accessed the website with a Selenium WebDriver and Accepted All Cookies.");
	        // 4 | check to see if a Cookie called Session_ID has been used.
	        boolean isSessionCookiePresent = driver.manage().getCookieNamed("culture") != null;
	        if(isSessionCookiePresent) {
	        System.out.println("A Cookie called culture is present: " + driver.manage().getCookieNamed("culture"));
	        }else {System.out.println("A Cookie called Session_Id is not present or has been blocked!");}
	        System.out.println(driver.manage().getCookies());
	        driver.quit();
	    }
	}


//Current WebDriver for MSEdge: "C:\DevTools\edgedriver_win64 _134.0.3124.51\msedgedriver.exe"