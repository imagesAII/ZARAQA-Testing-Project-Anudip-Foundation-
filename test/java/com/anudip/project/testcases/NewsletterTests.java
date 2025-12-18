package com.anudip.project.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class NewsletterTests extends BaseTest{

    @Test(priority = 4)
    public void test_newsletter() throws InterruptedException {
        log.info("================================");
        log.info("NEWSLETER TEST STARTED");
        log.info("=================================");

        WebElement newsletter = driver.findElement(By.xpath("//section[@id='newsletter']"));
        if (newsletter.isDisplayed() == true) {
            log.info("The newletter section is visbile : " + newsletter.isDisplayed());
        } else {
            log.info("Newsletter is not displayed");
        }
        WebElement input = driver.findElement(By.xpath("//input[@id='newsletterEmail']"));
        input.sendKeys("ps");
        driver.findElement(By.xpath("//button[normalize-space()='SUBSCRIBE']")).click();
        Thread.sleep(2000);
        input.clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='newsletterEmail']")).sendKeys("pratik1234@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='SUBSCRIBE']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 30).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        log.info("================================");
        log.info("NEWSLETTER TESTED SUCESFULLY");
        log.info("=================================");
        System.err.println("=============================");
    }
}
