package tests;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHomePage {

  private WebDriver driver;

  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
      driver.quit();
  }

  @Test
  public void verifySearchButton() {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://localhost:8080");
      WebElement selectUserButton = driver.findElement(By.id("dropdownMenuButton"));
      Assert.assertEquals(selectUserButton.getText(),"SELECT USER","Text not found!");
      selectUserButton.click();
      WebElement drowDownItem = driver.findElement(By.id("10021"));
      drowDownItem.click();
      WebElement userName = driver.findElement(By.id("userName"));
      Assert.assertEquals(userName.getText(), "Rick Thomas","User name not found!");
  }
}