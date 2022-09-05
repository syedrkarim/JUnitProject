package testcases;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import pages.HomePage;

public class SingleCheckBoxRemove extends TestBase {

	HomePage HomePageObj;

	@Before()
	public void setUp() {
		initDriver();
		HomePageObj = PageFactory.initElements(driver, HomePage.class);
	}

	@Test()
	public void validateSingleChkBoxRemove() {

		HomePageObj.deleteAllChkBox();

		HomePageObj.createChkBox("Selenium");
		HomePageObj.createChkBox("Appium");
		HomePageObj.createChkBox("RESTApi");

		List<WebElement> allCheckBox = driver
				.findElements(By.xpath("//li[@style='font-size: 16px']//input[@type='checkbox']"));
		System.out.println("List Before Delete: " + allCheckBox.size());

		driver.findElement(By.xpath("//li[@style='font-size: 16px']//input[@name='todo[1]']")).click();
		HomePageObj.removeChkBox();

		List<WebElement> checkBoxAfterDelete = driver
				.findElements(By.xpath("//li[@style='font-size: 16px']//input[@type='checkbox']"));
		System.out.println("List After Delete: " + checkBoxAfterDelete.size());

		Assert.assertFalse(allCheckBox.equals(checkBoxAfterDelete));

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
