package KiteTest;//


import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import KitePom.Base;
import KitePom.KiteHomePage;
import KitePom.KiteLoginPage;
import KitePom.KitePinPage;
import KitePom.Utility;



@Listeners(listener.Listener.class)
public class ValidateKiteUserID2PropertyFile extends Base{
	
	KiteLoginPage login;
	KitePom.KiteHomePage home;
	KitePinPage pin;
	String TCID="123";
	@Parameters("browsername")
	@BeforeClass
	public void launchBrowser(String name) throws IOException
	{
		if(name.equals("chrome"))
		{
			openchromeBrowser();
		}
		
		else if(name.equals("edge"))
		{
			openedgeBrowser(name);
		}
		login=new KiteLoginPage(driver);
		home=new KiteHomePage(driver);
		pin=new KitePinPage(driver);
	}
	
	@BeforeMethod
	public void loginToKiteApp() throws IOException 
	{
		login.sendUsername(Utility.geDataFromPropFile("UN"));
		login.sendPassword(Utility.geDataFromPropFile("PWD"));
		login.clickOnLoginButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		pin.sendpin(Utility.geDataFromPropFile("PIN"));
		pin.clickOnContinueButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
	}
  @Test
  public void validateUserID() throws EncryptedDocumentException, IOException {
	  
	  Assert.assertEquals(home.actualUserName(), Utility.geDataFromPropFile("UN"),"actual and expected not matching TC is failed");
	  Assert.fail();
  }
  @AfterMethod
  public void logOutFromKite()
  {
	  home.clickOnLogout();
  }
  
  @AfterClass
  public void closeBrowser()
  {
	  driver.close();
  }
}
