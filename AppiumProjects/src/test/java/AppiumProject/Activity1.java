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

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {
		// Set the Desired Capabilities
		DesiredCapabilities task = new DesiredCapabilities();
		task.setCapability("deviceId", "Z60E1818DA563168");
		task.setCapability("platformName", "android");
		task.setCapability("automationName", "UiAutomator2");
		task.setCapability("appPackage", "com.google.android.apps.tasks");
		task.setCapability("appActivity", ".ui.TaskListsActivity");
		task.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(server, task);

	}

	@Test
	public void google_task() throws InterruptedException {

		 Thread.sleep(10000);	  
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		  Thread.sleep(2000);
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		  Thread.sleep(2000);
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();  
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		  Thread.sleep(2000);
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		  Thread.sleep(2000);

		List<MobileElement> rows = driver.findElementsById("task_name");
		int row_num = rows.size();
		int act_num = 3;
		AssertJUnit.assertEquals(act_num, row_num);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
