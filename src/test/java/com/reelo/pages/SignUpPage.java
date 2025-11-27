package com.reelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    // NOTE: adjust selectors if dev.reelo.io uses different attributes
      By Name = By.xpath("//input[@id='name']");
      By Email = By.xpath("//input[@id='email']");
      By MobileNumber = By.xpath("//input[@id='number']");
      By passwordInput = By.xpath("//input[@id='password']");
      By signUpButton = By.xpath("//button[@type='submit']");


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://dev.reelo.io/signup");
    }

    public void signUp(String name, String email, String number, String password) {
        type(Name, name);
        type(Email, email);
        type(MobileNumber, number);
        type(passwordInput, password);
        click(signUpButton);
    }
}

