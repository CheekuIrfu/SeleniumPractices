package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Form {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // Step 1: Open DEMOQA.com
            driver.get("https://demoqa.com");

            // Step 2: Scroll down to "Forms" section and click using text-based XPath
            WebElement formsSection = driver.findElement(By.xpath("//h5[text()='Forms']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formsSection);
            formsSection.click();

            // Step 3: Scroll down to "Practice Form" menu item and click using text-based XPath
            WebElement practiceFormMenuItem = driver.findElement(By.xpath("//span[text()='Practice Form']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", practiceFormMenuItem);
            practiceFormMenuItem.click();

            // Step 4: Enter the first name
            driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("John");

            // Step 5: Enter the last name
            driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Doe");

            // Step 6: Enter the email
            driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("john.doe@example.com");

            // Step 7: Choose the male gender
            driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[1]/label")).click();

            // Step 8: Enter the mobile number
            driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys("1234567890");

            // Step 9: Enter the subject
            WebElement subjectField = driver.findElement(By.xpath("//*[@id='subjectsContainer']/div/div[1]"));
            subjectField.sendKeys("Computer Science");
            subjectField.sendKeys(Keys.TAB); // To ensure the entered subject is selected

            // Step 10: Choose the sports option
            driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label")).click();

            // Step 11: Choose the random picture to upload
            driver.findElement(By.xpath("//*[@id='uploadPicture']")).sendKeys("C:\\path\\to\\your\\image.jpg"); // Replace with the path to your image

            // Step 12: Enter random address
            driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys("123 Main St, Anytown, USA");

            // Step 13: Select the state and city
            WebElement stateDropdown = driver.findElement(By.xpath("//*[@id='state']/div/div[1]"));
            stateDropdown.click();
            WebElement stateOption = driver.findElement(By.xpath("//div[contains(text(),'NCR')]"));
            stateOption.click();

            WebElement cityDropdown = driver.findElement(By.xpath("//*[@id='city']/div/div[1]"));
            cityDropdown.click();
            WebElement cityOption = driver.findElement(By.xpath("//div[contains(text(),'Delhi')]"));
            cityOption.click();

            // Step 14: Click the submit button
            driver.findElement(By.xpath("//*[@id='submit']")).click();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
