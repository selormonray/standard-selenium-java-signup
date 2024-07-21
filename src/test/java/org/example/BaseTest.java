package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
