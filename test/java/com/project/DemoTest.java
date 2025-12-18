//package com.project;
//
//import java.time.Duration;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//
//import org.apache.logging.log4j.Logger;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class DemoTest {
//
//	WebDriver driver = new ChromeDriver();
//	Actions act = new Actions(driver);
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	private static final Logger log = LogManager.getLogger(DemoTest.class);
//
//	@BeforeClass
//	public void loadwebsite() {
//		log.info("Before Class loaded");
//
//		act = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		driver.get("http://127.0.0.1:5500/index.html");
//		log.info("Website opened");
//
//		driver.manage().window().maximize();
//		log.info("Browser maximized");
//	}
//
//	// Check the title bar
//	@Test(priority = 1)
//	public void check_home_page_title() throws InterruptedException {
//		log.info("================================");
//		log.info("TITLE BAR TEST STARTED");
//		log.info("=================================");
//
//		log.info("Checking home page");
//		Thread.sleep(2000);
//		log.info(driver.getTitle());
//		WebElement logo_name = driver.findElement(By.xpath("//div[@class='logo']//h1"));
//		log.info("The logo name is : " + logo_name.getText());
//		log.info("Getting title bar names");
//		WebElement search = driver.findElement(By.xpath("//a[normalize-space()='SEARCH']"));
//		log.info("The 1st name is : " + search.getText());
//		WebElement login = driver.findElement(By.xpath("//a[@id='loginLink']"));
//		log.info("The 2nd name is : " + login.getText());
//		WebElement help = driver.findElement(By.xpath("//a[normalize-space()='HELP']"));
//		log.info("The 3rd element is : " + help.getText());
//		WebElement cart = driver.findElement(By.xpath("//a[@href='cart.html']"));
//		log.info("The 4th element is : " + cart.getText());
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 20).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//
//		smoothScrollDown.run();
//		log.info("================================");
//		log.info("TITLE BAR TESTED TESTED SUCESFULLY");
//		log.info("=================================");
//
//		System.err.println("=============================");
//
//	}
//
//////
////////	
/////// Hero video is playing/not
//	@Test(priority = 2)
//	public void test_video() {
//		log.info("================================");
//		log.info("VIDEO TESTING STARTED ");
//		log.info("=================================");
//
//		WebElement video = driver.findElement(By.xpath("//video[@id='heroVideo']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		Boolean isPaused = (Boolean) js.executeScript("return arguments[0].paused;", video);
//
//		if (!isPaused) {
//			log.info("Video is playing");
//		} else {
//			log.info("Video is paused or stopped");
//		}
//
////		// Checking on vedio text
//		WebElement title = driver.findElement(By.xpath("//h1[@class='hero-title']"));
//		log.info("The on video title is : " + title.getText());
//		WebElement subtitle = driver.findElement(By.xpath("//p[@class='hero-subtitle']"));
//		log.info("The subtitle on the video is : " + subtitle.getText());
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 30).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//
//		smoothScrollDown.run();
//		log.info("================================");
//		log.info("VIDEO TESTING TESTED SUCESFULLY");
//		log.info("=================================");
//		System.err.println("=============================");
//
//	}
//
//////
//	// check Section's
//	@Test(priority = 3)
//	public void test_cards() {
//		log.info("================================");
//		log.info("SECTION TEST STARTED");
//		log.info("=================================");
//
//		WebElement woman_card = driver.findElement(By.xpath("//section[@id='categoryGrid']//a[1]"));
//		log.info("Visiblity of the woman card :" + woman_card.isDisplayed());
//
//		WebElement woman_text = driver.findElement(By.xpath("//h3[normalize-space()='WOMAN']"));
//
//		log.info("The text is visisble and is : " + woman_text.getText());
//		woman_card.click();
//		driver.navigate().back();
//		log.info("Woman section is visible...");
//		WebElement man_card = driver.findElement(By.xpath("(//a[@class='category-card'])[2]"));
//		log.info("Visibility of teh Man card : " + man_card.isDisplayed());
//		WebElement man_text = driver.findElement(By.xpath("//h3[normalize-space()='MAN']"));
//		log.info("The text is visisble and is : " + man_text.getText());
//		man_card.click();
//		driver.navigate().back();
//		log.info("Woman section is visible...");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 50).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		log.info("================================");
//		log.info("SECTION TESTED SUCESFULLY");
//		log.info("=================================");
//		System.err.println("=============================");
//
//	}
//
////////
////////	
//	@Test(priority = 4)
//	public void test_newsletter() throws InterruptedException {
//		log.info("================================");
//		log.info("NEWSLETER TEST STARTED");
//		log.info("=================================");
//
//		WebElement newsletter = driver.findElement(By.xpath("//section[@id='newsletter']"));
//		if (newsletter.isDisplayed() == true) {
//			log.info("The newletter section is visbile : " + newsletter.isDisplayed());
//		} else {
//			log.info("Newsletter is not displayed");
//		}
//		WebElement input = driver.findElement(By.xpath("//input[@id='newsletterEmail']"));
//		input.sendKeys("ps");
//		driver.findElement(By.xpath("//button[normalize-space()='SUBSCRIBE']")).click();
//		Thread.sleep(2000);
//		input.clear();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='newsletterEmail']")).sendKeys("pratik1234@gmail.com");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[normalize-space()='SUBSCRIBE']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 20).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		// log4G dependency
//		smoothScrollDown.run();
//		log.info("================================");
//		log.info("NEWSLETTER TESTED SUCESFULLY");
//		log.info("=================================");
//		System.err.println("=============================");
//
//	}
//
////
//////	
//	@Test(priority = 5)
//	public void test_footer() throws InterruptedException {
//		log.info("================================");
//		log.info("FOOTER TEST STARTED");
//		log.info("=================================");
//
//		WebElement footer = driver.findElement(By.xpath("//footer[@class='footer']"));
//		if (footer.isDisplayed() == true) {
//			log.info("Footer is displayed...");
//		} else {
//			log.info("Footer is not displayed...");
//		}
//
//		List<WebElement> allLi = footer.findElements(By.tagName("li"));
//
//		for (WebElement li : allLi) {
//			log.info(li.getText());
//		}
//
//		String parent = driver.getWindowHandle();
////
//		// Instagram
//		driver.findElement(By.xpath("//a[@title='Instagram']")).click();
//		for (String win : driver.getWindowHandles()) {
//			if (!win.equals(parent)) {
//				driver.switchTo().window(win);
//				Thread.sleep(5000);
//				log.info("Instagram page visited");
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parent);
//
//		// Facebook
//		driver.findElement(By.xpath("//a[@title='Facebook']")).click();
//		for (String win : driver.getWindowHandles()) {
//			if (!win.equals(parent)) {
//				driver.switchTo().window(win);
//				Thread.sleep(5000);
//				log.info("Facebook page visited");
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parent);
//
//		// YouTube
//		driver.findElement(By.xpath("//a[@title='YouTube']")).click();
//		for (String win : driver.getWindowHandles()) {
//			if (!win.equals(parent)) {
//				driver.switchTo().window(win);
//				Thread.sleep(5000);
//				log.info("YouTube page visited");
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parent);
//		log.info("================================");
//		log.info("FOOTER TESTED SUCESFULLY");
//		log.info("=================================");
//		System.err.println("=============================");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 40).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//
//	}
//
////
//////	
//	@Test(priority = 6)
//	public void last_footer() {
//		log.info("================================");
//		log.info("LAST FOOTER TEST STARTED");
//		log.info("=================================");
//
//		WebElement year = driver.findElement(By.xpath("//p[normalize-space()='© 2025 ZARA']"));
//		log.info("Year od production of the website is : " + year.getText());
//		WebElement region = driver.findElement(By.xpath("//p[@class='country']"));
//		log.info("The country of the website is : " + region.getText());
//		WebElement designer = driver.findElement(By.xpath("//p[normalize-space()='RECREATED BY PRATIK']"));
//		log.info("The designer of the wesite is : " + designer.getText());
//		log.info("================================");
//		log.info("LAST FOOTER TESTED SUCESFULLY");
//		log.info("=================================");
//		System.err.println("=============================");
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -40).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//
//	}
//
//	// Test login
//
//	@Test(priority = 7)
//	public void login_clicked() {
//		driver.findElement(By.xpath("//a[@id='loginLink']")).click();
//		log.info(driver.getTitle());
//		WebElement login_title = driver.findElement(By.xpath("//h2[normalize-space()='LOG IN']"));
//		if (login_title.isDisplayed() == true) {
//			log.info("The login title is : " + login_title.getText());
//		} else {
//			log.info("Login page is not displayed...");
//		}
//		driver.findElement(By.xpath("//div[@class='auth-left']"));
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 28).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//
//		// social media buttons
//		WebElement google_btn = driver.findElement(By.xpath("//button[@class='social-btn google-btn']"));
//		log.info("Is google button displayed : " + google_btn.isDisplayed());
//		WebElement apple_btn = driver.findElement(By.xpath("//button[@class='social-btn apple-btn']"));
//		log.info("Is apple button displayed : " + apple_btn.isDisplayed());
//		WebElement create_account = driver.findElement(By.xpath("//a[@href='register.html']"));
//		log.info("Create account text is : " + create_account.getText());
//
//	}
//
////
//////
//	@Test(priority = 8)
//	public void check_create_account_wrong_and_right() throws InterruptedException {
//		driver.findElement(By.xpath("//a[@href='register.html']")).click();
//		log.info(driver.getTitle());
//		WebElement create_txt = driver.findElement(By.xpath("//h1[normalize-space()='CREATE AN ACCOUNT']"));
//		log.info("Text displayed : " + create_txt.getText());
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 35).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		WebElement create_button = driver.findElement(By.xpath("//button[normalize-space()='CREATE ACCOUNT']"));
//		create_button.click();
//		WebElement error_text = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
//		log.info("The error text is : " + error_text.getText());
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -40).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		WebElement email = driver.findElement(By.xpath("//input[@placeholder='EMAIL']"));
//		email.sendKeys("PRATIK");
//		WebElement password = driver.findElement(By.xpath("//input[@placeholder='PASSWORD']"));
//		password.sendKeys("1234556");
//		WebElement name = driver.findElement(By.xpath("//input[@placeholder='NAME']"));
//		name.sendKeys("PRATIK");
//		WebElement phone = driver.findElement(By.xpath("//input[@placeholder='TELEPHONE']"));
//		phone.sendKeys("5533221155");
//
//		// checkboxes
//		WebElement checkbox_1 = driver.findElement(By.xpath("//input[@id='newsletter']"));
//		checkbox_1.click();
//		WebElement checkbox_2 = driver.findElement(By.xpath("//input[@id='privacy']"));
//		checkbox_2.click();
//		create_button.click();
//		Thread.sleep(3000);
//		smoothScrollUp.run();
//		email.clear();
//		email.sendKeys("pratik001@gmail.com");
//		smoothScrollDown.run();
//		create_button.click();
//		Thread.sleep(2000);
//		WebElement pass_err = driver
//				.findElement(By.xpath("//span[contains(text(),'Password must be 6+ chars and include uppercase, l')]"));
//		log.info("Error for password is : " + pass_err.getText());
//		smoothScrollUp.run();
//		password.clear();
//		password.sendKeys("pratik1234");
//		smoothScrollDown.run();
//		create_button.click();
//		WebElement num_err = driver
//				.findElement(By.xpath("//span[normalize-space()='Enter 10 digit mobile starting with 9, 8, 7 or 6']"));
//		log.info("Phone Number Test : " + num_err.getText());
//		smoothScrollUp.run();
//		password.clear();
//		password.sendKeys("Pratik@1234");
//		phone.clear();
//		phone.sendKeys("9876543210");
//		smoothScrollDown.run();
//		create_button.click();
//		Thread.sleep(4000);
//
//		// popup
//		WebElement created_txt = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
//		log.info("Created account as : " + created_txt.getText());
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Thread.sleep(3000);
//
//	}
//
//////
////////
//	@Test(priority = 9)
//	public void user_login_logout() throws InterruptedException {
//		WebElement user_name = driver.findElement(By.xpath("//a[@id='loginLink']"));
//		log.info(driver.getTitle());
//		log.info("The user name is : " + user_name.getText());
//		user_name.click();
//		WebElement logout_btn = driver.findElement(By.xpath("//button[@id='logoutBtn']"));
//		logout_btn.click();
//		WebElement cancel_btn = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='CANCEL']")));
//		cancel_btn.click();
//		user_name.click();
//		logout_btn.click();
//		WebElement confirm = wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='CONFIRM']")));
//		confirm.click();
//		WebElement logout_txt = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
//		log.info("Logout Text is : " + logout_txt.getText());
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Thread.sleep(4000);
//	}
//
//	@Test(priority = 10)
//	public void create_account_withexixting_user() throws InterruptedException {
//		driver.findElement(By.xpath("//a[@id='loginLink']")).click();
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 28).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		WebElement create_account = driver.findElement(By.xpath("//a[@href='register.html']"));
//		create_account.click();
//		driver.findElement(By.xpath("//input[@placeholder='EMAIL']")).sendKeys("pratik001@gmail.com");
//		driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("Pratik$001");
//		driver.findElement(By.xpath("//input[@placeholder='NAME']")).sendKeys("xyz");
//		driver.findElement(By.xpath("//input[@placeholder='TELEPHONE']")).sendKeys("9812345482");
//		Runnable smoothScrollDown2 = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 8).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown2.run();
//		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
//		driver.findElement(By.xpath("//input[@id='privacy']")).click();
//
//		driver.findElement(By.xpath("//button[normalize-space()='CREATE ACCOUNT']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Thread.sleep(2000);
//		WebElement already_txt = driver
//				.findElement(By.xpath("//a[normalize-space()='ALREADY HAVE AN ACCOUNT? LOG IN']"));
//		log.info("I already have an account so i click on : " + already_txt.getText());
//		act.moveToElement(already_txt).click().perform();
//
//	}
//
////
//	@Test(priority = 11)
//	public void login_using_wrong() throws InterruptedException {
////		driver.findElement(By.xpath("//a[@id='loginLink']")).click();
//		Thread.sleep(4000);
////		log.info("We are on the " + driver.getTitle() + "page");
//		WebElement email_input = driver.findElement(By.xpath("//input[@placeholder='EMAIL']"));
//		email_input.sendKeys("pratigmail.com");
//		WebElement password_input = driver.findElement(By.xpath("//input[@placeholder='PASSWORD']"));
//		password_input.sendKeys("Pratik");
//		Thread.sleep(4000);
//		WebElement login_btn = driver.findElement(By.xpath("//button[normalize-space()='LOG IN']"));
//		login_btn.click();
//		Thread.sleep(3000);
//		email_input.clear();
//		email_input.sendKeys("pratik001@gmail.com");
//		password_input.clear();
//		password_input.sendKeys("Pratik@12");
//		login_btn.click();
//		WebElement ok = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']")));
//		ok.click();
//		password_input.clear();
//		email_input.clear();
//	}
//
////
//	@Test(priority = 12)
//	public void login_using_wright_credentials() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@placeholder='EMAIL']")).sendKeys("pratik001@gmail.com");
//		driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("Pratik@1234");
//		driver.findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
//		WebElement ok = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']")));
//		ok.click();
//		Thread.sleep(5000);
//
//	}
//
//	// if wordeeed dont use
////
//	By menuBtn = By.id("menuBtn");
//
//	public void clickMenuItem(String label) {
//		// Always re-locate the menu button
//		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
//
//		WebElement item = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='" + label + "']")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
//	}
//
////
//////
//	@Test(priority = 13)
//	public void test_menu() throws InterruptedException {
//		clickMenuItem("WOMAN");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
//
//		clickMenuItem("MAN");
//		Thread.sleep(2000);
//		clickMenuItem("KIDS");
//		Thread.sleep(2000);
//		clickMenuItem("ESSENTIALS");
//		Thread.sleep(2000);
//		clickMenuItem("SHOES");
//		Thread.sleep(2000);
//		clickMenuItem("BAGS");
//		Thread.sleep(2000);
//		clickMenuItem("PERFUMES");
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
//		Thread.sleep(5000);
//
//	}
//
////
//	@Test(priority = 14)
//	public void check_woman_section() {
//		clickMenuItem("WOMAN");
//		log.info("Testing womans section");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//
//		// IMAGE LIST
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
//
//		// NAME LIST
//		List<WebElement> names = driver.findElements(By.xpath("//h3"));
//
//		// PRICE LIST
//		List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
//
//		int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
//
//		log.info("Total Products Found: " + totalProducts);
//		log.info("--------------------------------------------");
//
//		for (int i = 0; i < totalProducts; i++) {
//
//			String imageAlt = images.get(i).getAttribute("alt"); // <img alt="...">
//			String productName = names.get(i).getText(); // <h3>Product Name</h3>
//			String price = prices.get(i).getText(); // <p class="price">$XX</p>
//
//			log.info("Product #" + (i + 1));
//			log.info("Image Name : " + imageAlt);
//			log.info("Product Name : " + productName);
//			log.info("Price : " + price);
//			log.info("--------------------------------------------");
//		}
//
//	}
//
////
//	@Test(priority = 15)
//	public void check_man_section() {
//		clickMenuItem("MAN");
//		log.info("Testing mans section");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		// IMAGE LIST
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
//
//		// NAME LIST
//		List<WebElement> names = driver.findElements(By.xpath("//h3"));
//
//		// PRICE LIST
//		List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
//
//		int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
//
//		log.info("Total Products Found: " + totalProducts);
//		log.info("--------------------------------------------");
//
//		for (int i = 0; i < totalProducts; i++) {
//
//			String imageAlt = images.get(i).getAttribute("alt"); // <img alt="...">
//			String productName = names.get(i).getText(); // <h3>Product Name</h3>
//			String price = prices.get(i).getText(); // <p class="price">$XX</p>
//
//			log.info("Product #" + (i + 1));
//			log.info("Image Name : " + imageAlt);
//			log.info("Product Name : " + productName);
//			log.info("Price : " + price);
//			log.info("--------------------------------------------");
//		}
//
//	}
//
//	@Test(priority = 16)
//	public void check_kids_section() {
//		clickMenuItem("KIDS");
//		log.info("Testing kids section");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		// IMAGE LIST
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
//
//		// NAME LIST
//		List<WebElement> names = driver.findElements(By.xpath("//h3"));
//
//		// PRICE LIST
//		List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
//
//		int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
//
//		log.info("Total Products Found: " + totalProducts);
//		log.info("--------------------------------------------");
//
//		for (int i = 0; i < totalProducts; i++) {
//
//			String imageAlt = images.get(i).getAttribute("alt"); // <img alt="...">
//			String productName = names.get(i).getText(); // <h3>Product Name</h3>
//			String price = prices.get(i).getText(); // <p class="price">$XX</p>
//
//			log.info("Product #" + (i + 1));
//			log.info("Image Name : " + imageAlt);
//			log.info("Product Name : " + productName);
//			log.info("Price : " + price);
//			log.info("--------------------------------------------");
//		}
//
//	}
//
////
//	@Test(priority = 17)
//	public void check_essentials_section() {
//		clickMenuItem("ESSENTIALS");
//		log.info("Testing essentials section");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		// IMAGE LIST
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
//
//		// NAME LIST
//		List<WebElement> names = driver.findElements(By.xpath("//h3"));
//
//		// PRICE LIST
//		List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
//
//		int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
//
//		log.info("Total Products Found: " + totalProducts);
//		log.info("--------------------------------------------");
//
//		for (int i = 0; i < totalProducts; i++) {
//
//			String imageAlt = images.get(i).getAttribute("alt"); // <img alt="...">
//			String productName = names.get(i).getText(); // <h3>Product Name</h3>
//			String price = prices.get(i).getText(); // <p class="price">$XX</p>
//
//			log.info("Product #" + (i + 1));
//			log.info("Image Name : " + imageAlt);
//			log.info("Product Name : " + productName);
//			log.info("Price : " + price);
//			log.info("--------------------------------------------");
//		}
//
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
//	}
//
////
//	@Test(priority = 18)
//	public void check_shoes_section() {
//		clickMenuItem("SHOES");
//		log.info("Testing shoes section");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		// IMAGE LIST
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
//
//		// NAME LIST
//		List<WebElement> names = driver.findElements(By.xpath("//h3"));
//
//		// PRICE LIST
//		List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
//
//		int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
//
//		log.info("Total Products Found: " + totalProducts);
//		log.info("--------------------------------------------");
//
//		for (int i = 0; i < totalProducts; i++) {
//
//			String imageAlt = images.get(i).getAttribute("alt"); // <img alt="...">
//			String productName = names.get(i).getText(); // <h3>Product Name</h3>
//			String price = prices.get(i).getText(); // <p class="price">$XX</p>
//
//			log.info("Product #" + (i + 1));
//			log.info("Image Name : " + imageAlt);
//			log.info("Product Name : " + productName);
//			log.info("Price : " + price);
//			log.info("--------------------------------------------");
//		}
//
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
//
//	}
//
////
//	@Test(priority = 19)
//	public void check_bags_section() {
//		clickMenuItem("BAGS");
//		log.info("Testing bags section");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		// IMAGE LIST
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
//
//		// NAME LIST
//		List<WebElement> names = driver.findElements(By.xpath("//h3"));
//
//		// PRICE LIST
//		List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
//
//		int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
////
//		log.info("Total Products Found: " + totalProducts);
//		log.info("--------------------------------------------");
//
//		for (int i = 0; i < totalProducts; i++) {
//
//			String imageAlt = images.get(i).getAttribute("alt"); // <img alt="...">
//			String productName = names.get(i).getText(); // <h3>Product Name</h3>
//			String price = prices.get(i).getText(); // <p class="price">$XX</p>
//
//			log.info("Product #" + (i + 1));
//			log.info("Image Name : " + imageAlt);
//			log.info("Product Name : " + productName);
//			log.info("Price : " + price);
//			log.info("--------------------------------------------");
//		}
//
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'← BACK')])[1]"))).click();
//
//	}
//
////
//	@Test(priority = 20)
//	public void check_perfumes_section() {
//		clickMenuItem("PERFUMES");
//		log.info("Testing perfumes section");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		// IMAGE LIST
//		List<WebElement> images = driver.findElements(By.xpath("//img"));
//
//		// NAME LIST
//		List<WebElement> names = driver.findElements(By.xpath("//h3"));
//
//		// PRICE LIST
//		List<WebElement> prices = driver.findElements(By.xpath("//p[@class='price']"));
//
//		int totalProducts = Math.min(images.size(), Math.min(names.size(), prices.size()));
//
//		log.info("Total Products Found: " + totalProducts);
//		log.info("--------------------------------------------");
//
//		for (int i = 0; i < totalProducts; i++) {
//
//			String imageAlt = images.get(i).getAttribute("alt"); // <img alt="...">
//			String productName = names.get(i).getText(); // <h3>Product Name</h3>
//			String price = prices.get(i).getText(); // <p class="price">$XX</p>
//
//			log.info("Product #" + (i + 1));
//			log.info("Image Name : " + imageAlt);
//			log.info("Product Name : " + productName);
//			log.info("Price : " + price);
//			log.info("--------------------------------------------");
//		}
//
//	}
//
//	@Test(priority = 21)
//	public void test_womanman_addtocart() throws InterruptedException {
//		clickMenuItem("WOMAN");
//		Thread.sleep(2000);
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 18).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		WebElement img_2 = driver.findElement(By.xpath("//img[@alt='Satin Midi Skirt']"));
//		act.moveToElement(img_2).perform();
//
//		WebElement first_item = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]//div[1]//button[1]")));
//		act.moveToElement(first_item).click().perform();
//
//		for (int i = 1; i <= 2; i++) {
//
//			// Every time reacquire the OK button
//			WebElement ok = wait
//					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
//
//			act.moveToElement(ok).click().perform();
//			Thread.sleep(1500);
////
//			// Trigger the popup again (hover and click first item)
//			act.moveToElement(img_2).perform();
//			act.moveToElement(first_item).click().perform();
//		}
//		// Every time reacquire the OK button
//		WebElement ok = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
//		act.moveToElement(ok).click().perform();
//		Thread.sleep(3000);
////		Hover over images 
//		WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Oversized Blazer']"));
//		act.moveToElement(img_1).perform();
//		act.moveToElement(img_2).perform();
//		WebElement img_3 = driver.findElement(By.xpath("//img[@alt='Wool Blend Coat']"));
//		act.moveToElement(img_3).perform();
//		WebElement img_4 = driver.findElement(By.xpath("//img[@alt='Pleated Trousers']"));
//		act.moveToElement(img_4).perform();
//		act.moveToElement(img_3).perform();
//		act.moveToElement(img_2).perform();
//		act.moveToElement(img_1).perform();
//		Runnable smoothScrollDown2 = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 27).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown2.run();
//		WebElement img_5 = driver.findElement(By.xpath("//img[@alt='Cashmere Sweater']"));
//		act.moveToElement(img_5).perform();
//		WebElement img_6 = driver.findElement(By.xpath("//img[@alt='Silk Blouse']"));
//		act.moveToElement(img_6).perform();
//		WebElement scnd_item = driver.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])[7]"));
//		act.moveToElement(scnd_item).click().perform();
//		Thread.sleep(4000);
//		WebElement msg = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
//		log.info("The name os the second item added to the cart is : " + msg.getText());
//		WebElement ok2 = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
//		act.moveToElement(ok2).click().perform();
//
//		Runnable smoothScrollDown3 = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 35).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown3.run();
//		Thread.sleep(5000);
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -85).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//
//		driver.findElement(By.xpath("//a[@href='cart.html']")).click();
//		log.info("Shopping bag button is clicked sucessfully....");
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
//		log.info("Continue shopping is clicked....");
//		Thread.sleep(3000);
//
//	}
//
//	@Test(priority = 22)
//	public void test_man_addtocart() throws InterruptedException {
//		clickMenuItem("MAN");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 18).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Tailored Suit Jacket']"));
//		act.moveToElement(img_1).perform();
//		driver.findElement(By.xpath("//section[@class='products-section']//div[1]//div[1]//button[1]")).click();
//		WebElement add_msg = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
//		log.info("What is added to the cart : " + add_msg.getText());
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Runnable smoothScrollDown2 = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 35).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown2.run();
//		WebElement img_2 = driver.findElement(By.xpath("//img[@alt='Denim Jacket']"));
//		act.moveToElement(img_2).perform();
//
//		WebElement img_3 = driver.findElement(By.xpath("//img[@alt='Leather Loafers']"));
//		act.moveToElement(img_3).perform();
//		WebElement img_4 = driver.findElement(By.xpath("//img[@alt='Bomber Jacket']"));
//		act.moveToElement(img_4).perform();
//		log.info("Hovered sucesfull...");
//		driver.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])[7]")).click();
//		WebElement added_box = driver.findElement(By.xpath("//div[@class='custom-alert']"));
//		if (added_box.isDisplayed() == true) {
//			log.info("Added Sucessfully displayed..");
//		} else {
//			log.info("Not displayed...");
//		}
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		smoothScrollDown2.run();
//		WebElement img_5 = driver.findElement(By.xpath("//img[@alt='Wool Overcoat']"));
//		log.info("Are the images displayed...." + img_5.isDisplayed());
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -85).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("//a[@href='cart.html']")).click();
//		log.info("Shopping bag clicked sucessfully...");
//		Thread.sleep(5000);
//		smoothScrollDown.run();
//		smoothScrollDown2.run();
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
//		log.info("Continue clicked...");
//		Thread.sleep(2000);
//
//	}
//
//	}
//
//	@Test(priority = 23)
//	public void kids_addtocart() throws InterruptedException {
//		clickMenuItem("KIDS");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 52).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		Thread.sleep(3000);
//		WebElement img_5 = driver.findElement(By.xpath("//img[@alt='Hooded Sweatshirt']"));
//		act.moveToElement(img_5).perform();
//		WebElement add_1 = driver
//				.findElement(By.xpath("(//button[@class='add-to-cart-btn'][normalize-space()='ADD TO CART'])[5]"));
//		act.moveToElement(add_1).click().perform();
//		WebElement add_msg = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='custom-alert-message']")));
//		log.info("What has been added to the cart section : " + add_msg.getText());
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Thread.sleep(3000);
//		smoothScrollDown.run();
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -95).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("//a[@href='cart.html']")).click();
//		WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='SHOPPING BAG']"));
//		log.info("The title of the page after click is : " + title.getText());
//		log.info(driver.getTitle());
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
//		log.info("Continue clicked...");
//		Thread.sleep(2000);
//
//	}
//
//	}
//
//	@Test(priority = 24)
//	public void essentials_addtocart() throws InterruptedException {
//		clickMenuItem("ESSENTIALS");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 25).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		WebElement img_1 = driver.findElement(By.xpath("//img[@alt='LEATHER BELT WITH DOUBLE BUCKLE']"));
//		act.moveToElement(img_1).perform();
//		driver.findElement(By.xpath("//div[2]//div[1]//button[1]")).click();
//		WebElement ok = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
//		ok.click();
//		log.info("First element is added sucessfully");
//		smoothScrollDown.run();
//		Thread.sleep(3000);
//		smoothScrollDown.run();
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -85).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("//a[@href='cart.html']")).click();
//		smoothScrollDown.run();
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
//		log.info("Continue shopping is clicked....");
//		Thread.sleep(3000);
//	}
//
//	}
//
//	@Test(priority = 25)
//	public void shoes_addtocart() throws InterruptedException {
//		clickMenuItem("SHOES");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 25).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		Thread.sleep(2000);
//		smoothScrollDown.run();
//		Thread.sleep(2000);
//		Runnable smoothScrollDown2 = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 35).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown2.run();
//		WebElement img_1 = driver.findElement(By.xpath("//img[@alt='High Heels']"));
//		act.moveToElement(img_1).perform();
//		driver.findElement(By.xpath("//div[9]//div[1]//button[1]")).click();
//		log.info("Sandals added to the cart sucessfully");
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -95).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("//a[contains(text(),'← CONTINUE SHOPPING')]")).click();
//		log.info("Continue clicked...");
//		Thread.sleep(2000);
//	}
//
//	}
//
//	@Test(priority = 26)
//	public void bags_addtocart() throws InterruptedException {
//		clickMenuItem("BAGS");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 22).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//
//		WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Crossbody Bag']"));
//		act.moveToElement(img_1).perform();
//		Thread.sleep(1500);
//		driver.findElement(By.xpath("//body[1]/section[1]/div[3]/div[2]/div[1]/button[1]")).click();
//		WebElement msg = driver.findElement(By.xpath("//div[@class='custom-alert-message']"));
//		log.info("Which bag is added : " + msg.getText());
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		driver.findElement(By.xpath("//a[@href='cart.html']")).click();
//		Thread.sleep(3000);
//		driver.navigate().back();
//		log.info("Sucessfully used the driver back function....");
//		Thread.sleep(4000);
////		
//	}
//
//	}
//
//	@Test(priority = 27)
//	public void perfumes_addtocart() throws InterruptedException {
//		clickMenuItem("PERFUMES");
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -90).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		Runnable smoothScrollDown2 = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 53).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown2.run();
//		WebElement img_1 = driver.findElement(By.xpath("//img[@alt='Ebony Wood']"));
//		act.moveToElement(img_1).perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[7]//div[1]//button[1]")).click();
//		Thread.sleep(1500);
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		Thread.sleep(2000);
//		log.info("The Third element from the second row is added sucessfully");
//		driver.findElement(By.xpath("//a[@href='cart.html']")).click();
//		log.info(driver.getCurrentUrl());
//		Thread.sleep(3500);
//		smoothScrollUp.run();// comment in after
//	}
//
//	}
//
//	/*
//	 * Search bar get toptabs scroll the hidden elements
//	 */
//	@Test(priority = 28)
//	public void test_searchbtn_menu() throws InterruptedException {
//		driver.findElement(By.xpath("//a[normalize-space()='ZARA']")).click();
//		log.info("sucesfully clicked the brand....");
//		log.info("Getting the s/earch box");
//		WebElement search_btn = driver.findElement(By.xpath("//a[normalize-space()='SEARCH']"));
//		search_btn.click();
//		Thread.sleep(3000);
//		WebElement top_tabs = driver.findElement(By.xpath("//div[@class='top-tabs']"));
//		log.info("The title on the aesrch bars are : " + top_tabs.getText());
//		WebElement search_box = driver.findElement(By.xpath("//div[@class='top-tabs']"));
//		log.info("Is search box displayed : " + search_box.isDisplayed());
//		WebElement woman_btn = driver.findElement(By.xpath("//div[normalize-space()='WOMAN']"));
//		woman_btn.click();
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 15).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		WebElement horizontalScroll = driver.findElement(By.id("productsRow"));
////		
////		//csroll 
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + 300;", horizontalScroll);
//		Thread.sleep(1500);
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -15).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//
//		WebElement man_btn = driver.findElement(By.xpath("//div[normalize-space()='MAN']"));
//		man_btn.click();
//		smoothScrollDown.run();
//		WebElement manscroll = driver.findElement(By.id("productsRow"));
//		smoothScrollDown.run();
//		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + 300;", manscroll);
//		Thread.sleep(1500);
//		smoothScrollUp.run();
//		WebElement kids_btn = driver.findElement(By.xpath("//div[normalize-space()='KIDS']"));
//		kids_btn.click();
//		smoothScrollDown.run();
//		WebElement kidsscroll = driver.findElement(By.id("productsRow"));
//		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + 300;", kidsscroll);
//		Thread.sleep(3000);
//		smoothScrollUp.run();
////		 search for kids 
//		WebElement input_search = driver.findElement(By.xpath("//input[@id='searchInput']"));
//		input_search.sendKeys("A");
//		WebElement suggestions = driver.findElement(By.id("suggestionsList"));
//		List<WebElement> suggestionItems = suggestions.findElements(By.xpath(".//div"));
//		for (WebElement item : suggestionItems) {
//			log.info(item.getText());
//		}
////
//		WebElement s1 = wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='HOODED SWEATSHIRT']")));
//		act.moveToElement(s1).perform();
//		Thread.sleep(1500);
//		act.moveToElement(s1).click().perform();
//		WebElement text1 = driver.findElement(By.xpath("//div[@id='questionText']"));
//		String name1 = text1.getText();
//		log.info("text1 is " + name1);
//		WebElement img_1 = driver.findElement(By.xpath("(//img[@alt='Hooded Sweatshirt'])[2]"));
//		log.info("Is image displayed : " + img_1.isDisplayed());
//		log.info("Image is Visible");
//		Thread.sleep(4000);
//		smoothScrollDown.run();
//		WebElement img_1txt = driver.findElement(By.xpath("(//h3[contains(text(),'Hooded Sweatshirt')])[2]"));
//		log.info("text2 is " + img_1txt.getText());
//		String name2 = img_1txt.getText();
//		if (name1.equalsIgnoreCase(name2)) {
//			log.info("Search is successfully parsed");
//		} else {
//			log.info("Search is not matched....");
//		}
////
//		smoothScrollUp.run();
//
////		search for man
//		man_btn.click();
//		Thread.sleep(2000);
//		act.moveToElement(input_search).perform();
//		input_search.sendKeys("CROSSBODY BAG");
//		Thread.sleep(1500);
//		// keyboard input auto
//		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
//		Thread.sleep(3000);
//		smoothScrollDown.run();
//		WebElement price = driver
//				.findElement(By.xpath("//div[@id='searchResultsRow']//p[@class='price'][normalize-space()='$79.90']"));
//		log.info("Price of the item is : " + price.getText());
//		String actualPrice = price.getText().trim();
////
//		if (actualPrice.equals("$79.90")) {
//			log.info("Price is as expected");
//		} else {
//			log.info("Price is more than expected");
//		}
//		smoothScrollUp.run();
//		woman_btn.click();
//		WebElement input_line = driver.findElement(By.xpath("//div[@id='questionText']"));
//		input_line.click();
//		act.moveToElement(input_search)
//
//				.sendKeys("w").pause(Duration.ofMillis(200)).sendKeys("o").pause(Duration.ofMillis(200)).sendKeys("n")
//				.pause(Duration.ofMillis(200)).sendKeys("d").pause(Duration.ofMillis(200)).sendKeys("e")
//				.pause(Duration.ofMillis(200)).sendKeys("r").pause(Duration.ofMillis(200))
//
//				.sendKeys(" ").pause(Duration.ofMillis(200))
//
//				.keyDown(Keys.SHIFT).sendKeys("r").pause(Duration.ofMillis(200)).sendKeys("o")
//				.pause(Duration.ofMillis(200)).sendKeys("s").pause(Duration.ofMillis(200)).sendKeys("e")
//				.pause(Duration.ofMillis(200)).keyUp(Keys.SHIFT)
//
//				.pause(Duration.ofMillis(200)).sendKeys(Keys.ENTER)
//
//				.perform();
//		Thread.sleep(3000);
//		smoothScrollDown.run();
//		smoothScrollUp.run();
//		woman_btn.click();
//		input_line.click();
//		input_search.sendKeys("JEANS");
//		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
//		Thread.sleep(2000);
//		WebElement empty = driver.findElement(By.xpath("//div[@class='suggestions-wrapper']"));
//		Boolean blank = empty.isDisplayed();
//		WebElement upcomming = driver.findElement(By.xpath("//div[@class='single-result-msg']"));
//
//		if (blank.equals(false)) {
//			log.info("cart is empty");
//		} else {
//			log.info(upcomming.getText());
//
//		}
//		man_btn.click();
//		input_line.click();
//		input_search.sendKeys("gloves");
//		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
//		Thread.sleep(2000);
//		act.moveToElement(input_line).keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
//		act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
//		act.moveToElement(input_search)
//				//
//				.sendKeys("r").pause(Duration.ofMillis(200)).sendKeys("u").pause(Duration.ofMillis(200)).sendKeys("n")
//				.pause(Duration.ofMillis(200)).sendKeys("n").pause(Duration.ofMillis(200)).sendKeys("i")
//				.pause(Duration.ofMillis(200)).sendKeys("n").pause(Duration.ofMillis(200)).sendKeys("g")
//				.pause(Duration.ofMillis(200)).sendKeys(" ").pause(Duration.ofMillis(200)).sendKeys("s")
//				.pause(Duration.ofMillis(200)).sendKeys("h").pause(Duration.ofMillis(200)).sendKeys("o")
//				.pause(Duration.ofMillis(200)).sendKeys("e").pause(Duration.ofMillis(200)).sendKeys("s")
//				.pause(Duration.ofMillis(200)).perform();
//		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
//		Thread.sleep(2000);
//
//		log.info("================================");
//		log.info("SEARCH SECTION TESTED SUCESFULLY");
//		log.info("=================================");
//
//		driver.findElement(By.xpath("//a[normalize-space()='ZARA']")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@Test(priority = 29)
//	public void test_help_section() throws InterruptedException {
//		WebElement help_btn = driver.findElement(By.xpath("//a[normalize-space()='HELP']"));
//		help_btn.click();
//		Thread.sleep(3000);
//		log.info(driver.getTitle());
//		WebElement help_input = driver.findElement(By.xpath("//input[@id='helpInput']"));
//		act.moveToElement(help_input).click().perform();
//		help_input.sendKeys("how do i track my shipment");
//		Thread.sleep(1000);
//		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
//		System.err.println("How do i track my shipment");
//		WebElement answer_txt = driver.findElement(By.xpath("//div[@id='answerText']"));
//		log.info(answer_txt.getText());
//		Thread.sleep(1500);
//		WebElement clear_btn = driver.findElement(By.xpath("//button[@id='clearBtn']"));
//		clear_btn.click();
//		Thread.sleep(2000);
//		help_input.sendKeys("Where");
//		log.info("The sugessions is : ");
//		Thread.sleep(1000);
//		WebElement suggestions = driver.findElement(By.id("suggestions"));
//		act.moveToElement(suggestions).perform();
//		System.err.println(suggestions.getText());
//
//		suggestions.click();
//		Thread.sleep(2000);
//		log.info(answer_txt.getText());
//		clear_btn.click();
//		help_input.sendKeys("W");
//		Thread.sleep(1000);
//		log.info("On typing W i get the suggestion as : ");
//		act.moveToElement(suggestions).perform();
//		Thread.sleep(2000);
//		System.err.println(suggestions.getText());
//		WebElement payments_q = driver.findElement(By
//				.xpath("(//div[@class='suggestion-item'][normalize-space()='What payment methods are accepted?'])[1]"));
//		log.info(payments_q.getText());
//		act.moveToElement(payments_q).perform();
//		act.moveToElement(payments_q).click().perform();
//		Thread.sleep(2000);
//		WebElement question = driver.findElement(By.xpath("//div[@id='answerQuestion']"));
//		System.err.println(question.getText());
//		log.info(answer_txt.getText());
//		Thread.sleep(2000);
//	}
//
//	}
//
//	@Test(priority = 30)
//	public void test_shopping_bag() throws InterruptedException {
////		WebElement shopping_bag = driver.findElement(By.xpath("//a[@class='nav-link']"));
////		act.moveToElement(shopping_bag).click().perform();
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 100).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -100).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		Thread.sleep(1500);
//		;
//		WebElement product_names = driver.findElement(By.xpath("//h3"));
//		log.info("The names of products adde dto the cart are : " + product_names.getText());
//		WebElement order_sry = driver.findElement(By.xpath("//h2[normalize-space()='ORDER SUMMARY']"));
//		log.info("======");
//		log.info(order_sry.getText());
//		WebElement sub_total = driver.findElement(By.xpath("//span[@id='cartSubtotal']"));
//		log.info("The Subtotal Amount is : " + sub_total.getText());
////		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//span[@id='cartTotal'];")));
//		WebElement total = driver.findElement(By.id("cartTotal"));
//		log.info("Total Amount paid should be : " + total.getText());
//		driver.findElement(By.xpath("//button[@id='checkoutBtn']")).click();
//		Thread.sleep(1000);
//
//	}
//
//	}
//
//	@Test(priority = 31)
//	public void test_checkout_form() throws InterruptedException {
//		WebElement name = driver.findElement(By.xpath("//input[@id='fullName']"));
//		name.sendKeys("PRATIK SALVE");
//		WebElement email_id = driver.findElement(By.xpath("//input[@id='email']"));
//		email_id.sendKeys("pratiksalve001@gmail.com");
//		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
//		phone.sendKeys("8877441123");
//		WebElement address = driver.findElement(By.xpath("//input[@id='address']"));
//		address.sendKeys("MUMBAI");
//		WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
//		city.sendKeys("thane");
//		WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
//		state.sendKeys("Maharashtra");
//		WebElement zipcode = driver.findElement(By.xpath("//input[@id='zipCode']"));
//		zipcode.sendKeys("400001");
//
//	}
//
//	@Test(priority = 32)
//	public void checkout_with_card() throws InterruptedException {
//		driver.findElement(By.xpath("(//div[@class='payment-content'])[1]")).click();
//		driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("3455 6666 2266 666");
//		driver.findElement(By.xpath("//input[@id='expiry']")).sendKeys("1245");
//		driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("145");
//		// 3455 6666 2266 666
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 15).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -15).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("//button[normalize-space()='PLACE ORDER']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//
//	}
//
////	@Test(priority=33)
//	public void test_checkout_using_upi() throws InterruptedException {
////		test_checkout_form();
//		Thread.sleep(2000);
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -15).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("(//div[@class='payment-content'])[2]")).click();
//		driver.findElement(By.xpath("//input[@id='upiId']")).sendKeys("pratik12@icicbank");
//		driver.findElement(By.xpath("//button[normalize-space()='PLACE ORDER']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//	}
//
////	@Test(priority=34)
//	public void test_checkout_using_cod() throws InterruptedException {
////		test_checkout_form();
//		Thread.sleep(2000);
//		Runnable smoothScrollUp = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, -15).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollUp.run();
//		driver.findElement(By.xpath("(//div[@class='payment-content'])[3]")).click();
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 15).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		driver.findElement(By.xpath("//button[normalize-space()='PLACE ORDER']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//
//	}
//
//	@Test(priority = 35)
//	public void test_orderconform_page() {
//		WebElement order_no = driver.findElement(By.xpath("//span[@id='orderNumber']"));
//		log.info("Your order number is : " + order_no.getText());
//		WebElement order_cnf = driver.findElement(By.xpath("//div[@class='thankyou-message']//p[1]"));
//		log.info(order_cnf.getText());
//		WebElement name = driver.findElement(By.xpath("//span[@id='customerName']"));
//		log.info("The name of the receiver is : " + name.getText());
//		WebElement shipping_address = driver.findElement(By.xpath("(//p)[7]"));
//		log.info("The shipment will be send to : " + shipping_address.getText());
//		WebElement order_items = driver.findElement(By.xpath("//div[@class='order-item']"));
//		log.info("The items you ordered are : " + order_items.getText());
//		driver.findElement(By.xpath("//a[normalize-space()='CONTINUE SHOPPING']")).click();
//
//	}
//
//	@Test(priority = 36)
//	public void test_project_details() throws InterruptedException {
//		Runnable smoothScrollDown = () -> {
//			long end = System.currentTimeMillis() + 5000;
//			while (System.currentTimeMillis() < end) {
//				act.scrollByAmount(0, 89).perform();
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//				}
//			}
//		};
//		smoothScrollDown.run();
//		WebElement project_info = driver.findElement(By.xpath("//div[@class='footer-manufacturer']"));
//		log.info(project_info.getText());
//		Thread.sleep(5000);
//
//	}
//	
//
//	@AfterClass
//	public void quitall() {
//		driver.close();
//	}
//
//}
//
