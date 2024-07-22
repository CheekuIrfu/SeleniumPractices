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

public class Menu {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


            driver.get("https://www.google.com");

            driver.get("https://demoqa.com/");

            WebElement widgetsOption = driver.findElement(By.xpath("(//div/child::h5['Widgets'])[4]"));
            widgetsOption.click();

          //  Thread.sleep(3000);

            WebElement menuOption = driver.findElement(By.xpath("//span[text()='Menu']"));
            menuOption.click();

           // Thread.sleep(3000);

            WebElement mainItem1 = driver.findElement(By.xpath("//a[text()='Main Item 1']"));
            mainItem1.click();
            System.out.println("Main item 1 clicked");

            //Thread.sleep(1000);

            WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
            mainItem2.click();
            System.out.println("Main item 2 clicked");

           // Thread.sleep(1000);

            WebElement mainItem3 = driver.findElement(By.xpath("//a[text()='Main Item 3']"));
            mainItem3.click();
            System.out.println("Main item 3 clicked");

        }
    }

