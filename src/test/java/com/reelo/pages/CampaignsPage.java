package com.reelo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampaignsPage extends BasePage {

    By campaignsMenu = By.xpath("//div[@class='menu']//span[text()='Campaigns']");
    By existingTemplate = By.xpath("//div[@class='objective']//h5[text()='National Cake Day (26th Nov)']");
    By closeButton = By.xpath("//button[@aria-label='Close']");
    By campaignTemplate = By.xpath("(//div[@class='campTemplate'])[1]");
    By customiseBtn = By.xpath("//span[text()='Customise and Send']");
    By unselectEmail = By.xpath("//h6[text()='Email']/following::input[@type='checkbox']");
    By commonNextBtn = By.xpath("//button[text()='Next']");
    By title = By.xpath("//input[@placeholder='Enter Title']");
    By context = By.xpath("//div[@class='prefix-value-suffix-row']");
    By phoneNumberColumn = By.xpath("//span[text()='Enter Contact Number']");
    By editSMS = By.xpath("//input[@placeholder='Select Store Name']");
    By phnNumberToTrigger = By.xpath("//input[@id='number']");
    By testCampaign = By.xpath("//span[text()='Test campaign']");
    By saveAndExit = By.xpath("//button[text()='Save and exit']");



    public CampaignsPage(WebDriver driver) {
        super(driver);
    }

    public void openCampaigns() {
        waitClickable(By.xpath("//div[@class='menu']//span[text()='Campaigns']"));
        safeClick(campaignsMenu);
    }

    public void openTemplate() {
        waitClickable(By.xpath("//div[@class='objective']//h5[text()='National Cake Day (26th Nov)']"));
        safeClick(existingTemplate);
        safeClick(closeButton);
    }

    public void chooseTemplate() {
        safeClick(campaignTemplate);
        click(customiseBtn);
        click(unselectEmail);

    }

    public void nextBtn() {
        safeClick(commonNextBtn);
    }

    public void campaignTitle() {
        type(title, "Slice, Smile, Repeat");
    }

//    public void enterNumber() {
//        waitClickable(context);
//        type(context, "9160872571");
//        type(phoneNumberColumn, "9160872571");
//
//    }
    public void enterNameWithSMS() {
        type(editSMS, "Balaji Automation Brand");
    }

    public void enterNumToTriggerTest() {
        type(phnNumberToTrigger, "9160872571");
        safeClick(testCampaign);
    }

    public void selectSaveAndExit() {
        safeClick(saveAndExit);
    }

}
