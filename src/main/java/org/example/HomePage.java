package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObject{

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

      private final By createEmailInput = By.id("email_create");
    private final By createAccountButton = By.id("SubmitCreate");

    //        enter first name
    private WebElement getCreateEmailInput() {
        return getWebElement(createEmailInput);
    }
    public HomePage enterEmail(final String email) {
        getCreateEmailInput().sendKeys(email);
        return this;
    }



    private WebElement getCreateAccountButton() {
        return getWebElement(createAccountButton);
    }
    public HomePage clickCreateAccountBtn() {
       getCreateAccountButton().click();
       return this;
    }



}
