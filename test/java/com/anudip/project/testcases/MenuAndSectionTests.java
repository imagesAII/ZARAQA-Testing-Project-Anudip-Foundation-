package com.anudip.project.testcases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class MenuAndSectionTests extends BaseTest{

    public void clickMenuItem(String label) {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuBtn")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='" + label + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
    }

    @Test(priority = 13)
    public void test_menu() throws InterruptedException {
        clickMenuItem("WOMAN");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
        clickMenuItem("MAN");
        Thread.sleep(2000);
        clickMenuItem("KIDS");
        Thread.sleep(2000);
        clickMenuItem("ESSENTIALS");
        Thread.sleep(2000);
        clickMenuItem("SHOES");
        Thread.sleep(2000);
        clickMenuItem("BAGS");
        Thread.sleep(2000);
        clickMenuItem("PERFUMES");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
        Thread.sleep(5000);
    }

    @Test(priority = 14)
    public void check_woman_section() {
        clickMenuItem("WOMAN");
        log.info("Testing womans section");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        List<WebElement> images = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
        int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
        log.info("Total Products Found: " + totalProducts);
        log.info("--------------------------------------------");
        for (int i = 0; i < totalProducts; i++) {
            String imageAlt = images.get(i).getAttribute("alt");
            String productName = names.get(i).getText();
            String price = prices.get(i).getText();
            log.info("Product #" + (i + 1));
            log.info("Image Name : " + imageAlt);
            log.info("Product Name : " + productName);
            log.info("Price : " + price);
            log.info("--------------------------------------------");
        }
    }

    @Test(priority = 15)
    public void check_man_section() {
        clickMenuItem("MAN");
        log.info("Testing mans section");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        List<WebElement> images = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
        int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
        log.info("Total Products Found: " + totalProducts);
        log.info("--------------------------------------------");
        for (int i = 0; i < totalProducts; i++) {
            String imageAlt = images.get(i).getAttribute("alt");
            String productName = names.get(i).getText();
            String price = prices.get(i).getText();
            log.info("Product #" + (i + 1));
            log.info("Image Name : " + imageAlt);
            log.info("Product Name : " + productName);
            log.info("Price : " + price);
            log.info("--------------------------------------------");
        }
    }

    @Test(priority = 16)
    public void check_kids_section() {
        clickMenuItem("KIDS");
        log.info("Testing kids section");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        List<WebElement> images = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
        int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
        log.info("Total Products Found: " + totalProducts);
        log.info("--------------------------------------------");
        for (int i = 0; i < totalProducts; i++) {
            String imageAlt = images.get(i).getAttribute("alt");
            String productName = names.get(i).getText();
            String price = prices.get(i).getText();
            log.info("Product #" + (i + 1));
            log.info("Image Name : " + imageAlt);
            log.info("Product Name : " + productName);
            log.info("Price : " + price);
            log.info("--------------------------------------------");
        }
    }

    @Test(priority = 17)
    public void check_essentials_section() {
        clickMenuItem("ESSENTIALS");
        log.info("Testing essentials section");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        List<WebElement> images = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
        int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
        log.info("Total Products Found: " + totalProducts);
        log.info("--------------------------------------------");
        for (int i = 0; i < totalProducts; i++) {
            String imageAlt = images.get(i).getAttribute("alt");
            String productName = names.get(i).getText();
            String price = prices.get(i).getText();
            log.info("Product #" + (i + 1));
            log.info("Image Name : " + imageAlt);
            log.info("Product Name : " + productName);
            log.info("Price : " + price);
            log.info("--------------------------------------------");
        }
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
    }

    @Test(priority = 18)
    public void check_shoes_section() {
        clickMenuItem("SHOES");
        log.info("Testing shoes section");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        List<WebElement> images = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
        int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
        log.info("Total Products Found: " + totalProducts);
        log.info("--------------------------------------------");
        for (int i = 0; i < totalProducts; i++) {
            String imageAlt = images.get(i).getAttribute("alt");
            String productName = names.get(i).getText();
            String price = prices.get(i).getText();
            log.info("Product #" + (i + 1));
            log.info("Image Name : " + imageAlt);
            log.info("Product Name : " + productName);
            log.info("Price : " + price);
            log.info("--------------------------------------------");
        }
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
    }

    @Test(priority = 19)
    public void check_bags_section() {
        clickMenuItem("BAGS");
        log.info("Testing bags section");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        List<WebElement> images = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
        int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
        log.info("Total Products Found: " + totalProducts);
        log.info("--------------------------------------------");
        for (int i = 0; i < totalProducts; i++) {
            String imageAlt = images.get(i).getAttribute("alt");
            String productName = names.get(i).getText();
            String price = prices.get(i).getText();
            log.info("Product #" + (i + 1));
            log.info("Image Name : " + imageAlt);
            log.info("Product Name : " + productName);
            log.info("Price : " + price);
            log.info("--------------------------------------------");
        }
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
    }

    @Test(priority = 20)
    public void check_perfumes_section() {
        clickMenuItem("PERFUMES");
        log.info("Testing perfumes section");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 90).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        List<WebElement> images = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
        int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
        log.info("Total Products Found: " + totalProducts);
        log.info("--------------------------------------------");
        for (int i = 0; i < totalProducts; i++) {
            String imageAlt = images.get(i).getAttribute("alt");
            String productName = names.get(i).getText();
            String price = prices.get(i).getText();
            log.info("Product #" + (i + 1));
            log.info("Image Name : " + imageAlt);
            log.info("Product Name : " + productName);
            log.info("Price : " + price);
            log.info("--------------------------------------------");
        }
    }
}

