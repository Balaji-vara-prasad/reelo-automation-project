package com.reelo.tests;


import com.reelo.pages.SignUpPage;
import com.reelo.pages.LoginPage;
import com.reelo.utils.WebDriverFactory;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.time.Instant;
import java.util.UUID;

public class SignUpAndLoginTest {

    private WebDriver driver;
    private String email;
    private String password = "Myreelopass1@";

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.create();
    }

    @Test
    public void signupThenLogin() throws InterruptedException {
        // create unique email to avoid clashes
        email = "pdkvara@gmail.com";
        String name = "P Balaji Vara Prasad";
        String phone = System.getProperty("phone", "9160872571"); // override if you want

        SignUpPage sign = new SignUpPage(driver);
        sign.open();
        sign.signUp(name, email, phone, password);

        // wait for redirect to dashboard or any confirmation - adjust wait if needed
        Thread.sleep(5000);

        // now logout if auto logged in, or go to login and verify successful login
        // We'll attempt to open login and log in to confirm credentials
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login(email, password);

        // small pause to let dashboard load
        Thread.sleep(5000);
    }


    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

