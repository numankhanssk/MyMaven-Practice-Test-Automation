package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        try {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Jenkins/Linux safe mode
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);

            // Open SauceDemo
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Maximize (works in non-headless too; safe to keep)
            driver.manage().window().maximize();

            // Login steps
           driver.findElement(By.id("username")).sendKeys("student");
           driver.findElement(By.id("password")).sendKeys("Password123");
           driver.findElement(By.id("submit")).click();

            // Print after login
            System.out.println("TITLE AFTER LOGIN: " + driver.getTitle());

            // Close browser
            driver.quit();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
