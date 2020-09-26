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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {
		// Set the Desired Capabilities
		DesiredCapabilities task = new DesiredCapabilities();
		task.setCapability("deviceId", "Z60E1818DA563168");
		task.setCapability("platformName", "android");
		task.setCapability("automationName", "UiAutomator2");
		task.setCapability("appPackage", "com.android.chrome");
		task.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		task.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(server, task);

	}

	@Test
	public void google_popup() throws InterruptedException {
		this.driver.get("https://www.training-support.net/selenium");
		Thread.sleep(10000L);
		this.driver.findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textStartsWith(\"Popups\"))"));
		((MobileElement) this.driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Popups']"))).click();
		this.driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")"))).click();
		Thread.sleep(2000L);
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")))
				.sendKeys(new CharSequence[] { "admin" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")))
				.sendKeys(new CharSequence[] { "password" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")"))).click();
		String success = ((MobileElement) this.driver
				.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"))).getText();
		System.out.println("success");
		AssertJUnit.assertEquals(success, "Welcome Back, admin");
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")"))).click();
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")"))).clear();
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")))
				.sendKeys(new CharSequence[] { "admin" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")"))).clear();
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")))
				.sendKeys(new CharSequence[] { "password123" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")"))).click();
		String failure = ((MobileElement) this.driver
				.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"))).getText();
		System.out.println("failure");
		AssertJUnit.assertEquals(failure, "Invalid Credentials");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}