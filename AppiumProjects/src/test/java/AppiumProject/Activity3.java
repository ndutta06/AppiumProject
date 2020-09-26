package AppiumProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {
		// Set the Desired Capabilities
		DesiredCapabilities task = new DesiredCapabilities();
		task.setCapability("deviceId", "Z60E1818DA563168");
		task.setCapability("platformName", "android");
		task.setCapability("automationName", "UiAutomator2");
		task.setCapability("appPackage", "com.google.android.keep");
		task.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
		task.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(server, task);

	}

	@Test
	public void google_keep_reminder() {

		driver.findElementById("com.google.android.keep:id/new_note_button").click();
		driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("GoogleKeepTitle");
		driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("IBM");
		driver.findElementById("com.google.android.keep:id/menu_reminder").click();
		driver.findElementById("com.google.android.keep:id/save").click();

		driver.findElementByAccessibilityId("Open navigation drawer").click();

		boolean reminder_check = driver.findElementById("reminder_chip_text").isDisplayed();
		if (reminder_check == true) {
			AssertJUnit.assertEquals(reminder_check, true);
		} else {
			AssertJUnit.assertEquals(reminder_check, false);
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}