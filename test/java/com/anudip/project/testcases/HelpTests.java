package com.anudip.project.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class HelpTests extends BaseTest{

    @Test(priority = 29)
    public void test_help_section() throws InterruptedException {
        WebElement helpbtn = driver.findElement(By.xpath("//a[normalize-space()='HELP']"));
        helpbtn.click();
        Thread.sleep(3000);
        log.info(driver.getTitle());
        WebElement helpinput = driver.findElement(By.xpath("//input[@id='helpInput']"));
        act.moveToElement(helpinput).click().perform();
        helpinput.sendKeys("how do i track my shipment");
        Thread.sleep(1000);
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        System.err.println("How do i track my shipment");
        WebElement answertxt = driver.findElement(By.xpath("//div[@id='answerText']"));
        log.info(answertxt.getText());
        Thread.sleep(1500);
        WebElement clearbtn = driver.findElement(By.xpath("//button[@id='clearBtn']"));
        clearbtn.click();
        Thread.sleep(2000);
        helpinput.sendKeys("Where");
        log.info("The sugessions is");
        Thread.sleep(1000);
        WebElement suggestions = driver.findElement(By.id("suggestions"));
        act.moveToElement(suggestions).perform();
        System.err.println(suggestions.getText());
        suggestions.click();
        Thread.sleep(2000);
        log.info(answertxt.getText());
        clearbtn.click();
        helpinput.sendKeys("W");
        Thread.sleep(1000);
        log.info("On typing W i get the suggestion as");
        act.moveToElement(suggestions).perform();
        Thread.sleep(2000);
        System.err.println(suggestions.getText());
        WebElement paymentsq = driver.findElement(By.xpath("//div[@class='suggestion-item'][normalize-space()='What payment methods are accepted?']"));
        log.info(paymentsq.getText());
        act.moveToElement(paymentsq).perform();
        act.moveToElement(paymentsq).click().perform();
        Thread.sleep(2000);
        WebElement question = driver.findElement(By.xpath("//div[@id='answerQuestion']"));
        System.err.println(question.getText());
        log.info(answertxt.getText());
        Thread.sleep(2000);
    }
}

