
package com.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestwebPage {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
    	System.setProperty("webdriver.edge.driver", "C:\\DevTools\\selenium-java-4.25.0\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("http://localhost:10400/Selenium_2/Index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Updated
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testAddUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        usernameField.click();
        usernameField.sendKeys("Graeme");

        driver.findElement(By.id("store")).click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
        assertEquals("Graeme", storedValue);
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testRecallUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        usernameField.click();
        usernameField.sendKeys("Graeme");

        WebElement storeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("store")));
        storeButton.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
        assertEquals("Graeme", storedValue);

        driver.findElement(By.id("recall")).click();
        wait.until(ExpectedConditions.textToBePresentInElementValue(usernameField, "Graeme"));
        String usernameValue = usernameField.getAttribute("value");
        assertEquals("Graeme", usernameValue);
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testRemoveUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        usernameField.click();
        usernameField.sendKeys("Graeme");

        driver.findElement(By.id("store")).click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
        assertEquals("Graeme", storedValue);

        driver.findElement(By.id("remove")).click();
        wait.until(ExpectedConditions.textToBePresentInElementValue(usernameField, ""));
        String usernameValue = usernameField.getAttribute("value");
        assertEquals("", usernameValue);
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testReset() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        WebElement legend = driver.findElement(By.id("leg"));

        usernameField.click();
        usernameField.sendKeys("Graeme");

        driver.findElement(By.id("store")).click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
        assertEquals("Graeme", storedValue);

        driver.findElement(By.id("reset")).click();
        wait.until(ExpectedConditions.textToBePresentInElementValue(usernameField, ""));
        String usernameValue = usernameField.getAttribute("value");
        String legendText = legend.getText();
        assertEquals("", usernameValue);
        assertEquals("Enter Name:", legendText);
    }
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testFindPara() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String expected = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\nLorem Ipsum has been the industry's standard dummy text ever since the 1500s";
        WebElement para = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("para")));
        String actual = para.getText();
        assertEquals(expected, actual);

    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}