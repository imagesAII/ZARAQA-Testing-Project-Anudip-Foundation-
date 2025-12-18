package com.anudip.project.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class ProjectInfoTests extends BaseTest{

    @Test(priority = 36)
    public void test_project_details() throws InterruptedException {
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 100).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement projectinfo = driver.findElement(By.xpath("//div[@class='footer-manufacturer']"));
        log.info(projectinfo.getText());
        Thread.sleep(5000);
    }
}
