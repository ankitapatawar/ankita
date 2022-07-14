package KitePom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	
	private static final String UD = null;
	//1. data member
	@FindBy(xpath = "//span[@class='user-id']")private WebElement userName;
	@FindBy(xpath = "//a[@target='_self']") private WebElement logOutButton;
	
	//2. constructor
	 public KiteHomePage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //3. methods
	  
	 public void validateUsername(String ExpectedUserID)
	 {
		 String expectedUserName=ExpectedUserID;
		 String actualUserName = userName.getText();
		 
		 if(expectedUserName.equals(actualUserName))
		 {
			 System.out.println("actual and expected user id is matching TC is passed");
		 }
		 
		 else
		 {
			 System.out.println("actual and expected user id is not matching TC is failed");
		 }
		 
		 
	 }
	 public String actualUserName()
	 {
		 String actualUserName = userName.getText();
		return actualUserName;
	 }
	 
	 public void clickOnLogout() 
	 {
		 userName.click();
		 logOutButton.click();
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
