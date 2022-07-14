package KitePom;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;


public class Base {
	static protected WebDriver driver=null;
	public void openchromeBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\26marchb\\selenium\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--incognito");
		opt.addArguments("--disable-notifications");
		driver=new ChromeDriver(opt);
		driver.get(Utility.geDataFromPropFile("URL"));
		Reporter.log("launching browser",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}
	
	public void openedgeBrowser(Object Reporter) throws IOException
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Desktop\\26marchb\\selenium\\msedgedriver.exe");
		
		driver=new EdgeDriver();
		driver.get(Utility.geDataFromPropFile("URL"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}
	
	public void captureScreenShot(String TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\DELL\\Desktop\\screenshot\\myss"+TCID+".jpg");
		FileHandler.copy(src, destination);
	}

}
