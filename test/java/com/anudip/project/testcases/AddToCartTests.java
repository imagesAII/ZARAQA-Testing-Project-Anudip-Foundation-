package com.anudip.project.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class AddToCartTests extends BaseTest{

	By menuBtn = By.id("menuBtn");

	public void clickMenuItem(String label) {
		// Always re-locate the menu button
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);

		WebElement item = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='" + label + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	}
    @Test(priority = 21)
    public void test_womanman_addtocart() throws InterruptedException {
        clickMenuItem("WOMAN");
        Thread.sleep(2000);
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 18).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement img_2 = driver.findElement(By.xpath("//img[@alt='Satin Midi Skirt']"));
        act.moveToElement(img_2).perform();
        WebElement first_item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]//div[1]//button[1]")));
        act.moveToElement(first_item).click().perform();
        for (int i = 1; i <= 2; i++) {
            WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
            act.moveToElement(ok).click().perform();
            Thread.sleep(1500);
            act.moveToElement(img_2).perform();
            act.moveToElement(first_item).click().perform();
        }
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        act.moveToElement(ok).click().perform();
        Thread.sleep(3000);
        WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Oversized Blazer']"));
        act.moveToElement(img_1).perform();
        act.moveToElement(img_2).perform();
        WebElement img_3 = driver.findElement(By.xpath("//img[@alt='Wool Blend Coat']"));
        act.moveToElement(img_3).perform();
        WebElement img_4 = driver.findElement(By.xpath("//img[@alt='Pleated Trousers']"));
        act.moveToElement(img_4).perform();
        act.moveToElement(img_3).perform();
        act.moveToElement(img_2).perform();
        act.moveToElement(img_1).perform();
        Runnable smoothScrollDown2 = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 27).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown2.run();
        WebElement img_5 = driver.findElement(By.xpath("//img[@alt='Cashmere Sweater']"));
        act.moveToElement(img_5).perform();
        WebElement img_6 = driver.findElement(By.xpath("//img[@alt='Silk Blouse']"));
        act.moveToElement(img_6).perform();
        WebElement scnd_item = driver.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])[7]"));
        act.moveToElement(scnd_item).click().perform();
        Thread.sleep(4000);
        WebElement msg = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
        log.info("The name os the second item added to the cart is : " + msg.getText());
        WebElement ok2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        act.moveToElement(ok2).click().perform();
        Runnable smoothScrollDown3 = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 35).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown3.run();
        Thread.sleep(5000);
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -85).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        driver.findElement(By.xpath("//a[@href='cart.html']")).click();
        log.info("Shopping bag button is clicked sucessfully....");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
        log.info("Continue shopping is clicked....");
        Thread.sleep(3000);
    }

    @Test(priority = 22)
    public void test_man_addtocart() throws InterruptedException {
        clickMenuItem("MAN");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 18).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Tailored Suit Jacket']"));
        act.moveToElement(img_1).perform();
        driver.findElement(By.xpath("//section[@class='products-section']//div[1]//div[1]//button[1]")).click();
        WebElement add_msg = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
        log.info("What is added to the cart : " + add_msg.getText());
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Runnable smoothScrollDown2 = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 35).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown2.run();
        WebElement img_2 = driver.findElement(By.xpath("//img[@alt='Denim Jacket']"));
        act.moveToElement(img_2).perform();
        WebElement img_3 = driver.findElement(By.xpath("//img[@alt='Leather Loafers']"));
        act.moveToElement(img_3).perform();
        WebElement img_4 = driver.findElement(By.xpath("//img[@alt='Bomber Jacket']"));
        act.moveToElement(img_4).perform();
        log.info("Hovered sucesfull...");
        driver.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])[7]")).click();
        WebElement added_box = driver.findElement(By.xpath("//div[@class='custom-alert']"));
        if (added_box.isDisplayed() == true) {
            log.info("Added Sucessfully displayed..");
        } else {
            log.info("Not displayed...");
        }
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        smoothScrollDown2.run();
        WebElement img_5 = driver.findElement(By.xpath("//img[@alt='Wool Overcoat']"));
        log.info("Are the images displayed...." + img_5.isDisplayed());
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -85).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        driver.findElement(By.xpath("//a[@href='cart.html']")).click();
        log.info("Shopping bag clicked sucessfully...");
        Thread.sleep(5000);
        smoothScrollDown.run();
        smoothScrollDown2.run();
        smoothScrollUp.run();
        driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
        log.info("Continue clicked...");
        Thread.sleep(2000);
    }

    @Test(priority = 23)
    public void kids_addtocart() throws InterruptedException {
        clickMenuItem("KIDS");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 52).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        Thread.sleep(3000);
        WebElement img_5 = driver.findElement(By.xpath("//img[@alt='Hooded Sweatshirt']"));
        act.moveToElement(img_5).perform();
        WebElement add_1 = driver.findElement(By.xpath("(//button[@class='add-to-cart-btn'][normalize-space()='ADD TO CART'])[5]"));
        act.moveToElement(add_1).click().perform();
        WebElement add_msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='custom-alert-message']")));
        log.info("What has been added to the cart section : " + add_msg.getText());
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Thread.sleep(3000);
        smoothScrollDown.run();
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -95).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        driver.findElement(By.xpath("//a[@href='cart.html']")).click();
        WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='SHOPPING BAG']"));
        log.info("The title of the page after click is : " + title.getText());
        log.info(driver.getTitle());
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
        log.info("Continue clicked...");
        Thread.sleep(2000);
    }

    @Test(priority = 24)
    public void essentials_addtocart() throws InterruptedException {
        clickMenuItem("ESSENTIALS");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 25).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement img_1 = driver.findElement(By.xpath("//img[@alt='LEATHER BELT WITH DOUBLE BUCKLE']"));
        act.moveToElement(img_1).perform();
        driver.findElement(By.xpath("//div[2]//div[1]//button[1]")).click();
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        ok.click();
        log.info("First element is added sucessfully");
        smoothScrollDown.run();
        Thread.sleep(3000);
        smoothScrollDown.run();
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -85).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        driver.findElement(By.xpath("//a[@href='cart.html']")).click();
        smoothScrollDown.run();
        smoothScrollUp.run();
        driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
        log.info("Continue shopping is clicked....");
        Thread.sleep(3000);
    }

    @Test(priority = 25)
    public void shoes_addtocart() throws InterruptedException {
        clickMenuItem("SHOES");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 25).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        Thread.sleep(2000);
        smoothScrollDown.run();
        Thread.sleep(2000);
        Runnable smoothScrollDown2 = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 35).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown2.run();
        WebElement img_1 = driver.findElement(By.xpath("//img[@alt='High Heels']"));
        act.moveToElement(img_1).perform();
        driver.findElement(By.xpath("//div[9]//div[1]//button[1]")).click();
        log.info("Sandals added to the cart sucessfully");
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
        driver.findElement(By.xpath("//a[@href='cart.html']")).click();
        smoothScrollDown2.run();
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -95).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
    
        smoothScrollUp.run();
        driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
        log.info("Continue clicked...");
        Thread.sleep(2000);
    }


    @Test(priority = 26)
    public void bags_addtocart() throws InterruptedException {
        clickMenuItem("BAGS");
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 22).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Crossbody Bag']"));
        act.moveToElement(img_1).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//body[1]//section[1]//div[3]//div[2]//div[1]//button[1]")).click();
        WebElement msg = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
        log.info("Which bag is added " + msg.getText());
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        driver.findElement(By.xpath("//a[@href='cart.html']")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        log.info("Sucessfully used the driver back function....");
        Thread.sleep(4000);
    }

    @Test(priority = 27)
    public void perfumes_addtocart() throws InterruptedException {
        clickMenuItem("PERFUMES");
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
        Runnable smoothScrollDown2 = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 53).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown2.run();
        WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Ebony Wood']"));
        act.moveToElement(img_1).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[7]//div[1]//button[1]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Thread.sleep(2000);
        log.info("The Third element from the second row is added sucessfully");
        driver.findElement(By.xpath("//a[@href='cart.html']")).click();
        log.info(driver.getCurrentUrl());
        Thread.sleep(3500);
//        Runnable smoothScrollDown3 = () -> {
//            long end = System.currentTimeMillis() + 5000;
//            while (System.currentTimeMillis() < end) {
//                act.scrollByAmount(0, 100).perform();
//                try {
//                    Thread.sleep(100);
//                } catch (Exception e) {}
//            }
//        };
//        smoothScrollDown3.run();
    }
}
// man more scroll down add to cart 
/// essential scroll more down 

