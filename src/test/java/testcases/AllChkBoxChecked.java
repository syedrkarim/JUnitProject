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

public class AllChkBoxChecked extends TestBase {

	HomePage HomePageObj;

	@Before()
	public void setUp() {
		initDriver();
		HomePageObj = PageFactory.initElements(driver, HomePage.class);
	}

	@Test()
	public void validateAllChkBoxChecked() {

		HomePageObj.deleteAllChkBox();

		HomePageObj.createChkBox("Selenium");
		HomePageObj.createChkBox("Appium");
		HomePageObj.createChkBox("RESTApi");
		HomePageObj.toggleAllChkBox();

		List<WebElement> allCheckBox = driver
				.findElements(By.xpath("//li[@style='font-size: 16px']//input[@type='checkbox']"));

		for (WebElement chkBox : allCheckBox) {
			Assert.assertTrue(chkBox.isSelected());
		}

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
