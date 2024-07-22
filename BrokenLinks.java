//package org.example;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//public class BrokenLinks {
//    public static void main(String[] args) {
//        // Setup ChromeOptions
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-extensions");
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait
//
//        try {
//            // Open google.com
//            driver.get("https://www.google.com");
//
//            // Open DEMOQA website
//            driver.get("https://demoqa.com");
//
//            // Click the "Elements" option
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement elementsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div")));
//            elementsOption.click();
//
//            // Click the "Broken Links - Images" option
//            WebElement brokenLinksOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-6']")));
//            brokenLinksOption.click();
//
//            // Click the "Click Here for Valid Link" link
//            WebElement validLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div/div[2]/div[2]/a[1]")));
//            validLink.click();
//
//            // Switch to the new tab, wait for the page to load, close the tab, and switch back
//            switchToNewTab(driver);
//            Thread.sleep(3000);  // Wait for the page to load
//            driver.close();  // Close the new tab
//            driver.switchTo().window(driver.getWindowHandles().iterator().next());  // Switch back to the original tab
//            driver.navigate().to("https://demoqa.com/");
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            // Close the browser
//            driver.quit();
//        }
//    }
//
//    private static void switchToNewTab(WebDriver driver) {
//        String originalWindow = driver.getWindowHandle();
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(originalWindow)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//    }
//}

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

public class BrokenLinks {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait

        try {
            // Open google.com
            driver.get("https://www.google.com");

            // Open DEMOQA website
            driver.get("https://demoqa.com");

            // Click the "Elements" option
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement elementsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div")));
            elementsOption.click();

            // Click the "Broken Links - Images" option
            WebElement brokenLinksOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-6']")));
            brokenLinksOption.click();

            // Click the "Click Here for Broken Link" link
            WebElement brokenLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div/div[2]/div[2]/a[2]")));
            brokenLink.click();

            // Switch to the new tab, wait for the page to load, close the tab, and switch back
            switchToNewTab(driver);
            Thread.sleep(3000);  // Wait for the page to load
            driver.close();  // Close the new tab
            driver.switchTo().window(driver.getWindowHandles().iterator().next());  // Switch back to the original tab
            driver.navigate().to("https://demoqa.com/");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void switchToNewTab(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
