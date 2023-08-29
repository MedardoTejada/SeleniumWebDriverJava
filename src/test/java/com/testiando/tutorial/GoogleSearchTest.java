package com.testiando.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.PhantomReference;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }

    @Test
    public void searchGooglePage(){
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("Medardo Tejada - QA Automation");
        searchbox.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        assertEquals("Medardo Tejada - QA Automation - Buscar con Google",driver.getTitle());
    }

    @After
    public void testDown(){
        driver.quit();
    }
}
