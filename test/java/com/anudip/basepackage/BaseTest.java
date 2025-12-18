package com.anudip.basepackage;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    protected static WebDriver driver;
    protected static Actions act;
    protected static WebDriverWait wait;

    protected static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        log.info("Before Suite");

        if (driver == null) {
            driver = new ChromeDriver();
            act = new Actions(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("http://127.0.0.1:5500/index.html");
            driver.manage().window().maximize();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            log.info("Browser closed");
        }
    }
}

