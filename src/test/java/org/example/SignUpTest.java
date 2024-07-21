package org.example;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Enum.UserDOB.*;
import static Enum.UserNames.*;

public class SignUpTest extends BaseTest {

    @Test
    void createAccount() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    Faker faker = new Faker();
    final String expectedAlertText = "Your account has been created.";

    homePage.enterEmail(faker.internet().emailAddress());
    homePage.clickCreateAccountBtn();

    SignUpPage signUpPage = new SignUpPage(driver);
    Thread.sleep(5000);
    signUpPage.enterFirstName(TOM.getDisplayText());
    signUpPage.enterLastName(SMITH.getDisplayText());
    signUpPage.enterPassword(PASSWORD.getDisplayText());
    signUpPage.selectDaysFromDropdown(DAY_OF_BIRTH.getDropdownValue());
    signUpPage.selectMonthsFromDropdown(MONTH_OF_BIRTH.getDropdownValue());
    signUpPage.selectYearsFromDropdown(YEAR_OF_BIRTH.getDropdownValue());
    verifyDetailsInSignUpForm();
    signUpPage.clickRegisterBtn();
    Thread.sleep(5000);
    Assert.assertEquals(signUpPage.getAlertSuccessText(), expectedAlertText, "Account creation was not successful");

    }

    public void verifyDetailsInSignUpForm() {
        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertEquals(signUpPage.getFirstNameFromInputField(), TOM.getDisplayText());
        Assert.assertEquals(signUpPage.getLastNameFromInputField(), SMITH.getDisplayText());
        Assert.assertEquals(signUpPage.getPasswordFromInputField(), PASSWORD.getDisplayText());
    }


}
