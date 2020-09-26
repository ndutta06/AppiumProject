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

public class Activity5 {
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
	public void google_login() throws InterruptedException {
		this.driver.get("https://www.training-support.net/selenium");
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver.findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textStartsWith(\"Login Form\"))"));
		((MobileElement) this.driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Login Form']")))
				.click();
		Thread.sleep(2000L);
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")))
				.sendKeys(new CharSequence[] { "admin" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")))
				.sendKeys(new CharSequence[] { "password" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")"))).click();
		String confirm = ((MobileElement) this.driver
				.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"))).getText();
		System.out.println("confirm");
		AssertJUnit.assertEquals(confirm, "Welcome Back, admin");
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")"))).clear();
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")))
				.sendKeys(new CharSequence[] { "admin" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")"))).clear();
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")))
				.sendKeys(new CharSequence[] { "password123" });
		((MobileElement) this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")"))).click();
		String invalid = ((MobileElement) this.driver
				.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"))).getText();
		System.out.println("invalid");
		AssertJUnit.assertEquals(invalid, "Invalid Credentials");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}