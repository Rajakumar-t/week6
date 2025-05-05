package hw.w6.d1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseClassSalesForce {

	public FirefoxDriver driver;

	@Parameters ({"url","username","password"})
	
	@BeforeMethod
	public void precondition(String url, String username, String password) {
		FirefoxOptions ff = new FirefoxOptions();
		ff.addArguments("--disable-notifications");
		driver = new FirefoxDriver(ff);
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();

	}

	@AfterMethod
	public void postCondition() {
		driver.close();

	}
}
