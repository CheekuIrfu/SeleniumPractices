package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Textbox {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait

        try {
            driver.get("https://demoqa.com");
            WebElement elementsOption = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div"));
            elementsOption.click();

            Thread.sleep(1000);

            WebElement textBoxOption = driver.findElement(By.xpath("//*[@id='item-0']"));
            textBoxOption.click();

            Thread.sleep(1000);

            WebElement fullName = driver.findElement(By.xpath("//*[@id='userName']"));
            fullName.sendKeys("John Doe");

            WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
            email.sendKeys("johndoe@example.com");

            WebElement currentAddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
            currentAddress.sendKeys("123 Main St, Springfield");

            WebElement permanentAddress = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
            permanentAddress.sendKeys("456 Elm St, Springfield");

            WebElement submitButton = driver.findElement(By.xpath("//*[@id='userForm']/div[5]/div"));
            submitButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement outputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

            if (outputBox.isDisplayed()) {
                System.out.println("Form submitted successfully and details displayed.");
            } else {
                System.out.println("Form submission failed or details not displayed.");
            }

            Thread.sleep(5000);

            driver.get("https://demoqa.com/thank-you");

            WebElement thankYouMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Thank You')]")));
            if (thankYouMessage.isDisplayed()) {
                System.out.println("Navigated to Thank You page successfully.");
            } else {
                System.out.println("Failed to navigate to Thank You page.");
            }

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
