package com.Maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String type) {
		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void inputValueElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static WebDriver close() {
		driver.close();
		return driver;
	}

	public static WebDriver quit() {
		driver.quit();
		return driver;
	}

	public static void dropDown(WebElement element, String type, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("selectByIndex")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data);
		} else if (type.equalsIgnoreCase("selectByValue")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("selectByVisibleText")) {
			s.selectByVisibleText(value);
		}
	}

	public static WebDriver get(String element) {
		driver.get(element);
		return driver;
	}

	public static WebDriver navigateTo(String element) {
		driver.navigate().to(element);
		return driver;
	}

	public static WebDriver navigateBack() {
		driver.navigate().back();
		return driver;
	}

	public static WebDriver navigateForward() {
		driver.navigate().forward();
		return driver;
	}

	public static WebDriver navigateRefresh() {
		driver.navigate().refresh();
		return driver;
	}

	public static void Action(WebElement element, String type) {
		Actions a = new Actions(driver);
		if (type.equalsIgnoreCase("click")) {
			a.click(element).build().perform();
		} else if (type.equalsIgnoreCase("rightclick")) {
			a.click(element).build().perform();
		}
	}

//	public static void dragAndDrop(WebElement dragelement,WebElement dropelement) {
//		Actions a=new Actions(driver);
//		String drag = driver.(dragelement); 
//		String drop = driver.(dropelement);
//		a.dragAndDrop(drag, drop).build().perform();
//		a.clickAndHold(drag).moveToElement(drag).release(drop).build().perform();
//	}
	public static void frames(WebElement element, int index, String type) {
		if (type.equalsIgnoreCase("index")) {
			driver.switchTo().frame(index);
		} else {
			driver.switchTo().frame(element);
		}
	}
	public static void robot(int key, String type) throws AWTException {
		Robot rob = new Robot();
		if (type.equalsIgnoreCase("keypress")) {
			rob.keyPress(key);
		} else if (type.equalsIgnoreCase("keyrelease")) {
			rob.keyRelease(key);
		}
	}
	public static WebDriver getTitle() {
		String title= driver.getTitle();
		System.out.println(title);
		return driver;
	}
	public static WebDriver currentUrl() {
		String curUrl = driver.getCurrentUrl();
		System.out.println(curUrl);
		return driver;
	}
	public static WebDriver getTitles() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			String title = driver.switchTo().window(window).getTitle();
			System.out.println("all window title:" + title);
	}
		return driver;
	}
}
