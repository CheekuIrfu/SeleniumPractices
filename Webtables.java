package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Webtables {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open DEMOQA website
            driver.get("https://demoqa.com");

            // Click the "Elements" option
            WebElement elementsOption = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div"));
            elementsOption.click();

            // Click the "Web Tables" option
            WebElement webTablesOption = driver.findElement(By.xpath("//*[@id='item-3']"));
            webTablesOption.click();

            // Click the "Add" button
            WebElement addButton = driver.findElement(By.xpath("//*[@id='addNewRecordButton']"));
            addButton.click();

            // Fill the "First Name" field
            WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
            firstName.sendKeys("Virat");

            // Fill the "Last Name" field
            WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
            lastName.sendKeys("Kohli");

            // Fill the "Email" field
            WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
            email.sendKeys("cheeku@example.com");

            // Fill the "Age" field
            WebElement age = driver.findElement(By.xpath("//*[@id='age']"));
            age.sendKeys("35");

            // Fill the "Salary" field
            WebElement salary = driver.findElement(By.xpath("//*[@id='salary']"));
            salary.sendKeys("100000");

            // Fill the "Department" field
            WebElement department = driver.findElement(By.xpath("//*[@id='department']"));
            department.sendKeys("Engineering");

            // Click the "Submit" button
            WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
            submitButton.click();

            // Verify the new record in the web table
            WebElement newRecord = driver.findElement(By.xpath("//div[@class='rt-tr-group'][last()]"));
            if (newRecord.isDisplayed()) {
                System.out.println("New record added successfully.");
                System.out.println("Record details: " + newRecord.getText());
            } else {
                System.out.println("Failed to add new record.");
            }

            // Wait for a while to see the result
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
