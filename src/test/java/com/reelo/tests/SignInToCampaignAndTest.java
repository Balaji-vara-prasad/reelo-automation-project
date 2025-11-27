package com.reelo.tests;

import com.reelo.pages.*;
import com.reelo.utils.WebDriverFactory;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class SignInToCampaignAndTest {

    private WebDriver driver;
    // Replace these with your real login or pass via -D
    private final String email = System.getProperty("login.email", "pdkvara@gmail.com");
    private final String password = System.getProperty("login.password", "Myreelopass1@");
//    private final String phone = System.getProperty("phone", "+911234567890");
//    private final String name = System.getProperty("name", "Balaji");

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.create();
    }

    @Test
    public void loginAndConfigureCampaign() throws InterruptedException {
        // Login
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login(email, password);
        //Thread.sleep(5000);

        // handle onboarding if present
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.handleIfPresent("AutomationBrand","1","Rajiv Nagar", "Palamaner", "517408");


        CampaignsPage campaignsPage = new CampaignsPage(driver);
        campaignsPage.openCampaigns();
        campaignsPage.openTemplate();
        Thread.sleep(2000);
        campaignsPage.chooseTemplate();
        campaignsPage.nextBtn();
        campaignsPage.campaignTitle();
        campaignsPage.nextBtn();
        Thread.sleep(5000);
        campaignsPage.nextBtn();
        Thread.sleep(2000);
        campaignsPage.nextBtn();
        Thread.sleep(2000);
        campaignsPage.enterNameWithSMS();
        Thread.sleep(2000); //wait is used only for video demonstration purpose
        campaignsPage.nextBtn();
        campaignsPage.enterNumToTriggerTest();
        campaignsPage.selectSaveAndExit();
        Thread.sleep(5000); //wait is used only for video demonstration purpose

    }

    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
    }
}

