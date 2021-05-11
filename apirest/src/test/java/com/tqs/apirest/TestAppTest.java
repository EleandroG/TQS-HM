package com.tqs.apirest;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class TestAppTest {
  private WebDriver driver;
  private Map<String, Object> vars;

  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testApp() {
    driver.get("http://localhost:8080/AirQuality/home");
    driver.manage().window().setSize(new Dimension(1195, 892));
    driver.findElement(By.linkText("Madrid")).click();
    driver.findElement(By.linkText("Valencia")).click();
    driver.findElement(By.linkText("Vigo")).click();
    driver.findElement(By.linkText("Valladolid")).click();
    driver.findElement(By.linkText("Bilbao")).click();
    driver.findElement(By.linkText("Coruña")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("WAQI")).click();
  }

}
