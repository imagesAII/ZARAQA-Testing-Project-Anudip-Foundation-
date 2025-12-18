package com.anudip.project.testcases;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class SearchTests extends BaseTest{

    @Test(priority = 28)
    public void test_searchbtn_menu() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='ZARA']")).click();
        log.info("sucesfully clicked the brand....");
        log.info("Getting the search box");
        WebElement searchbtn = driver.findElement(By.xpath("//a[normalize-space()='SEARCH']"));
        searchbtn.click();
        Thread.sleep(3000);
        WebElement toptabs = driver.findElement(By.xpath("//div[@class='top-tabs']"));
        log.info("The title on the aesrch bars are " + toptabs.getText());
        WebElement searchbox = driver.findElement(By.xpath("//div[@class='top-tabs']"));
        log.info("Is search box displayed " + searchbox.isDisplayed());
        WebElement womanbtn = driver.findElement(By.xpath("//div[normalize-space()='WOMAN']"));
        womanbtn.click();
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 15).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement horizontalScroll = driver.findElement(By.id("productsRow"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + 300;", horizontalScroll);
        Thread.sleep(1500);
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -15).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        WebElement manbtn = driver.findElement(By.xpath("//div[normalize-space()='MAN']"));
        manbtn.click();
        smoothScrollDown.run();
        WebElement manscroll = driver.findElement(By.id("productsRow"));
        smoothScrollDown.run();
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + 300;", manscroll);
        Thread.sleep(1500);
        smoothScrollUp.run();
        WebElement kidsbtn = driver.findElement(By.xpath("//div[normalize-space()='KIDS']"));
        kidsbtn.click();
        smoothScrollDown.run();
        WebElement kidsscroll = driver.findElement(By.id("productsRow"));
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + 300;", kidsscroll);
        Thread.sleep(3000);
        smoothScrollUp.run();
        WebElement inputsearch = driver.findElement(By.xpath("//input[@id='searchInput']"));
        inputsearch.sendKeys("A");
        WebElement suggestions = driver.findElement(By.id("suggestionsList"));
        List<WebElement> suggestionItems = suggestions.findElements(By.xpath(".//div"));
        for (WebElement item : suggestionItems) {
            log.info(item.getText());
        }
        smoothScrollDown.run();
        WebElement s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='HOODED SWEATSHIRT']")));
        act.moveToElement(s1).perform();
        Thread.sleep(1500);
        act.moveToElement(s1).click().perform();
        WebElement text1 = driver.findElement(By.xpath("(//div[@id='questionText'])[1]"));
        String name1 = text1.getText();
        log.info("text1" + " is " + name1);
        WebElement img1 = driver.findElement(By.xpath("//div[@id='searchResultsRow']//img[@alt='Hooded Sweatshirt']"));
        log.info("Is image displayed " + img1.isDisplayed());
        log.info("Image is Visible");
        Thread.sleep(4000);
//        smoothScrollDown.run();
        WebElement img1txt = driver.findElement(By.xpath("//div[@id='searchResultsRow']//h3[contains(text(),'Hooded Sweatshirt')]"));
        log.info("text2 is " + img1txt.getText());
        String name2 = img1txt.getText();
        if (name1.equalsIgnoreCase(name2)) {
            log.info("Search is successfully parsed");
        } else {
            log.info("Search is not matched....");
        }
        smoothScrollUp.run();
        manbtn.click();
        Thread.sleep(2000);
        act.moveToElement(inputsearch).perform();
        inputsearch.sendKeys("CROSSBODY BAG");
        Thread.sleep(1500);
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        Thread.sleep(3000);
        smoothScrollDown.run();
        WebElement price = driver.findElement(By.xpath("(//p[@class='price'][normalize-space()='$79.90'])[2]"));
        act.moveToElement(price).perform();
        log.info("Price of the item is " + price.getText());
        String actualPrice = price.getText().trim();
        if (actualPrice.equals("79.90")) {
            log.info("Price is as expected");
        } else {
            log.info("Price is more than expected");
        }
        smoothScrollUp.run();
        womanbtn.click();
        WebElement inputline = driver.findElement(By.xpath("//div[@id='questionText']"));
        inputline.click();
        act.moveToElement(inputsearch)
                .sendKeys("w").pause(Duration.ofMillis(200))
                .sendKeys("o").pause(Duration.ofMillis(200))
                .sendKeys("n").pause(Duration.ofMillis(200))
                .sendKeys("d").pause(Duration.ofMillis(200))
                .sendKeys("e").pause(Duration.ofMillis(200))
                .sendKeys("r").pause(Duration.ofMillis(200))
                .sendKeys("").pause(Duration.ofMillis(200))
                .keyDown(Keys.SHIFT).sendKeys("r").pause(Duration.ofMillis(200))
                .sendKeys("o").pause(Duration.ofMillis(200))
                .sendKeys("s").pause(Duration.ofMillis(200))
                .sendKeys("e").pause(Duration.ofMillis(200))
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofMillis(200))
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(3000);
        smoothScrollDown.run();
        smoothScrollUp.run();
        womanbtn.click();
        inputline.click();
        inputsearch.sendKeys("JEANS");
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        Thread.sleep(2000);
        WebElement empty = driver.findElement(By.xpath("//div[@class='suggestions-wrapper']"));
        Boolean blank = empty.isDisplayed();
        WebElement upcomming = driver.findElement(By.xpath("//div[@class='single-result-msg']"));
        if (blank.equals(false)) {
            log.info("cart is empty");
        } else {
            log.info(upcomming.getText());
        }
        manbtn.click();
        inputline.click();
        inputsearch.sendKeys("gloves");
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        Thread.sleep(2000);
        act.moveToElement(inputline).keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
        act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
        act.moveToElement(inputsearch)
                .sendKeys("r").pause(Duration.ofMillis(200))
                .sendKeys("u").pause(Duration.ofMillis(200))
                .sendKeys("n").pause(Duration.ofMillis(200))
                .sendKeys("n").pause(Duration.ofMillis(200))
                .sendKeys("i").pause(Duration.ofMillis(200))
                .sendKeys("n").pause(Duration.ofMillis(200))
                .sendKeys("g").pause(Duration.ofMillis(200))
                .sendKeys(" ").pause(Duration.ofMillis(200))
                .sendKeys("s").pause(Duration.ofMillis(200))
                .sendKeys("h").pause(Duration.ofMillis(200))
                .sendKeys("o").pause(Duration.ofMillis(200))
                .sendKeys("e").pause(Duration.ofMillis(200))
                .sendKeys("s").pause(Duration.ofMillis(200))
                .perform();
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        Thread.sleep(2000);
        log.info("SEARCH SECTION TESTED SUCESFULLY");
        driver.findElement(By.xpath("//a[normalize-space()='ZARA']")).click();
        Thread.sleep(2000);
    }
}
