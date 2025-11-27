package com.reelo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver create() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        // keep non-headless so reviewer can watch the run
        opts.addArguments("--start-maximized");
        return new ChromeDriver(opts);
    }
}

