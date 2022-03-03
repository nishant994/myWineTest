package DatadrivenUtils;

import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import Utility.Abstract;

public class DataMine {

	
	@DataProvider(name="DataContainer")
    public String readProperty(String key)  {
		 String resultfromPropery=null;
		try {
			
			FileReader reader=new FileReader("src\\DatadrivenUtils\\config.properties");		      
		    Properties p=new Properties(); 
		    p.load(reader); 
		    resultfromPropery=p.getProperty(key);
		  System.out.println(resultfromPropery);
	 
		} catch (Exception e) {
			System.out.println("Properties file couldn't be loaded");
		}
		return resultfromPropery;	
		
	}	  
	
}
