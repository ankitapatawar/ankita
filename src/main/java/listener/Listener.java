package listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import KitePom.Base;


public class Listener extends Base implements ITestListener {
	//WebDriver driver;
	Base b=new Base();
	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("congratulations your TC is passed, passed TC name is "+result.getName(),true);
		
	}
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("sorry TC is failed, failed TC name is "+result.getName(),true);
		String name = result.getName();
		try {
			b.captureScreenShot(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
