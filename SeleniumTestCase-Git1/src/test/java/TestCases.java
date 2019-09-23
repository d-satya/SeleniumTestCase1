import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
	public static	WebDriver driver;

	  @Test (priority=1)
	  public void LaunchBrowser() {
		  System.setProperty("webdriver.chrome.driver","D:\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
	  }
	  
	  @Test (priority=2)
	  public void GettheURL() {
			driver.get("http://740.p3fusion.net/prweb");
			Assert.assertEquals("Pega Platform", driver.getTitle());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			System.out.print("Before Login the Page Title: " +driver.getTitle()+ "\n");
	  }
	  
	  @Test (priority=3)
	  public void GetUserNameandPassword() {
		  driver.findElement(By.cssSelector("#txtUserID")).sendKeys("pegatestuser");
			driver.findElement(By.cssSelector("#txtPassword")).sendKeys("rules");
			driver.findElement(By.cssSelector("#sub")).click();
			Assert.assertEquals("Pega Designer Studio", driver.getTitle());
			System.out.print("After Login the Page Title: " +driver.getTitle()+ "\n");
	  }
	  
	  @Test (priority=4)
	  public void GetLog() {
		  Assert.assertEquals(true, driver.findElement(By.cssSelector("#RULE_KEY > div > div > div > div.content-item.content-field.item-1.remove-left-spacing.remove-right-spacing.flex.flex-row.pega-7.dataValueWrite > span > i > img")).isDisplayed());
		  }
	  @Test (priority=5)
	  public void CloseBrowser() {
			driver.close();
			driver.quit();
	  }
}
