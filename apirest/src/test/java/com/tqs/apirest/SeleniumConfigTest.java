package com.tqs.apirest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfigTest {

    @Test
    public void SeleniumConfig() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        //Open browser == BeforeEach
        driver.get("http://localhost:8080/AirQuality/home");

        System.out.println(driver.getTitle());

        //Close browser == AfterEach
        driver.close();
    }
}
