package com.qainfotech.Automation.futurefuel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
		SwitchToVideoFrame();
		MakeInvisibleElementsPermanentlyVisible();
		

	}
	
	private void MakeInvisibleElementsPermanentlyVisible() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("play"))));
		js.executeScript("document.querySelector('.vp-controls').classList.remove('invisible')");
		js.executeScript("document.querySelector('.vp-controls').classList.remove('hidden')");
		js.executeScript("document.querySelector('.vp-controls').removeAttribute('hidden')");
		js.executeScript("document.querySelector('.vp-sidedock').classList.remove('invisible')");
		js.executeScript("document.querySelector('.vp-sidedock').classList.remove('hidden')");
		js.executeScript("document.querySelector('.vp-sidedock').removeAttribute('hidden')");
	}

	
	public void SwitchToVideoFrame() {
		driver.switchTo().frame("iframeVideo");

	}
	
	
	public void ValidateLikeButton() {
		boolean ans=driver.findElement(By.className("like-button")).isDisplayed();
        Assert.assertTrue(ans);
	}

	public void ValidateShareButton() {
	
		boolean ans=driver.findElement(By.className("share-button")).isDisplayed();
        Assert.assertTrue(ans);
	}

	public void ValidateWatchLaterButton() {

		boolean ans=driver.findElement(By.className("watch-later-button")).isDisplayed();
        Assert.assertTrue(ans);
	}

	public void ValidatePlayButton() {
		boolean ans=driver.findElement(By.className("play")).isDisplayed();
        Assert.assertTrue(ans);
	}
	
	
}
