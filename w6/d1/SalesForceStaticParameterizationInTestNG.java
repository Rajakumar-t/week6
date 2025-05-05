package hw.w6.d1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SalesForceStaticParameterizationInTestNG extends BaseClassSalesForce {

	@Parameters({ "url", "username", "password" })
	@Test
	public void parameteris(String url, String unmae, String pword) throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click the view button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// click the legal entities
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();

		// Click on new button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New']")).click();

		// input the entries as requested for company name and description
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");

		// xxxxxxxxxxxxThis is advance click that is been used. XXXXXXXXXXXXXXXXXXXXXX
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//label[text()='Status']//following::button"));
		driver.executeScript("arguments[0].click()", element);
		WebElement element2 = driver.findElement(By.xpath("//span[@title='Active']"));
		driver.executeScript("arguments[0].click()", element2);
		Thread.sleep(3000);

		// Click Save without filling Name
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		// Verify alert message for missing Name field
		Thread.sleep(2000);
		WebElement alertMsg = driver.findElement(By.xpath("//div[text()='Complete this field.']"));
		String actualMessage = alertMsg.getText();
		String expectedMessage = "Complete this field.";

		if (actualMessage.equals(expectedMessage)) {
			System.out.println(" Yes, verified");
		} else {
			System.out.println(" Verification failed: Expected ");
		}

	}

}
