package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_COOKIES = "//*[contains(@data-cookiebanner, 'accept_only_essential_button')]";
    public static final String XPATH_ACCOUNT = "//*[contains(@data-testid, 'open-registration-form-button')]";
    public static final String XPATH_DAY = "//select[1]";
    public static final String XPATH_MOUNTH = "//select[2]";
    public static final String XPATH_YEAR = "//select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath(XPATH_COOKIES)).click();

        driver.findElement(By.xpath(XPATH_ACCOUNT)).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Lukasz");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Testowy");

        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("test@test.com");

        WebElement emailConfirmation = driver.findElement(By.name("reg_email_confirmation__"));
        emailConfirmation.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("Test123%");

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_DAY));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(15);

        WebElement selectCombo2 = driver.findElement(By.xpath(XPATH_MOUNTH));
        Select selectBoard2 = new Select(selectCombo2);
        selectBoard2.selectByIndex(5);

        WebElement selectCombo3 = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectBoard3 = new Select(selectCombo3);
        selectBoard3.selectByIndex(20);

        WebElement sex = driver.findElement(By.name("sex"));
        sex.click();

    }
}
