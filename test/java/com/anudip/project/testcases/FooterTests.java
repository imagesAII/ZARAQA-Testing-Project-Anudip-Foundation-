package com.anudip.project.testcases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class FooterTests extends BaseTest{

    @Test(priority = 5)
    public void test_footer() throws InterruptedException {
        log.info("================================");
        log.info("FOOTER TEST STARTED");
        log.info("=================================");

        WebElement footer = driver.findElement(By.xpath("//footer[@class='footer']"));
        if (footer.isDisplayed() == true) {
            log.info("Footer is displayed...");
        } else {
            log.info("Footer is not displayed...");
        }

        List<WebElement> allLi = footer.findElements(By.tagName("li"));

        for (WebElement li : allLi) {
            log.info(li.getText());
        }

        String parent = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@title='Instagram']")).click();
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                Thread.sleep(5000);
                log.info("Instagram page visited");
                driver.close();
            }
        }
        driver.switchTo().window(parent);

        driver.findElement(By.xpath("//a[@title='Facebook']")).click();
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                Thread.sleep(5000);
                log.info("Facebook page visited");
                driver.close();
            }
        }
        driver.switchTo().window(parent);

        driver.findElement(By.xpath("//a[@title='YouTube']")).click();
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                Thread.sleep(5000);
                log.info("YouTube page visited");
                driver.close();
            }
        }
        driver.switchTo().window(parent);
        log.info("================================");
        log.info("FOOTER TESTED SUCESFULLY");
        log.info("=================================");
        System.err.println("=============================");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 5).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
    }

    @Test(priority = 6)
    public void last_footer() {
        log.info("================================");
        log.info("LAST FOOTER TEST STARTED");
        log.info("=================================");

        WebElement year = driver.findElement(By.xpath("(//p[normalize-space()='© DEC 2025 ZARA'])[1]"));
        log.info("Year od production of the website is : " + year.getText());
        WebElement region = driver.findElement(By.xpath("//p[@class='country']"));
        log.info("The country of the website is : " + region.getText());
        WebElement designer = driver.findElement(By.xpath("//p[normalize-space()='RECREATED BY PRATIK']"));
        log.info("The designer of the wesite is : " + designer.getText());
        log.info("================================");
        log.info("LAST FOOTER TESTED SUCESFULLY");
        log.info("=================================");
        System.err.println("=============================");
    }
}

