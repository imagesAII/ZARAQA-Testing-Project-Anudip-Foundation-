package com.anudip.project.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class CategoryTests extends BaseTest{

    @Test(priority = 3)
    public void test_cards() {
        log.info("================================");
        log.info("SECTION TEST STARTED");
        log.info("=================================");

        WebElement woman_card = driver.findElement(By.xpath("//section[@id='categoryGrid']//a[1]"));
        log.info("Visiblity of the woman card :" + woman_card.isDisplayed());
        WebElement woman_text = driver.findElement(By.xpath("//h3[normalize-space()='WOMAN']"));
        log.info("The text is visisble and is : " + woman_text.getText());
        woman_card.click();
        driver.navigate().back();
        log.info("Woman section is visible...");
        WebElement man_card = driver.findElement(By.xpath("(//a[@class='category-card'])[2]"));
        log.info("Visibility of teh Man card : " + man_card.isDisplayed());
        WebElement man_text = driver.findElement(By.xpath("//h3[normalize-space()='MAN']"));
        log.info("The text is visisble and is : " + man_text.getText());
        man_card.click();
        driver.navigate().back();
        log.info("Woman section is visible...");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 50).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        log.info("================================");
        log.info("SECTION TESTED SUCESFULLY");
        log.info("=================================");
        System.err.println("=============================");
    }
}

