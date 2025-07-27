package org.example;

import Enum.UserDOB;
import Enum.UserNames;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test
    void createAccount() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Faker faker = new Faker();
        homePage.openHomePage();

        homePage.enterEmail(faker.internet().emailAddress());
        homePage.clickCreateAccountBtn();

        SignUpPage signUpPage = new SignUpPage(driver);
        Thread.sleep(5000L);

        signUpPage.enterFirstName(UserNames.TOM.getDisplayText());
        signUpPage.enterLastName(UserNames.SMITH.getDisplayText());
        signUpPage.enterPassword(UserNames.PASSWORD.getDisplayText());
        signUpPage.selectDaysFromDropdown(UserDOB.DAY_OF_BIRTH.getDropdownValue());
        signUpPage.selectMonthsFromDropdown(UserDOB.MONTH_OF_BIRTH.getDropdownValue());
        signUpPage.selectYearsFromDropdown(UserDOB.YEAR_OF_BIRTH.getDropdownValue());

        verifyDetailsInSignUpForm();
        signUpPage.clickRegisterBtn();
        Thread.sleep(5000L);
    }

    private void verifyDetailsInSignUpForm() {
        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertEquals(signUpPage.getFirstNameFromInputField(), UserNames.TOM.getDisplayText());
        Assert.assertEquals(signUpPage.getLastNameFromInputField(), UserNames.SMITH.getDisplayText());
        Assert.assertEquals(signUpPage.getPasswordFromInputField(), UserNames.PASSWORD.getDisplayText());
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}