package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends PageObject{
    private final WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }


    private final By titleRadioBtn = By.id("uniform-id_gender1");
    private final By firstNameInput = By.id("customer_firstname");
    private final By lastNameInput = By.id("customer_lastname");
    private final By passwordInput = By.id("passwd");
    private final By daysFromDropDownSelector = By.id("days");
    private final By monthsFromDropDownSelector = By.id("months");
    private final By yearsFromDropDownSelector = By.id("years");
    private final By registerBtn = By.id("submitAccount");
    private final By alertTextElement = By.cssSelector("#center_column > p.alert.alert-success");

    //        tick the title
    private WebElement getRadioBtn() {
        return getWebElement(titleRadioBtn);
    }

    public SignUpPage tickTitle() {
        getRadioBtn().click();
        return this;
    }


    //        enter first name
    private WebElement getFirstNameInput() {
        return getWebElement(firstNameInput);
    }
    public SignUpPage enterFirstName(final String firstName) {
        getFirstNameInput().sendKeys(firstName);
        return this;
    }

    public String getFirstNameFromInputField() {
        return getFirstNameInput().getAttribute("value");
    }



    //        enter last name
    private WebElement getLastNameInput() {
        return getWebElement(lastNameInput);
    }
    public SignUpPage enterLastName(final String lastName) {
        getLastNameInput().sendKeys(lastName);
        return this;
    }
    public String getLastNameFromInputField() {
        return getLastNameInput().getAttribute("value");
    }


    //        enter password
    private WebElement getPassword() {
        return getWebElement(passwordInput);
    }
    public SignUpPage enterPassword(final String password) {
        getPassword().sendKeys(password);
        return this;
    }
    public String getPasswordFromInputField() {
        return getPassword().getAttribute("value");
    }



    //    select from days dropdown
    private WebElement getDaysFromDropdown() {
        return getWebElement(daysFromDropDownSelector);
    }

    private Select daysFromDropdown() {
        return new Select(getDaysFromDropdown());
    }

    public SignUpPage selectDaysFromDropdown(final Integer day) {
        daysFromDropdown().selectByValue(String.valueOf(day));
        return this;
    }



    //    select from months dropdown
    private WebElement getMonthsFromDropdown() {
        return getWebElement(monthsFromDropDownSelector);
    }

    private Select monthsFromDropdown() {
        return new Select(getMonthsFromDropdown());
    }

    public SignUpPage selectMonthsFromDropdown(final Integer month) {
        monthsFromDropdown().selectByValue(String.valueOf(month));
        return this;
    }



    //    select from years dropdown
    private WebElement getYearsFromDropdown() {
        return getWebElement(yearsFromDropDownSelector);
    }

    private Select yearsFromDropdown() {
        return new Select(getYearsFromDropdown());
    }

    public SignUpPage selectYearsFromDropdown(final Integer years) {
        yearsFromDropdown().selectByValue(String.valueOf(years));
        return this;
    }



//    click on register button
    private WebElement getRegisterBtn() {
        return getWebElement(registerBtn);
    }

    public SignUpPage clickRegisterBtn() {
        getRegisterBtn().click();
        return this;
    }



    private WebElement getAlertElement() {
        return getWebElement(alertTextElement);
    }

    public SignUpPage getAlertSuccessText() {
       getAlertElement().getText().trim();
       return this;
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
    }

    public void waitForRegistrationCompletion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertTextElement));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(alertTextElement, "Your account has been created."));
    }



}
