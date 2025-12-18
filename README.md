# Zara E‑commerce Selenium Automation Framework

## Overview

This repository contains a Selenium WebDriver automation framework built in **Java** with **TestNG** for a Zara‑style **e‑commerce** web application.  
It automates end‑to‑end user journeys including home page UI, hero video, categories, newsletter, footer, registration, login, search, help, add‑to‑cart, cart, and checkout (Card/UPI/COD).

---

## Tech Stack

- **Automation Tool:** Selenium WebDriver  
- **Language:** Java  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **IDE:** IntelliJ IDEA  
- **Logging:** Log4j2  
- **Browser:** Chrome (ChromeDriver)

---

## Project Structure

src/test/java
├─ com.anudip.basepackage
│ └─ BaseTest.java
└─ com.anudip.project.testcases
├─ HomeTests.java
├─ VideoTests.java
├─ CategoryTests.java
├─ NewsletterTests.java
├─ FooterTests.java
├─ AuthTests.java
├─ MenuAndSectionTests.java
├─ AddToCartTests.java
├─ SearchTests.java
├─ HelpTests.java
├─ CartAndCheckoutTests.java
└─ ProjectInfoTests.java


Main suite: **`testng.xml`** (runs tests sequentially in one browser session).

---

## How to Run

1. **Clone the repo**

git clone <your-repo-url>
cd <project-folder>


2. **Run with Maven**
mvn clean test

or run `testng.xml` directly from your IDE.

3. **View Reports**
- HTML report: `test-output/emailable-report.html`
- Detailed results: `test-output/testng-results.xml`

---

## Test Cases

### Home, Hero, Categories, Newsletter, Footer

**TC_001 – Verify Home Page Header**  
- **Steps:** Open home page → Observe logo and menu items SEARCH, LOGIN, HELP, CART  
- **Expected:** Logo text and all four navigation links are visible and correctly labeled  

**TC_002 – Verify Hero Video and Text**  
- **Steps:** Open home page → Check hero video state → Read hero title and subtitle  
- **Expected:** Video is playing (not paused); hero title and subtitle match design text  

**TC_003 – Verify Category Cards (WOMAN / MAN)**  
- **Steps:** Scroll to category grid → Check WOMAN card text and click/back → Check MAN card and click/back  
- **Expected:** Both cards visible with correct labels and navigate to correct sections then back  

**TC_004 – Verify Newsletter Subscription and Validation**  
- **Steps:** Scroll to newsletter → Check visibility → Enter invalid email & SUBSCRIBE → Enter valid email & SUBSCRIBE → Handle OK popup  
- **Expected:** Section visible; invalid email shows error; valid email shows success popup  

**TC_005 – Verify Footer Links and Social Icons**  
- **Steps:** Scroll to footer → Verify footer texts → Click Instagram, Facebook, YouTube → Close tabs and return  
- **Expected:** Footer visible; links listed; each icon opens correct site in new window/tab  

**TC_006 – Verify Final Footer Information**  
- **Steps:** Scroll to very bottom → Read year, country, and recreated text  
- **Expected:** Shows “© 2025 ZARA”, correct country, and “RECREATED BY PRATIK”  

**TC_007 – Verify Project / Manufacturer Info**  
- **Steps:** Scroll to footer manufacturer section → Read full text  
- **Expected:** Project / manufacturer info text displayed as configured  

---

### Authentication and Account Management

**TC_008 – Verify Login Page UI**  
- **Steps:** Click LOGIN in header → Check page title, left panel, Google/Apple buttons, CREATE ACCOUNT link  
- **Expected:** All elements present and visible  

**TC_009 – Registration with Empty Fields**  
- **Steps:** From login page click CREATE ACCOUNT → On registration page click CREATE ACCOUNT with all fields blank  
- **Expected:** Custom alert popup for missing required fields  

**TC_010 – Registration with Invalid Email / Weak Password / Invalid Phone**  
- **Steps:**  
1. Enter non‑email text, weak password, name, 10‑digit phone, select checkboxes → Submit  
2. Fix email → Submit → Observe password error  
3. Fix password (still invalid rules) → Submit → Observe phone error  
- **Expected:** Correct validation messages for email, password, and phone  

**TC_011 – Successful Registration with Valid Data**  
- **Steps:** Enter valid email, strong password, name, valid 10‑digit phone (9/8/7/6), tick newsletter & privacy, click CREATE ACCOUNT → Handle success popup  
- **Expected:** Account created; success popup text displayed  

**TC_012 – Logout with Cancel**  
- **Steps:** While logged in → Click username → LOGOUT → CANCEL  
- **Expected:** User remains logged in, username still visible  

**TC_013 – Logout with Confirm**  
- **Steps:** Click username → LOGOUT → CONFIRM → Handle logout popup  
- **Expected:** Logout success popup; header reverts to LOGIN  

**TC_014 – Registration with Existing Email**  
- **Steps:** Open registration → Enter existing email & valid data → Check checkboxes → CREATE ACCOUNT → Handle popup → Click “ALREADY HAVE AN ACCOUNT? LOG IN”  
- **Expected:** User informed; link returns to login screen  

**TC_015 – Invalid Login (Format and Wrong Password)**  
- **Steps:** Enter bad email + short password → LOG IN → Then valid email + wrong password → LOG IN  
- **Expected:** Error popups; user not logged in  

**TC_016 – Valid Login**  
- **Steps:** Enter existing email and password `Pratik@1234` → LOG IN → OK  
- **Expected:** Login success popup; user logged in  

---

### Menu Navigation and Product Sections

**TC_017 – Verify Menu Navigation**  
- **Steps:** Click menu → Visit WOMAN, BACK, MAN, KIDS, ESSENTIALS, SHOES, BAGS, PERFUMES → Use BACK where shown  
- **Expected:** Each item opens correct section; BACK works  

**TC_018 – Verify WOMAN Product List**  
- **Steps:** Open WOMAN → Scroll through products → Capture image alt, name, price  
- **Expected:** Image / name / price present and aligned for all products  

**TC_019 – Verify MAN Product List**  
- **Steps:** Open MAN → Scroll and log image, name, price for each product  
- **Expected:** All MAN products display correct data  

**TC_020 – Verify KIDS Product List**  
- **Steps:** Open KIDS → Scroll and log products (image, name, price)  
- **Expected:** All KIDS products show correct data  

**TC_021 – Verify ESSENTIALS Product List and Back**  
- **Steps:** Open ESSENTIALS → Scroll and log products → Scroll up → Click BACK  
- **Expected:** Products correct; BACK returns to previous page  

**TC_022 – Verify SHOES Product List**  
- **Steps:** Open SHOES → Scroll and log products  
- **Expected:** All shoes show image, name, price  

**TC_023 – Verify BAGS Product List**  
- **Steps:** Open BAGS → Scroll and log products  
- **Expected:** All bags show image, name, price  

**TC_024 – Verify PERFUMES Product List**  
- **Steps:** Open PERFUMES → Scroll and log products  
- **Expected:** All perfumes show image, name, price  

---

### Add to Cart Scenarios

**TC_025 – WOMAN: Add Multiple Products to Cart**  
- **Steps:** WOMAN section → Hover “Satin Midi Skirt” → ADD TO CART three times (OK each) → Add another product (e.g., “Silk Blouse”) → Open cart → Continue shopping  
- **Expected:** Popups show correct items; cart contains WOMAN products; continue shopping works  

**TC_026 – MAN: Add Multiple Products to Cart**  
- **Steps:** MAN section → Add “Tailored Suit Jacket” and another product → Verify alert box → Go to cart → Continue shopping  
- **Expected:** Cart and popups show correct MAN products  

**TC_027 – KIDS: Add to Cart and Open Cart Page**  
- **Steps:** KIDS section → Hover “Hooded Sweatshirt” → ADD TO CART → OK → Open Shopping Bag → Read title → Continue shopping  
- **Expected:** Popup text correct; Shopping Bag title correct; continue shopping works  

**TC_028 – ESSENTIALS: Add to Cart and Back from Cart**  
- **Steps:** ESSENTIALS → Add “LEATHER BELT WITH DOUBLE BUCKLE” → OK → Open cart → Scroll → Continue shopping  
- **Expected:** Belt listed in cart; user can return to shopping  

**TC_029 – SHOES: Add to Cart**  
- **Steps:** SHOES → Scroll → Hover “High Heels” → ADD TO CART → OK → Continue shopping  
- **Expected:** Shoe added; success popup; back to listing  

**TC_030 – BAGS: Add to Cart and Browser Back**  
- **Steps:** BAGS → Hover “Crossbody Bag” → ADD TO CART → OK → Open cart → Use browser Back  
- **Expected:** Bag present in cart; browser back returns to BAGS without error  

**TC_031 – PERFUMES: Add to Cart and Open Cart**  
- **Steps:** PERFUMES → Scroll to second row → Hover “Ebony Wood” → ADD TO CART → OK → Open cart  
- **Expected:** Ebony Wood visible in cart; URL of cart page correct  

---

### Search Scenarios

**TC_032 – Search Tabs and Layout**  
- **Steps:** Click logo → SEARCH → Verify tabs & search bar → Check WOMAN, MAN, KIDS with vertical + horizontal scroll  
- **Expected:** Search tabs and product rows behave correctly  

**TC_033 – Search Suggestion and Result Mapping (Hooded Sweatshirt)**  
- **Steps:** KIDS tab → Type “A” → View suggestions → Select “HOODED SWEATSHIRT” → Compare question text & product name → Check image  
- **Expected:** Selected suggestion maps to matching product and visible image  

**TC_034 – Search Price Verification (CROSSBODY BAG)**  
- **Steps:** MAN tab → Search “CROSSBODY BAG” → Press ENTER → Read price  
- **Expected:** Price equals 79.90  

**TC_035 – Search WONDER ROSE Using Typed Input**  
- **Steps:** WOMAN tab → Use Actions to type “wonder rose” → ENTER → Observe results  
- **Expected:** Results show appropriate WONDER ROSE product(s)  

**TC_036 – Negative Search JEANS**  
- **Steps:** WOMAN tab → Search “JEANS” → ENTER  
- **Expected:** No product cards; empty/upcoming message shown  

**TC_037 – Search GLOVES then RUNNING SHOES**  
- **Steps:** MAN tab → Search “gloves” → ENTER → Clear via select+backspace → Type “running shoes” → ENTER  
- **Expected:** First query returns results; clearing works; second query returns running shoes  

---

### Help / FAQ

**TC_038 – Help: Track Shipment Question**  
- **Steps:** Click HELP → Type “how do I track my shipment” → ENTER  
- **Expected:** Answer text describing shipment tracking is displayed  

**TC_039 – Help: Suggestions and Clear**  
- **Steps:** In Help click CLEAR → Type “Where” → View suggestions → Select one → Read answer  
- **Expected:** Suggestions appear; chosen suggestion opens correct answer; CLEAR resets state  

**TC_040 – Help: Payment Methods Suggestion**  
- **Steps:** Type “W” → Choose “What payment methods are accepted?” → Observe question & answer  
- **Expected:** Correct question and detailed payment methods answer displayed  

---

### Cart, Checkout, and Order Confirmation

**TC_041 – Shopping Bag Summary**  
- **Steps:** Open Shopping Bag (cart link) → Scroll up/down → Read product names, ORDER SUMMARY, subtotal & total → Click CHECKOUT  
- **Expected:** All sections visible; totals consistent; navigation to checkout  

**TC_042 – Checkout Form Data Entry**  
- **Steps:** On checkout page, fill full name, email, phone, address, city, state, zip code  
- **Expected:** All fields accept valid data without validation errors  

**TC_043 – Checkout with Card Payment**  
- **Steps:** Select card option → Enter card number, expiry, CVV → Scroll if needed → PLACE ORDER → OK  
- **Expected:** Order placed using card; success popup shown  

**TC_044 – Checkout with UPI Payment**  
- **Steps:** Ensure form data → Select UPI option → Enter UPI ID → PLACE ORDER → OK  
- **Expected:** Order placed via UPI; success popup displayed  

**TC_045 – Checkout with Cash on Delivery**  
- **Steps:** Ensure form data → Select COD option → Scroll → PLACE ORDER → OK  
- **Expected:** Order placed with COD; success popup visible  

**TC_046 – Order Confirmation Page**  
- **Steps:** After order, view confirmation page → Read order number, thank‑you message, customer name, shipping address, order items → Click CONTINUE SHOPPING  
- **Expected:** All details correct; continue shopping returns to main site  

---

## Future Enhancements

- CI/CD integration with Jenkins  
- Parallel and cross‑browser execution  
- Cloud execution using Selenium Grid / SaaS providers  
- Page Object Model (POM) refactor  
- External test data (Excel/CSV/JSON)  
- Advanced reporting (Extent / Allure)  
- BDD with Cucumber
