package com.anudip.project.testcases;


import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeTests extends BaseTest{

    @Test(priority = 1)
    public void check_home_page_title() throws InterruptedException {
        log.info("================================");
        log.info("TITLE BAR TEST STARTED");
        log.info("=================================");

        log.info("Checking home page");
        Thread.sleep(2000);
        log.info(driver.getTitle());
        WebElement logo_name = driver.findElement(By.xpath("//div[@class='logo']//h1"));
        log.info("The logo name is : " + logo_name.getText());
        log.info("Getting title bar names");
        WebElement search = driver.findElement(By.xpath("//a[normalize-space()='SEARCH']"));
        log.info("The 1st name is : " + search.getText());
        WebElement login = driver.findElement(By.xpath("//a[@id='loginLink']"));
        log.info("The 2nd name is : " + login.getText());
        WebElement help = driver.findElement(By.xpath("//a[normalize-space()='HELP']"));
        log.info("The 3rd element is : " + help.getText());
        WebElement cart = driver.findElement(By.xpath("//a[@href='cart.html']"));
        log.info("The 4th element is : " + cart.getText());
        log.info("================================");
        log.info("TITLE BAR TESTED SUCESFULLY");
        log.info("=================================");
        System.err.println("=============================");
    }
}

