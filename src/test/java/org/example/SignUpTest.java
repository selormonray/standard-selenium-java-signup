package org.example;

import Enum.UserDOB;
import Enum.UserNames;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private String userEmail;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        userEmail = new Faker().internet().emailAddress();
    }

    @Test
    void shouldCreateNewUserAccount() {
        // Start sign up process
        homePage.openHomePage()
                .enterEmail(userEmail)
                .clickCreateAccountBtn();
        // Fill registration form
        signUpPage.waitForPageLoad();
        fillUserDetails();

        // Verify entered details
        verifyDetailsInSignUpForm();

        // Complete registration
        signUpPage.clickRegisterBtn();
        signUpPage.waitForRegistrationCompletion();
    }




    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}