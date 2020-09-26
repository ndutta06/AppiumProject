package AppiumProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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

public class Activity4 {
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
	public void google_todolist() throws InterruptedException {
        this.driver.get("https://www.training-support.net/selenium");
        this.driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        this.driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textStartsWith(\"To-Do List\"))"));
        ((MobileElement)this.driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='To-Do List']"))).click();
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"))).sendKeys(new CharSequence[]{"Add tasks to list"});
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")"))).click();
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"))).sendKeys(new CharSequence[]{"Get number of tasks"});
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")"))).click();
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"))).sendKeys(new CharSequence[]{"Clear the list"});
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")"))).click();
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add tasks to list\")"))).click();
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Get number of tasks\")"))).click();
        ((MobileElement)this.driver.findElement(MobileBy.AndroidUIAutomator("text(\"Clear the list\")"))).click();
        System.out.println("Clear List");
    }
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}