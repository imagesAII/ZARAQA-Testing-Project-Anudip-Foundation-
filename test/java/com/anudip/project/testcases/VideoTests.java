package com.anudip.project.testcases;


import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class VideoTests extends BaseTest{

    @Test(priority = 2)
    public void test_video() {
        log.info("================================");
        log.info("VIDEO TESTING STARTED ");
        log.info("=================================");

        WebElement video = driver.findElement(By.xpath("//video[@id='heroVideo']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Boolean isPaused = (Boolean) js.executeScript("return arguments[0].paused;", video);

        if (!isPaused) {
            log.info("Video is playing");
        } else {
            log.info("Video is paused or stopped");
        }

        WebElement title = driver.findElement(By.xpath("//h1[@class='hero-title']"));
        log.info("The on video title is : " + title.getText());
        WebElement subtitle = driver.findElement(By.xpath("//p[@class='hero-subtitle']"));
        log.info("The subtitle on the video is : " + subtitle.getText());
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
        log.info("VIDEO TESTING TESTED SUCESFULLY");
        log.info("=================================");
        System.err.println("=============================");
    }
}

