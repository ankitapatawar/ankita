package KitePom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage {
	
	
	private static final CharSequence UN = null;
	private static final CharSequence PWD = null;
	//1. data member/variablr
	@FindBy(id = "userid")  private WebElement userName;
	@FindBy(id = "password") private WebElement password;
	@FindBy (xpath = "//button[@type='submit']") private WebElement login;
	
	
	
	//2. constructor
	
	public KiteLoginPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//3. methods
	
	public void sendUsername(String UserName)
	{
		userName.sendKeys(UserName);	
	}
	
	public void sendPassword(String passWord)
	{
		password.sendKeys(passWord);
	}
	
	public void clickOnLoginButton()
	{
		login.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
