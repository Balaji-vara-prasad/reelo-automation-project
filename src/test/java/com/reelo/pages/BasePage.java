package com.reelo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected WebElement waitVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void click(By by) {
        waitClickable(by).click();
    }

    protected void type(By by, String text) {
        WebElement el = waitVisible(by);
        // Select all text
        el.sendKeys(Keys.CONTROL + "a");

        // Delete it
        el.sendKeys(Keys.BACK_SPACE);
        el.sendKeys(text);
    }

    protected String getText(By by) {
        return waitVisible(by).getText();
    }

    protected void safeClick(By locator) {
        try {
            // wait for visibility, then scroll into view, then wait for clickable
            WebElement el = waitVisible(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'})", el);
            waitClickable(locator); // still try a clickable wait
            el.click(); // normal click
        } catch (Exception e) {
            // fallback to JS click
            try {
                WebElement el = driver.findElement(locator); // fresh reference
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
            } catch (Exception ex) {
                // last resort: use Actions moveToElement then click
                try {
                    WebElement el = driver.findElement(locator);
                    new Actions(driver).moveToElement(el).click().perform();
                } catch (Exception exc) {
                    throw new RuntimeException("Unable to click element: " + locator, exc);
                }
            }
        }
    }
}

