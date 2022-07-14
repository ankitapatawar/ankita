package KitePom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	public static String geDataFromPropFile(String key) throws IOException
	{
	Properties prop=new Properties();
	FileInputStream myfile=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\march26maven\\myProperties.properties");
	prop.load(myfile);
	String value = prop.getProperty(key);
	return value;
	
	}

}
