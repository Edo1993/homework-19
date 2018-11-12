package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver driver;
    private Select select;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com/");

    }
    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.name("userName"));
        loginField.sendKeys("test1");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("test1");
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        driver.findElement(By.xpath(".//*[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
        WebElement typeButton = driver.findElement(By.xpath(".//*[@name='tripType' and contains (@value,'oneway')]"));
        typeButton.click();
        WebElement listPassengers = driver.findElement(By.xpath(".//*[@name='passCount']"));
        getSelect(listPassengers);
        select.selectByValue("2");
        WebElement selectedPassengers = select.getFirstSelectedOption();
        Assert.assertEquals("2 ",selectedPassengers.getText());
        WebElement listFrom = driver.findElement(By.xpath(".//*[@name='fromPort']"));
        getSelect(listFrom);
        select.selectByValue("Paris");
        WebElement selectedFrom = select.getFirstSelectedOption();
        Assert.assertEquals("Paris",selectedFrom.getText());
        WebElement listOnMonth = driver.findElement(By.xpath(".//*[@name='fromMonth']"));
        getSelect(listOnMonth);
        select.selectByValue("11");
        WebElement selectedOnMonth = select.getFirstSelectedOption();
        Assert.assertEquals("November",selectedOnMonth.getText());
        WebElement listOnDay = driver.findElement(By.xpath(".//*[@name='fromDay']"));
        getSelect(listOnDay);
        select.selectByValue("20");
        WebElement selectedOnDay = select.getFirstSelectedOption();
        Assert.assertEquals("20",selectedOnDay.getText());
        WebElement listTo = driver.findElement(By.xpath(".//*[@name='toPort']"));
        getSelect(listTo);
        select.selectByValue("Seattle");
        WebElement selectedTo = select.getFirstSelectedOption();
        Assert.assertEquals("Seattle",selectedTo.getText());
        WebElement listToMonth = driver.findElement(By.xpath(".//*[@name='toMonth']"));
        getSelect(listToMonth);
        select.selectByValue("12");
        WebElement selectedToMonth = select.getFirstSelectedOption();
        Assert.assertEquals("December",selectedToMonth.getText());
        WebElement listToDay = driver.findElement(By.xpath(".//*[@name='toDay']"));
        getSelect(listToDay);
        select.selectByValue("19");
        WebElement selectedToDay = select.getFirstSelectedOption();
        Assert.assertEquals("19",selectedToDay.getText());
        WebElement classButton = driver.findElement(By.xpath(".//*[@name='servClass' and contains (@value,'Business')]"));
        classButton.click();
        WebElement listAirline = driver.findElement(By.xpath(".//*[@name='airline']"));
        getSelect(listAirline);
        select.selectByIndex(3);
        WebElement selectedAirline = select.getFirstSelectedOption();
        Assert.assertEquals("Pangea Airlines",selectedAirline.getText());
        WebElement continueButton = driver.findElement(By.xpath(".//*[@name='findFlights' and contains (@src,'/images/forms/continue.gif')]"));
        continueButton.click();

        driver.findElement(By.xpath(".//*[@src='/images/masts/mast_selectflight.gif']")).isDisplayed();
        Assert.assertEquals(driver.getPageSource().contains(" Paris to Seattle"), true);
        Assert.assertEquals(driver.getPageSource().contains(" 11/20/2018"), true);
        WebElement departButton = driver.findElement(By.xpath(".//*[@name='outFlight' and contains (@value,'Unified Airlines$363$281$11:24')]"));
        departButton.click();
        Assert.assertEquals(driver.getPageSource().contains(" Seattle to Paris"), true);
        Assert.assertEquals(driver.getPageSource().contains(" 12/19/2018"), true);
        WebElement returnButton = driver.findElement(By.xpath(".//*[@name='inFlight' and contains (@value,'Blue Skies Airlines$631$273$14:30')]"));
        returnButton.click();
        WebElement continueButton2 = driver.findElement(By.xpath(".//*[@name='reserveFlights' and contains (@src,'/images/forms/continue.gif')]"));
        continueButton2.click();


        driver.findElement(By.xpath(".//*[@src='/images/masts/mast_book.gif']")).isDisplayed();
        Assert.assertEquals(driver.getPageSource().contains("Paris to Seattle"), true);
        Assert.assertEquals(driver.getPageSource().contains(" 11/20/2018"), true);
        Assert.assertEquals(driver.getPageSource().contains("FLIGHT"), true);
        Assert.assertEquals(driver.getPageSource().contains(" Unified Airlines 363"), true);
        Assert.assertEquals(driver.getPageSource().contains("CLASS"), true);
        Assert.assertEquals(driver.getPageSource().contains(" Business"), true);
        Assert.assertEquals(driver.getPageSource().contains("PRICE"), true);
        Assert.assertEquals(driver.getPageSource().contains(" 281 "), true);
        Assert.assertEquals(driver.getPageSource().contains(" Seattle to Paris"), true);
        Assert.assertEquals(driver.getPageSource().contains(" 12/19/2018"), true);
        Assert.assertEquals(driver.getPageSource().contains("FLIGHT"), true);
        Assert.assertEquals(driver.getPageSource().contains(" Blue Skies Airlines 631"), true);
        Assert.assertEquals(driver.getPageSource().contains("CLASS"), true);
        Assert.assertEquals(driver.getPageSource().contains("Business"), true);
        Assert.assertEquals(driver.getPageSource().contains("PRICE"), true);
        Assert.assertEquals(driver.getPageSource().contains(" 273"), true);
        Assert.assertEquals(driver.getPageSource().contains("Passengers:"), true);
        Assert.assertEquals(driver.getPageSource().contains("2"), true);
        Assert.assertEquals(driver.getPageSource().contains(" Taxes:"), true);
        Assert.assertEquals(driver.getPageSource().contains("$91"), true);
        Assert.assertEquals(driver.getPageSource().contains(" Total Price (including taxes):"), true);
        Assert.assertEquals(driver.getPageSource().contains("$1199"), true);
        WebElement firstNameOne= driver.findElement(By.name("passFirst0"));
        firstNameOne.sendKeys("Ivanov");
        WebElement lastNameOne= driver.findElement(By.name("passLast0"));
        lastNameOne.sendKeys("Ivan");
        WebElement mealOne = driver.findElement(By.xpath(".//*[@name='pass.0.meal']"));
        getSelect(mealOne);
        select.selectByValue("HNML");
        WebElement selectedMealOne = select.getFirstSelectedOption();
        Assert.assertEquals("Hindu",selectedMealOne.getText());
        WebElement firstNameTwo= driver.findElement(By.name("passFirst1"));
        firstNameTwo.sendKeys("Ivanova");
        WebElement lastNameTwo= driver.findElement(By.name("passLast1"));
        lastNameTwo.sendKeys("Irina");
        WebElement mealTwo = driver.findElement(By.xpath(".//*[@name='pass.1.meal']"));
        getSelect(mealTwo);
        select.selectByValue("BLML");
        WebElement selectedMealTwo = select.getFirstSelectedOption();
        Assert.assertEquals("Bland",selectedMealTwo.getText());
        WebElement cardType = driver.findElement(By.xpath(".//*[@name='creditCard']"));
        getSelect(cardType);
        select.selectByValue("BA");
        WebElement selectedCardType = select.getFirstSelectedOption();
        Assert.assertEquals("Visa",selectedCardType.getText());
        WebElement cardNumber= driver.findElement(By.name("creditnumber"));
        cardNumber.sendKeys("5479540454132487");
        WebElement expirationOne = driver.findElement(By.xpath(".//*[@name='cc_exp_dt_mn']"));
        getSelect(expirationOne);
        select.selectByIndex(5);
        //WebElement selectedExpirationOne = select.getFirstSelectedOption();
        //Assert.assertEquals("05",selectedExpirationOne.getText());
        WebElement expirationTwo = driver.findElement(By.xpath(".//*[@name='cc_exp_dt_yr']"));
        getSelect(expirationTwo);
        select.selectByValue("2009");
        //WebElement selectedExpirationTwo = select.getFirstSelectedOption();
        //Assert.assertEquals("2009 ",selectedExpirationTwo.getText());
        WebElement firstNameCard= driver.findElement(By.name("cc_frst_name"));
        firstNameCard.sendKeys("Ivan");
        WebElement middleNameCard= driver.findElement(By.name("cc_mid_name"));
        middleNameCard.sendKeys("Ivanovich");
        WebElement lastNameCard= driver.findElement(By.name("cc_last_name"));
        lastNameCard.sendKeys("Ivanov");
        WebElement billingAddress= driver.findElement(By.name("billAddress1"));
        billingAddress.clear();
        billingAddress.sendKeys("1085 Borregas Ave.");
        WebElement billingCity= driver.findElement(By.name("billCity"));
        billingCity.clear();
        billingCity.sendKeys("Albuquerque");
        WebElement billingState= driver.findElement(By.name("billState"));
        billingState.clear();
        billingState.sendKeys("New Mexico");
        WebElement billingZipCode= driver.findElement(By.name("billZip"));
        billingZipCode.clear();
        billingZipCode.sendKeys("94089");
        WebElement billingCountry = driver.findElement(By.xpath(".//*[@name='billCountry']"));
        getSelect(billingCountry);
        select.selectByValue("215");
        WebElement selectedBillCountry = select.getFirstSelectedOption();
        Assert.assertEquals("UNITED STATES ",selectedBillCountry.getText());
        WebElement checkboxSameAsBill = driver.findElement(By.xpath(".//font[contains(.,'Same as Billing Address')]/../input"));
        checkboxSameAsBill.click();
        WebElement deliveryAddress= driver.findElement(By.name("delAddress1"));
        deliveryAddress.clear();
        deliveryAddress.sendKeys("1225 Borregas Ave.");
        WebElement deliveryCity= driver.findElement(By.name("delCity"));
        deliveryCity.clear();
        deliveryCity.sendKeys("Boston");
        WebElement deliveryState= driver.findElement(By.name("delState"));
        deliveryState.clear();
        deliveryState.sendKeys("Massachusetts");
        WebElement deliveryZipCode= driver.findElement(By.name("delZip"));
        deliveryZipCode.clear();
        deliveryZipCode.sendKeys("91089");
        WebElement deliveryCountry = driver.findElement(By.xpath(".//*[@name='delCountry']"));
        getSelect(deliveryCountry);
        select.selectByValue("215");
        WebElement selectedDeliveryCountry = select.getFirstSelectedOption();
        Assert.assertEquals("UNITED STATES ",selectedDeliveryCountry.getText());
        WebElement buttonSecurePurchase = driver.findElement(By.xpath(".//*[@name='buyFlights' and contains (@src,'/images/forms/purchase.gif')]"));
        buttonSecurePurchase.click();


        driver.findElement(By.xpath(".//*[@src='/images/masts/mast_confirmation.gif']")).isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath(".//font[contains(.,'Departing')]/following::font[1]/b")).getText().contains("Paris to Seattle"));
        Assert.assertTrue(driver.findElement(By.xpath(".//font[contains(.,'Departing')]/following::font[1]")).getText().contains("11/20/2018"));
        Assert.assertTrue(driver.findElement(By.xpath(".//font[contains(.,'Departing')]/following::font[1]")).getText().contains("Unified Airlines 363"));
        Assert.assertTrue(driver.findElement(By.xpath(".//font[contains(.,'Returning')]/following::font[1]/b")).getText().contains("Seattle to Paris"));
        Assert.assertTrue(driver.findElement(By.xpath(".//font[contains(.,'Returning')]/following::font[1]")).getText().contains("12/19/2018"));
        Assert.assertTrue(driver.findElement(By.xpath(".//font[contains(.,'Returning')]/following::font[1]")).getText().contains("Blue Skies Airlines 631"));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Passengers')]/following::font[1]")).getText().contains("2 passengers"));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Billed To')]/following::font[1]")).getText().contains("Ivan Ivanovich Ivanov"));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Billed To')]/following::font[1]")).getText().contains("1085 Borregas Ave."));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Billed To')]/following::font[1]")).getText().contains("Albuquerque, New Mexico, 94089"));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Billed To')]/following::font[2]")).getText().contains("AX 0"));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Delivery Address')]/following::font[1]")).getText().contains("1225 Borregas Ave."));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Delivery Address')]/following::font[1]")).getText().contains("Boston, Massachusetts, 91089"));
        Assert.assertTrue(driver.findElement(By.xpath(".//b[contains(.,'Price (including taxes):')]/following::b[2]")).getText().contains("$1199 USD"));
        WebElement backToHomeButton = driver.findElement(By.xpath(".//*[@src='/images/forms/home.gif']"));
        backToHomeButton.click();
       }
    @AfterClass
    public static void exit() {
        driver.quit();
    }
    }
