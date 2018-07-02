package com.qainfotech.Automation.futurefuel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FutureFuelTest {
	
	WebDriver driver;
	HomePage homePage;
	
	@BeforeClass
	public void Launch() {
		System.setProperty("webdriver.chrome.driver","//home//qainfotech//Downloads//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://futurefuel.io/");
		homePage = new HomePage(driver);
	}
	
	@Test
	public void WatchFullVideoButtonTest() {
		homePage.ClickOnButton_WatchFullVideo();
		
	}
	
	@Test(dependsOnMethods= {"WatchFullVideoButtonTest"})
	public void LikeButtonTest() {
	    homePage.ValidateLikeButton();	
	}
	
	@Test(dependsOnMethods= {"WatchFullVideoButtonTest"})
	public void ShareButtonTest() {
		homePage.ValidateShareButton();
	}
	
	@Test(dependsOnMethods= {"WatchFullVideoButtonTest"})
	public void WatchLaterButtonTest() {
		homePage.ValidateWatchLaterButton();
	}
	
	@Test(dependsOnMethods= {"WatchFullVideoButtonTest"})
	public void PlayButtonTest() {
		homePage.ValidatePlayButton();
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.close();
	}
	

}
