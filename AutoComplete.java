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

public class AutoComplete {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait

        try {
            // Step 1: Open google.com
            driver.get("https://www.google.com");

            // Step 2: Open DEMOQA website
            driver.get("https://demoqa.com/");

            // Step 3: Click the Widgets option
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement widgetsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[4]")));
            widgetsOption.click();

            // Step 4: Navigate to Widgets URL
           // driver.get("https://demoqa.com/widgets");

            // Step 5: Click the Auto Complete option
            WebElement autoCompleteOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Auto Complete']/parent::li")));
            autoCompleteOption.click();

            // Step 6: Enter and clear value in the Type multiple color names textbox
            WebElement multipleColorsTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='autoCompleteMultipleContainer']/div/div[1]")));
            multipleColorsTextbox.sendKeys("123");
            Thread.sleep(2000); // Wait for 2 seconds to see the entered value
            multipleColorsTextbox.clear();

            // Step 7: Enter and clear value in the Type single color name textbox
            WebElement singleColorTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='autoCompleteSingleContainer']/div/div[1]")));
            singleColorTextbox.sendKeys("456");
            Thread.sleep(2000); // Wait for 2 seconds to see the entered value
            singleColorTextbox.clear();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
