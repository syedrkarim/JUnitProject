package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@class='advance-controls']/input[@type='text']")
	WebElement chkBoxText;
	
	@FindBy(xpath = "//div[@class='advance-controls']/input[@type='submit']")
	WebElement chkBoxButton;
	
	@FindBy(xpath = "//input[@name='allbox']")
	WebElement toggleAll;
	
	@FindBy(xpath = "//input[@value='Remove']")
	WebElement removeBtn;
	
	
	public void createChkBox(String chkBoxName) {
		chkBoxText.sendKeys(chkBoxName);
		chkBoxButton.click();
	}
	
	public void toggleAllChkBox() {
		toggleAll.click();
	}
	
	public void removeChkBox() {
		removeBtn.click();
	}
	
	
	public void deleteAllChkBox() {
		toggleAll.click();
		removeBtn.click();
	}
	
	
	

}
