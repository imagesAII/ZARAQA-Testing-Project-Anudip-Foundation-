package com.anudip.project.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.anudip.basepackage.BaseTest;

public class AuthTests extends BaseTest{

    @Test(priority = 7)
    public void login_clicked() {
        driver.findElement(By.xpath("//a[@id='loginLink']")).click();
        log.info(driver.getTitle());
        WebElement login_title = driver.findElement(By.xpath("//h2[normalize-space()='LOG IN']"));
        if (login_title.isDisplayed() == true) {
            log.info("The login title is : " + login_title.getText());
        } else {
            log.info("Login page is not displayed...");
        }
        driver.findElement(By.xpath("//div[@class='auth-left']"));
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 28).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();

        WebElement google_btn = driver.findElement(By.xpath("//button[@class='social-btn google-btn']"));
        log.info("Is google button displayed : " + google_btn.isDisplayed());
        WebElement apple_btn = driver.findElement(By.xpath("//button[@class='social-btn apple-btn']"));
        log.info("Is apple button displayed : " + apple_btn.isDisplayed());
        WebElement create_account = driver.findElement(By.xpath("//a[@href='register.html']"));
        log.info("Create account text is : " + create_account.getText());
    }

    @Test(priority = 8)
    public void check_create_account_wrong_and_right() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='register.html']")).click();
        log.info(driver.getTitle());
        WebElement create_txt = driver.findElement(By.xpath("//h1[normalize-space()='CREATE AN ACCOUNT']"));
        log.info("Text displayed : " + create_txt.getText());
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 35).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement create_button = driver.findElement(By.xpath("//button[normalize-space()='CREATE ACCOUNT']"));
        create_button.click();
        WebElement error_text = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
        log.info("The error text is : " + error_text.getText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Runnable smoothScrollUp = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, -40).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollUp.run();
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='EMAIL']"));
        email.sendKeys("PRATIK");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='PASSWORD']"));
        password.sendKeys("1234556");
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='NAME']"));
        name.sendKeys("PRATIK");
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='TELEPHONE']"));
        phone.sendKeys("5533221155");

        WebElement checkbox_1 = driver.findElement(By.xpath("//input[@id='newsletter']"));
        checkbox_1.click();
        WebElement checkbox_2 = driver.findElement(By.xpath("//input[@id='privacy']"));
        checkbox_2.click();
        create_button.click();
        Thread.sleep(3000);
        smoothScrollUp.run();
        email.clear();
        email.sendKeys("pratik001@gmail.com");
        smoothScrollDown.run();
        create_button.click();
        Thread.sleep(2000);
        WebElement pass_err = driver.findElement(By.xpath("//span[contains(text(),'Password must be 6+ chars and include uppercase, l')]"));
        log.info("Error for password is : " + pass_err.getText());
        smoothScrollUp.run();
        password.clear();
        password.sendKeys("pratik1234");
        smoothScrollDown.run();
        create_button.click();
        WebElement num_err = driver.findElement(By.xpath("//span[normalize-space()='Enter 10 digit mobile starting with 9, 8, 7 or 6']"));
        log.info("Phone Number Test : " + num_err.getText());
        smoothScrollUp.run();
        password.clear();
        password.sendKeys("Pratik@1234");
        phone.clear();
        phone.sendKeys("9876543210");
        smoothScrollDown.run();
        create_button.click();
        Thread.sleep(4000);

        WebElement created_txt = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
        log.info("Created account as : " + created_txt.getText());
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void user_login_logout() throws InterruptedException {
        WebElement user_name = driver.findElement(By.xpath("//a[@id='loginLink']"));
        log.info(driver.getTitle());
        log.info("The user name is : " + user_name.getText());
        user_name.click();
        WebElement logout_btn = driver.findElement(By.xpath("//button[@id='logoutBtn']"));
        logout_btn.click();
        WebElement cancel_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='CANCEL']")));
        cancel_btn.click();
        user_name.click();
        logout_btn.click();
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='CONFIRM']")));
        confirm.click();
        WebElement logout_txt = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
        log.info("Logout Text is : " + logout_txt.getText());
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Thread.sleep(4000);
    }

    @Test(priority = 10)
    public void create_account_withexixting_user() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='loginLink']")).click();
        Runnable smoothScrollDown = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 28).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown.run();
        WebElement create_account = driver.findElement(By.xpath("//a[@href='register.html']"));
        create_account.click();
        driver.findElement(By.xpath("//input[@placeholder='EMAIL']")).sendKeys("pratik001@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("Pratik$001");
        driver.findElement(By.xpath("//input[@placeholder='NAME']")).sendKeys("xyz");
        driver.findElement(By.xpath("//input[@placeholder='TELEPHONE']")).sendKeys("9812345482");
        Runnable smoothScrollDown2 = () -> {
            long end = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < end) {
                act.scrollByAmount(0, 8).perform();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        smoothScrollDown2.run();
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='privacy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='CREATE ACCOUNT']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Thread.sleep(2000);
        WebElement already_txt = driver.findElement(By.xpath("//a[normalize-space()='ALREADY HAVE AN ACCOUNT? LOG IN']"));
        log.info("I already have an account so i click on : " + already_txt.getText());
        act.moveToElement(already_txt).click().perform();
    }

    @Test(priority = 11)
    public void login_using_wrong() throws InterruptedException {
        Thread.sleep(4000);
        WebElement email_input = driver.findElement(By.xpath("//input[@placeholder='EMAIL']"));
        email_input.sendKeys("pratigmail.com");
        WebElement password_input = driver.findElement(By.xpath("//input[@placeholder='PASSWORD']"));
        password_input.sendKeys("Pratik");
        Thread.sleep(4000);
        WebElement login_btn = driver.findElement(By.xpath("//button[normalize-space()='LOG IN']"));
        login_btn.click();
        Thread.sleep(3000);
        email_input.clear();
        email_input.sendKeys("pratik001@gmail.com");
        password_input.clear();
        password_input.sendKeys("Pratik@12");
        login_btn.click();
        WebElement ok = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']")));
        ok.click();
        password_input.clear();
        email_input.clear();
    }

    @Test(priority = 12)
    public void login_using_wright_credentials() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='EMAIL']")).sendKeys("pratik001@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("Pratik@1234");
        driver.findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
        WebElement ok = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']")));
        ok.click();
        Thread.sleep(5000);
    }
}

