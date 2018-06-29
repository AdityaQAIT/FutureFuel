package com.qainfotech.Automation.futurefuel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HomePage {

	WebDriver driver;
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnButton_WatchFullVideo() {
		driver.findElement(By.cssSelector("button[data-target=\"#videoModal\"]")).click();
		String str = driver.findElement(By.cssSelector("div#videoModal")).getAttribute("style");
		Assert.assertTrue(str.contains("block"));
	}
	
	public void MoveMouseToFrame() {
		Actions hover = new Actions(driver);	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		hover.moveToElement(driver.findElement(By.cssSelector("div#player"))).build().perform();
	}
	
	public void SwitchToVideoFrame() {
		driver.switchTo().frame("iframeVideo");

	}
	
	public void SwitchBackFromVideoFrame() {
		driver.switchTo().defaultContent();
	}

	public void ValidateLikeButton() {
		SwitchToVideoFrame();
		MoveMouseToFrame();
		boolean ans=driver.findElement(By.className("like-button")).isDisplayed();
        Assert.assertTrue(ans);
        SwitchBackFromVideoFrame();
	}

	public void ValidateShareButton() {
		SwitchToVideoFrame();
		MoveMouseToFrame();
		boolean ans=driver.findElement(By.className("share-button")).isDisplayed();
        Assert.assertTrue(ans);
        SwitchBackFromVideoFrame();
	}

	public void ValidateWatchLaterButton() {
		SwitchToVideoFrame();
		MoveMouseToFrame();
		boolean ans=driver.findElement(By.className("watch-later-button")).isDisplayed();
        Assert.assertTrue(ans);
        SwitchBackFromVideoFrame();
	}
	
	
}
