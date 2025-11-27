package com.reelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailInput = By.cssSelector("input[name='email'], input#email");
    private By passwordInput = By.cssSelector("input[name='password'], input#password");
    private By loginButton = By.cssSelector("button[type='submit'], button.login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://dev.reelo.io/login");
    }

    public void login(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        click(loginButton);
    }
}

