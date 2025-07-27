package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.BrowserFactory.BASE_URL;

public class HomePage extends PageObject {
    private final By createEmailInput = By.id("email_create");
    private final By createAccountButton = By.id("SubmitCreate");
    private final By signInEmailInput = By.id("email");
    private final By passwordInput = By.id("passwd");
    private final By signInButton = By.id("SubmitLogin");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Sign Up Methods
    public HomePage enterEmail(String email) {
        getWebElement(createEmailInput).sendKeys(email);
        return this;
    }

    public HomePage clickCreateAccountBtn() {
        getWebElement(createAccountButton).click();
        return this;
    }

    // Sign In Methods
    public HomePage openSignInPage() {
        driver.get("http://www.automationpractice.pl/index.php?controller=my-account");
        return this;
    }

    public HomePage openHomePage() {
        driver.get(BrowserFactory.BASE_URL);
        return this;
    }

    public HomePage enterSignInEmail(String email) {
        getWebElement(signInEmailInput).sendKeys(email);
        return this;
    }

    public HomePage enterSignInPassword(String password) {
        getWebElement(passwordInput).sendKeys(password);
        return this;
    }

    public HomePage clickSignInButton() {
        getWebElement(signInButton).click();
        return this;
    }

    // Combined Methods for Better Flow
    public HomePage createNewAccount(String email) {
        enterEmail(email);
        clickCreateAccountBtn();
        return this;
    }

    public HomePage signIn(String email, String password) {
        enterSignInEmail(email);
        enterSignInPassword(password);
        clickSignInButton();
        return this;
    }
}