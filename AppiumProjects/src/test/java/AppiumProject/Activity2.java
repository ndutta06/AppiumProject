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

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {
		// Set the Desired Capabilities
		DesiredCapabilities task = new DesiredCapabilities();
		task.setCapability("deviceId", "Z60E1818DA563168");
		task.setCapability("platformName", "android");
		task.setCapability("automationName", "UiAutomator2");
		task.setCapability("appPackage", "com.google.android.keep");
		task.setCapability("appActivity", ".activities.BrowseActivity");
		task.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(server, task);

	}

	@Test
	  public void google_keep() throws InterruptedException {
		
		  Thread.sleep(5000);
		  driver.findElementById("com.google.android.keep:id/new_note_button").click();
		  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("GoogleKeepTitle");
		  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("IBM");
		  Thread.sleep(2000);
	      driver.findElementByAccessibilityId("Open navigation drawer").click();    
	      
		  String title =driver.findElement(MobileBy.AndroidUIAutomator("text(\"GoogleKeepTitle\")")).getText();
		  AssertJUnit.assertEquals(title, "GoogleKeepTitle");
		  String note =driver.findElementById("index_note_text_description").getText();
		  AssertJUnit.assertEquals(note, "IBM");
	      
		  
		 
		  }

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
