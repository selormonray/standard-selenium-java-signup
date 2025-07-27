package org.example;

import Enum.UserNames;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {
    private WebDriver driver;
    private static String userEmail;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        if (userEmail == null) {
            userEmail = new Faker().internet().emailAddress();
        }
    }

    @Test(priority = 1)
    void createAccount() {
        HomePage homePage = new HomePage(driver);

        homePage.openHomePage();
        homePage.enterEmail(userEmail);
        homePage.clickCreateAccountBtn();
    }

    @Test(priority = 2)
    void signIn() {
        HomePage homePage = new HomePage(driver);

        homePage.openSignInPage()
                .enterSignInEmail(userEmail)
                .enterSignInPassword(UserNames.PASSWORD.getDisplayText())
                .clickSignInButton();
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}