package com.reelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnboardingPage extends BasePage {
    By brandInput = By.xpath("//input[@id='store_name']");
    By nextBtn = By.xpath("//button[@type='submit']//span[text()='Next']");
    By selectIndustry = By.xpath("//div[text()='Select Industry']");
    By foodAndBeverage = By.xpath("//div[text()='Food & Beverage']");
    By selectCategory = By.xpath("//div[text()='Select Category']");
    By cloudKitchen = By.xpath("//div[text()='Cloud Kitchen (only delivery)']");
    By countStores = By.xpath("//input[@id='stores_count']");
    By streetAddress = By.xpath("//input[@id='address']");
    By state = By.xpath("//div[text()='Select state']");
    By selectedState = By.xpath("//div[text()='Andhra Pradesh']");
    By city = By.xpath("//input[@id='city']");
    By pinCode = By.xpath("//input[@id='zipcode']");
    By billingSoftware = By.xpath("//div[text()='Petpooja']");
    By checkBox = By.xpath("(//input[@type='checkbox'])[1]");
    By finish = By.xpath("//button[@type='submit']//span[text()='Finish']");



    public OnboardingPage(WebDriver driver) {
        super(driver);
    }

    // returns true if onboarding was handled
    public boolean handleIfPresent(String brandName, String storesCount, String address, String cityName, String pincode) {
        try {
            waitVisible(brandInput);      // this waits instead of Thread.sleep()
        } catch (Exception e) {
            return false;  // onboarding not shown → do nothing
        }

        //type(brandInput, brandName);
        click(nextBtn);
        //safeClick(selectIndustry);
        //click(selectIndustry);
        click(foodAndBeverage);
        click(foodAndBeverage);
        //click(selectCategory);
        click(cloudKitchen);
        click(cloudKitchen);

        try {
            waitVisible(countStores);      // this waits instead of Thread.sleep()

        } catch (Exception e) {
            return false;  // onboarding not shown → do nothing
        }

        safeClick(nextBtn);
        try {
            waitVisible(streetAddress);      // this waits instead of Thread.sleep()
            type(streetAddress, address);
        } catch (Exception e) {
            return false;  // onboarding not shown → do nothing
        }
        click(state);
        click(selectedState);
        try {
            waitVisible(city);      // this waits instead of Thread.sleep()
            type(city, cityName);
            waitVisible(pinCode);
            type(pinCode, pincode);

        } catch (Exception e) {
            return false;  // onboarding not shown → do nothing
        }
        safeClick(nextBtn);
        safeClick(billingSoftware);
        safeClick(billingSoftware);
        safeClick(nextBtn);
        safeClick(checkBox);
        safeClick(finish);



        return true;
    }
}

