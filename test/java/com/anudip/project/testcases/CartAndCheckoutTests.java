package com.anudip.project.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class CartAndCheckoutTests extends BaseTest{

    @Test(priority = 30)
    public void test_shopping_bag() throws InterruptedException {
        WebElement shoppingbag = driver.findElement(By.xpath("//a[@class='nav-link']"));
        act.moveToElement(shoppingbag).click().perform();
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
//        Runnable smoothScrollUp = () -> {
//            long end = System.currentTimeMillis() + 5000;
//            while (System.currentTimeMillis() < end) {
//                act.scrollByAmount(0, -100).perform();
//                try {
//                    Thread.sleep(100);
//                } catch (Exception e) {}
//            }
//        };
//        smoothScrollUp.run();
        Thread.sleep(1500);
        WebElement productnames = driver.findElement(By.xpath("//h3"));
        log.info("The names of products adde dto the cart are " + productnames.getText());
        WebElement ordersry = driver.findElement(By.xpath("(//h2[normalize-space()='ORDER SUMMARY'])[1]"));
        log.info(ordersry.getText());
        WebElement subtotal = driver.findElement(By.xpath("//span[@id='cartSubtotal']"));
        log.info("The Subtotal Amount is " + subtotal.getText());
        WebElement total = driver.findElement(By.id("cartTotal"));
        log.info("Total Amount paid should be " + total.getText());
        driver.findElement(By.xpath("//button[@id='checkoutBtn']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 31)
    public void test_checkout_form() throws InterruptedException {
        WebElement name = driver.findElement(By.xpath("//input[@id='fullName']"));
        name.sendKeys("PRATIK SALVE");
        WebElement emailid = driver.findElement(By.xpath("//input[@id='email']"));
        emailid.sendKeys("pratiksalve001@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
        phone.sendKeys("8877441123");
        WebElement address = driver.findElement(By.xpath("//input[@id='address']"));
        address.sendKeys("MUMBAI");
        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("thane");
        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("Maharashtra");
        WebElement zipcode = driver.findElement(By.xpath("//input[@id='zipCode']"));
        zipcode.sendKeys("400001");
    }

    @Test(priority = 32)
    public void checkout_with_card() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='payment-content'][1]")).click();
        driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("3455 6666 2266 666");
        driver.findElement(By.xpath("//input[@id='expiry']")).sendKeys("1245");
        driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("145");
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
        driver.findElement(By.xpath("//button[normalize-space()='PLACE ORDER']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
    }

//    @Test(priority = 33)
    public void test_checkout_using_upi() throws InterruptedException {
        test_checkout_form();
        Thread.sleep(2000);
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
        driver.findElement(By.xpath("//div[@class='payment-content'][2]")).click();
        driver.findElement(By.xpath("//input[@id='upiId']")).sendKeys("pratik12icicbank");
        driver.findElement(By.xpath("//button[normalize-space()='PLACE ORDER']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
    }

//    @Test(priority = 34)
    public void test_checkout_using_cod() throws InterruptedException {
        test_checkout_form();
        Thread.sleep(2000);
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
        driver.findElement(By.xpath("//div[@class='payment-content'][3]")).click();
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
        driver.findElement(By.xpath("//button[normalize-space()='PLACE ORDER']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
    }

    @Test(priority = 35)
    public void test_orderconform_page() {
        WebElement orderno = driver.findElement(By.xpath("//span[@id='orderNumber']"));
        log.info("Your order number is " + orderno.getText());
        WebElement ordercnf = driver.findElement(By.xpath("//div[@class='thankyou-message']//p[1]"));
        log.info(ordercnf.getText());
        WebElement name = driver.findElement(By.xpath("//span[@id='customerName']"));
        log.info("The name of the receiver is " + name.getText());
        WebElement shippingaddress = driver.findElement(By.xpath("//span[@id='customerAddress']"));
        log.info("The shipment will be send to " + shippingaddress.getText());
        WebElement orderitems = driver.findElement(By.xpath("//div[@class='order-item']"));
        log.info("The items you ordered are " + orderitems.getText());
        driver.findElement(By.xpath("//a[normalize-space()='CONTINUE SHOPPING']")).click();
    }
}

