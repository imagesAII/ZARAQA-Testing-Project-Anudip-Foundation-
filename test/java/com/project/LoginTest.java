package com.project;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {

    private static final Logger log = LogManager.getLogger(LoginTest.class);

    @Test
    public void loginTest() {
        log.info("Browser launched");
        log.info("Navigated to login page");
        log.info("Entered username");
        log.info("Entered password");
        log.info("Clicked login button");
    }
}

