package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {

    public WebDriver driver;

    protected WebElement getWebElement(By selector) {
        return driver.findElement(selector);
    }
}
